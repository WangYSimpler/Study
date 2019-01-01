package com.simple.regex;

import java.util.regex.Pattern;

public class RegexExample {

	public static void main(String[] args) {
		
		String content = "I am noob " + "from runoob.com.";
		String pattern = ".*runoob.*";
		boolean isMatch = Pattern.matches(pattern, content);
		System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
		
		String  pattern1 = ".*noo.*";
		boolean match = Pattern.matches(pattern1, content);
		System.out.println("字符串中是否包含了 'noo' 子字符串? " + match);
		
	}

}
