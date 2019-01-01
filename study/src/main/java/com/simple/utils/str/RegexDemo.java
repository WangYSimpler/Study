package com.simple.utils.str;

public class RegexDemo {
	public static void main(String[] args) {
		String s1 = "Mark007";
		String s2 = "mark007";
		//
		boolean bn1 = s1.matches("\\p{Upper}\\p{Lower}\\p{Lower}\\p{Lower}\\d\\d\\d");
		boolean bn2 = s2.matches("\\p{Upper}\\p{Lower}\\p{Lower}\\p{Lower}\\d\\d\\d");
		
		System.out.println(bn1+":" +bn2);
		//
		boolean bn3 = s1.matches("\\p{Upper}\\p{Lower}{3}\\d{3}");
		System.out.println(bn3);
		
		
		
	}
}
