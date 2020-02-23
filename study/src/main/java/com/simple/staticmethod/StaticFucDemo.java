package com.simple.staticmethod;

class StaticDemo {
	
	private String name;
	private int age;
	private static String city = "南京";

	public StaticDemo(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String talk() {
		return "名称:" + this.name + ", 年龄:" + this.age + "，所在城市 ：" + city;
	}

	public static void setCity(String c) {
		city = c;
	}

}

public class StaticFucDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticDemo p1 = new StaticDemo("张三", 25);
		StaticDemo p2 = new StaticDemo("李四", 30);
		StaticDemo p3 = new StaticDemo("王五", 26);
		System.out.println("old ："+p1.talk());
		System.out.println("old ："+p2.talk());
		System.out.println("old ："+p3.talk());
		
		///new setCity()
		StaticDemo.setCity("上海");
		///new
		System.out.println("new ："+p1.talk());
		System.out.println("new ："+p2.talk());
		System.out.println("new ："+p3.talk());
		

	}

}
