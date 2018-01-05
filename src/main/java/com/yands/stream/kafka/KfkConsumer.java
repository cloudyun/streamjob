package com.yands.stream.kafka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import com.yands.stream.tools.StringUtils;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

/**
 * @(#)kafka 消费者
 * @description: 基于进程实现的kafka消息消费者
 * @author: yanqisong
 * @date: 2016-8-8 上午10:37:13
 * @version: V1.0
 * @copyright : FiberHome FHZ Telecommunication Technologies Co.Ltd.
 */
public class KfkConsumer {

	/**
	 * 配置文件
	 */
	private static ResourceBundle pread = ResourceBundle.getBundle("config.kafka");

	/**
	 * 消费者连接器
	 */
	private ConsumerConnector consumerConnector;

	/**
	 * kafka字节流
	 */
	private KafkaStream<byte[], byte[]> kafkaStream;

	/**
	 * 默认构造函数
	 */
	public KfkConsumer(List<String> topics, String groupId) {
		if (topics.isEmpty()) {
			throw new IllegalArgumentException("Args is illegal,Please check!");
		}
		Map<String, Integer> topickMap = new HashMap<String, Integer>();
		for (String topic : topics) {
			topickMap.put(topic, 1);
		}

		this.consumerConnector = Consumer.createJavaConsumerConnector(createConsumerConfig(groupId));
		Map<String, List<KafkaStream<byte[], byte[]>>> streamMap = consumerConnector.createMessageStreams(topickMap);

		this.kafkaStream = streamMap.get(topics).get(0);
	}

	/**
	 * 默认构造函数
	 */
	public KfkConsumer(String topicName, String groupId) {
		if (StringUtils.isNullOREmpty(topicName) && StringUtils.isNullOREmpty(groupId)) {
			throw new IllegalArgumentException("Args is illegal,Please check!");
		}
		Map<String, Integer> topickMap = new HashMap<String, Integer>();
		topickMap.put(topicName, 1);

		this.consumerConnector = Consumer.createJavaConsumerConnector(createConsumerConfig(groupId));
		Map<String, List<KafkaStream<byte[], byte[]>>> streamMap = consumerConnector.createMessageStreams(topickMap);
		this.kafkaStream = streamMap.get(topicName).get(0);
	}

	/**
	 * 获取配置属性
	 */
	private ConsumerConfig createConsumerConfig(String groupId) {
		Properties props = new Properties();
		// props.put(Constants.KAFKA_BOOTSTRAP_SERVERS,pread.get(Constants.KAFKA_BOOTSTRAP_SERVERS));
		// props.put(Constants.KAFKA_GROUP_ID,groupId);
		// props.put(Constants.KAFKA_ENABLE_AUTO_COMMIT,
		// Boolean.valueOf(pread.get(Constants.KAFKA_ENABLE_AUTO_COMMIT)));
		// props.put(Constants.KAFKA_AUTO_COMMIT_INTERVAL_MS,pread.get(Constants.KAFKA_AUTO_COMMIT_INTERVAL_MS));
		// props.put(Constants.KAFKA_SESSION_TIMEOUT_MS,
		// pread.get(Constants.KAFKA_SESSION_TIMEOUT_MS));
		// props.put(Constants.KAFKA_KEY_DESERIALIZER,pread.get(Constants.KAFKA_KEY_DESERIALIZER));
		// props.put(Constants.KAFKA_VALUE_DESERIALIZER,pread.get(Constants.KAFKA_VALUE_DESERIALIZER));
		// props.put(Constants.KAFKA_AUTO_OFFSET_RESET,
		// pread.get(Constants.KAFKA_AUTO_OFFSET_RESET));
		// props.put(Constants.KAFKA_ZOOKEEPER_CONNECT,
		// pread.get(Constants.KAFKA_ZOOKEEPER_CONNECT));
		// props.put(Constants.KAFKA_CONNECTIONS_MAX_IDLE_MS,
		// pread.get(Constants.KAFKA_CONNECTIONS_MAX_IDLE_MS));
		// props.put(Constants.KAFKA_CONSUMER_TIMEOUT_MS,
		// pread.get(Constants.KAFKA_CONSUMER_TIMEOUT_MS));
		// props.put(Constants.FETCH_MESSAGE_MAX_BYTES,
		// pread.get(Constants.FETCH_MESSAGE_MAX_BYTES));
		// props.put(Constants.ZOOKEEPER_SESSION_TIMEOUT_MS,
		// pread.get(Constants.ZOOKEEPER_SESSION_TIMEOUT_MS));
		// props.put(Constants.ZOOKEEPER_CONNECTION_TIMEOUT_MS,
		// pread.get(Constants.ZOOKEEPER_CONNECTION_TIMEOUT_MS));
		// props.put(Constants.ZOOKEEPER_SYNC_TIME_MS,
		// pread.get(Constants.ZOOKEEPER_SYNC_TIME_MS));
		// props.put(Constants.REBALANCE_BACKOFF_MS,
		// pread.get(Constants.REBALANCE_BACKOFF_MS));
		// props.put(Constants.REBALANCE_MAX_RETRIES,
		// pread.get(Constants.REBALANCE_MAX_RETRIES));
		// props.put(Constants.REFRESH_LEADER_BACKOFF_MS,
		// pread.get(Constants.REFRESH_LEADER_BACKOFF_MS));
		return new ConsumerConfig(props);
	}

	/**
	 * 获取消费者连接器
	 */
	public ConsumerConnector getConsumerConnector() {
		return consumerConnector;
	}

	/**
	 * 获取字节流
	 */
	public KafkaStream<byte[], byte[]> getKafkaStream() {
		return kafkaStream;
	}

	/**
	 * 启动消息 TODO
	 */
	public void start() {

	}

	/**
	 * 关闭连接
	 */
	@SuppressWarnings("unused")
	private void close() {
		consumerConnector.shutdown();
	}

	/**
	 * 暂停接收消息
	 */
	public void pauseReceive() {
		try {
			consumerConnector.wait();
		} catch (InterruptedException e) {
			System.out.println("Pause Receive messages fail: " + e.getMessage());
		}
	}

	/**
	 * 恢复接收消息
	 */
	public void recoverReceive() {
		try {
			consumerConnector.notify();
		} catch (Exception e) {
			System.out.println("Recover Receive messages fail: " + e.getMessage());
		}
	}
}
