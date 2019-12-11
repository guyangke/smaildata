/**
  * Copyright 2012 (C) PANLAB ，All Rights Reserved.
 * 日期         作者 			动作
 * 2012-10-20   青蛙                     创建
 */
package com.gyk.utils;

import java.util.Calendar;
import java.util.Date;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * Title: 基础类
 * </p>
 * <p>
 * Description: 日期转换
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @version 1.0
 */
public class DateUtils {
	/**
	 * Date Style
	 */
	public static final String DATESTYLE = "yyyyMMddHHmmss";

	/**
	 * Date Style for Extention
	 */
	public static final String DATESTYLE_EX = "yyyy-MM-dd_HH-mm-ss";

	/**
	 * Date Style for Extention
	 */
	public static final String DATESTYLE_ = "yyyy-MM-dd";

	/**
	 * Date Style for Year & Month
	 */
	public static final String DATESTYLE_YEAR_MONTH = "yyyyMM";

	/**
	 * Date Style for Short
	 */
	public static final String DATESTYLE_SHORT = "yyyyMMdd";

	/**
	 * Date Style for Extention
	 */
	public static final String DATESTYLE_SHORT_EX = "yyyy/MM/dd";

	/**
	 * Date Style for Year & Month Extention
	 */
	public static final String DATESTYLE_YEAR_MONTH_EX = "yyyy/MM";

	/**
	 * Date Style for detail
	 */
	public static final String DATESTYLE_DETAIL = "yyyyMMddHHmmssSSS";
	
    // 默认日期格式
    public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";

    // 默认时间格式
    public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String TIME_DEFAULT_FORMAT = "HH:mm:ss";

    // 日期格式化
    private static DateFormat dateFormat = null;

    // 时间格式化
    private static DateFormat dateTimeFormat = null;

    private static DateFormat timeFormat = null;

    private static Calendar gregorianCalendar = null;

    static {
        dateFormat = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
        dateTimeFormat = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
        timeFormat = new SimpleDateFormat(TIME_DEFAULT_FORMAT);
        gregorianCalendar = new GregorianCalendar();
    }

	// static long now = System.currentTimeMillis();
	// public static Date CurrTime = new Date(now);
	
	

