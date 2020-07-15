package com.aplus.fileservice.utils;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 田平 2008-1-28
 */
public class DateUtil {
	public static final String defaultDTPattern = "yyyy-MM-dd HH:mm:ss";
	public static final String defaultDT1Pattern = "yyyyMMddHHmmss";
	public static final String defaultDPattern = "yyyy-MM-dd";
	public static final String defaultD1Pattern = "yyyyMMdd";

	public static final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(defaultDTPattern);
	public static final DateTimeFormatter dateTime1Formatter = DateTimeFormat.forPattern(defaultDT1Pattern);
	public static final DateTimeFormatter dateFormatter = DateTimeFormat.forPattern(defaultDPattern);
	public static final DateTimeFormatter date1Formatter = DateTimeFormat.forPattern(defaultD1Pattern);

	/**
	 * 返回预设Format的当前日期字符串
	 */
	public static String getToday() {
		Date today = new Date();
		return format(today);
	}

	/**
	 * 使用预设Format格式化Date成字符串
	 */
	public static String format(Date date) {
		String returnValue = null;
		if (date != null) {
			DateTime dateTime = new DateTime(date);
			returnValue = dateTime.toString(defaultDTPattern);
		}
		return returnValue;
	}

	/**
	 * 使用参数Format格式化Date成字符串
	 */
	public static String format(Date date, String pattern) {
		String returnValue = null;
		if (date != null) {
			DateTime dateTime = new DateTime(date);
			return dateTime.toString(pattern);
		}
		return returnValue;
	}

	/**
	 * 使用参数Format将字符串转为Date
	 */
	public static Date parse(String strDate, String pattern) {
		if (StringUtils.hasText(strDate)) {
			DateTime dateTime = DateTime.parse(strDate, DateTimeFormat.forPattern(pattern));
			return dateTime.toDate();
		} else {
			return null;
		}

	}

	/**
	 * 在日期上增加数个整月
	 */
	public static Date addMonth(Date date, int n) {
		DateTime dateTime = new DateTime(date);
		dateTime = dateTime.plusMonths(n);
		return dateTime.toDate();
	}

	/**
	 * 在日期上加多少天
	 * 
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date addDay(Date date, int n) {
		DateTime dateTime = new DateTime(date);
		dateTime = dateTime.plusDays(n);

		return dateTime.toDate();
	}

	/**
	 * 在日期上增加小时
	 */
	public static Date addHour(Date date, int n) {
		DateTime dateTime = new DateTime(date);
		dateTime = dateTime.plusHours(n);
		return dateTime.toDate();
	}

	/**
	 * 在日期上增加数个整分钟
	 */
	public static String addMinute(Date date, int n) {
		DateTime dateTime = new DateTime(date);
		dateTime = dateTime.plusMinutes(n);
		return dateTime.toString(defaultDTPattern);
	}

	public static Date addMinuteDate(Date date, int n) {
		DateTime dateTime = new DateTime(date);
		dateTime = dateTime.plusMinutes(n);
		return dateTime.toDate();
	}

	/**
	 * 在日期上增加数个整秒
	 */
	public static String addSecond(Date date, int n) {
		DateTime dateTime = new DateTime(date);
		dateTime = dateTime.plusSeconds(n);
		return dateTime.toString(defaultDTPattern);
	}

	public static Date addSecondDate(Date date, int n) {
		DateTime dateTime = new DateTime(date);
		dateTime = dateTime.plusSeconds(n);
		return dateTime.toDate();
	}

