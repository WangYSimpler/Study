package com.study.jsonTest;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.study.test.Test;

public class FastJsonDemo {
	
	
	public void Test(){
		String json= "{\"pids\":[\"1\",\"2\",\"3\"]}";
		System.out.println(new JsonParser().parse(json).getAsJsonObject().getAsJsonArray("pids"));
		
		String str = "{\"a\":\"b\", \"c\":\"d\"}";  
		JsonObject jsonObject = new Gson().fromJson(str);
	        System.out.println(jsonObject); // {"c":"d","a":"b"}  
	        System.out.println(jsonObject.get("c")); // d  
		

	}
	
	
	public static void main(String[] args){
		new FastJsonDemo().Test();
		
	}
	//JsonObject jsonObject = ""
	
	
	//String json= "{\"pids\":[\"1\",\"2\",\"3\"]}";
	//System.out.println(new JsonParser().parse(json).getAsJsonObject().getAsJsonArray("pids").get(0).getAsString());

}
