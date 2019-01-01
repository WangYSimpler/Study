package com.simple.network;

import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTcp {

	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;
	
	void getServer(){
		
		try {
			server = new ServerSocket(9876);
			System.out.println("Server ");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
