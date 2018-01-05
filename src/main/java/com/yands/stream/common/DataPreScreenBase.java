package com.yands.stream.common;

import com.alibaba.fastjson.JSONObject;
import com.yands.stream.DataPreScreen;
import com.yands.stream.constants.StreamingConstants;
import com.yands.stream.tools.StringUtils;


/**
 * @FileName : (DataPreScreenBase.java)
 * 
 * @description : (预筛选通用基类)
 * @author: gaoyun
 * @version: Version No.1
 * @date: 2017年10月18日
 * @modify: 2017年8月14日 下午4:45:08
 * @copyright: FiberHome FHZ Telecommunication Technologies Co.Ltd.
 *
 */
public class DataPreScreenBase extends DataPreScreen {

	protected String columnsId;

	protected String partiotionColumn;

	public DataPreScreenBase(String properties) {
		super(properties);
		columnsId = bundle.getString(StreamingConstants.COLUMNS_ID );
		partiotionColumn = bundle.getString(StreamingConstants.PARTITION_COLUMNS);
	}

	/**
	 * 预筛选数据
	 * 
	 * @param json
	 * @return
	 */
	@Override
	public String preScreen(JSONObject json) {
		String id = json.getString(columnsId);
		String time = json.getString(partiotionColumn);
		
		String msg = "";
		if (StringUtils.isNullOREmpty(id)) {
			msg = "解析消息出错  & 消息中id为空";
			return msg;
		}
		
		if (StringUtils.isNullOREmpty(time) || time.length() < 10) {
			msg = "解析消息出错  & 消息中时间字段为空";
			return msg;
		}
		
		return msg;
	}
}