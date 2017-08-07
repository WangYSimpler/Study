package com.simple.utils.str;

public class ReplaceStringDemo {

	
	public static void main(String[] args) {
		
		String str1 = "bad bad study!!!";
		
		///完全替代字符串中所有
		String str2 = str1.replace("bad", "good");
		System.out.println(str2);
		
		String str3 = str1.replaceFirst("bad", "good");
		System.out.println(str3);
		
	}
}
