package com.study.classExtend;

public class GenericMethodTest {

	public static <E> void printArray(E[] inputArray) {
		for (E e : inputArray) {
			System.out.printf("%s ",e);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] num = {1,2,3,4};
		printArray(num);
	}

}
