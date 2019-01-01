package com.simple.network;

import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTcp {

	@SuppressWarnings("unused")
	private BufferedReader reader;
	@SuppressWarnings("unused")
	private ServerSocket server;
	@SuppressWarnings("unused")
	private Socket socket;
	
	void getServer(){
		
		try {
			this.server = new ServerSocket(9876);
			System.out.println("Server ");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
