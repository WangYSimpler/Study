package com.simple.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	
	/**
	 *  获取当前格式化日期
	 * @param dateForMatStr
	 * @return
	 */
	public static String getCurrentDate(String dateFormatStr) {

		/// 格式化
		String dateForMat = dateFormatStr;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateForMat);

		/// 日期格式
		Date currentTime = new Date();
		String dateString = simpleDateFormat.format(currentTime);
		return dateString;
	}

	/**
	 * 日期格式转换
	 * @param sourceDateStr
	 * @param sourceDateForMatStr
	 * @param targetDateFormatStr
	 * @return
	 */
	public static String transDateFormat(String sourceDateStr, String sourceDateForMatStr, String targetDateFormatStr) {

		String sourceDate = sourceDateStr;
		String sourceDateForMat = sourceDateForMatStr;
		String targetDateFormat = targetDateFormatStr;

		SimpleDateFormat sdf = new SimpleDateFormat(sourceDateForMat);
		String targetDateStr = "";
		if (sourceDate != null) {
			try {
				targetDateStr = new SimpleDateFormat(targetDateFormat).format(sdf.parse(sourceDate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		return targetDateStr;

	}

	//
	public static String retFormatNowDate() {
		
		return formatLongDate(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss");
	}

	public static String formatLongDate(Long longTime,String dateFormatStr) {
		
		  Date nowTime = new Date(longTime);
		  SimpleDateFormat sdFormatter = new SimpleDateFormat(dateFormatStr);
		  String retStrFormatNowDate = sdFormatter.format(nowTime);

		  return retStrFormatNowDate;
		}
 
	
	
	
	public static void main(String[] args) {
		System.out.println(getCurrentDate("yy"));
		System.out.println(transDateFormat("","yyyy-MM-dd HH:mm:ss","yyyy年MM月dd日 HH小时mm分"));
	}

}