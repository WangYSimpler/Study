package com.study.generic;


class Building{
	
}

class House extends Building{
	
}

/**
 *  擦除补偿
 * @author WangY
 * @Date   2017年6月7日
 * @param <T>
 */
public class ClassTypeCapture<T> {

	Class<T> kind;
	
	
	
	public ClassTypeCapture(Class<T> kind) {
		super();
		this.kind = kind;
	}

	public boolean f(Object arg){
		return kind.isInstance(arg);
	}

	public static void main(String[] args) {
		
		  ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(Building.class);  
		  
	        System.out.println(ctt1.f(new Building()));  
	        System.out.println(ctt1.f(new House()));  
	        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<House>(House.class);  
	        System.out.println(ctt2.f(new Building()));  
	        System.out.println(ctt2.f(new House()));  
	}

}
