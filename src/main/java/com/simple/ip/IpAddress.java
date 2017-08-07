package com.simple.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAddress {

	public static void main(String[] args) {
		InetAddress ip;
		
		try {
			ip = InetAddress.getLocalHost();
			String localname = ip.getHostName();
			String localIp = ip.getHostAddress();
			System.out.println(localname + ":" + localIp);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
