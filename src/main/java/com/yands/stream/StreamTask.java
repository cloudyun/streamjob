package com.yands.stream;

/**
 * @FileName : (StreamTask.java) 
 * 
 * @description  : (流业务中布控类任务实体基类)
 * @author: gaoyun
 * @version: Version No.1
 * @date: 2017年11月10日
 * @modify: 2017年11月10日 下午1:27:07
 * @copyright: FiberHome FHZ Telecommunication Technologies Co.Ltd.
 *
 */
public class StreamTask {
	
	/**
	 * 任务id
	 */
	protected String id;
	
	/**
	 * 该任务的类型
	 */
	protected String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
