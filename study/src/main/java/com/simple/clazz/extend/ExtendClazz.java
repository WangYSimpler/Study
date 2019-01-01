package com.simple.clazz.extend;

class Parent{
	public Parent(){
		System.out.println("Parent 构造方法！！");
	}
	
}

class Child extends Parent{
	Child(){
		System.out.println("Child 构造方法！！");
	}
	
}



public class ExtendClazz {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Child childObj = new Child();
				
	}

}
