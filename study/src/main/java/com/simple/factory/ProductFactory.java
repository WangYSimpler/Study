package com.simple.factory;


public class ProductFactory {

	public static Product produce(String productNameStr) throws Exception{
		switch (1) {
		/*case "TV":
			return new TV();
		case "Car":
			return new Car();*/

		default:
			throw new Exception("没有该产品！！");
			
		}
	}
	
	
	public static void main(String[] args) {
		try {
			ProductFactory.produce("Car");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
