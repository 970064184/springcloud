package com.example.demo.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基于线程池的方式
 * 
 * @author zb
 * @date 2018年7月18日 下午3:43:48
 */
public class ThreadPoolDemo2 {

	private static int count = 10;

	private static Lock lock = new ReentrantLock();

	public static void main(String[] args) {

		ExecutorService threadPool = Executors.newFixedThreadPool(6);
		while (count > 0) {
			threadPool.execute(() -> {
				lock.lock();
				try {
					if (count > 0) {
						count--;
						System.out.println(Thread.currentThread().getName() + " is running,剩余count数目为：" + count);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				} finally {
					lock.unlock();
				}
			});
		}
		threadPool.shutdown();
	}

}
