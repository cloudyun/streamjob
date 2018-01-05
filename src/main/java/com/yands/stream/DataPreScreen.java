package com.yands.stream;

import java.util.ResourceBundle;

import com.alibaba.fastjson.JSONObject;

/**
 * @FileName : (DataPreScreen.java) 
 * 
 * @description  : (预筛选)
 * @author: gaoyun
 * @version: Version No.1
 * @date: 2017年8月22日
 * @modify: 2017年8月22日 上午9:34:15
 * @copyright: FiberHome FHZ Telecommunication Technologies Co.Ltd.
 *
 */
public abstract class DataPreScreen {
	
	protected ResourceBundle bundle;
	
	public DataPreScreen(String properties) {
		this.bundle = ResourceBundle.getBundle("config." + properties);
	}

	protected abstract String preScreen(JSONObject json);
	
}
