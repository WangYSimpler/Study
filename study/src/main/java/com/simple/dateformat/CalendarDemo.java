package com.simple.dateformat;

import java.util.Calendar;

public class CalendarDemo {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		for (int i = 0; i < 5; i++) {
			System.out.println("123");		
		}
		Calendar calDemo = Calendar.getInstance();
		
		///printf current time
		System.out.println(calDemo.get(calDemo.YEAR)+"��"+(calDemo.get(calDemo.MONTH)+1)+"��"+calDemo.get(calDemo.DAY_OF_MONTH)+calDemo.get(calDemo.HOUR));
		/// add 230 days
		calDemo.add(calDemo.DAY_OF_YEAR, 230);
		///printf current +230
		System.out.println(calDemo.get(calDemo.YEAR)+"��"+(calDemo.get(calDemo.MONTH)+1)+"��"+calDemo.get(calDemo.DAY_OF_MONTH)+calDemo.get(calDemo.HOUR));

	}

}
