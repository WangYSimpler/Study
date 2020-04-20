/**
 * Copyright © 2020 SCF. All rights reserved
 * @ Study 
 * @author WangY
 * 2020年4月1日
 */
package com.simple.thread.bank;

 /** 
 * @ClassName: BankCash 
 * @Description: TODO
 * @date: 2020年4月1日  
 */
public class BankCash {
	
	private int money;
    private String name;

    public BankCash(String name, int money) {
    this.name = name;
    this.money = money;
    }

    /**
     * 存款
     */
    public synchronized void deposit(int m) {
    	if (m <= 0) {
    		System.err.println("error");
    		return;
		}
    	  money += m;
    }

    /**
     * 取款
     
     */
    public synchronized boolean withdraw(int m) {
		
    	if (m <= 0) {
			System.err.println("error");
			 return false; //传入参数错误
		}
	    
	    if (money >= m) {
	        money -= m;
	        return true; // 取款成功
	    } else {
	        return false; // 余额不足
	    }
    }

    public String getName() {
    return name;
    }

	/**  
	* @Description:   
	* @param @param args
	* @return void
	* @throws  
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
