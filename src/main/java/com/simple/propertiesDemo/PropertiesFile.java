package com.simple.propertiesDemo;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties settings = new Properties();
		
		try {
			settings.load(new FileInputStream("c:\\count.java"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
