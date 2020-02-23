package com.simple.variableType;



public class VariableType {
	
	//获取变量的类型名称
	public static String getVariableType(Object obj){
		return obj.getClass().getTypeName();
	}

	public static void main(String[] args) {
		
		int a =0;
		String typeName_Integer = getVariableType(a);
		System.out.println(typeName_Integer);
		
		String b ="abc";
		String typeName_String = getVariableType(b);
		System.out.println(typeName_String);
		
	}
}
