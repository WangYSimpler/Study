package com.simple.utils;

import java.lang.reflect.ParameterizedType;

public class BaseHello<T> {  
	
    private Class<T> entityClass;  
      
    @SuppressWarnings("unchecked")
	public BaseHello(){  
        //entityClass怎么赋值？（怎么能知道entityClass就是代表Personal这个类？）  
    	ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass(); 

    	setEntityClass((Class<T>)(parameterizedType.getActualTypeArguments()[0]));
    }

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}  
	
	public static void main(String[] args) {  
	    BaseHello<String> pdao = new BaseHello<String>();  
	    System.out.println(pdao);  
	}  
}  
