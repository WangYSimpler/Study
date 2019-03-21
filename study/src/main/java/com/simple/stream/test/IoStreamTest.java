package com.simple.stream.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.simple.stream.ReaderFiles;
import com.simple.stream.WriterFile;

/**
 * 
 * @author WangY
 * @Date 2017年5月17日
 */
public class IoStreamTest {
	
	
	/**
	 * 读文件例子
	 * @param fileNameStr
	 */
	public void readfileDemo(String fileNameStr){
		
		String fileName = "E:" + File.separator + fileNameStr;
		
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
	
	/**
	 * 写文件例子
	 */
	public void writeFileDemo(){
		
		String dirName = "e:/temp.txt";
		
		String fileName = "e:" + File.separator + "Hello.txt";
		
		File f = new File(fileName);
		WriterFile wf = new WriterFile();
		wf.createFile(dirName);
		
		String fileContent = new ReaderFiles().readerFile(f);
		
		wf.writeFile(dirName, fileContent);
		
		
	}

	public static void main(String[] args) {
		
		IoStreamTest ioStreamTest  = new IoStreamTest();
		ioStreamTest.readfileDemo("1.txt");
		
		ioStreamTest.writeFileDemo();
		
		ioStreamTest.readfileDemo("temp.txt");
	}
}