	/**
	 * 日期转化为字符串
	 * 
	 * @param date
	 *            时间
	 * @return yyyy-MM-dd HH:mm:ss 格式化的时间字符串
	 */
	public static String dateToString(Date date) {
		if (date == null)
			return "";
		return FormatDate(date, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 日期转化为字符串
	 * 
	 * @param date
	 *            时间
	 * @return yyyy-MM-dd 格式化的时间字符串
	 */
	public static String dateToStringShort(Date date) {
		if (date == null)
			return "";
		return FormatDate(date, "yyyy-MM-dd");
	}

	/**
	 * 计算两个日期差（毫秒）
	 * 
	 * @param date1
	 *            时间1
	 * @param date2
	 *            时间2
	 * @return 相差毫秒数
	 */
	public static long diffTwoDate(Date date1, Date date2) {
		long l1 = date1.getTime();
		long l2 = date2.getTime();
		return (l1 - l2);
	}

	/**
	 * 计算两个日期差（天）
	 * 
	 * @param date1
	 *            时间1
	 * @param date2
	 *            时间2
	 * @return 相差天数
	 */
	public static int diffTwoDateDay(Date date1, Date date2) {
		long l1 = date1.getTime();
		long l2 = date2.getTime();
		int diff = Integer.parseInt("" + (l1 - l2) / 3600 / 24 / 1000);
		return diff;
	}

	/**
	 * 对日期进行格式化
	 * 
	 * @param date
	 *            日期
	 * @param sf
	 *            日期格式
	 * @return 字符串
	 */
	public static String FormatDate(Date date, String sf) {
		if (date == null)
			return "";
		SimpleDateFormat dateformat = new SimpleDateFormat(sf);
		return dateformat.format(date);
	}

	/**
	 * 取得当前系统日期
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getCurrDate() {
		Date date_time = new Date();
		return FormatDate(date_time, "yyyy-MM-dd");
	}

	// 取系统时间时一定要用这个方法，否则日期可能不动
	public static Date getCurrDateTime() {
		return new Date(System.currentTimeMillis());
	}

	/**
	 * 取得当前系统时间
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrTime() {
		Date date_time = new Date();
		return FormatDate(date_time, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 10位时间转为8时间
	 * 
	 * @param str
	 * @return
	 */
	public static String getDate10to8(String str) {
		String y = str.substring(0, 4);
		String m = str.substring(5, 7);
		String d = str.substring(8, 10);
		return y + m + d;
	}

	/**
	 * 8位时间转为10时间
	 * 
	 * @param str
	 * @return
	 */
	public static String getDate8to10(String str) {
		String y = str.substring(0, 4);
		String m = str.substring(4, 6);
		String d = str.substring(6, 8);
		return y + "-" + m + "-" + d;
	}

	/**
	 * 取得日期的天份
	 * 
	 * @param date
	 *            日期
	 * @return dd 天字符串
	 */
	public static String getDay(Date date) {
		return FormatDate(date, "dd");
	}

	/**
	 * 取得日期的小时
	 * 
	 * @param date
	 *            日期
	 * @return hh 小时字符串
	 */
	public static String getHour(Date date) {
		return FormatDate(date, "HH");
	}

	/**
	 * 取得日期的分钟
	 * 
	 * @param date
	 *            时间
	 * @return mm 分钟字符串
	 */
	public static String getMinute(Date date) {
		return FormatDate(date, "mm");
	}

	/**
	 * 取得日期的月份
	 * 
	 * @param date
	 *            日期
	 * @return mm 月份字符串
	 */
	public static String getMonth(Date date) {
		return FormatDate(date, "MM");
	}

	public static int getMonth(Date start, Date end) {
		if (start.after(end)) {
			Date t = start;
			start = end;
			end = t;
		}
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(start);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(end);
		Calendar temp = Calendar.getInstance();
		temp.setTime(end);
		temp.add(Calendar.DATE, 1);

		int year = endCalendar.get(Calendar.YEAR)
				- startCalendar.get(Calendar.YEAR);
		int month = endCalendar.get(Calendar.MONTH)
				- startCalendar.get(Calendar.MONTH);

		if ((startCalendar.get(Calendar.DATE) == 1)
				&& (temp.get(Calendar.DATE) == 1)) {
			return year * 12 + month + 1;
		} else if ((startCalendar.get(Calendar.DATE) != 1)
				&& (temp.get(Calendar.DATE) == 1)) {
			return year * 12 + month;
		} else if ((startCalendar.get(Calendar.DATE) == 1)
				&& (temp.get(Calendar.DATE) != 1)) {
			return year * 12 + month;
		} else {
			return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
		}
	}

	/**
	 * 取得时间的秒
	 * 
	 * @param date
	 *            时间
	 * @return ss 秒字符串
	 */
	public static String getSecond(Date date) {
		return FormatDate(date, "ss");
	}

	/**
	 * 根据年、月取得月末的日期
	 * 
	 * @param year
	 *            年
	 * @parm month 月
	 * @return time 返回日期格式"yyyy-mm-dd"
	 */
	public static String getTime(String year, String month) {
		String time = "";
		int len = 31;
		int iYear = Integer.parseInt(year);
		int iMonth = Integer.parseInt(month);
		if (iMonth == 4 || iMonth == 6 || iMonth == 9 || iMonth == 11)
			len = 30;
		if (iMonth == 2) {
			len = 28;
			if ((iYear % 4 == 0 && iYear % 100 == 0 && iYear % 400 == 0)
					|| (iYear % 4 == 0 && iYear % 100 != 0)) {
				len = 29;
			}
		}
		time = year + "-" + month + "-" + String.valueOf(len);
		return time;
	}

	/**
	 * 取得日期的年份
	 * 
	 * @param date
	 *            日期
	 * @return yyyy 年份字符串
	 */
	public static String getYear(Date date) {
		return FormatDate(date, "yyyy");
	}


	/**
	 * 字符串转换为日期
	 * 
	 * @param dateString
	 *            yyyy-MM-dd HH:mm:ss
	 * @return 日期
	 */
	public static Date stringToDate(String dateString) {
		if (dateString == null || dateString.trim().length() == 0)
			return null;
		String datestr = dateString.trim();

		String sf = "yyyy-MM-dd HH:mm:ss";
		Date dt = stringToDate(datestr, sf);
		if (dt == null)
			dt = stringToDate(datestr, "yyyy-MM-dd");
		if (dt == null)
			dt = stringToDate(datestr, "yyyyMMdd");
		return dt;
	}
	/**
	 * 字符串转换为日期
	 * 
	 * @param dateString
	 *            日期格式字符串
	 * @param sf
	 *            日期格式化定义
	 * @return 转换后的日期
	 */
	public static Date stringToDate(String dateString, String sf) {
		ParsePosition pos = new ParsePosition(0);
		SimpleDateFormat sdf = new SimpleDateFormat(sf);
		Date dt = sdf.parse(dateString, pos);
		return dt;
	}
	/**
	 * 字符串转换为日期
	 * 
	 * @param dateString
	 *            yyyy-MM-dd
	 * @return 日期
	 */
	public static Date stringToDateShort(String dateString) {
		String sf = "yyyy-MM-dd";
		Date dt = stringToDate(dateString, sf);
		return dt;
	}

	/**
	 * 取得日以上粒度起始时间
	 * 
	 * @param granularity
	 *            粒度
	 * @param statisticDate
	 *            结束时间
	 * @return 起始时间
	 */
	public  static String getBeginDate(String granularity, String statisticDate) {
		String beginDate = "";
		Date date = DateUtils.stringToDateShort(statisticDate);
		Date beginDateTemp = null;
		if (granularity.equals("1")) {// 日
			beginDateTemp = date;
		}
		if (granularity.equals("2")) {// 周
			beginDateTemp = DateUtils.getWeekBegin(date);
		}
		if (granularity.equals("3")) {// 旬
			beginDateTemp = DateUtils.getPeriodBegin(date);
		} else if (granularity.equals("4")) {// 月
			beginDateTemp = DateUtils.getMonthBegin(date);
		} else if (granularity.equals("5")) {// 季
			beginDateTemp = DateUtils.getSeasonBegin(date);
		} else if (granularity.equals("6")) {// 半年
			beginDateTemp = DateUtils.getHalfYearBegin(date);
		} else if (granularity.equals("7")) {// 年
			beginDateTemp = DateUtils.getYearBegin(date);
		}
		beginDate = DateUtils.dateToStringShort(beginDateTemp);
		return beginDate;
	}


	/**
	 *
	 * @param currentTime
	 *            计算的日期
	 * @param type
	 *            偏移的类别
	 * @param iQuantity
	 *            偏移数量
	 * @return 偏移后的时间
	 */
	public static Date getDateChangeTime(Date currentTime, String type,
			int iQuantity) {
		int year = Integer.parseInt(DateUtils.FormatDate(currentTime, "yyyy"));
		int month = Integer.parseInt(DateUtils.FormatDate(currentTime, "MM"));
		// 月份修正
		month = month - 1;
		int day = Integer.parseInt(DateUtils.FormatDate(currentTime, "dd"));
		int hour = Integer.parseInt(DateUtils.FormatDate(currentTime, "HH"));
		int mi = Integer.parseInt(DateUtils.FormatDate(currentTime, "mm"));
		int ss = Integer.parseInt(DateUtils.FormatDate(currentTime, "ss"));
		GregorianCalendar gc = new GregorianCalendar(year, month, day, hour, mi,
				ss);
		// 月份修正
		// gc.add(GregorianCalendar.MONTH, -1);
		if (type.equalsIgnoreCase("y")) {
			gc.add(GregorianCalendar.YEAR, iQuantity);
		} else if (type.equalsIgnoreCase("m")) {
			gc.add(GregorianCalendar.MONTH, iQuantity);
		} else if (type.equalsIgnoreCase("d")) {
			gc.add(GregorianCalendar.DATE, iQuantity);
		} else if (type.equalsIgnoreCase("h")) {
			gc.add(GregorianCalendar.HOUR, iQuantity);
		} else if (type.equalsIgnoreCase("mi")) {
			gc.add(GregorianCalendar.MINUTE, iQuantity);
		} else if (type.equalsIgnoreCase("s")) {
			gc.add(GregorianCalendar.SECOND, iQuantity);
		}
		return gc.getTime();
	}

	/**
	 *
	 * @param currentTime
	 *            计算的日期
	 * @param type
	 *            偏移的类别
	 * @param iQuantity
	 *            偏移数量
	 * @return 偏移后的时间串
	 */
	public static String getDateChangeTime(String currentTime, String type,
			int iQuantity) {
		Date curr = DateUtils.stringToDate(currentTime);
		curr = DateUtils.getDateChangeTime(curr, type, iQuantity);
		return DateUtils.dateToString(curr);
	}
	/**
	 * 取得日以上粒度起始时间
	 * 
	 * @param granularity
	 *            粒度
	 * @param statisticDate
	 *            结束时间
	 * @return 起始时间
	 */
	public static String getEndDate(String granularity, String statisticDate) {
		String beginDate = "";
		Date date = DateUtils.stringToDateShort(statisticDate);
		Date beginDateTemp = null;

		if (granularity.equals("1")) {// 日
			beginDateTemp = date;
		}
		if (granularity.equals("2")) {// 周
			beginDateTemp = DateUtils.getWeekEnd(date);
		}
		if (granularity.equals("3")) {// 旬
			beginDateTemp = DateUtils.getPeriodEnd(date);
		} else if (granularity.equals("4")) {// 月
			beginDateTemp = DateUtils.getMonthEnd(date);
		} else if (granularity.equals("5")) {// 季
			beginDateTemp = DateUtils.getSeasonEnd(date);
		} else if (granularity.equals("6")) {// 半年
			beginDateTemp = DateUtils.getHalfYearEnd(date);
		} else if (granularity.equals("7")) {// 年
			beginDateTemp = DateUtils.getYearEnd(date);
		}

		beginDate = DateUtils.dateToStringShort(beginDateTemp);
		return beginDate;
	}

	/**
	 * 取半年初
	 * 
	 * @param date
	 * @return
	 */
	public static Date getHalfYearBegin(Date date) {
		int year = Integer.parseInt(DateUtils.FormatDate(date, "yyyy"));
		int month = Integer.parseInt(DateUtils.FormatDate(date, "MM"));
		String newDateStr = DateUtils.FormatDate(date, "yyyy") + "-";
		if (month <= 6) {
			newDateStr += "01-01";
		} else {
			newDateStr += "07-01";
		}
		return DateUtils.stringToDateShort(newDateStr);
	}

	/**
	 * 取半年末
	 * 
	 * @param date
	 * @return
	 */
	public static Date getHalfYearEnd(Date date) {
		int year = Integer.parseInt(DateUtils.FormatDate(date, "yyyy"));
		int month = Integer.parseInt(DateUtils.FormatDate(date, "MM"));
		String newDateStr = DateUtils.FormatDate(date, "yyyy") + "-";
		if (month <= 6) {
			newDateStr += "06-30";
		} else {
			newDateStr += "12-31";
		}
		return DateUtils.stringToDateShort(newDateStr);
	}
	
	 /**
     * 获取当前月的第一天
     * 
     * @return date
     */
    public static Date getFirstDayOfMonth() {
        gregorianCalendar.setTime(new Date());
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取当前月的最后一天
     * 
     * @return
     */
    public static Date getLastDayOfMonth() {
        gregorianCalendar.setTime(new Date());
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        gregorianCalendar.add(Calendar.MONTH, 1);
        gregorianCalendar.add(Calendar.DAY_OF_MONTH, -1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取指定月的第一天
     * 
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取指定月的最后一天
     * 
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        gregorianCalendar.add(Calendar.MONTH, 1);
        gregorianCalendar.add(Calendar.DAY_OF_MONTH, -1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取日期前一天
     * 
     * @param date
     * @return
     */
    public static Date getDayBefore(Date date) {
        gregorianCalendar.setTime(date);
        int day = gregorianCalendar.get(Calendar.DATE);
        gregorianCalendar.set(Calendar.DATE, day - 1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取日期后一天
     * 
     * @param date
     * @return
     */
    public static Date getDayAfter(Date date) {
        gregorianCalendar.setTime(date);
        int day = gregorianCalendar.get(Calendar.DATE);
        gregorianCalendar.set(Calendar.DATE, day + 1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取当前年
     * 
     * @return
     */
    public static int getNowYear() {
        Calendar d = Calendar.getInstance();
        return d.get(Calendar.YEAR);
    }

    /**
     * 获取当前月份
     * 
     * @return
     */
    public static int getNowMonth() {
        Calendar d = Calendar.getInstance();
        return d.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取当月天数
     * 
     * @return
     */
    public static int getNowMonthDay() {
        Calendar d = Calendar.getInstance();
        return d.getActualMaximum(Calendar.DATE);
    }

    /**
     * 获取时间段的每一天
     * 
     * @param 开始日期
     * @param 结算日期
     * @return 日期列表
     */
    public static List<Date> getEveryDay(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return null;
        }
        // 格式化日期(yy-MM-dd)
        startDate = DateUtils.getDateFormat(DateUtils.getDateFormat(startDate));
        endDate = DateUtils.getDateFormat(DateUtils.getDateFormat(endDate));
        List<Date> dates = new ArrayList<Date>();
        gregorianCalendar.setTime(startDate);
        dates.add(gregorianCalendar.getTime());
        while (gregorianCalendar.getTime().compareTo(endDate) < 0) {
            // 加1天
            gregorianCalendar.add(Calendar.DAY_OF_MONTH, 1);
            dates.add(gregorianCalendar.getTime());
        }
        return dates;
    }
    

    /**
     * 日期格式化yyyy-MM-dd
     * 
     * @param date
     * @return
     */
    public static Date formatDate(String date, String format) {
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期格式化yyyy-MM-dd
     * 
     * @param date
     * @return
     */
    public static String getDateFormat(Date date) {
        return dateFormat.format(date);
    }

    /**
     * 日期格式化yyyy-MM-dd HH:mm:ss
     * 
     * @param date
     * @return
     */
    public static String getDateTimeFormat(Date date) {
        return dateTimeFormat.format(date);
    }

    /**
     * 时间格式化
     * 
     * @param date
     * @return HH:mm:ss
     */
    public static String getTimeFormat(Date date) {
        return timeFormat.format(date);
    }

   
    /**
     * 日期格式化
     * 
     * @param date
     * @return
     */
    public static Date getDateFormat(String date) {
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 时间格式化
     * 
     * @param date
     * @return
     */
    public static Date getDateTimeFormat(String date) {
        try {
            return dateTimeFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前日期(yyyy-MM-dd)
     * 
     * @param date
     * @return
     */
    public static Date getNowDate() {
        return DateUtils.getDateFormat(dateFormat.format(new Date()));
    }

    /**
     * 获取当前日期星期一日期
     * 
     * @return date
     */
    public static Date getFirstDayOfWeek() {
        gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        gregorianCalendar.setTime(new Date());
        gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek()); // Monday
        return gregorianCalendar.getTime();
    }

    /**
     * 获取当前日期星期日日期
     * 
     * @return date
     */
    public static Date getLastDayOfWeek() {
        gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        gregorianCalendar.setTime(new Date());
        gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek() + 6); // Monday
        return gregorianCalendar.getTime();
    }

    /**
     * 获取日期星期一日期
     * 
     * @param 指定日期
     * @return date
     */
    public static Date getFirstDayOfWeek(Date date) {
        if (date == null) {
            return null;
        }
        gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek()); // Monday
        return gregorianCalendar.getTime();
    }

    /**
     * 获取日期星期一日期
     * 
     * @param 指定日期
     * @return date
     */
    public static Date getLastDayOfWeek(Date date) {
        if (date == null) {
            return null;
        }
        gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek() + 6); // Monday
        return gregorianCalendar.getTime();
    }

    /**
     * 获取提前多少个月
     * 
     * @param monty
     * @return
     */
    public static Date getFirstMonth(int monty) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -monty);
        return c.getTime();
    }

		

	/**
	 * 取月初
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMonthBegin(Date date) {
		String newDateStr = DateUtils.FormatDate(date, "yyyy-MM") + "-01";
		// FormatDate(date, "yyyy-MM-dd");
		return DateUtils.stringToDateShort(newDateStr);
	}

	/**
	 * 取月末时间
	 * 
	 * @param date
	 *            日期
	 * @return date
	 */
	public static Date getMonthEnd(Date date) {
		int year = Integer.parseInt(DateUtils.FormatDate(date, "yyyy"));
		int month = Integer.parseInt(DateUtils.FormatDate(date, "MM"));
		int day = Integer.parseInt(DateUtils.FormatDate(date, "dd"));

		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day,
				0, 0, 0);
		int monthLength = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
		String newDateStr = DateUtils.FormatDate(date, "yyyy") + "-"
				+ DateUtils.FormatDate(date, "MM") + "-";
		if (monthLength < 10)
			newDateStr += "0" + monthLength;
		else
			newDateStr += "" + monthLength;
		return DateUtils.stringToDateShort(newDateStr);
	}

	/**
	 * 取旬初
	 * 
	 * @param date
	 * @return
	 */
	public static Date getPeriodBegin(Date date) {
		int days = Integer.parseInt(DateUtils.FormatDate(date, "dd"));
		String newDateStr = DateUtils.FormatDate(date, "yyyy-MM") + "-";
		if (days <= 10) {
			newDateStr += "01";
		} else if (days <= 20) {
			newDateStr += "11";
		} else {
			newDateStr += "21";
		}
		return DateUtils.stringToDateShort(newDateStr);
	}

	/**
	 * 取旬末
	 * 
	 * @param date
	 * @return
	 */
	public static Date getPeriodEnd(Date date) {
		int days = Integer.parseInt(DateUtils.FormatDate(date, "dd"));
		String newDateStr = DateUtils.FormatDate(date, "yyyy-MM") + "-";
		if (days <= 10) {
			newDateStr += "10";
		} else if (days <= 20) {
			newDateStr += "20";
		} else {
			newDateStr = DateUtils.FormatDate(DateUtils.getMonthEnd(date), "yyyy-MM-dd");
		}
		return DateUtils.stringToDateShort(newDateStr);
	}

	/**
	 * 取季初
	 * 
	 * @param date
	 * @return
	 */
	public static Date getSeasonBegin(Date date) {
		int year = Integer.parseInt(DateUtils.FormatDate(date, "yyyy"));
		int month = Integer.parseInt(DateUtils.FormatDate(date, "MM"));
		String newDateStr = DateUtils.FormatDate(date, "yyyy") + "-";
		if (month >= 1 && month <= 3) {
			newDateStr += "01-01";
		} else if (month >= 4 && month <= 6) {
			newDateStr += "04-01";
		} else if (month >= 7 && month <= 9) {
			newDateStr += "07-01";
		} else if (month >= 10 && month <= 12) {
			newDateStr += "10-01";
		}
		return DateUtils.stringToDateShort(newDateStr);
	}

	/**
	 * 取季度末时间
	 * 
	 * @param date
	 *            日期
	 * @return date
	 */
	public static Date getSeasonEnd(Date date) {
		int year = Integer.parseInt(DateUtils.FormatDate(date, "yyyy"));
		int month = Integer.parseInt(DateUtils.FormatDate(date, "MM"));
		String newDateStr = DateUtils.FormatDate(date, "yyyy") + "-";
		if (month >= 1 && month <= 3) {
			newDateStr += "03-31";
		} else if (month >= 4 && month <= 6) {
			newDateStr += "06-30";
		} else if (month >= 7 && month <= 9) {
			newDateStr += "09-30";
		} else if (month >= 10 && month <= 12) {
			newDateStr += "12-31";
		}
		return DateUtils.stringToDateShort(newDateStr);
	}

	/**
	 * 取得时间描述 日 yyyy－mm－dd 月 yyyy年mm月 季 yyyy年第×季度 年 yyyy年
	 * 
	 * @param granularity
	 *            粒度
	 * @param statisticDate
	 *            时间
	 * @return 时间对应粒度的描述
	 */
	public static String getTimedes(String granularity, String statisticDate) {
		String timedes = "";
		Date date = DateUtils.stringToDateShort(statisticDate);
		String year = "", month = "01", day = "01";
		year = DateUtils.getYear(date);
		month = DateUtils.getMonth(date);
		day = DateUtils.getDay(date);
		if (granularity.equals("1")) {// 日
			timedes = statisticDate;
		} else if (granularity.equals("4")) {// 月
			timedes = year + "年" + month + "月";

		} else if (granularity.equals("8")) {// 季
			String quarter = month + "-" + day;
			if (quarter.equals("03-31")) {
				timedes = year + "年 第1季度";
			} else if (quarter.equals("06-30")) {
				timedes = year + "年 第2季度";
			} else if (quarter.equals("09-30")) {
				timedes = year + "年 第3季度";
			} else if (quarter.equals("12-31")) {
				timedes = year + "年 第4季度";
			}
		} else if (granularity.equals("32")) {// 年
			timedes = year + "年";
		}
		return timedes;
	}

	/**
	 * 取周初
	 * 
	 * @param date
	 * @return
	 */
	public static Date getWeekBegin(Date date) {

		int year = Integer.parseInt(DateUtils.FormatDate(date, "yyyy"));
		int month = Integer.parseInt(DateUtils.FormatDate(date, "MM"));
		// 月份修正
		month = month - 1;
		int day = Integer.parseInt(DateUtils.FormatDate(date, "dd"));

		GregorianCalendar gc = new GregorianCalendar(year, month, day);

		int week = GregorianCalendar.DAY_OF_WEEK - 1;

		if (week == 0) {
			week = 7;
		}

		gc.add(GregorianCalendar.DATE, 0 - week + 1);

		return gc.getTime();
	}

	/**
	 * 取周末
	 * 
	 * @param date
	 * @return
	 */
	public static Date getWeekEnd(Date date) {

		int year = Integer.parseInt(DateUtils.FormatDate(date, "yyyy"));
		int month = Integer.parseInt(DateUtils.FormatDate(date, "MM"));
		// 月份修正
		month = month - 1;
		int day = Integer.parseInt(DateUtils.FormatDate(date, "dd"));

		GregorianCalendar gc = new GregorianCalendar(year, month, day);

		int week = GregorianCalendar.DAY_OF_WEEK - 1;

		if (week == 0) {
			week = 7;
		}
		gc.add(GregorianCalendar.DATE, 7 - week);

		return gc.getTime();
	}

	/**
	 * 取得年初
	 * 
	 * @param date
	 * @return
	 */
	public static Date getYearBegin(Date date) {
		String newDateStr = DateUtils.FormatDate(date, "yyyy") + "-01-01";
		return DateUtils.stringToDateShort(newDateStr);
	}

	/**
	 * 是否为年末
	 * 
	 * @param date
	 *            时间
	 * @return
	 */
	public static Date getYearEnd(Date date) {
		String newDateStr = DateUtils.FormatDate(date, "yyyy") + "-12-31";
		return DateUtils.stringToDateShort(newDateStr);
	}

	/**
	 * 是否为旬末
	 * 
	 * @param date
	 *            时间
	 * @return 是或否
	 */
	public static boolean IsXperiodEnd(Date date) {

		boolean flag = false;

		String day = DateUtils.getDay(date);
		String month = DateUtils.getMonth(date);

		if (day.equalsIgnoreCase("10")) {
			flag = true;
		} else if (day.equalsIgnoreCase("20")) {
			flag = true;
		}
		// 月末不算旬末
		// else if( DateUtils.getMonthEnd(date).compareTo(date)==0 ){
		// flag = true;
		// }

		return flag;
	}

	/**
	 * 日期加N天
	 * 
	 * @param Sring
	 *            时间
	 * @return 加后的日期
	 */
	public static String addDay(String s, int n) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Calendar cd = Calendar.getInstance();
			cd.setTime(sdf.parse(s));
			cd.add(Calendar.DATE, n);// 增加一天
			// cd.add(Calendar.MONTH, n);//增加一个月

			return sdf.format(cd.getTime());

		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 日期加N天
	 * 
	 * @param Sring
	 *            时间
	 * @return 加后的日期
	 */
	public static String delDay(String s, int n) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Calendar cd = Calendar.getInstance();
			cd.setTime(sdf.parse(s));
			cd.add(Calendar.DATE, -n);// 增加一天
			// cd.add(Calendar.MONTH, n);//增加一个月

			return sdf.format(cd.getTime());

		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将Date转换成Calendar类型
	 * 
	 * @param date
	 * @return
	 */
	public static Calendar dateToCalendar(Date date) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		return instance;
	}

	/**
	 * 将日期字符串转换成Calendar类型
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Calendar stringToCalendar(String str) {
		Date date = stringToDate(str);
		return dateToCalendar(date);
	}

	/**
	 * 根据日期算年龄
	 * 
	 * @param birthday
	 *            字符串类型的日期
	 * @return
	 * @throws ParseException
	 */
	public static int getAge(String birthday) {
		Calendar calendar = stringToCalendar(birthday);
		calendar.setTime(stringToDate(birthday));
		int age = calendar.get(Calendar.YEAR);
		Calendar instance = Calendar.getInstance();
		int age2 = instance.get(Calendar.YEAR);
		return age2 - age;
	}

	/**
	 * 根据日期算年龄
	 * 
	 * @param birthday
	 *            Date类型的参数
	 * @return
	 */
	public static int getAge(Date birthday) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birthday);
		int age = calendar.get(Calendar.YEAR);
		Calendar instance = Calendar.getInstance();
		int age2 = instance.get(Calendar.YEAR);
		return age2 - age;
	}

	/**
	 * 判断到未来需要的天数
	 * 
	 * @param future
	 * @return
	 */
	public static int getFutureDays(String future) {

		Date date = new Date();
		long time = date.getTime();

		Date formateStringToDate = stringToDate(future);
		long time2 = formateStringToDate.getTime();

		long dt = time2 - time;

		int day = (int) (dt / 1000 / 60 / 60 / 24);
		return day;
	}

	/**
	 * 日期比较
	 * 
	 * @return
	 */
	public static boolean compareTo(Date date, Date date2) {

		long time = date.getTime();

		long time2 = date2.getTime();

		return time - time2 > 0 ? true : false;
	}

	/**
	 * 判断给定日期是否是当天
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isToday(String str) {
		/*
		 * 获取日期的年 月 日 Calendar instance = Calendar.getInstance();
		 * instance.setTime(new Date()); instance.get(Calendar.YEAR);
		 * instance.get(Calendar.MONTH); instance.get(Calendar.DAY_OF_MONTH);
		 */

		int futureDays = getFutureDays(str);
		if (futureDays == 0) {
			return true;
		}
		return false;
	}
	/**
	 * 判断当前给定的日期是否在本周之内
	 * 
	 * @return
	 */
	public static boolean isDayInWeek(String date) {

		Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		int year = instance.get(Calendar.YEAR);
		int month = instance.get(Calendar.MONTH);
		int dayOfWeek = instance.get(Calendar.DAY_OF_WEEK_IN_MONTH);

		Date stringToDate = stringToDate(date);
		Calendar dateToCalendar = dateToCalendar(stringToDate);
		int year1 = dateToCalendar.get(Calendar.YEAR);
		int month1 = dateToCalendar.get(Calendar.MONTH);
		int dayOfWeek1 = dateToCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);

		if (year == year1 && month == month1 && dayOfWeek == dayOfWeek1) {
			return true;
		}
		return false;
	}

	/***
	 * 给定时间对象，初始化到该年初的1月1日0时0分0秒0毫秒
	 */
	public static void setInitDate(String str) {
		Date stringToDate = stringToDate(str);
		Calendar dateToCalendar = dateToCalendar(stringToDate);
		dateToCalendar.set(Calendar.MONTH, 1);
		dateToCalendar.set(Calendar.DAY_OF_YEAR, 1);
		dateToCalendar.set(Calendar.HOUR, 0);
		dateToCalendar.set(Calendar.MINUTE, 0);
		dateToCalendar.set(Calendar.SECOND, 0);
		dateToCalendar.set(Calendar.MILLISECOND, 0);

		System.out.println(dateToCalendar.getTime());

	}

	/**
	 * 方法2：根据传入的参数获取该日期的月初日期，例如给定的日期为“2019-09-19 19:29:39”，返回“2019-09-01
	 * 00:00:00”
	 */
	public static Date getDateByMonthInit(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		int year = ca.get(Calendar.YEAR);
		int mouth = ca.get(Calendar.MONTH);
		ca.clear();
		ca.set(Calendar.YEAR, year);
		ca.set(Calendar.MONTH, mouth);
		ca.set(Calendar.HOUR, 0);
		return ca.getTime();
	}

	/**
	 * 方法3 :根据传入的参数获取该日器的月末日期，例如给定的日期为“2019-09-19 19:29:39”，返回“2019-09-30
	 * 23:59:59”，注意月大月小以及闰年。
	 */
	public static Date getDateByMonthLast(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		int year = ca.get(Calendar.YEAR);
		int mouth = ca.get(Calendar.MONTH);
		ca.clear();
		ca.set(Calendar.HOUR, 0);
		ca.set(Calendar.YEAR, year);
		ca.set(Calendar.MONTH, mouth + 1);
		Long time = ca.getTime().getTime();
		return new Date(time - 1);
	}

	/** 方法4：求未来日期离今天还剩的天数 */
	public static int getDaysByFuture(Date future) {
		Date now = new Date();
		return (int) ((future.getTime() - now.getTime())
				/ (60 * 60 * 24 * 1000));
	}

	/** 方法5：求过去日期离今天过去的天数 */
	public static int getDaysByDeparted(Date departed) {
		Date now = new Date();
		return (int) ((now.getTime() - departed.getTime())
				/ (60 * 60 * 24 * 1000));
	}

	/** 随机一个时间 param:int类型的年份，随机日期在该年份之后 */
	public static Date getRandomDate(int year) {
		Calendar now = Calendar.getInstance();
		int nowYear = now.get(Calendar.YEAR);
		int nowMouth = now.get(Calendar.MONTH) + 1;
		int nowDay = now.get(Calendar.DATE);

		Random rd = new Random();
		int newYear = rd.nextInt(nowYear - year + 1) + year;
		int newMonth = 0;
		if (newYear == year) {
			newMonth = rd.nextInt(nowMouth);
		} else {
			newMonth = rd.nextInt(13);
		}
		// newMonth = newMonth==0?newMonth+1:newMonth;
		int newDay = 0;
		if (newYear == year && newMonth == nowMouth) {
			newDay = rd.nextInt(nowDay + 1);
		} else {
			if (newMonth != 4) {
				newDay = rd.nextInt(31);
			} else {
				newDay = rd.nextInt(29);
			}
		}
		newDay = newDay == 0 ? newDay + 1 : newDay;
		Date date = new Date(rd.nextInt(1000 * 60 * 60 * 24));
		now.setTime(date);
		now.set(newYear, newMonth, newDay);
		return now.getTime();
	}

}
