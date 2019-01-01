package com.simple.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;


public class ImageUtils {
	
	private File picture ;
	/**  构造方法 **/
	public ImageUtils() {
		super();
	}

	public ImageUtils(File picture) {
		super();
		this.picture = picture;
	}
	
	/**
	 * 获取指定bufferImage
	 * @return
	 */
	private BufferedImage getBufferedImage()
	{
		BufferedImage Img = null ;
		try {
			 Img =ImageIO.read(new FileInputStream(picture));
			 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Img;
	}
	

	public String getImageWidth()
	{
		  
	        BufferedImage sourceImg = this.getBufferedImage();   
	        System.out.println(String.format("%.1f",picture.length()/1024.0));  
	        String width = "" + sourceImg.getWidth();  
	       
			return width;  
	}
	
	public String getImageHeight()
	{
	        BufferedImage sourceImg = this.getBufferedImage();   
	        System.out.println(String.format("%.1f",picture.length()/1024.0));  
	        String heightStr = "" + sourceImg.getHeight();  
	       
			return heightStr;  
	}
	public byte[] getMaxImageByte(String typeStr)
	{
		
		String type = typeStr;
		BufferedImage image = this.getBufferedImage();   
		BufferedImage fixImage = this.GetFixImage(image, 800, 600);
		
		byte[] maxByte = this.getImageByte(fixImage, type);
		
		return maxByte;
		
	}
	
	public byte[] getThumbnailByte(byte[] sourcePicByte,String typeStr)
	{
		
		byte[] source = sourcePicByte;
		String type = typeStr;
		byte[] thumbnailByte = this.getFixByte(source,type,200,150);
		
		return thumbnailByte;
		
	}
	
	private byte[] getFixByte(byte[] sourcePicByte,String typeStr,int toWidthInt,int toHeightInt)
	{
		byte[] source = sourcePicByte;
		String type = typeStr;
		
		 //将b作为输入流；
		ByteArrayInputStream in = new ByteArrayInputStream(source);   
		BufferedImage image = null ;
		try {
			image = ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		}     //将in作为输入流，读取图片存入image中，而这里in可以为ByteArrayInputStream();
		
		BufferedImage fixImage = this.GetFixImage(image, toWidthInt, toHeightInt);
		
		byte[] fixByte = this.getImageByte(fixImage, type);
		
		return fixByte;
		
	}
	
	
	
	
	
	
	private byte[] getImageByte(BufferedImage bufferedImage,String typeStr)
	{
		BufferedImage image = bufferedImage;
		String type = typeStr;
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ImageIO.write( image,type, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		byte[] imageBytes = out.toByteArray();
		
		return imageBytes;
	}
	
	public static byte[] image2byte(String path){
	    byte[] data = null;
	    FileImageInputStream input = null;
	    try {
	      input = new FileImageInputStream(new File(path));
	      ByteArrayOutputStream output = new ByteArrayOutputStream();
	      byte[] buf = new byte[1024];
	      int numBytesRead = 0;
	      while ((numBytesRead = input.read(buf)) != -1) {
	      output.write(buf, 0, numBytesRead);
	      }
	      data = output.toByteArray();
	      output.close();
	      input.close();
	    }
	    catch (FileNotFoundException ex1) {
	      ex1.printStackTrace();
	    }
	    catch (IOException ex1) {
	      ex1.printStackTrace();
	    }
	    return data;
	  }
	
	
	  //byte数组到图片
	  public void byte2image(byte[] data,String path){
	    if(data.length<3||path.equals("")) return;
	    try{
	    FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
	    imageOutput.write(data, 0, data.length);
	    imageOutput.close();
	    System.out.println("Make Picture success,Please find image in " + path);
	    } catch(Exception ex) {
	      System.out.println("Exception: " + ex);
	      ex.printStackTrace();
	    }
	  }
	  
	  
	  //byte数组到16进制字符串
	  public static String byte2string(byte[] data){
	    if(data==null||data.length<=1) return "0x";
	    if(data.length>200000) return "0x";
	    StringBuffer sb = new StringBuffer();
	    int buf[] = new int[data.length];
	    //byte数组转化成十进制
	    for(int k=0;k<data.length;k++){
	      buf[k] = data[k]<0?(data[k]+256):(data[k]);
	    }
	    //十进制转化成十六进制
	    for(int k=0;k<buf.length;k++){
	      if(buf[k]<16) sb.append("0"+Integer.toHexString(buf[k]));
	      else sb.append(Integer.toHexString(buf[k]));
	    }
	    return "0x"+sb.toString().toUpperCase();
	  }

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	} 

	
	 /** 
     * @param im            原始图像 
     * @param resizeTimes   需要缩小的倍数，缩小2倍为原来的1/2 ，这个数值越大，返回的图片越小 
     * @return              返回处理后的图像 
     */  
    public BufferedImage resizeImage(BufferedImage im, float resizeTimes) {  
        /*原始图像的宽度和高度*/  
        int width = im.getWidth();  
        int height = im.getHeight();  
  
        /*调整后的图片的宽度和高度*/  
        int toWidth = (int) (Float.parseFloat(String.valueOf(width)) / resizeTimes);  
        int toHeight = (int) (Float.parseFloat(String.valueOf(height)) / resizeTimes);  
  
        /*新生成结果图片*/  
        BufferedImage result = new BufferedImage(toWidth, toHeight, BufferedImage.TYPE_INT_RGB);  
  
        result.getGraphics().drawImage(im.getScaledInstance(toWidth, toHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);  
        return result;  
    }  
  
  /**
   * 获取指定宽度和高度的图片
   * @param im
   * @param toWidthInt
   * @param toHeightInt
   * @return
   */
    public BufferedImage GetFixImage(BufferedImage im,int toWidthInt,int toHeightInt) {  
        /*原始图像的宽度和高度*/  
        int width = im.getWidth();  
        int height = im.getHeight();  
        int toWidth = toWidthInt;
        int toHeight =  toHeightInt;
    
        if (width < toWidth) {
        	toWidth = width;
		}
  
        if (height < toHeight) {
        	height = toHeight;
		}
        /*新生成结果图片*/  
        BufferedImage result = new BufferedImage(toWidth, toHeight, BufferedImage.TYPE_INT_RGB);  
  
        result.getGraphics().drawImage(im.getScaledInstance(toWidth, toHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);  
        return result;  
    }  
  
   
  
    /** 
     * 把图片写到磁盘上 
      * @param im 
     * @param path     eg: C://home// 图片写入的文件夹地址 
      * @param fileName DCM1987.jpg  写入图片的名字 
      * @return 
     */  
    public boolean writeToDisk(BufferedImage im, String path, String fileName) {  
        File f = new File(path + fileName);  
        String fileType = getExtension(fileName);  
        if (fileType == null)  
            return false;  
        try {  
            ImageIO.write(im, fileType, f);  
            im.flush();  
            return true;  
        } catch (IOException e) {  
            return false;  
        }  
    }  
  
  
   
  
    /** 
     * 返回文件的文件后缀名 
      * @param fileName 
      * @return 
    */  
    public String getExtension(String fileName) {  
        try {  
            return fileName.split("\\.")[fileName.split("\\.").length - 1];  
        } catch (Exception e) {  
            return null;  
        }  
    }  
  
   

}
