package com.example.demo.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程实现方式4：通过线程池创建线程
 * 
 * @author zb
 * @date 2018年7月18日 上午11:02:06
 */
public class ThreadDemo04 {
	private static int POOL_NUM = 10;

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(7);
		for (int i = 0; i < POOL_NUM; i++) {
			RunnableThread runnableThread = new RunnableThread();
			executorService.execute(runnableThread);
		}
		// 关闭线程池
		executorService.shutdown();
	}
}

class RunnableThread implements Runnable {

	@Override
	public void run() {
		System.out.println("通过线程池方式创建的线程：" + Thread.currentThread().getName() + " ");
	}

}