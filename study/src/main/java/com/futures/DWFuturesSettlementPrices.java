/**
 * Copyright © 2018 SCF. All rights reserved
 * @ bookCar 
 * @author WangY
 * 2018年8月17日
 */
package com.futures;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.simple.http.HttpRequest;

public class DWFuturesSettlementPrices {
	
	public static void main(String[] args) {
		
		HttpRequest httpRequestObj = new HttpRequest();
		
		String shfeUrl = "http://www.shfe.com.cn/data/";
		String dailydataStr = "dailydata/kx/" + "kx" + "20200417" + ".dat";		
		
		//发送登录请求
		String rtnDailyDataStr = httpRequestObj.sendGet(shfeUrl + dailydataStr,"");
		
		JSONObject jsonObject = JSON.parseObject(rtnDailyDataStr);
		JSONArray data = jsonObject.getJSONArray("o_curinstrument");
        
	/*	data.forEach(shfeObject ->{
			String prductId = (JSONObject.parseObject(shfeObject)).get("PRODUCTID");
		});*/
		
        for (int i = 0 ;i < data.size();i++) {
        	JSONObject jsonObj = data.getJSONObject(i);
        	System.out.println("id :" + jsonObj.get("PRODUCTID"));
		}
    }
}
