package com.simple.thread;

class MyThead extends Thread {

	private String title;

	public MyThead(String title) {
		this.title = title;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.title + " ：执行 " + i);
		}

	}
}

public class TheadDemo {

	public static void main(String[] args) {
		new MyThead("线程A").start();
		new MyThead("线程B").start();
		new MyThead("线程C").start();
	}
}
