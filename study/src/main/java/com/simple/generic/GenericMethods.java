package com.simple.generic;


/**
 * 自定 义泛型方法
 * 
 * @author WangY
 * @Date   2017年6月7日
 */
public class GenericMethods {

	/**
	 * 当方法操作的引用数据类型不确定的时候，可以将泛型定义在方法上  
	 * @param x 传参数
	 */
	public <T> void f(T x){
		System.out.println(x.getClass().getName());  
	}
	
	public static void main(String[] args) {
		
		GenericMethods gm = new GenericMethods();  
        gm.f(99);  
        gm.f("掌上洪城");  
        gm.f(new Integer(99));  
        gm.f(18.88);  
        gm.f('a');  
        gm.f(gm);  

	}

}
