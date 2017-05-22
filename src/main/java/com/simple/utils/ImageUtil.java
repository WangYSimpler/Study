package com.simple.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class ImageUtil {

	public <T> Image getImage( T t) {

		Image image = null;
	
		if (t instanceof File || t instanceof InputStream || t instanceof ImageInputStream  || t instanceof URL) {
			System.out.println("1222");
		}
		try {
			image = ImageIO.read((File)t);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		return image;

	}
	
	 // 测试主函数  
	   public static void main(String args[]) {  
	      File file = new File("d://大图1.jpg");  
	     new  ImageUtil().getImage(file);
	    }  


}
