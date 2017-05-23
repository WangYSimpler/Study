package com.study.classExtend;
 
class animal
{
	String name;
	int legs;
}

class birds extends animal
{
	String wings;
}
public class TestClassExtend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		birds durk = new birds();
		durk.legs = 2;
		durk.name = "Black Duck";
		durk.wings="black";
		
		System.out.println(durk.legs);
	}

}
