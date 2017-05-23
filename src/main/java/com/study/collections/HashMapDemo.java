package com.study.collections;

import java.util.HashMap;

class Demo
{
	private String name;
	private int age;
	
	Demo(String name,int age)
	{
		this.name= name;
		this.age= age;
	}
	
	public String toString()
	{
		return "姓名:"+this.name+", 年龄:"+this.age;
	}
}

public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	HashMap hMap = new HashMap<>();
	hMap.put(new Demo("张三",23),"张三");
	System.out.println(hMap.get(hMap.get(new Demo("张三", 23))));
	}

}
