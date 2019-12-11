/**
 * Create Date:2019年12月6日
 */
package com.gyk.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * <br>Title:TODO 类标题
 * <br>Description:TODO 类功能描述
 * <br>Author:谷杨科2523854480@qq.com)
 * <br>Date:2019年12月6日
 */
public class DateUtil {
  //根据日期算年龄
  public static int getAgeByBirth(String birthDay) throws ParseException {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date fDate = format.parse(birthDay);
    int age = 0;
    Calendar cal = Calendar.getInstance();
    if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
      throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
    }
    int yearNow = cal.get(Calendar.YEAR); //当前年份
    int monthNow = cal.get(Calendar.MONTH); //当前月份
    int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
    cal.setTime(fDate);
    int yearBirth = cal.get(Calendar.YEAR);
    int monthBirth = cal.get(Calendar.MONTH);
    int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
    age = yearNow - yearBirth; //计算整岁数
    if (monthNow <= monthBirth) {
      if (monthNow == monthBirth) {
        if (dayOfMonthNow < dayOfMonthBirth)
          age--;//当前日期在生日之前，年龄减一
      } else {
        age--;//当前月份在生日之前，年龄减一
      }
    }
    return age;
  }

  //求未来日期离今天还剩的天数
  public static String testFurtherHasDay(String d) throws ParseException {

    Date date = new Date();

    long a = date.getTime();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    long b = sdf.parse(d).getTime();

    int success = (int) ((b - a) / (1000 * 60 * 60 * 24)); //1000毫秒*60分钟*60秒*24小时 = 天
    return "距离" + d + "还有" + success + "天";
  }

  //求过去日期离今天还剩的天数
  public static String testPast(String datetime) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = sdf.parse(datetime);
    long s1 = date.getTime();//将时间转为毫秒
    long s2 = System.currentTimeMillis();//得到当前的毫秒
    int day = (int) ((s2 - s1) / 1000 / 60 / 60 / 24);
    return datetime + "距现在已有" + day + "天";
  }

  //判断给定的日期是否是同一日期
  /**
   * 判断时间是不是今天
   * @param date
   * @return    是返回true，不是返回false
   * @throws ParseException 
   */
  public static boolean isNowDay(String date) throws ParseException {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date fDate = format.parse(date);
    //当前时间
    Date now = new Date();
    SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
    //获取今天的日期
    String nowDay = sf.format(now);

    //对比的时间
    String day = sf.format(fDate);

    if (day.equals(nowDay)) {
      return true;
    } else {
      return false;
    }
  }

  //判断给定的日期是否在本周之内
  public static boolean isInWeek(String time) throws ParseException {
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());
    firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);
    int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);
    firstDayOfWeek.add(Calendar.DATE, -day + 1 + 1);// 后面的+1是因为从周日开始
    // 本周一的日期
    //System.out.println(format.format(firstDayOfWeek.getTime()));

    Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());
    lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);
    day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);
    lastDayOfWeek.add(Calendar.DATE, 7 - day + 1);
    // 本周星期天的日期

    // System.out.println(format.format(lastDayOfWeek.getTime()));
    int time1 = Integer.parseInt(time);
    int time2 = Integer.parseInt(format.format(firstDayOfWeek.getTime()));
    int time3 = Integer.parseInt(format.format(lastDayOfWeek.getTime()));

    if (time1 >= time2 && time1 <= time3) {
      return true;
    } else {
      return false;
    }
  }

  //判断是否在本月
  public static boolean isInMonth(String time) throws ParseException {
    //2019-12-06
    System.out.println(time);
    Date date = new Date();

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String NowMonth = format.format(date);
    String[] split2 = NowMonth.split("-");

    String[] split1 = time.split("-");

    if (Integer.parseInt(split1[1]) == Integer.parseInt(split2[1])
      && Integer.parseInt(split1[0]) == Integer.parseInt(split2[0])) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * 获取日期所在月的第一天 date基准日期
   * 
   * @param date
   *      yyyy-MM-dd
   * @return String （yyyy-MM）
   * @throws Exception
   * 
   * */
  public static String getMonthFirstDate(String date) throws Exception {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Date dt = df.parse(date);
    Calendar c = Calendar.getInstance();
    c.setTime(dt);
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH);
    c.set(year, month, 1);
    String mDateTime = df.format(c.getTime());
    String strStart = mDateTime.substring(0, 10);
    return strStart;
  }

  /**
  * 获取日期所在月的最后一天
  * 
  * @param date基准日期yyyy
  *      -MM-dd
  * @return String yyyy-MM-dd
  * @throws Exception
  * 
  * */
  public static String getMonthLastDate(String date) throws Exception {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Date dt = df.parse(date);
    Calendar c = Calendar.getInstance();
    c.setTime(dt);
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH);
    int dayNum = c.getActualMaximum(Calendar.DAY_OF_MONTH);
    c.set(year, month, dayNum);
    String mDateTime = df.format(c.getTime());
    String strStart = mDateTime.substring(0, 10);
    return strStart;
  }

  /**比较两个日期
   * @param sDate 起始日期
   * @param eDate 结束日期
   * @param pattern 日期格式
   * @return boolean 返回比较结果
   * @throws Exception
   */
  public static boolean compareDate(String sDate, String eDate, String pattern) throws Exception {

    DateFormat df1 = new SimpleDateFormat(pattern);
    Date date1 = df1.parse(sDate);
    Date date2 = df1.parse(eDate);
    if (null == date1 || null == date2) {
      return false;
    }
    long intervalMilli = date2.getTime() - date1.getTime();
    if (intervalMilli > 0) {
      return true;
    }
    return false;
  }
}
