package com.example.demo.sellticket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 基于同步代码块的方法解决线程同步问题
 * 
 * @author zb
 * @date 2018年7月18日 下午6:55:04
 */
public class SellTickets {
	static int tickets = 10;
	static String string = "";

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(6);
		while (tickets > 0) {
			service.execute(() -> {
				synchronized (string) {
					try {
						if (tickets > 0) {
							System.out.println(Thread.currentThread().getName() + "卖出了第" + (tickets--) + "张票");
							Thread.sleep(1000);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

		}
		// 关闭线程池
		service.shutdown();
	}

}
