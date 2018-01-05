package com.yands.stream;

import com.alibaba.fastjson.JSONArray;


/**
 * @(#)
 * @description: 修改流任务
 * @author: yanqisong
 * @edit by: 
 * @date: 2017年10月25日
 * @modify : 
 * @version: V1.0
 * @modify:
 * @copyright : FiberHome FHZ Telecommunication Technologies Co.Ltd.
 */
public interface IAlterTask {
	
	/**
	 * 添加任务 一般在布控预警类业务中需要 
	 * 需要抛出所有异常，方便反馈异常信息给调用接口者
	 * @see {@link com.fhzz.core.stream.face.PetitionTheamticStreamJob#addTask}
	 * @param json
	 */
	public abstract void addTask(JSONArray json) throws Exception;
	
	/**
	 * 删除任务 一般在布控预警类业务中需要
	 * 需要抛出所有异常，方便反馈异常信息给调用接口者
	 * @see {@link com.fhzz.core.stream.face.PetitionTheamticStreamJob#dropTask}
	 * @param json
	 */
	public abstract void dropTask(JSONArray json) throws Exception;
	
	/**
	 * 更新任务 一般在布控预警类业务中需要
	 * 需要抛出所有异常，方便反馈异常信息给调用接口者
	 * @see {@link com.fhzz.core.stream.face.PetitionTheamticStreamJob#updateTask}
	 * @param json
	 */
	public abstract void updateTask(JSONArray json) throws Exception;
}
