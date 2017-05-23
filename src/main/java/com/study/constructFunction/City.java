package com.study.constructFunction;

public class City extends Country {

	String name;

	void value() {
		name = "Hefei";
		System.out.println(name);
		///构造方法实现方法保证获取到父类的函数
		super.value();// 不调用此方法时，super.name返回的是父类的成员变量的值null
		System.out.println(super.name);
	}

	public static void main(String[] args) {
		City c = new City();
		c.value();
	}
}
