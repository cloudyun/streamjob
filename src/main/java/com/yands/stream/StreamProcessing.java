package com.yands.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.yands.stream.common.DataPreScreenBase;
import com.yands.stream.kafka.KfkConsumer;
import com.yands.stream.tools.SpeedCounterUtils;
import com.yands.stream.tools.StringUtils;

/**
 * @FileName : (StreamProcessing.java)
 * 
 * @description : (流处理程序任务)
 * @author: gaoyun
 * @version: Version No.1
 * @date: 2017年8月14日
 * @modify: 2017年8月14日 下午4:45:08
 * @copyright: FiberHome FHZ Telecommunication Technologies Co.Ltd.
 *
 */
public class StreamProcessing {

	private static final Logger LOG = Logger.getLogger(StreamProcessing.class);

	/**
	 * 队列名称
	 */
	private List<String> topics = null;

	/**
	 * 消费者ID
	 */
	private String group_id;

	protected List<String> jobNames = new ArrayList<String>();

	protected Map<String, StreamJob> jobs = new HashMap<String, StreamJob>();

	// 是否已经启动任务
	private AtomicBoolean start = new AtomicBoolean(false);

	/**
	 * 处理计数
	 */
	private AtomicLong COUNT = new AtomicLong(0l);

	/**
	 * 是否暂停任务
	 */
	protected AtomicBoolean pause = new AtomicBoolean(false);

	protected DataPreScreen perScreen;

	protected String properties;

	protected Timer timer;

	/**
	 * 超时刷新，超时会执行各业务JOB的flush()一次
	 */
	protected long TIMEOUT = 200000;

	private KfkConsumer kfkConsumer = null;

	private List<ExecutorService> poolList;
	/**
	 * 线程池最大任务数
	 */
	private Integer poolJobsMaxCountInteger = 100;

	/**
	 * 线程池线程数
	 */
	private Integer poolThreadsCount = 20;

	/**
	 * 限流，负数表示不限流
	 */
	private Integer throughput;

	private static Map<String, StreamProcessing> instances = new HashMap<String, StreamProcessing>();

	public synchronized static StreamProcessing getInstance(String topic,
			String group_id, Integer throughput, String properties) {
		StreamProcessing instance = instances.get(topic);
		if (instance != null) {
			return instance;
		}
		instance = new StreamProcessing(Arrays.asList(topic), group_id,
				throughput, properties);
		instances.put(topic, instance);
		return instance;
	}

	public synchronized static StreamProcessing getInstance(
			List<String> topics, String group_id, Integer throughput,
			String properties) {
		String names = names(topics);
		StreamProcessing instance = instances.get(names);
		if (instance != null) {
			return instance;
		}
		instance = new StreamProcessing(topics, group_id, throughput,
				properties);
		instances.put(names, instance);
		return instance;
	}

	private StreamProcessing(List<String> topics, String group_id,
			Integer throughput, String properties) {
		this.topics = topics;
		this.group_id = group_id;
		this.perScreen = new DataPreScreenBase(properties);
		this.properties = properties;
		this.throughput = throughput;

		poolList = new ArrayList<ExecutorService>();
	}

	public void setPerScreen(DataPreScreen perScreen) {
		this.perScreen = perScreen;
	}

	/**
	 * 流处理
	 */
	public void run() {
		timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				// 超时提交
				for (String name : jobNames) {
					StreamJob job = jobs.get(name);
					long now = System.currentTimeMillis();
					if (now - job.getRecord() < TIMEOUT) {
						continue;
					}
					job.flush();
					job.setRecord(now);
				}
			}
		};
		timer.schedule(task, TIMEOUT, TIMEOUT);

		String infoPre = "流处理:" + properties;
		SpeedCounterUtils.startCount(infoPre, COUNT, 60000, 60000);
		ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<Runnable>(
				poolJobsMaxCountInteger+poolThreadsCount);
		ThreadPoolExecutor pools = new ThreadPoolExecutor(poolThreadsCount,
				poolThreadsCount, 0l, TimeUnit.MILLISECONDS, arrayBlockingQueue);
		poolList.add(pools);
		kfkConsumer = new KfkConsumer(topics, group_id);
		KafkaStream<byte[], byte[]> kafkaStream = kfkConsumer.getKafkaStream();
		ConsumerIterator<byte[], byte[]> iterator = kafkaStream.iterator();
		List<JSONObject> jsonList = new ArrayList<JSONObject>();
		while (true) {
			if (!iterator.hasNext()) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			MessageAndMetadata<byte[], byte[]> next = iterator.next();
			JSONObject json = JSONObject.parseObject(new String(next.message()));
			if (json == null) {
				continue;
			}
			String msg = perScreen.preScreen(json);
			if (!StringUtils.isNullOREmpty(msg)) {
				LOG.info(msg);
				continue;
			}
			COUNT.incrementAndGet();
			jsonList.add(json);
			try {
				while (arrayBlockingQueue.size() >= poolJobsMaxCountInteger) {
					Thread.sleep(1l);
				}
				int tempCount = jsonList.size();
				for (String name : jobNames) {
					pools.execute(new MultiHandle(name, jsonList));
				}
			} catch (Exception e) {
				LOG.error(properties + ":数据处理异常 ! msg : " + e.getMessage(), e);
			}
			if (!start.get()) {
				pools.shutdown();
			}
		}

//		try {
//			kfkConsumer.start();
//		} catch (Exception e) {
//			LOG.error("启动过车消费失败！");
//		}
//
//		while (!pools.isTerminated()) {
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				LOG.info(e.getMessage());
//			}
//		}
//
//		for (String name : jobNames) {
//			jobs.get(name).cleanup();
//		}
//		SpeedCounterUtils.cancel(infoPre);
//		LOG.info("流任务已停止");
	}

	class MultiHandle implements Runnable {

		private String name;

		private List<JSONObject> jsons;

		public MultiHandle(String name, List<JSONObject> jsons) {
			this.name = name;
			this.jsons = jsons;
		}

		public void run() {
			if (jsons == null || jsons.size() == 0)
				return;

			StreamJob streamJob = jobs.get(name);
			for (JSONObject json : jsons) {
				try {
					streamJob.handle(json);
				} catch (Exception e) {
					LOG.error("name : [" + name + "] 处理数据[" + json
							+ "]出现异常,msg:[" + e.getMessage() + "]", e);
				}
			}
		}
	}

	public void addJob(StreamJob job) {
		String name = job.getName();
		if (jobNames.contains(name)) {
			return;
		}
		jobNames.add(name);
		jobs.put(name, job);
	}

	/**
	 * @Description : 获取属性信息
	 * @return
	 */
	public String getProperties() {
		return properties;
	}

	/**
	 * @Description : 获取当前流处理程序(topic,kafka)
	 * @return
	 */
	public static Map<String, StreamProcessing> getCurrentStreamProcessing() {
		return instances;
	}

	private static String names(List<String> list) {
		StringBuilder build = new StringBuilder();
		for (String name : list) {
			build.append(name);
		}
		return build.toString();
	}
}