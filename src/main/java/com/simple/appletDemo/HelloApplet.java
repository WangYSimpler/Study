package com.simple.appletDemo;

import java.applet.Applet;
import java.awt.Graphics;

public class HelloApplet extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String myString = "";
	public void paint(Graphics g) {
		g.drawString(myString, 50, 300);
	}

	public void  init() {
		myString += "正在初始化....";
		repaint();
	}
	
	public void start() {
		myString += "正在执行...";
		repaint();
	}
	
	public void stop() {
		myString+= "stop...";
		repaint();
	}
	public void destory() {
		
		myString+= "正在收回资源...";
		repaint();
	}
}
