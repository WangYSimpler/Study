/**
 * @file   JsonTest.java
 * @author WangY
 * @Date  2017年3月15日
 */
package com.study.json;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 *
 *@author  WangY
 *@Date    2017年3月15日 
 */
public class JsonTest {
	
	 public  Map<String, String> getProvinceAndCountryCBAInvest(String inJsonStr)
	    {
	    	String inJson = inJsonStr;
	    	
	    	//List<Map<String, String>> inMapsList = new ArrayList<Map<String,String>>();
	    	Map<String, String> inDto = null;
	    	if (inJson != null && !"".equals(inJson)) {
	    		Gson gson = new Gson();
	    		inDto = gson.fromJson(inJson,new TypeToken<Map<String,String>>(){}.getType());
			}
	    	return inDto;
	    }
	 
	 public static void main(String[] args) {
		 String testStr = "{\"cbaid\":\"CB2300000000002016120005\",\"xclb\":\"\",\"xcjy\":\"1\",\"ssxzqh\":\"1\",\"tjxcdm\":\"2\",\"tjxc\":\"3\"}";
		System.out.println(new JsonTest().getProvinceAndCountryCBAInvest(testStr));
	}
}
