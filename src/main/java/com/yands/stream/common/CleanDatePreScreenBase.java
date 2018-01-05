package com.yands.stream.common;

import java.util.Calendar;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.yands.stream.constants.StreamingConstants;
import com.yands.stream.tools.DateUtil;
import com.yands.stream.tools.StringUtils;

/**
 * @FileName : (CleanDatePreScreenBase.java)
 *
 * @description : 时间过滤预处理
 * @author : Zhihao.Du
 * @version : Version No.1
 * @create : 2017年10月20日 下午3:10:35
 * @modify : 2017年10月20日 下午3:10:35
 * @copyright : FiberHome FHZ Telecommunication Technologies Co.Ltd.
 */
public class CleanDatePreScreenBase extends DataPreScreenBase {

	protected Integer dayAgoCount = 120;// 默认120天

	public CleanDatePreScreenBase(String properties) {
		super(properties);
		dayAgoCount = Integer.parseInt(bundle.getString(StreamingConstants.CLEAN_DAY_AGO));
	}

	@Override
	public String preScreen(JSONObject json) {
		String msg = super.preScreen(json);

		if (!StringUtils.isNullOREmpty(msg)) {
			return msg;
		}

		String time = json.getString(this.partiotionColumn);

		// 时间过滤
		Date parseDate = DateUtil.parseDate(time);
		// 排除过期数据（前多少天和未来的数据）
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date futureDate = calendar.getTime();
		calendar.add(Calendar.DAY_OF_YEAR, -(dayAgoCount + 2));
		Date dayAgoDate = calendar.getTime();

		if (parseDate.after(futureDate) || parseDate.before(dayAgoDate)) {
			msg = "解析消息出错  & 消息中jgsk不在待保留的时间内:" + time;
			return msg;
		} else
			return msg;
	}

}
