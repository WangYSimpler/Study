package com.simple.classExtend;

public class GenericMethodTest {

	public static <E> void printArray(E[] inputArray) {
		for (E e : inputArray) {
			System.out.printf("%s ",e);
		}
		System.out.println("展示结束");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] num = {1,2,3,4};
		Long[] longs ={1L,2L,3l,5l};
		
		printArray(num);
		printArray(longs);
	}

}
