package com.simple.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReaderFiles {
	
	
	/**
	 * 默认读取UTF-8 文件
	 * @param fileHandle
	 * @return
	 */
	public String readerFile(File fileHandle) {
		File f = fileHandle;
		return this.readerFile(f,"UTF-8");
	}


	/**
	 * 读取文件 以指定的编码方式
	 * @param fileHandle
	 * @param encodeingStr
	 * @return
	 */
	public String readerFile(File fileHandle,String encodeingStr) {
		
		File f = fileHandle;
		//文件编码方式
		String encodeing = encodeingStr;
		
		StringBuffer strBuffer = new StringBuffer();
		 
	    String line = "";
	 
	    FileInputStream fis = null;
	 
	    InputStreamReader isr = null;
	 
	    BufferedReader br = null;
	 
	    try {
	 
	        fis = new FileInputStream(f);
	 
	        isr = new InputStreamReader(fis,encodeing);
	 
	        br = new BufferedReader(isr);
	 
	        while ((line = br.readLine()) != null) {
	        	///文件读入遇到换行换行 "\n" 和  "\r" 回车符 ，拼接增加换行符
	        	strBuffer.append(line).append("\n");
	 
	        }
	 
	    } catch (Exception e) {
	 
	        e.printStackTrace();
	 
	    } finally {
	 
	        try {
	 
	            fis.close();
	 
	        } catch (Exception e) {
	 
	            e.printStackTrace();
	        }
	 
	    }
	 
	    return strBuffer.toString();
	}

	
	
	
	
	public static void main(String[] args) {
		
		String fileName = "D:" + File.separator + "Hello.txt";
		
		File f = new File(fileName);
		
		System.out.println(new ReaderFiles().readerFile(f));
	}

}
