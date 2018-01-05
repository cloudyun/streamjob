package com.yands.stream;

import java.util.ResourceBundle;

import com.yands.stream.constants.StreamingConstants;
import com.yands.stream.tools.StringUtils;

/**
 * @FileName : (StreamingJobBean.java)
 *
 * @description : 定时任务流任务bean
 * @author : Zhihao.Du
 * @version : Version No.1
 * @create : 2017年10月20日 上午9:47:55
 * @modify : 2017年10月20日 上午9:47:55
 * @copyright : FiberHome FHZ Telecommunication Technologies Co.Ltd.
 */
public abstract class StreamingJobBean implements Runnable {

	protected StreamProcessing streamProcessing;
	private String jobName;// 任务名
	private String topicName;
	private String kafkaGroupId;
	private Integer throughput;//限流
	private String properties;// 属性文件名
	private Boolean isInit = false;

	/**
	 * @Description : 初始化
	 */
	protected abstract void init();

	/**
	 * @Description : 设置任务名称
	 * @param jobName
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;

		ResourceBundle bundle = ResourceBundle.getBundle(StreamingConstants.BASE_PATH + ".config");
		// 未启用
//		if (!Boolean.parseBoolean(bundle.getString(jobName + "_job"))) {
//			System.out.print("流任务初始化:" + this.jobName + " 未启用");
//			return;
//		}
		// propertiesName
		properties = bundle.getString(jobName + "_props");
		if (StringUtils.isNullOREmpty(properties)) {
			System.out.print("流任务初始化:" + this.jobName + "props配置为空");
			return;
		}
		ResourceBundle streamBundle = ResourceBundle.getBundle(StreamingConstants.BASE_PATH + "."
				+ properties);//+ properties + "." + properties);

		topicName = streamBundle.getString(StreamingConstants.TOPIC_NAME);
		kafkaGroupId = streamBundle.getString(StreamingConstants.KAFKA_GROUP_ID);
		throughput=Integer.valueOf(streamBundle.getString(StreamingConstants.KAFKA_THROUGHPUT));

		if (StringUtils.isNullOREmpty(topicName)
				|| StringUtils.isNullOREmpty(kafkaGroupId)) {
			System.out.print("流任务初始化:" + this.jobName
					+ " topicName 或kafakgroupid配置为空");
			return;
		}

		streamProcessing = StreamProcessing.getInstance(topicName,
				kafkaGroupId,throughput, properties);

		init();

		isInit = true;
	}

	public String getJobName() {
		return jobName;
	}

	/**
	 * @Description : 获取属性文件名
	 * @return
	 */
	public String getProperties() {
		return properties;
	}
	

	/**
	 * @Description : 获取流处理程序
	 * @return
	 */
	public StreamProcessing getStreamProcessing() {
		return streamProcessing;
	}

	public void run() {
		streamProcessing.run();
		System.out.print("启动流任务成功!" + jobName);
	}

}
