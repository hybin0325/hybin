package com.edas.edascommon.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LocalDateUtils {

	/**
	 * 转long
	 */
	public static long getTimestampOfDateTime(LocalDateTime localDateTime) {
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = localDateTime.atZone(zone).toInstant();
		return instant.toEpochMilli();
	}

	public static LocalDateTime getDateTimeOfTimestamp(long timestamp) {
		Instant instant = Instant.ofEpochMilli(timestamp);
		ZoneId zone = ZoneId.systemDefault();
		return LocalDateTime.ofInstant(instant, zone);
	}

	public static long getAgoMinutes10(Long time) {
		//System.out.println("获取当前系统时间为：" + getDateTimeOfTimestamp(time));// 转换成标准年月日的形式
		// Long time1 =time-20*1000*60;//在当前系统时间的基础上往后加30分钟
		Long time1 = time - 1 * 1000 * 60;
		//System.out.println("一分钟前的时间为：" + getDateTimeOfTimestamp(time1));

		return time1;
	}

	public static void main(String[] args) {
		System.out.println(getTimestampOfDateTime(LocalDateTime.now()));
		System.out.println(System.currentTimeMillis());
		System.out.println(SystemClock.millisClock().now()+"  SystemClock");
		long start = System.currentTimeMillis();
		 System.out.println(getAgoMinutes10(System.currentTimeMillis())+" ddd ");
		long end = System.currentTimeMillis();
		System.out.println("SystemClock Time:" + (end - start) + "毫秒");

		// int times=Integer.MAX_VALUE;
		/*
		 * long start = System.currentTimeMillis(); for (long i = 0; i < times; i++) {
		 * SystemClock.millisClock().now(); } long end = System.currentTimeMillis();
		 * 
		 * System.out.println("SystemClock Time:" + (end - start) + "毫秒");
		 * 
		 * long start2 = System.currentTimeMillis(); for (long i = 0; i < times; i++) {
		 * System.currentTimeMillis(); } long end2 = System.currentTimeMillis();
		 * System.out.println("SystemCurrentTimeMillis Time:" + (end2 - start2) + "毫秒");
		 * 
		 * long start3 = System.currentTimeMillis(); for (long i = 0; i < times; i++) {
		 * LocalDateTime.now(); } long end3 = System.currentTimeMillis();
		 * System.out.println("SystemCurrentTimeMillis Time:" + (end3 - start3) + "毫秒");
		 */
	}

}
