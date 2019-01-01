package com.simple.generic;

import java.util.ArrayList;

/**
 *  泛型擦除 
 * @author WangY
 * @Date   2017年6月7日
 */
public class ErasedTypeEquivalence {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		/**
		 * 在泛型内部，无法获得任何有关泛型参数类型的信息。
		 * ArrayList<String>和ArrayList<Integer>是相同的类型。
		 */
		Class c1 = new ArrayList<String>().getClass();  
        Class c2 = new ArrayList<Integer>().getClass();  
        System.out.println(c1 == c2);  
	}

}
