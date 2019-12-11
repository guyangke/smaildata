package com.gyk.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.gyk.utils.DateUtil;
import com.gyk.utils.DateUtils;

public class TestDateUtil {

	//根据日期判断年龄
	@Test
	public void getAge() throws ParseException {
		System.out.println(DateUtil.getAgeByBirth("2000-06-08"));
	}
	
	//根据传入的参数获取该日期的月初日期，例如给定的日期为“2019-09-19 19:29:39”，返回“2019-09-01 00:00:00”
	@Test
	public  void getDateByMonthInit () throws ParseException {
		String time = "2000-06-08";
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sim.parse(time);
		System.out.println(DateUtils.getDateByMonthInit(date));
	}

	//根据传入的参数获取该日器的月末日期，例如给定的日期为“2019-09-19 19:29:39”，返回“2019-09-30 23:59:59”，注意月大月小以及闰年。
	@Test
	public void getDateByMonthLast() throws ParseException {
		String time = "2000-06-08";
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sim.parse(time);
		System.out.println(DateUtils.getDateByMonthLast(date));
		
	}
	
	//求未来日期离今天还剩的天数
	@Test
	public void getDaysByFuture () throws ParseException {
		String time = "2020-01-13";
		System.out.println(DateUtil.testFurtherHasDay(time));
	}
	
	//求过去日期离今天过去的天数
	@Test
	public void getDaysByDeparted () throws ParseException {
		String datetime = "2000-06-08";
		System.out.println(DateUtil.testPast(datetime));
		
	}



}
