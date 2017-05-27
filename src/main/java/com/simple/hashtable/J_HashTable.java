package com.simple.hashtable;

import java.util.Hashtable;

/**
 * hash 表测试
 * @author WangY
 * @Date   2017年5月22日
 */
public class J_HashTable {

	public static void main(String[] args) {
		
		String[] sa = {"Mary","Tom","Herry"};
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		
		//int i = 0;
		
		for(int i = 0;i < sa.length;i++){
			ht.put(sa[i], i);
		}
		System.out.println(sa[1]);
		
		System.out.println(ht.get(sa[1]));
		
		
	}

}
