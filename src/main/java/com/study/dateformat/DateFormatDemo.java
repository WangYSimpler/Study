package com.study.dateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DateFormatDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleDateFormat sDF1 = new SimpleDateFormat("yyy-mm-dd hh:mm:ss");
		SimpleDateFormat sDF2 = new SimpleDateFormat("yyyy年mm月dd日hh时mm分ss秒");
		SimpleDateFormat sDF3 = new SimpleDateFormat("yyyymmdd hhmmss");
		
		try {
			Date data1= sDF1.parse("2016-1-24 18:30:38");
			System.out.println(sDF2.format(data1));
			System.out.println(sDF3.format(data1));
			
		} catch (ParseException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	

}
