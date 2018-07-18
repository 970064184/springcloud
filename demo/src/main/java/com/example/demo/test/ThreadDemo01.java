package com.example.demo.test;

/**
 * 继承Thread类的线程实现方式如下
 * 
 * (继承Thread类要重写run()方法)
 * 
 * @author zb
 * @date 2018年7月17日 上午11:23:11
 */
public class ThreadDemo01 extends Thread {

	private Thread t;
	private String threadName;

	ThreadDemo01(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	@Override
	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				// 让线程睡眠一会
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	@Override
	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
