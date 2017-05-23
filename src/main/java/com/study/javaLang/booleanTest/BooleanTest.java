package com.study.javaLang.booleanTest;


public class BooleanTest {
	
	public void test()
	{System.out.println("test");}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Boolean b1 = new Boolean("true");
		System.out.print(b1 );
		
		Boolean b2 = new Boolean(true);
		System.out.print(b2);
		
		System.out.println();
		String aString = "1";
		switch (aString) {
		case "1":
			System.out.println("输入的字节是" + 1);
			
			break;

		default:
			break;
		}

		
		
	}

}
