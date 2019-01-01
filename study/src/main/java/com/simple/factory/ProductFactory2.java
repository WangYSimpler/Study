package com.simple.factory;

/**
 * 
 ***************************
 * 2017年8月9日 WangY 创建文件
 * 利用发射进行生成工厂模式
 ***************************
 */
public class ProductFactory2 {
	
	public static Product produce(String classNamestr) throws Exception {
		Product product2 = null;
		try {
			product2 = (Product)Class.forName(classNamestr).newInstance();
			return product2;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new Exception("没有该产品");
	}
	
	public static void main(String[] args) {
		try {
			ProductFactory2.produce("com.simple.factory.Car");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
