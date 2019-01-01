/**
 * 
 */
package com.simple.polymorphism;

/**
 *@author WangY
 *@Date 2017 2017年2月5日 
 */
public class SubClass extends BaseClass{

	/**
	 * @param args
	 */
    public String book = "子类书";
	
	public void sub()
	{
		System.out.println("SubClass function！");
	}
	
	public void test()
	{
		System.out.println("sub test function!!");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseClass polly = new SubClass();
		
		System.out.println(polly.book);
		polly.test();
		
		
	}

}
