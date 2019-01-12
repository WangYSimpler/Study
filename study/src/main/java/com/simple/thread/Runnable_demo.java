package com.simple.thread;


/***
 * 多线程 卖票例子
 * @author Administrator
 *
 */
public class Runnable_demo implements Runnable {

	private int ticket = 100;

	public void run() {
		while(this.ticket > 0) {
				// 休眠1s秒中，为了使效果更明显，否则可能出不了效果
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				this.sale();
				
			}

		}
	

	public synchronized void sale(){
		if (this.ticket>0) {
			System.out.println( Thread.currentThread().getName() + ":号窗口卖出: " + this.ticket-- + "号票");
		}
	}
	
	public static void main(String args[]) {
		Runnable_demo demo = new Runnable_demo();
		// 基于火车票创建三个窗口
		new Thread(demo, "a").start();
		new Thread(demo, "b").start();
		new Thread(demo, "c").start();
	}

}
