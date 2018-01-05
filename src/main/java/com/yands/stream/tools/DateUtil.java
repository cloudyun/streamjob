package com.yands.stream.tools;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateUtil {

	private static final int[] dayArray = new int[] { 31, 28, 31, 30, 31, 30,
			31, 31, 30, 31, 30, 31 };

	private static SimpleDateFormat sdf = new SimpleDateFormat();

	public static final long SECOND = 1000;

	public static final long MINUTE = 60 * SECOND;

	public static final long HOUR = 60 * MINUTE;

	public static final long DAY = 24 * HOUR;

	public static final long WEEK = 7 * DAY;

	/**
	 * 距离1970年1月1日有多少天
	 */
	public static long dayMill() {
		// System.out.print(System.currentTimeMillis());
		return (System.currentTimeMillis()) / (DAY);
	}

	/**
	 * 距离1970年1月1日有周
	 * 
	 * @return long
	 */
	public static long weekMill() {

		// System.out.print(dayMill() / 7);
		return dayMill() / 7;
	}

	public static synchronized String getDateHour(java.util.Date date) {
		String pattern = "HH";
		return getDateFormat(date, pattern);
	}

	public static synchronized String getDateMinute(java.util.Date date) {
		String pattern = "mm";
		return getDateFormat(date, pattern);
	}

	public static synchronized String getDateSecond(java.util.Date date) {
		String pattern = "ss";
		return getDateFormat(date, pattern);
	}

	public static synchronized Calendar getCalendar() {
		return GregorianCalendar.getInstance();
	}

	public static Date getCurrentTime() {
		Calendar ca = Calendar.getInstance();
		Date a = new Date();
		a.setTime(ca.getTimeInMillis());
		return a;
	}

	/**
	 * @return String
	 */
	public static synchronized String getDateMilliFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateMilliFormat(cal);
	}

	/**
	 * @param cal
	 * @return String
	 */
	public static synchronized String getDateMilliFormat(java.util.Calendar cal) {
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
		return getDateFormat(cal, pattern);
	}

	/**
	 * @param date
	 * @return String
	 */
	public static synchronized String getDateMilliFormat(java.util.Date date) {
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
		return getDateFormat(date, pattern);
	}

	/**
	 * @param date
	 * @return String
	 */
	public static synchronized String getDatePathFormat(java.util.Date date) {
		String pattern = "yyyy-MM-dd-HH-mm-ss-SSS";
		return getDateFormat(date, pattern);
	}

	/**
	 * @param date
	 * @return String
	 */
	public static synchronized String getDatePathFormatWithOutRandom(
			java.util.Date date) {
		String pattern = "yyyyMMddHHmmss";
		String rs = getDateFormat(date, pattern);
		return rs;
	}

	/**
	 * @param strDate
	 * @return java.util.Calendar
	 */
	public static synchronized Calendar parseCalendarMilliFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
		return parseCalendarFormat(strDate, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static synchronized Date parseDateMilliFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static synchronized Date parseSQLDate(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";

		return parseDateFormat(strDate, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static synchronized Date parseDate(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss";

		if(StringUtils.isNullOREmpty(strDate)) return null;
		return parseDateFormat(strDate, pattern);
	}

	public static synchronized String getDateSecondFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateSecondFormat(cal);
	}

	/**
	 * @param cal
	 * @return String
	 */
	public static synchronized String getDateSecondFormat(java.util.Calendar cal) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return getDateFormat(cal, pattern);
	}

	/**
	 * @param date
	 * @return String
	 */
	public static synchronized String getDateSecondFormat(java.util.Date date) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return getDateFormat(date, pattern);
	}

	// 电信定时录像的时间格式：YYYY-MM-DD-W-HH-MM，其中W现以0替代
	public static synchronized String getDateSecondTeleFormat(
			java.util.Date date) {
		String pattern = "yyyy-MM-dd-0-HH-mm";
		return getDateFormat(date, pattern);
	}

	public static synchronized String getDate(java.util.Date date) {
		String pattern = "yyyy-MM-dd";
		return getDateFormat(date, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Calendar
	 */
	public static synchronized Calendar parseCalendarSecondFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return parseCalendarFormat(strDate, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static synchronized Date parseDateSecondFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static synchronized Date parseDateSecondFormat2(String strDate) {
		String pattern = "yyyyMMddHHmmss";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * @return String
	 */
	public static synchronized String getDateMinuteFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateMinuteFormat(cal);
	}

	/**
	 * @param cal
	 * @return String
	 */
	public static synchronized String getDateMinuteFormat(java.util.Calendar cal) {
		String pattern = "yyyy-MM-dd HH:mm";
		return getDateFormat(cal, pattern);
	}

	/**
	 * @param date
	 * @return String
	 */
	public static synchronized String getDateMinuteFormat(java.util.Date date) {
		String pattern = "yyyy-MM-dd HH:mm";
		return getDateFormat(date, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Calendar
	 */
	public static synchronized Calendar parseCalendarMinuteFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm";
		return parseCalendarFormat(strDate, pattern);
	}

	public static Calendar DateToCalendar(Date d) {
		// System.out.println("Date::" + d);
		Calendar ca = Calendar.getInstance();
		ca.setTime(d);
		// System.out.println("Calendar::" + ca.getTime());
		return ca;
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static synchronized Date parseDateMinuteFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * @return String
	 */
	public static synchronized String getDateDayFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateDayFormat(cal);
	}

	/**
	 * @param cal
	 * @return String
	 */
	public static synchronized String getDateDayFormat(java.util.Calendar cal) {
		String pattern = "yyyy-MM-dd";
		return getDateFormat(cal, pattern);
	}

	/**
	 * @param date
	 * @return String
	 */
	public static synchronized String getDateDayFormat(java.util.Date date) {
		String pattern = "yyyy-MM-dd";
		return getDateFormat(date, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Calendar
	 */
	public static synchronized Calendar parseCalendarDayFormat(String strDate) {
		String pattern = "yyyy-MM-dd";
		return parseCalendarFormat(strDate, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static synchronized Date parseDateDayFormat(String strDate) {
		String pattern = "yyyy-MM-dd";
		return parseDateFormat(strDate, pattern);
	}

	public static synchronized String getDateMonthFormat(java.util.Date date) {
		String pattern = "yyyy-MM";
		return getDateFormat(date, pattern);
	}

	/**
	 * @return String
	 */
	public static synchronized String getDateFileFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateFileFormat(cal);
	}

	/**
	 * @param cal
	 * @return String
	 */
	public static synchronized String getDateFileFormat(java.util.Calendar cal) {
		String pattern = "yyyy-MM-dd_HH-mm-ss";
		return getDateFormat(cal, pattern);
	}

	/**
	 * @param date
	 * @return String
	 */
	public static synchronized String getDateFileFormat(java.util.Date date) {
		String pattern = "yyyy-MM-dd_HH-mm-ss";
		return getDateFormat(date, pattern);
	}

	/**
	 * @param date
	 * @return String
	 */
	public static synchronized String getDateFileFormatStringPU(
			java.util.Date date) {
		String pattern = "yyyy-MM-dd-HH-mm-ss";
		return getDateFormat(date, pattern);
	}

	public static synchronized String getDateFileFormatStringPUtiming(
			java.util.Date date) {
		String pattern = "yyyy-MM-dd-0-HH-mm";
		return getDateFormat(date, pattern);
	}

	public static synchronized String getDateFileFormatString(
			java.util.Date date) {
		String pattern = "HH-mm-ss";
		return getDateFormat(date, pattern);
	}

	/**
	 * @Description : 获取格式化字符串(HH:mm:ss)
	 * @param date
	 * @return
	 */
	public static synchronized String getDateFileFormatString2(
			java.util.Date date) {
		String pattern = "HH:mm:ss";
		return getDateFormat(date, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Calendar
	 */
	public static synchronized Calendar parseCalendarFileFormat(String strDate) {
		String pattern = "yyyy-MM-dd_HH-mm-ss";
		return parseCalendarFormat(strDate, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static synchronized Date parseDateFileFormat(String strDate) {
		String pattern = "yyyy-MM-dd_HH-mm-ss";
		return parseDateFormat(strDate, pattern);
	}

	public static synchronized Date parseDateFileFormatPU(String strDate) {
		String pattern = "yyyy-MM-dd-HH-mm-ss";
		return parseDateFormat(strDate, pattern);
	}

	public static synchronized Date parseDateFileFormatPUtiming(String strDate) {
		String pattern = "yyyy-MM-dd-0-HH-mm";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static synchronized Date parseDateFileFormatString(String strDate) {
		String pattern = "HH-mm-ss";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * @Description : 生成date(HH:mm:ss)
	 * @param strDate
	 * @return
	 */
	public static Date parseDateFileFormatString2(String strDate) {
		String pattern = "HH:mm:ss";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * @return String
	 */
	public static synchronized String getDateW3CFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateW3CFormat(cal);
	}

	/**
	 * @param cal
	 * @return String
	 */
	public static synchronized String getDateW3CFormat(java.util.Calendar cal) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return getDateFormat(cal, pattern);
	}

	/**
	 * @param date
	 * @return String
	 */
	public static synchronized String getDateW3CFormat(java.util.Date date) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return getDateFormat(date, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Calendar
	 */
	public static synchronized Calendar parseCalendarW3CFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return parseCalendarFormat(strDate, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static synchronized Date parseDateW3CFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * @param cal
	 * @return String
	 */
	public static synchronized String getDateFormat(java.util.Calendar cal) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return getDateFormat(cal, pattern);
	}

	/**
	 * @param date
	 * @return String
	 */
	public static synchronized String getDateFormat(java.util.Date date) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return getDateFormat(date, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Calendar
	 */
	public static synchronized Calendar parseCalendarFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return parseCalendarFormat(strDate, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static synchronized Date parseDateFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * @param cal
	 * @param pattern
	 * @return String
	 */
	public static synchronized String getDateFormat(java.util.Calendar cal,
			String pattern) {
		return getDateFormat(cal.getTime(), pattern);
	}

	/**
	 * @param date
	 * @param pattern
	 * @return String
	 */
	public static synchronized String getDateFormat(java.util.Date date,
			String pattern) {
		synchronized (sdf) {
			String str = null;
			sdf.applyPattern(pattern);
			str = sdf.format(date);
			return str;
		}
	}

	/**
	 * @param strDate
	 * @param pattern
	 * @return java.util.Calendar
	 */
	public static synchronized Calendar parseCalendarFormat(String strDate,
			String pattern) {
		synchronized (sdf) {
			Calendar cal = null;
			sdf.applyPattern(pattern);
			try {
				sdf.parse(strDate);
				cal = sdf.getCalendar();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cal;
		}
	}

	/**
	 * @param strDate
	 * @param pattern
	 * @return java.util.Date
	 */
	public static synchronized Date parseDateFormat(String strDate,
			String pattern) {
		synchronized (sdf) {
			Date date = null;
			sdf.applyPattern(pattern);
			try {
				date = sdf.parse(strDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return date;
		}
	}

	public static synchronized int getLastDayOfMonth(int month) {
		if (month < 1 || month > 12) {
			return -1;
		}
		int retn = 0;
		if (month == 2) {
			if (isLeapYear()) {
				retn = 29;
			} else {
				retn = dayArray[month - 1];
			}
		} else {
			retn = dayArray[month - 1];
		}
		return retn;
	}

	public static synchronized int getLastDayOfMonth(int year, int month) {
		if (month < 1 || month > 12) {
			return -1;
		}
		int retn = 0;
		if (month == 2) {
			if (isLeapYear(year)) {
				retn = 29;
			} else {
				retn = dayArray[month - 1];
			}
		} else {
			retn = dayArray[month - 1];
		}
		return retn;
	}

	public static synchronized boolean isLeapYear() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return isLeapYear(year);
	}

	public static synchronized boolean isLeapYear(int year) {
		/**
		 * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
		 * 3.能被4整除同时能被100整除则不是闰年
		 */
		if ((year % 400) == 0)
			return true;
		else if ((year % 4) == 0) {
			if ((year % 100) == 0)
				return false;
			else
				return true;
		} else
			return false;
	}

	/**
	 * 判断指定日期的年份是否是闰年
	 * 
	 * @param date
	 *            指定日期。
	 * @return 是否闰年
	 */
	public static synchronized boolean isLeapYear(java.util.Date date) {
		/**
		 * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
		 * 3.能被4整除同时能被100整除则不是闰年
		 */
		// int year = date.getYear();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		int year = gc.get(Calendar.YEAR);
		return isLeapYear(year);
	}

	public static synchronized boolean isLeapYear(java.util.Calendar gc) {
		/**
		 * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
		 * 3.能被4整除同时能被100整除则不是闰年
		 */
		int year = gc.get(Calendar.YEAR);
		return isLeapYear(year);
	}

	/**
	 * 得到指定日期的前一个工作日
	 * 
	 * @param date
	 *            指定日期。
	 * @return 指定日期的前一个工作日
	 */
	public static synchronized java.util.Date getPreviousWeekDay(
			java.util.Date date) {
		{
			/**
			 * 详细设计： 1.如果date是星期日，则减3天 2.如果date是星期六，则减2天 3.否则减1天
			 */
			GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
			gc.setTime(date);
			return getPreviousWeekDay(gc);
			// switch ( gc.get( Calendar.DAY_OF_WEEK ) )
			// {
			// case ( Calendar.MONDAY ):
			// gc.add( Calendar.DATE, -3 );
			// break;
			// case ( Calendar.SUNDAY ):
			// gc.add( Calendar.DATE, -2 );
			// break;
			// default:
			// gc.add( Calendar.DATE, -1 );
			// break;
			// }
			// return gc.getTime();
		}
	}

	public static synchronized java.util.Date getPreviousWeekDay(
			java.util.Calendar gc) {
		{
			/**
			 * 详细设计： 1.如果date是星期日，则减3天 2.如果date是星期六，则减2天 3.否则减1天
			 */
			switch (gc.get(Calendar.DAY_OF_WEEK)) {
			case (Calendar.MONDAY):
				gc.add(Calendar.DATE, -3);
				break;
			case (Calendar.SUNDAY):
				gc.add(Calendar.DATE, -2);
				break;
			default:
				gc.add(Calendar.DATE, -1);
				break;
			}
			return gc.getTime();
		}
	}

	/**
	 * 得到指定日期的后一个工作日
	 * 
	 * @param date
	 *            指定日期。
	 * @return 指定日期的后一个工作日
	 */
	public static synchronized java.util.Date getNextWeekDay(java.util.Date date) {
		/**
		 * 详细设计： 1.如果date是星期五，则加3天 2.如果date是星期六，则加2天 3.否则加1天
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case (Calendar.FRIDAY):
			gc.add(Calendar.DATE, 3);
			break;
		case (Calendar.SATURDAY):
			gc.add(Calendar.DATE, 2);
			break;
		default:
			gc.add(Calendar.DATE, 1);
			break;
		}
		return gc.getTime();
	}

	public static synchronized java.util.Calendar getNextWeekDay(
			java.util.Calendar gc) {
		/**
		 * 详细设计： 1.如果date是星期五，则加3天 2.如果date是星期六，则加2天 3.否则加1天
		 */
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case (Calendar.FRIDAY):
			gc.add(Calendar.DATE, 3);
			break;
		case (Calendar.SATURDAY):
			gc.add(Calendar.DATE, 2);
			break;
		default:
			gc.add(Calendar.DATE, 1);
			break;
		}
		return gc;
	}

	/**
	 * 取得指定日期的下一个月的最后一天
	 * 
	 * @param date
	 *            指定日期。
	 * @return 指定日期的下一个月的最后一天
	 */
	public static synchronized java.util.Date getLastDayOfNextMonth(
			java.util.Date date) {
		/**
		 * 详细设计： 1.调用getNextMonth设置当前时间 2.以1为基础，调用getLastDayOfMonth
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setTime(DateUtil.getNextMonth(gc.getTime()));
		gc.setTime(DateUtil.getLastDayOfMonth(gc.getTime()));
		return gc.getTime();
	}

	/**
	 * 取得指定日期的下一个星期的最后一天
	 * 
	 * @param date
	 *            指定日期。
	 * @return 指定日期的下一个星期的最后一天
	 */
	public static synchronized java.util.Date getLastDayOfNextWeek(
			java.util.Date date) {
		/**
		 * 详细设计： 1.调用getNextWeek设置当前时间 2.以1为基础，调用getLastDayOfWeek
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setTime(DateUtil.getNextWeek(gc.getTime()));
		gc.setTime(DateUtil.getLastDayOfWeek(gc.getTime()));
		return gc.getTime();
	}

	/**
	 * 取得指定日期的下一个月的第一天
	 * 
	 * @param date
	 *            指定日期。
	 * @return 指定日期的下一个月的第一天
	 */
	public static synchronized java.util.Date getFirstDayOfNextMonth(
			java.util.Date date) {
		/**
		 * 详细设计： 1.调用getNextMonth设置当前时间 2.以1为基础，调用getFirstDayOfMonth
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setTime(DateUtil.getNextMonth(gc.getTime()));
		gc.setTime(DateUtil.getFirstDayOfMonth(gc.getTime()));
		return gc.getTime();
	}

	public static synchronized java.util.Calendar getFirstDayOfNextMonth(
			java.util.Calendar gc) {
		/**
		 * 详细设计： 1.调用getNextMonth设置当前时间 2.以1为基础，调用getFirstDayOfMonth
		 */
		gc.setTime(DateUtil.getNextMonth(gc.getTime()));
		gc.setTime(DateUtil.getFirstDayOfMonth(gc.getTime()));
		return gc;
	}

	/**
	 * 取得指定日期的下一个星期的第一天
	 * 
	 * @param date
	 *            指定日期。
	 * @return 指定日期的下一个星期的第一天
	 */
	public static synchronized java.util.Date getFirstDayOfNextWeek(
			java.util.Date date) {
		/**
		 * 详细设计： 1.调用getNextWeek设置当前时间 2.以1为基础，调用getFirstDayOfWeek
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setTime(DateUtil.getNextWeek(gc.getTime()));
		gc.setTime(DateUtil.getFirstDayOfWeek(gc.getTime()));
		return gc.getTime();
	}

	public static synchronized java.util.Calendar getFirstDayOfNextWeek(
			java.util.Calendar gc) {
		/**
		 * 详细设计： 1.调用getNextWeek设置当前时间 2.以1为基础，调用getFirstDayOfWeek
		 */
		gc.setTime(DateUtil.getNextWeek(gc.getTime()));
		gc.setTime(DateUtil.getFirstDayOfWeek(gc.getTime()));
		return gc;
	}

	/**
	 * 取得指定日期的下一个月
	 * 
	 * @param date
	 *            指定日期。
	 * @return 指定日期的下一个月
	 */
	public static synchronized java.util.Date getNextMonth(java.util.Date date) {
		/**
		 * 详细设计： 1.指定日期的月份加1
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.MONTH, 1);
		return gc.getTime();
	}

	public static synchronized java.util.Calendar getNextMonth(
			java.util.Calendar gc) {
		/**
		 * 详细设计： 1.指定日期的月份加1
		 */
		gc.add(Calendar.MONTH, 1);
		return gc;
	}

	/**
	 * 取得指定日期的下一天
	 * 
	 * @param date
	 *            指定日期。
	 * @return 指定日期的下一天
	 */
	public static synchronized java.util.Date getNextDay(java.util.Date date) {
		/**
		 * 详细设计： 1.指定日期加1天
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.DATE, 1);
		return gc.getTime();
	}

	/**
	 * 取得指定时间的下一小时
	 * 
	 * @param date
	 *            指定日期。
	 * @author LuoChao
	 * @return 指定时间的下一小时
	 */
	public static synchronized java.util.Date getNextHour(java.util.Date date) {
		/**
		 * 详细设计： 1.指定日期加1天
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.HOUR_OF_DAY, 1);
		return gc.getTime();
	}

	public static synchronized java.util.Calendar getNextDay(
			java.util.Calendar gc) {
		/**
		 * 详细设计： 1.指定日期加1天
		 */
		gc.add(Calendar.DATE, 1);
		return gc;
	}

	/**
	 * 取得指定日期的下一个星期
	 * 
	 * @param date
	 *            指定日期。
	 * @return 指定日期的下一个星期
	 */
	public static synchronized java.util.Date getNextWeek(java.util.Date date) {
		/**
		 * 详细设计： 1.指定日期加7天
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.DATE, 7);
		return gc.getTime();
	}

	public static synchronized java.util.Calendar getNextWeek(
			java.util.Calendar gc) {
		/**
		 * 详细设计： 1.指定日期加7天
		 */
		gc.add(Calendar.DATE, 7);
		return gc;
	}

	/**
	 * 取得指定日期的所处星期的最后一天
	 * 
	 * @param date
	 *            指定日期。
	 * @return 指定日期的所处星期的最后一天
	 */
	public static synchronized java.util.Date getLastDayOfWeek(
			java.util.Date date) {
		/**
		 * 详细设计： 1.如果date是星期日，则加6天 2.如果date是星期一，则加5天 3.如果date是星期二，则加4天
		 * 4.如果date是星期三，则加3天 5.如果date是星期四，则加2天 6.如果date是星期五，则加1天
		 * 7.如果date是星期六，则加0天
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case (Calendar.SUNDAY):
			gc.add(Calendar.DATE, 6);
			break;
		case (Calendar.MONDAY):
			gc.add(Calendar.DATE, 5);
			break;
		case (Calendar.TUESDAY):
			gc.add(Calendar.DATE, 4);
			break;
		case (Calendar.WEDNESDAY):
			gc.add(Calendar.DATE, 3);
			break;
		case (Calendar.THURSDAY):
			gc.add(Calendar.DATE, 2);
			break;
		case (Calendar.FRIDAY):
			gc.add(Calendar.DATE, 1);
			break;
		case (Calendar.SATURDAY):
			gc.add(Calendar.DATE, 0);
			break;
		}
		return gc.getTime();
	}

	/**
	 * 取得指定日期的所处星期的第一天
	 * 
	 * @param date
	 *            指定日期。
	 * @return 指定日期的所处星期的第一天
	 */
	public static synchronized java.util.Date getFirstDayOfWeek(
			java.util.Date date) {
		/**
		 * 详细设计： 1.如果date是星期日，则减0天 2.如果date是星期一，则减1天 3.如果date是星期二，则减2天
		 * 4.如果date是星期三，则减3天 5.如果date是星期四，则减4天 6.如果date是星期五，则减5天
		 * 7.如果date是星期六，则减6天
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case (Calendar.SUNDAY):
			gc.add(Calendar.DATE, 0);
			break;
		case (Calendar.MONDAY):
			gc.add(Calendar.DATE, -1);
			break;
		case (Calendar.TUESDAY):
			gc.add(Calendar.DATE, -2);
			break;
		case (Calendar.WEDNESDAY):
			gc.add(Calendar.DATE, -3);
			break;
		case (Calendar.THURSDAY):
			gc.add(Calendar.DATE, -4);
			break;
		case (Calendar.FRIDAY):
			gc.add(Calendar.DATE, -5);
			break;
		case (Calendar.SATURDAY):
			gc.add(Calendar.DATE, -6);
			break;
		}
		return gc.getTime();
	}

	public static synchronized java.util.Calendar getFirstDayOfWeek(
			java.util.Calendar gc) {
		/**
		 * 详细设计： 1.如果date是星期日，则减0天 2.如果date是星期一，则减1天 3.如果date是星期二，则减2天
		 * 4.如果date是星期三，则减3天 5.如果date是星期四，则减4天 6.如果date是星期五，则减5天
		 * 7.如果date是星期六，则减6天
		 */
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case (Calendar.SUNDAY):
			gc.add(Calendar.DATE, 0);
			break;
		case (Calendar.MONDAY):
			gc.add(Calendar.DATE, -1);
			break;
		case (Calendar.TUESDAY):
			gc.add(Calendar.DATE, -2);
			break;
		case (Calendar.WEDNESDAY):
			gc.add(Calendar.DATE, -3);
			break;
		case (Calendar.THURSDAY):
			gc.add(Calendar.DATE, -4);
			break;
		case (Calendar.FRIDAY):
			gc.add(Calendar.DATE, -5);
			break;
		case (Calendar.SATURDAY):
			gc.add(Calendar.DATE, -6);
			break;
		}
		return gc;
	}

	/*
	 * 得到所处星期的最后一天
	 */

	public static synchronized java.util.Calendar getLastDayOfWeek1(
			java.util.Date d) {
		/**
		 * 详细设计： 1.如果date是星期日，则减0天 2.如果date是星期一，则减1天 3.如果date是星期二，则减2天
		 * 4.如果date是星期三，则减3天 5.如果date是星期四，则减4天 6.如果date是星期五，则减5天
		 * 7.如果date是星期六，则减6天
		 */

		java.util.Calendar gc = DateToCalendar(d);

		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case (Calendar.SUNDAY):
			gc.add(Calendar.DATE, 6);
			break;
		case (Calendar.MONDAY):
			gc.add(Calendar.DATE, 5);
			break;
		case (Calendar.TUESDAY):
			gc.add(Calendar.DATE, 4);
			break;
		case (Calendar.WEDNESDAY):
			gc.add(Calendar.DATE, 3);
			break;
		case (Calendar.THURSDAY):
			gc.add(Calendar.DATE, 2);
			break;
		case (Calendar.FRIDAY):
			gc.add(Calendar.DATE, 1);
			break;
		case (Calendar.SATURDAY):
			gc.add(Calendar.DATE, 0);
			break;
		}

		return gc;
	}

	/**
	 * 取得指定日期的所处月份的最后一天
	 * 
	 * @param date
	 *            指定日期。
	 * @return 指定日期的所处月份的最后一天
	 */
	public static synchronized java.util.Date getLastDayOfMonth(
			java.util.Date date) {
		/**
		 * 详细设计： 1.如果date在1月，则为31日 2.如果date在2月，则为28日 3.如果date在3月，则为31日
		 * 4.如果date在4月，则为30日 5.如果date在5月，则为31日 6.如果date在6月，则为30日
		 * 7.如果date在7月，则为31日 8.如果date在8月，则为31日 9.如果date在9月，则为30日
		 * 10.如果date在10月，则为31日 11.如果date在11月，则为30日 12.如果date在12月，则为31日
		 * 1.如果date在闰年的2月，则为29日
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(Calendar.MONTH)) {
		case 0:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 1:
			gc.set(Calendar.DAY_OF_MONTH, 28);
			break;
		case 2:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 3:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 4:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 5:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 6:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 7:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 8:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 9:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 10:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 11:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		}
		// 检查闰年
		if ((gc.get(Calendar.MONTH) == Calendar.FEBRUARY)
				&& (isLeapYear(gc.get(Calendar.YEAR)))) {
			gc.set(Calendar.DAY_OF_MONTH, 29);
		}
		return gc.getTime();
	}

	public static synchronized java.util.Calendar getLastDayOfMonth(
			java.util.Calendar gc) {
		/**
		 * 详细设计： 1.如果date在1月，则为31日 2.如果date在2月，则为28日 3.如果date在3月，则为31日
		 * 4.如果date在4月，则为30日 5.如果date在5月，则为31日 6.如果date在6月，则为30日
		 * 7.如果date在7月，则为31日 8.如果date在8月，则为31日 9.如果date在9月，则为30日
		 * 10.如果date在10月，则为31日 11.如果date在11月，则为30日 12.如果date在12月，则为31日
		 * 1.如果date在闰年的2月，则为29日
		 */
		switch (gc.get(Calendar.MONTH)) {
		case 0:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 1:
			gc.set(Calendar.DAY_OF_MONTH, 28);
			break;
		case 2:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 3:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 4:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 5:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 6:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 7:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 8:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 9:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 10:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 11:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		}
		// 检查闰年
		if ((gc.get(Calendar.MONTH) == Calendar.FEBRUARY)
				&& (isLeapYear(gc.get(Calendar.YEAR)))) {
			gc.set(Calendar.DAY_OF_MONTH, 29);
		}
		return gc;
	}

	/**
	 * 取得指定日期的所处月份的第一天
	 * 
	 * @param date
	 *            指定日期。
	 * @return 指定日期的所处月份的第一天
	 */
	public static synchronized java.util.Date getFirstDayOfMonth(
			java.util.Date date) {
		/**
		 * 详细设计： 1.设置为1号
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.set(Calendar.DAY_OF_MONTH, 1);
		return gc.getTime();
	}

	public static synchronized java.util.Calendar getFirstDayOfMonth(
			java.util.Calendar gc) {
		/**
		 * 详细设计： 1.设置为1号
		 */
		gc.set(Calendar.DAY_OF_MONTH, 1);
		return gc;
	}

	/***************************************************************************
	 * 将日期对象转换成为指定ORA日期、时间格式的字符串形式。如果日期对象为空，返回 一个空字符串对象，而不是一个空对象。
	 * 
	 * @param theDate
	 *            将要转换为字符串的日期对象。
	 * @param hasTime
	 *            如果返回的字符串带时间则为true
	 * @return 转换的结果
	 **************************************************************************/
	public static synchronized String toOraString(Date theDate, boolean hasTime) {
		/**
		 * 详细设计： 1.如果有时间，则设置格式为getOraDateTimeFormat()的返回值
		 * 2.否则设置格式为getOraDateFormat()的返回值 3.调用toString(Date theDate, DateFormat
		 * theDateFormat)
		 */
		DateFormat theFormat;
		if (hasTime) {
			theFormat = getOraDateTimeFormat();
		} else {
			theFormat = getOraDateFormat();
		}
		return toString(theDate, theFormat);
	}

	/**
	 * 将日期对象转换成为指定日期、时间格式的字符串形式。如果日期对象为空，返回 一个空字符串对象，而不是一个空对象。 将要转换为字符串的日期对象。
	 * 如果返回的字符串带时间则为true
	 * 
	 * @return 转换的结果
	 */
	public static synchronized String toString(Date theDate, boolean hasTime) {
		/**
		 * 详细设计： 1.如果有时间，则设置格式为getDateTimeFormat的返回值 2.否则设置格式为getDateFormat的返回值
		 * 3.调用toString(Date theDate, DateFormat theDateFormat)
		 */
		DateFormat theFormat;
		if (hasTime) {
			theFormat = getDateTimeFormat();
		} else {
			theFormat = getDateFormat();
		}
		return toString(theDate, theFormat);
	}

	/**
	 * 标准日期格式
	 */
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"MM/dd/yyyy");

	/**
	 * 标准时间格式
	 */
	private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat(
			"MM/dd/yyyy HH:mm");

	/**
	 * 带时分秒的标准时间格式
	 */
	// private static final SimpleDateFormat DATE_TIME_EXTENDED_FORMAT = new
	// SimpleDateFormat(
	// "MM/dd/yyyy HH:mm:ss" );
	/**
	 * ORA标准日期格式
	 */
	private static final SimpleDateFormat ORA_DATE_FORMAT = new SimpleDateFormat(
			"yyyyMMdd");

	/**
	 * ORA标准时间格式
	 */
	private static final SimpleDateFormat ORA_DATE_TIME_FORMAT = new SimpleDateFormat(
			"yyyyMMddHHmm");

	/**
	 * 带时分秒的ORA标准时间格式
	 */
	// private static final SimpleDateFormat ORA_DATE_TIME_EXTENDED_FORMAT = new
	// SimpleDateFormat(
	// "yyyyMMddHHmmss" );
	/**
	 * 创建一个标准日期格式的克隆
	 * 
	 * @return 标准日期格式的克隆
	 */
	public static synchronized DateFormat getDateFormat() {
		/**
		 * 详细设计： 1.返回DATE_FORMAT
		 */
		SimpleDateFormat theDateFormat = (SimpleDateFormat) DATE_FORMAT.clone();
		theDateFormat.setLenient(false);
		return theDateFormat;
	}

	/**
	 * 创建一个标准时间格式的克隆
	 * 
	 * @return 标准时间格式的克隆
	 */
	public static synchronized DateFormat getDateTimeFormat() {
		/**
		 * 详细设计： 1.返回DATE_TIME_FORMAT
		 */
		SimpleDateFormat theDateTimeFormat = (SimpleDateFormat) DATE_TIME_FORMAT
				.clone();
		theDateTimeFormat.setLenient(false);
		return theDateTimeFormat;
	}

	/**
	 * 创建一个标准ORA日期格式的克隆
	 * 
	 * @return 标准ORA日期格式的克隆
	 */
	public static synchronized DateFormat getOraDateFormat() {
		/**
		 * 详细设计： 1.返回ORA_DATE_FORMAT
		 */
		SimpleDateFormat theDateFormat = (SimpleDateFormat) ORA_DATE_FORMAT
				.clone();
		theDateFormat.setLenient(false);
		return theDateFormat;
	}

	/**
	 * 创建一个标准ORA时间格式的克隆
	 * 
	 * @return 标准ORA时间格式的克隆
	 */
	public static synchronized DateFormat getOraDateTimeFormat() {

		SimpleDateFormat theDateTimeFormat = (SimpleDateFormat) ORA_DATE_TIME_FORMAT
				.clone();
		theDateTimeFormat.setLenient(false);
		return theDateTimeFormat;
	}

	/**
	 * 将一个日期对象转换成为指定日期、时间格式的字符串。 如果日期对象为空，返回一个空字符串，而不是一个空对象。
	 * 
	 * @param theDate
	 *            要转换的日期对象
	 * @param theDateFormat
	 *            返回的日期字符串的格式
	 * @return 转换结果
	 */
	public static synchronized String toString(Date theDate,
			DateFormat theDateFormat) {
		/**
		 * 详细设计： 1.theDate为空，则返回"" 2.否则使用theDateFormat格式化
		 */
		if (theDate == null)
			return "";
		return theDateFormat.format(theDate);
	}

	/**
	 * @return String
	 */
	public static synchronized String getDateName() {
		Calendar ca = Calendar.getInstance();
		String Date = DateUtil.getDateSecondFormat(ca);
		Date = Date.replaceAll("-", "");
		Date = Date.replaceAll(":", "");
		Date = Date.replaceAll(" ", "");
		return Date.trim();
	}

	/**
	 * 判断时间段的跨度
	 */
	public static synchronized int isOneDay(String startTime, String endTime) {
		int timeFlag = 0;
		Date sDate = DateUtil.parseDateSecondFormat(startTime);
		Date eDate = DateUtil.parseDateSecondFormat(endTime);

		Calendar ca = Calendar.getInstance();
		ca.setTime(new Date());
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH) + 1;
		int day = ca.get(Calendar.DATE);
		String currentStr = year + "-" + month + "-" + day + " " + "00:00:00";
		Date date = DateUtil.parseDateSecondFormat(currentStr);
		if (sDate.getTime() <= eDate.getTime()) {
			if ((sDate.getTime() < date.getTime())
					&& (eDate.getTime() > date.getTime())) {// 时间段跨今天0点
				timeFlag = 2;
			} else if ((sDate.getTime() < date.getTime())
					&& (eDate.getTime() < date.getTime())) {// 时间段在今天之前
				timeFlag = 3;
			} else {// 时间段在今天之内或者之后
				timeFlag = 1;
			}
		}
		return timeFlag;
	}

	/**
	 * 判断时间段的跨度
	 */
	public static synchronized int isOneDay(Date date) {
		int timeFlag = 0;

		Calendar ca = Calendar.getInstance();
		ca.setTime(new Date());
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH) + 1;
		int day = ca.get(Calendar.DATE);
		String currentStr = year + "-" + month + "-" + day + " " + "00:00:00";
		Date today = DateUtil.parseDateSecondFormat(currentStr);
		if (date.getTime() < today.getTime()) { // 今天之前
			timeFlag = 3;
		} else {
			timeFlag = 1;// 在今天或者今天之后
		}
		return timeFlag;
	}

	/**
	 * 计算两个日期相差月数,如果两个日期在同一个月，则返回1
	 */
	@SuppressWarnings("deprecation")
	public static int countMonth(Date beginDate, Date endDate) {
		int beginYear = beginDate.getYear();
		int beginMonth = beginDate.getMonth();
		int endYear = endDate.getYear();
		int endMonth = endDate.getMonth();
		int difMonth = (endYear - beginYear) * 12 + (endMonth - beginMonth) + 1;

		return difMonth;
	}

	/**
	 * 计算两个日期间相差的天数
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static Integer countDay(Date beginDate, Date endDate) {

		Integer difDay = 0;

		Long count = endDate.getTime() - beginDate.getTime();

		difDay = (int) (count / 1000 / 60 / 60 / 24);

		return difDay;
	}

	/**
	 * 计算两个日期间相差的天数
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static Integer countDay(String beginDate, String endDate) {

		try {
			return countDay(parseDateFormat(beginDate),
					parseDateFormat(endDate));
		} catch (Exception e) {
			return 0;
		}

	}

	/**
	 * @Description :计算两个日期间相差的分钟
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static Integer countMinutes(Date beginDate, Date endDate) {
		Long count = endDate.getTime() - beginDate.getTime();
		Integer difMinutes = (int) (count / 1000 / 60);

		return difMinutes;
	}

	/**
	 * @Description : 计算两个日期间相差的分钟(四舍五入）
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static Integer countMinutesRound(Date beginDate, Date endDate) {
		Long count = endDate.getTime() - beginDate.getTime();

		BigDecimal b1 = new BigDecimal(count);
		BigDecimal b2 = new BigDecimal(1000 * 60);
		BigDecimal divide = b1.divide(b2, BigDecimal.ROUND_HALF_EVEN);

		Integer difMinutes = divide.intValue();

		return difMinutes;
	}

	/**
	 * 获取经过时刻 yqs add
	 * 
	 * @param nums
	 * @return
	 */
	public static String getJgsk(int nums) {
		String name = null;
		switch (nums) {
		case 0:
			name = "${zero_oclock}";
			break;
		case 1:
			name = "${one_oclock}";
			break;
		case 2:
			name = "${two_oclock}";
			break;
		case 3:
			name = "${three_oclock}";
			break;
		case 4:
			name = "${four_oclock}";
			break;
		case 5:
			name = "${five_oclock}";
			break;
		case 6:
			name = "${six_oclock}";
			break;
		case 7:
			name = "${seven_oclock}";
			break;
		case 8:
			name = "${eight_oclock}";
			break;
		case 9:
			name = "${nine_oclock}";
			break;
		case 10:
			name = "${ten_oclock}";
			break;
		case 11:
			name = "${eleven_oclock}";
			break;
		case 12:
			name = "${twelve_oclock}";
			break;
		case 13:
			name = "${thirteen_oclock}";
			break;
		case 14:
			name = "${fourteen_oclock}";
			break;
		case 15:
			name = "${fifteen_oclock}";
			break;
		case 16:
			name = "${sixteen_oclock}";
			break;
		case 17:
			name = "${seventeen_oclock}";
			break;
		case 18:
			name = "${eighteen_oclock}";
			break;
		case 19:
			name = "${nineteen_oclock}";
			break;

		case 20:
			name = "${twenty_oclock}";
			break;
		case 21:
			name = "${twenty_one_oclock}";
			break;
		case 22:
			name = "${twenty_two_oclock}";
			break;
		case 23:
			name = "${twenty_three_oclock}";
			break;
		default:
			name = null;
			break;
		}
		return name;
	}

	/**
	 * @Description : 计算两个日期间相差的小时
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static Integer countHours(Date beginDate, Date endDate) {
		Long count = endDate.getTime() - beginDate.getTime();
		Integer difHours = (int) (count / 1000 / 60 / 60);

		return difHours;
	}

	/**
	 * @Description : 计算两个日期间相差的小时(四舍五入）
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static Integer countHoursRound(Date beginDate, Date endDate) {
		Long count = endDate.getTime() - beginDate.getTime();

		BigDecimal b1 = new BigDecimal(count);
		BigDecimal b2 = new BigDecimal(1000 * 60 * 60);
		BigDecimal divide = b1.divide(b2, BigDecimal.ROUND_HALF_EVEN);

		Integer difHours = divide.intValue();

		return difHours;
	}

	/**
	 * @param date
	 * @return 将时间转换为分区条件
	 */
	public static String translateDateToPartition(String date) {
		date = date.substring(0, 10);
		String pattern = "year=''{0}'' and month=''{1}'' and day=''{2}''";
		MessageFormat format = new MessageFormat(pattern);
		return format.format(date.split("-"));
	}

	/**
	 * @param date
	 * @return 将时间转换为分区条件
	 */
	public static String translateDateToPartition(Date date) {
		String temp = getDateW3CFormat(date).substring(0, 10);
		String pattern = "year=''{0}'' and month=''{1}'' and day=''{2}''";
		MessageFormat format = new MessageFormat(pattern);
		return format.format(temp.split("-"));
	}

	/**
	 * @param beginDate
	 * @param endDate
	 * @return 将时间范围转换为分区条件
	 */
	public static List<String> translateDateToPartitions(String beginDate, String endDate) {
		beginDate = beginDate.substring(0, 10);
		endDate = endDate.substring(0, 10);
		Date begin = DateUtil.parseDateDayFormat(beginDate);
		Date end = DateUtil.parseDateDayFormat(endDate);
		return getBetweenPartitions(begin, end);
	}
	
	private static List<String> getBetweenPartitions(Date start, Date end) {
	    List<String> result = new ArrayList<String>();
	    Calendar tempStart = Calendar.getInstance();
	    tempStart.setTime(start);
	    tempStart.add(Calendar.DAY_OF_YEAR, 1);
	    
//        result.add(translateDateToPartition(start));
	    
	    Calendar tempEnd = Calendar.getInstance();
	    tempEnd.setTime(end);
	    while (tempStart.before(tempEnd)) {
	        result.add(translateDateToPartition(tempStart.getTime()));
	        tempStart.add(Calendar.DAY_OF_YEAR, 1);
	    }
	    return result;
	}

	/**
	 * @param date
	 * @return String
	 */
	public static synchronized String getDateMilliOnlyNumber(java.util.Date date) {
		String pattern = "yyyyMMddHHmmssSSS";
		return getDateFormat(date, pattern);
	}

	/**
	 * @Description : 获取年月日
	 * @param date
	 * @return 例:String[0]:2016,String[1]:05,String2]:20
	 */
	public static String[] getNYR(Date date) {
		String timeFormat = getDate(date);

		String year = timeFormat.substring(0, 4);
		String month = timeFormat.substring(5, 7);
		String day = timeFormat.substring(8, 10);

		String[] parseValue = { year, month, day };
		return parseValue;

	}

	/**
	 * @Description : 给当前时间加小时
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date addHour(Date date, int hour) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.add(Calendar.HOUR, hour);

		return calendar.getTime();
	}

	/**
	 * @Description : 给当前时间加8小时
	 * @param date
	 * @return
	 */
	public static Date addHourFor8(Date date) {

		return addHour(date, 8);

	}

	/**
	 * @Description :获取小时部分
	 * @param date
	 * @return
	 */
	public static Integer getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);

		return hour;
	}

	/**
	 * 判断日期是否是当天
	 * @param date
	 * @return
	 */
	public static boolean isCurrentDay(Date date) {
		Calendar target = Calendar.getInstance();
		Calendar current = Calendar.getInstance();
		target.setTime(date);
		boolean year = target.get(Calendar.YEAR) == current.get(Calendar.YEAR);
		boolean month = target.get(Calendar.MONTH) == current.get(Calendar.MONTH);
		boolean day = target.get(Calendar.DAY_OF_MONTH) == current.get(Calendar.DAY_OF_MONTH);
		return (year && month && day) ? true : false;
	}

	/**
	 * 判断日期是否是当前小时
	 * @param date
	 * @return
	 */
	public static boolean isCurrentHour(Date date) {
		Calendar target = Calendar.getInstance();
		Calendar current = Calendar.getInstance();
		target.setTime(date);
		boolean year = target.get(Calendar.YEAR) == current.get(Calendar.YEAR);
		boolean month = target.get(Calendar.MONTH) == current.get(Calendar.MONTH);
		boolean day = target.get(Calendar.DAY_OF_MONTH) == current.get(Calendar.DAY_OF_MONTH);
		boolean hour = target.get(Calendar.HOUR_OF_DAY) == current.get(Calendar.HOUR_OF_DAY);
		return (year && month && day && hour) ? true : false;
	}
	
	/**
	 * 比记录天早,则为历史数据,返回-1;比记录天晚,则是跨天,返回1;和记录天比较,同一天返回0
	 * @param target
	 * @param record
	 * @return
	 */
	public static int compareByDay(String target, String record) {
		Date recordDay = parseDateDayFormat(record);
		Date targetDay = parseDateDayFormat(target);
		if (targetDay.before(recordDay)) {
			return -1;
		}
		if (targetDay.after(recordDay)) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * 比记录小时早,则为历史数据,返回-1;比记录小时晚,则是跨小时,返回1;和记录小时比较,同一小时返回0
	 * @param target
	 * @param record
	 * @return
	 */
	public static int compareByHour(String target, String record) {
		Date recordDay = parseDateHourFormat(record);
		Date targetDay = parseDateHourFormat(target);
		if (targetDay.before(recordDay)) {
			return -1;
		}
		if (targetDay.after(recordDay)) {
			return 1;
		}
		return 0;
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static synchronized Date parseDateHourFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * 判断日期是否是当天
	 * @param sub
	 * @return
	 */
	public static String getDateStringBySub(int sub) {
		Calendar current = Calendar.getInstance();
//		current.set(Calendar.DATE, 0 - sub);
		current.add(Calendar.DAY_OF_YEAR, 0 - sub);
		return getDateDayFormat(current);
	}
	
	public static void main(String[] args) {
		List<String> list = getBetweenPartitions(parseDate("2017-12-01 11:11:11"), new Date());
		for (String date : list) {
			System.out.println(date);
		}
	}
}