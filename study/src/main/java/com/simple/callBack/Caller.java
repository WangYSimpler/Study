package com.simple.callBack;

public class Caller {
	
	public MyCallInterface mci;

	public void setCallFunc(MyCallInterface mci) {
		this.mci = mci;
	}

	public void call() {
		this.mci.method();
	}
}
