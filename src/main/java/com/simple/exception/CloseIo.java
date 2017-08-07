package com.simple.exception;

import java.io.FileInputStream;
import java.io.IOException;

public class CloseIo {

	private FileInputStream fileIn = null;
	
	public void readInfo(){
		try {
			fileIn = new FileInputStream("d:\\Role.java");
			System.out.println("创建IO流，分配内存资源");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("创建IO对象发生异常");
		}finally {
			//System.out.println("test");
			if (fileIn != null) {
				try {
					fileIn.close();
					System.out.println("关闭IO流，释放内存资源");
				} catch (IOException e2) {
					e2.printStackTrace();
					System.out.println("关闭IO对象异常!!");
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		CloseIo ex = new CloseIo();
		ex.readInfo();
	}

}
