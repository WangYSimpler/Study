package com.study.callBack;

public class Client implements MyCallInterface {

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("»Øµ÷º¯Êý²âÊÔ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Caller caller = new Caller();
		caller.setCallFunc(new Client());
	
		caller.call();
		
	}

	

}
