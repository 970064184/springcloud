package com.example.demo.test;

public class TestthreadMain {

	public static void main(String[] args) {
		/*
		 * ThreadDemo01 T1 = new ThreadDemo01("Thread-1"); T1.start();
		 * 
		 * ThreadDemo01 T2 = new ThreadDemo01("Thread-2"); T2.start();
		 */

		/*
		 * System.out.println(Thread.currentThread().getName()); Thread t1 = new
		 * Thread(new MyThread()); t1.start();
		 */
		/*
		 * MyThread R1 = new MyThread("Thread-1"); R1.start();
		 * 
		 * MyThread R2 = new MyThread("Thread-2"); R2.start();
		 * 
		 * Runnable target01 = () -> System.out.println("再测试一下新增另一个线程" +
		 * Thread.currentThread().getName()); Runnable target = () ->
		 * System.out.println("新增一个线程"); new Thread(target).start(); new
		 * Thread(target01).start();
		 */

		new Thread() {

			@Override
			public void run() {
				System.out.println(" 基于子类的实现");
			}
		}.start();

		new Thread(() -> System.out.println("基于接口的实现")).start();
	}

}
