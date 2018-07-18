package com.example.demo.test;

public class ThreadDemo extends Thread {

	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName() + " is running");// 打印当前线程的名字
			try {
				Thread.sleep(1000);// 休息1000ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ThreadDemo td = new ThreadDemo();
		td.start();
		ThreadDemo tt = new ThreadDemo();
		tt.start();
		ThreadDemo t2 = new ThreadDemo();
		t2.setName("第三条线程");
		t2.start();

		while (true) {
			System.out.println(Thread.currentThread().getName() + " is running ....");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
