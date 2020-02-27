package com.simple.util.json;

import com.google.gson.Gson;

public class GsonTest {

	public void commonGsonTest() {

		// Serialization
		Gson gson = new Gson();
		String json = gson.toJson(1); // ==> 1
		System.out.println(json);
		json = gson.toJson("abcd"); // ==> "abcd"
		System.out.println(json);
		json = gson.toJson(new Long(10)); // ==> 10
		System.out.println(json);
		int[] values = { 1 };

		json = gson.toJson(values); // ==> [1]
		System.out.println(json);

		// Deserialization
		int one = gson.fromJson("1", int.class);
		System.out.println(one);
		Integer oneInteger = gson.fromJson("1", Integer.class);
		Long oneLong = gson.fromJson("1", Long.class);
		Boolean falseBoolean = gson.fromJson("false", Boolean.class);
		String str = gson.fromJson("\"abc\"", String.class);
		String[] anotherStr = gson.fromJson("[\"abc\"]", String[].class);
	}

	class GsonObjecTest {
		private int value1 = 1;
		private String value2 = "abc";
		private transient int value3 = 3;

		GsonObjecTest() {
			// no-args constructor
		}
	}

	/**
	 * 普通 json 转换json代码
	 */
	public void commonGsonObjectTest() {

		// Serialization
		GsonObjecTest obj = new GsonObjecTest();
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		System.out.println(json);
		
		
		//deSerialization object 对象
		GsonObjecTest reObj = gson.fromJson(json,GsonObjecTest.class);
		
		System.out.println(reObj.value1+":" + reObj.value2);

	}

	public static void main(String[] args) {
		
		GsonTest gsonTestObject = new GsonTest();
		gsonTestObject.commonGsonTest();

		gsonTestObject.commonGsonObjectTest();
	}

}
