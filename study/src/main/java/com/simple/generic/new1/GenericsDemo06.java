package com.simple.generic.new1;


class Point<T>{
	private T var;
	
	public void setVar(T var) {
		this.var = var;
	}
	
	public T getVar(){
		return var;
	}
	
}
public class GenericsDemo06 {
	 public static void main(String args[]){  
		 Point <String> point = new Point<String>();
		 point.setVar("it");
		 System.out.println(point.getVar().length());
	 }
	 
}
