package com.simple.propertiesDemo;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties captials = new Properties();
		
		captials.put("中国", "北京");
		captials.put("日本", "东京");
		captials.put("美国", "华盛顿");
		
		@SuppressWarnings("rawtypes")
		Set states = captials.keySet();
		String str;		
		@SuppressWarnings("rawtypes")
		Iterator itr= states.iterator();
		while (itr.hasNext()) {
			str=(String)itr.next();
			System.out.println("国家:"+str+"，首都："+captials.getProperty(str));
			
		}

		str=captials.getProperty("法国","没有发现");
		System.out.println("法国的首都 "+str+". ");
		
	}

}
