package com.study.anno;
///自定义注解
public  @interface MyAnnotation {

	public String key() default "2";
	public String value() default "laowu";
}


