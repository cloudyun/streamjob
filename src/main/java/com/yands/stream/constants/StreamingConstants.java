package com.yands.stream.constants;

/**
 * @FileName : (StreamingConstants.java)
 *
 * @description : 流任务常量
 * @author : Zhihao.Du
 * @version : Version No.1
 * @create : 2017年10月23日 上午9:11:42
 * @modify : 2017年10月23日 上午9:11:42
 * @copyright : FiberHome FHZ Telecommunication Technologies Co.Ltd.
 */
public class StreamingConstants {

	/**
	 * 基础路径
	 */
	public final static String BASE_PATH = "config";

	/**
	 * 主题名称
	 */
	public final static String TOPIC_NAME = "topicName";

	/**
	 * kafka组ID
	 */
	public final static String KAFKA_GROUP_ID = "kafka.group.id";
	
	/**
	 * kafka限流
	 */
	public final static String KAFKA_THROUGHPUT="kafka.throughput";
	

	/**
	 * 统计等待间隔
	 */
	public final static String STATISTICS_WAIT_RATE = "STATISTICS_WAIT_RATE";

	/**
	 * 统计持久化等待间隔
	 */
	public final static String FLUSH_WAIT_RATE = "FLUSH_WAIT_RATE";

	/**
	 * 业务数据的合理范围（多少天内的）
	 */
	public final static String CLEAN_DAY_AGO = "day.ago";

	/**
	 * 提交：缓存数量
	 */
	public final static String CACHE_SIZE = "CACHE_SIZE";

	/**
	 * wal日志文件名称
	 */
	public final static String WAL_FILE_NAME = "wal.txt";

	/**
	 * solr集合名称
	 */
	public final static String SOLR_COL_NAME = "SOLR_COL_NAME";
	
	/**
	 * alarm solr集合名称
	 */
	public final static String SOLR_ALARM_COL = "alarm.solr.col";

	/**
	 * solr错误日志路径
	 */
	public final static String SOLR_WAL_PATH = "SOLR_WAL_PATH";

	/**
	 * elk表名
	 */
	public final static String ELK_TABLE_NAME = "ELK_TABLE_NAME";

	/**
	 * elk提交：达到一定数据
	 */
	public final static String ELK_COMMIT_MAX_COUNT = "ELK_COMMIT_MAX_COUNT";

	/**
	 * elk错误日志路径
	 */
	public final static String ELK_WAL_PATH = "ELK_WAL_PATH";

	/**
	 * hbase表名
	 */
	public final static String HBASE_TABLE_NAME = "HBASE_TABLE_NAME";

	/**
	 * jdbc配置路径
	 */
	public final static String JDBC_CONFIG_PATH = "jdbc";

	/**
	 * elk url
	 */
	public final static String ELK_URL = "elk.url";

	/**
	 * elk username
	 */
	public final static String ELK_USERNAME = "elk.username";

	/**
	 * elk password
	 */
	public final static String ELK_PASSWORD = "elk.password";
	
	
	/**
	 *  mpp url
	 */
	public final static String MPP_URL="mpp.url";
	
	/**
	 * mpp username
	 */
	public final static String MPP_USERNAME="mpp.username";
	
	/**
	 *  mpp password
	 */
	public final static String MPP_PASSWORD = "mpp.password";
	

	/**
	 * HBase错误日志路径
	 */
	public final static String HBASE_WAL_PATH = "HBASE_WAL_PATH";

	/**
	 * 持久化到ELK
	 */
	public final static String TO_ELK = "TO_ELK";

	/**
	 * 持久化到HBase
	 */
	public final static String TO_HBASE = "TO_HBASE";

	/**
	 * 持久化到solr
	 */
	public final static String TO_SOLR = "TO_SOLR";

	/**
	 * redis对比表名
	 */
	public final static String COMPARISON_TABLE = "comparison.table";

	/**
	 * redis记录表名
	 */
	public final static String RECORD_TABLE = "record.table";

	/**
	 * invalid 无效对象
	 */
	public final static String INVALID = "invalid";

	/**
	 * 实时推送队列名称
	 */
	public final static String PUSH_TOPIC_NAME = "push.topicName";

	/**
	 * 批量提交数据量
	 */
	public final static String BATCH_SIZE = "batch.size";

	/**
	 * 初次入城时间间隔等类型参数
	 */
	public final static String INTERVAL = "interval";
	
	/**
	 * 表名
	 */
	public final static String TABLE_NAME = "table.name";
	
	
	
	/**
	 * 主键字段
	 */
	public final static String COLUMNS_ID="columns.id";
	
	/**
	 * 数据表字段
	 */
	public final static String DT_COLUMNS="columns";
	
	/**
	 * solr索引字段
	 */
	public final static String SOLR_INDEXS="indexs";
	
	
	/**
	 * 时间类型字段
	 */
	public final static String TIME_COLUMNS = "time.columns";
	
	/**
	 * 分区字段
	 */
	public final static String PARTITION_COLUMNS="partition.columns";
	

	
	
	

}
