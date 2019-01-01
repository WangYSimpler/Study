package com.study.callBack;

public class Client implements MyCallInterface {

	public void method() {
	
	}
	
	public static void main(String[] args) {
		Caller caller = new Caller();
		caller.setCallFunc(new Client());
	
		caller.call();
		
	}

	

}
