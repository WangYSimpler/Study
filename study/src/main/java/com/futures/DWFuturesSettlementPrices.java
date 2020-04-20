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
import com.google.gson.JsonParser;
import com.simple.http.HttpRequest;



public class DWFuturesSettlementPrices {
	
	public static void main(String[] args) {
		
		HttpRequest httpRequestObj = new HttpRequest();
 
		//http://www.shfe.com.cn/data/dailydata/kx/kx20200417.dat
		
		String shfeUrl = "http://www.shfe.com.cn/data/";
		String dailydataStr = "dailydata/kx/" + "kx" + "20200417" + ".dat";		
		
		//发送登录请求
		String rtnDailyDataStr = httpRequestObj.sendGet(shfeUrl + dailydataStr,"");
		System.out.println(new JsonParser().parse(rtnDailyDataStr).getAsJsonObject().getAsJsonArray("o_curinstrument").get(0).getAsString());
		
		
		JSONObject jsonObject = JSON.parseObject(rtnDailyDataStr);
        @SuppressWarnings("unused")
		JSONArray data = jsonObject.getJSONArray("o_curinstrument");
       // for(JSONObject result : data ){ result = data.getJSONObject("result");}

    }

}
