package com.simple.exception;

import java.util.Arrays;

/**
 * 数组异常的测试
 * @author WangY
 * @Date   2017年6月14日
 */
public class ArrayExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[5];
		Arrays.fill(array, 8);
		
		for (int i = 0; i < 5; i++) {
			System.out.println("array[" + i +"] = " + array[i]);			
		}
	}

}
