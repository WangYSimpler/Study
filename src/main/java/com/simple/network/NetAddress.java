package com.simple.network;

import java.net.InetAddress;

public class NetAddress {
	
	public static void main(String[] args) {
		InetAddress ipNetAddress;
		
		try {
			ipNetAddress = InetAddress.getLocalHost();
			String localname = ipNetAddress.getHostName();
			String localip   = ipNetAddress.getHostAddress();
			
			System.out.println("本地主机名：" + localname);
			System.out.println("本地 IP 地址：" + localip);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
