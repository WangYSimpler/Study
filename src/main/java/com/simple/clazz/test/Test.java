package com.simple.clazz.test;

import com.simple.clazz.Animal;
import com.simple.clazz.Cat;

public class Test {

	public static void main(String[] args) {

		Animal a = new Cat();// 向上转型
		a.eat();

		Cat c = (Cat) a;// 向下转型
		c.eat();
	}

}
