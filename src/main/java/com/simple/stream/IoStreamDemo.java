package com.simple.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author WangY
 * @Date 2017年5月17日
 */
public class IoStreamDemo {

	public static void main(String[] args) {

		String fileName = "D:" + File.separator + "Hello.txt";
		
		File f = new File(fileName);
		InputStream in;
		try {
			in = new FileInputStream(f);
			byte[] b = new byte[1024];
			in.read(b);
			in.close();
			System.out.println(new String(b));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
