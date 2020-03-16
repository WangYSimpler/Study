package com.simple.redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisJava {
	
	public void testResdisHashDemo(Jedis jedis ) {
		   //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
	}

	public static void main(String[] args) {
			
		RedisJava redisJava = new RedisJava();
		Jedis jedis = new Jedis("127.0.0.1");
		//redis 连接信息
		{
			System.out.println("连接成功");
			// 查看服务是否运行
			System.out.println("服务正在运行: " + jedis.ping());
		}
		
		
		//demohash
		redisJava.testResdisHashDemo(jedis);
		
		//demo list
		redisJava.testResdisListDemo(jedis);
		
		//key 
		System.out.println("redis keys");
		redisJava.testResdisKeysDemo(jedis);
		jedis.del("*");
		redisJava.testResdisKeysDemo(jedis);
	}
	
	//redis list
	public void testResdisListDemo(Jedis jedis ) {
		
		jedis.ltrim("site-list", -1L,0L); 
		
		//存储数据到列表中
	    jedis.lpush("site-list", "Runoob");
	    jedis.lpush("site-list", "Google");
	    jedis.lpush("site-list", "Taobao");
	    
	    // 获取存储的数据并输出
	    List<String> list = jedis.lrange("site-list", 0 ,jedis.llen("site-list"));
	    for(int i=0; i<=list.size()-1; i++) {
	        System.out.println("列表项为: "+list.get(i));
	    }
	}
	
	//keys
	public void testResdisKeysDemo(Jedis jedis ) {
		// 获取数据并输出
        Set<String> keys = jedis.keys("*"); 
        Iterator<String> it=keys.iterator() ;   
        while(it.hasNext()){   
            String key = it.next();   
            System.out.println(key);   
        }
	}

}
