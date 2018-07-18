package com.example.demo.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 通过Callable和Future Task创建线程
 * 
 * @author zb
 * @date 2018年7月17日 下午3:41:32
 */
public class ThreadDemo03 {
	public static void main(String[] args) throws Exception, Exception {
		Callable<Integer> oneCallable = new Tickets();
		FutureTask<Integer> oneTask = new FutureTask<Integer>(oneCallable);

		Thread t = new Thread(oneTask);

		System.out.println(Thread.currentThread().getName());

		t.start();
		System.out.println(oneTask.get());
	}
}

class Tickets implements Callable<Integer> {

	// 重写call方法
	@Override
	public Integer call() throws Exception {
		int i = 8;
		System.out.println(Thread.currentThread().getName() + "-->我是通过实现Callable接口通过FutureTask包装器来实现的线程");
		return i;
	}
}