package com.simple.exception;

public class ThowException {

	public static void throwException(){
		throw new UnsupportedOperationException("方法尚未实现");
	}
	
	public static void main(String[] args) {
		
		ThowException.throwException();
	}

}
