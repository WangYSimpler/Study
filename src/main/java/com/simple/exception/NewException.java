package com.simple.exception;

/**
 * 自定异常使用
 * @author WangY
 * @Date   2017年6月14日
 */
public class NewException extends Exception {

	private static final long serialVersionUID = 1L;
	public NewException(Double r){
		System.out.println("发生异常:圆的半径不能小于20");
		System.out.println("圆的半径为：" + r);
	}
	 
	public static void showArea(double r) throws NewException{
		if (r<= 20) {
			throw new NewException(r);
		}
		
		double area = 3.14 * r * r;
		
		System.out.println("圆的面积是：" + area);
		
	}
	
	public static void main(String[] args) {
		try {
			showArea(10);
		} catch (NewException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
