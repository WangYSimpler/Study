package com.simple.staticmethod;

class StaticDemo {
	private String name;
	private int age;
	private static String city = "����";

	public StaticDemo(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String talk() {
		return "����:" + this.name + ", ����:" + this.age + "�꣬���ԣ�" + this.city;
	}

	public static void setCity(String c) {
		city = c;

	}

}

public class StaticFucDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticDemo p1 = new StaticDemo("����", 25);
		StaticDemo p2 = new StaticDemo("����", 30);
		StaticDemo p3 = new StaticDemo("����", 26);
		System.out.println("old"+p1.talk());
		System.out.println("old"+p2.talk());
		System.out.println("old"+p3.talk());
		
		///new setCity()
		StaticDemo.setCity("�Ͼ�");
		///new
		System.out.println("old"+p1.talk());
		System.out.println("old"+p2.talk());
		System.out.println("old"+p3.talk());
		

	}

}