	/**
	 * 校验时间是否天数是在当前天数之后
	 * 
	 * @param date
	 */
	public static boolean checkTimeAfterCurrent(Date date) {
		DateTime start = new DateTime(new Date());
		DateTime end = new DateTime(date);
		Period period = new Period(start, end);
		if (period.getDays() > 0 || period.getMonths() > 0 || period.getYears() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static float getUseSecond(Date date) {
		long before = date.getTime();
		long curr = new Date().getTime();
		float difference = curr - before;
		float second = difference / 1000;
		return second;
	}

	public static int getUseTime(Date date) {
		long before = date.getTime();
		long curr = new Date().getTime();
		long difference = curr - before;
		return (int) difference;
	}

	/**
	 * 获取上个月第一天
	 * 
	 * @param date
	 * @return 2017-09-01 00:00:00
	 */
	public static String lastMonthFirstDay(Date date) {
		DateTime dateTime = new DateTime(date);
		dateTime = dateTime.plusMonths(-1).dayOfMonth().withMinimumValue().millisOfDay().withMinimumValue();
		return dateTime.toString(defaultDTPattern);
	}

	/**
	 * 获取上个月最后一天
	 * 
	 * @param date
	 * @return 2017-09-30 23:59:59
	 */
	public static String lastMonthEndDay(Date date) {
		DateTime dateTime = new DateTime(date);
		dateTime = dateTime.plusMonths(-1).dayOfMonth().withMaximumValue().millisOfDay().withMaximumValue();
		return dateTime.toString(defaultDTPattern);
	}

	/**
	 * 获取上周一
	 * 
	 * @param date
	 * @return 2017-10-23 00:00:00
	 */
	public static String lastWeekFirstDay(Date date) {
		DateTime dateTime = new DateTime(date);
		dateTime = dateTime.plusDays(0 - dateTime.getDayOfWeek()).withDayOfWeek(1).millisOfDay().withMinimumValue();
		return dateTime.toString(defaultDTPattern);
	}

	/**
	 * 获取上周日
	 * 
	 * @param date
	 * @return 2016-09-30 23:59:59
	 */
	public static String lastWeekEndDay(Date date) {
		DateTime dateTime = new DateTime(date);
		dateTime = dateTime.plusDays(0 - dateTime.getDayOfWeek()).millisOfDay().withMaximumValue();
		return dateTime.toString(defaultDTPattern);
	}

	/**
	 * 获取当月第一天
	 * 
	 * @param date
	 * @return
	 */
	public static String monthFirstDay(Date date) {
		DateTime dateTime = new DateTime(date);
		dateTime = dateTime.dayOfMonth().withMinimumValue().withMillisOfDay(0);
		return dateTime.toString(defaultDTPattern);
	}

	/**
	 * 获取当前时间前后某一天
	 * 
	 * @param date
	 * @return
	 */
	public static String afterDay(Date date, int dayCount) {
		DateTime dateTime = new DateTime(date);
		dateTime = dateTime.plusDays(dayCount);
		return dateTime.withMillisOfDay(0).toString(defaultDTPattern);
	}

	public static float getBetweenMinute(Date start, Date end) {
		if (start == null || end == null) {
			return 0;
		}
		long l_start = start.getTime();
		long l_end = end.getTime();
		float difference = Math.abs(l_end - l_start);
		float minute = difference / 1000 / 60;
		return minute;
	}

	public static String getHourMinute(long distance) {
		long hour = distance / (3600 * 1000);
		long minute = (distance - hour * 3600 * 1000) / (60 * 1000);
		return hour + "小时" + minute + "分钟";
	}

	/**
	 * 将Long类型的数据转换成日期类型的数据
	 * 
	 * @param time
	 * @return
	 */
	public static Date convertLongValueToDate(Long time) {
		if (time == null) {
			return null;
		}
		DateTime dt = new DateTime(time);
		return dt.toDate();
	}

	public static boolean isWeek(Date date) {
		DateTime dt = new DateTime(date);
		if (dt.getDayOfWeek() == 6 || dt.getDayOfWeek() == 7) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取当前年份
	 * 
	 * @return
	 */
	public static int getYear() {
		DateTime dt = new DateTime();
		return dt.getYear();
	}

	/**
	 * 获取当前月
	 * 
	 * @return
	 */
	public static int getMonth() {
		DateTime dt = new DateTime();
		return dt.getMonthOfYear();
	}

	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public static int getDay() {
		DateTime dt = new DateTime();
		return dt.getDayOfMonth();
	}

	/**
	 * 把element-ui格式的时间返回转换为开始结束时间列表
	 * 
	 * @param dateRange "[2017-08-03T16:00:00.000Z, 2017-08-27T16:00:00.000Z]"
	 * @return
	 */
	public static List<Date> getElementUIDateRange(String dateRange) {
		List<Date> dateRanges = new ArrayList<Date>();
		String[] dates = dateRange.split(", ");
		Date inSDate = parse(dates[0], "'['yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Date inEDate = parse(dates[1], "yyyy-MM-dd'T'HH:mm:ss.SSS'Z]'");
		DateTime sDate = new DateTime(inSDate);
		DateTime eDate = new DateTime(inEDate);
		dateRanges.add(sDate.millisOfDay().withMinimumValue().toDate());
		dateRanges.add(eDate.millisOfDay().withMaximumValue().toDate());
		return dateRanges;
	}
}
