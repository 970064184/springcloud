package com.example.demo.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 基于线程池的方式
 * 
 * @author zb
 * @date 2018年7月18日 下午3:43:48
 */
public class ThreadPoolDemo {

	private static AtomicInteger count = new AtomicInteger(11);

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(6);
		while (count.intValue() > 0) {
			threadPool.execute(() -> {
				if (count.intValue() > 0) {
					// count--;
					System.out.println(
							Thread.currentThread().getName() + " is running,剩余count数目为：" + count.decrementAndGet());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		threadPool.shutdown();
	}

}
