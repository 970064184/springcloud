package com.example.demo.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestSimpleDateFormat {

	public static void main(String[] args) throws Exception {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

		Callable<LocalDate> task = () -> LocalDate.parse("20180826", dtf);

		// 写一个长度为10的线程池
		ExecutorService pool = Executors.newFixedThreadPool(10);

		List<Future<LocalDate>> results = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			results.add(pool.submit(task));
		}
		for (Future<LocalDate> future : results) {
			System.out.println(future.get());
		}
		pool.shutdown();
		/*
		 * Callable<Date> task = () -> DateFormatThreadLocal.convert("20180828");
		 * 
		 * // 写一个长度为10的线程池 ExecutorService pool = Executors.newFixedThreadPool(10);
		 * 
		 * List<Future<Date>> results = new ArrayList<>(); for (int i = 0; i < 10; i++)
		 * { results.add(pool.submit(task)); } for (Future<Date> future : results) {
		 * System.out.println(future.get()); } pool.shutdown();
		 */ /*
			 * SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			 * 
			 * Callable<Date> task = () -> sdf.parse("20180828");
			 * 
			 * // 写一个长度为10的线程池 ExecutorService pool = Executors.newFixedThreadPool(10);
			 * 
			 * List<Future<Date>> results = new ArrayList<>(); for (int i = 0; i < 10; i++)
			 * { results.add(pool.submit(task)); } for (Future<Date> future : results) {
			 * System.out.println(future.get()); }
			 */
	}
}
