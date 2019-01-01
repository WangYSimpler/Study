package com.simple.generic;

import java.util.Random;

interface Generator<T> {  
    public T next();  
}  
  
class Coffee{  
    public String toString(){  
        return getClass().getSimpleName();  
    }  
}  
  
class Mocha extends Coffee{}  
class Cappuccino extends Coffee{}  
class Breve extends Coffee{}  
class Latte extends Coffee{}  
  
class CoffeeGenerator implements Generator<Coffee>{ //T为Coffee  
    private static Random rand = new Random(47);  
    @SuppressWarnings("rawtypes")
	private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Breve.class};  
    public Coffee next(){ //T为Coffee  
        try {  
            return (Coffee)  
                    types[rand.nextInt(types.length)].newInstance();  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }   
    }  
} 

public class InterfaceGenTest {

	public static void main(String[] args) {
		 CoffeeGenerator gen = new CoffeeGenerator();  
	        for(int i=0; i<4; i++){  
	            System.out.println(gen.next());  
	        }  
	}

}
