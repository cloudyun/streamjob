package com.yands.stream;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSONObject;
import com.yands.stream.tools.StringUtils;

/**
 * @FileName : (IStreamJob.java) 
 * 
 * @description  : (流处理业务(JOB)接口)
 * @author: gaoyun
 * @version: Version No.1
 * @date: 2017年8月22日
 * @modify: 2017年8月22日 上午9:34:15
 * @copyright: FiberHome FHZ Telecommunication Technologies Co.Ltd.
 *
 */
public abstract class StreamJob {
	
	protected String properties;
	
	protected List<JSONObject> jsonObjectList ;
	
	/**
	 * 异常记录
	 */
	protected PrintWriter walClient;
	
	/**
	 * 记录上次提交完成的时间
	 */
	public long record = System.currentTimeMillis();
	
	/**
	 * 初始化设置
	 */
	public abstract void setup();
	
	/**
	 * 处理一条数据
	 * @param obj
	 */
	public abstract void handle(JSONObject obj);
	
	/**
	 * 刷新入库
	 */
	public abstract void flush();
	
	
	public StreamJob(String properties)
	{
		if(StringUtils.isNullOREmpty(properties))
		{
			throw new IllegalArgumentException("properties can not be null!");
		}
		this.properties  = properties;
		jsonObjectList =new ArrayList<JSONObject>();
	}
	
	
	public StreamJob()
	{
		jsonObjectList = new ArrayList<JSONObject>();
	}
	
	/**
	 * 处理没有成功的任务
	 */
	protected void flushUnAck()
	{
		for (JSONObject json : jsonObjectList) {
			walClient.write(json.toString() + " \r\n");
		}	
	}
	
	
	public long getRecord() {
		return record;
	}
	
	public void setRecord(long record) {
		this.record = record;
	}
	
	/**
	 * 最后清理
	 */
	public abstract void cleanup();
	
	/**
	 * 获取该业务的业务名称
	 * 
	 * 一般 @see {@link com.fhzz.core.stream.face.PetitionTheamticStreamJob#getName}
	 * 通用 @see {@link com.fhzz.core.stream.common.ConsumeDataToELKJob#getName}
	 * @return
	 */
	public abstract String getName();
	
}