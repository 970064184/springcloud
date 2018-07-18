package com.example.demo.sellticket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用特殊域变量(volatile)实现线程同步(测试好像没有解决)
 * 
 * @author zb
 * @date 2018年7月18日 下午6:55:04
 */
public class SellTickets2 {
	static volatile int tickets = 10;

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(6);
		while (tickets > 0) {
			service.execute(() -> {
				try {
					if (tickets > 0) {
						System.out.println(Thread.currentThread().getName() + "卖出了第" + (tickets--) + "张票");
						Thread.sleep(1000);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			});

		}
		// 关闭线程池
		service.shutdown();
	}

}
