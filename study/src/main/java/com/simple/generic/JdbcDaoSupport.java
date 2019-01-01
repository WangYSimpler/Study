/**
 * 
 */
package com.simple.generic;
import java.lang.reflect.ParameterizedType;
/**
 *@author WangY
 *@Date 2017 2017年3月4日 
 */
public abstract class JdbcDaoSupport <T>{
	
	private Class<T> clazz;
	
    @SuppressWarnings("unchecked")
	protected JdbcDaoSupport() {
        clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
        System.out.println(clazz.getClass().getSimpleName());
    }

}
