package com.simple.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 可变参数与泛型方法
 * 
 * @author WangY
 * @Date   2017年6月7日
 */
public class GenericVarargs {

	/**
	 *  可变参数
	 * @param args
	 * @return
	 */
	@SafeVarargs
	public static <T> List<T> makeList(T... args){  
        List<T> result = new ArrayList<T>();  
        for(T item:args)  
            result.add(item);  
        return result;         
    }  
	
    @SuppressWarnings("rawtypes")
	public static void main(String[] args) {  
        List ls = makeList("A");  
        System.out.println(ls);  
        ls = makeList("A","B","C");  
        System.out.println(ls);  
        ls = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));  
        System.out.println(ls);  
    }  

}
