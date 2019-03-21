package com.simple.redis;

import redis.clients.jedis.Jedis;

public class RedisJava {
	
	public void testResdisDemo(Jedis jedis ) {
		   //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Jedis jedis = new Jedis("localhost");
		
		RedisJava redisJava = new RedisJava();
		Jedis jedis = new Jedis("127.0.0.1");
		System.out.println("连接成功");
		// 查看服务是否运行
		System.out.println("服务正在运行: " + jedis.ping());
		
		redisJava.testResdisDemo(jedis);

	}

}
