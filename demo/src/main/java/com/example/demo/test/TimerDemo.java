package com.example.demo.test;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器
 * 
 * @author zb
 * @date 2018年7月18日 下午3:34:12
 */
public class TimerDemo {

	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public static void main(String[] args) throws Exception {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("定时器打印执行");
			}
		}, FORMAT.parse("2018-07-18 15:41:00"));
		/*
		 * Timer timer = new Timer(); timer.schedule(new TimerTask() {
		 * 
		 * @Override public void run() { System.out.println("定时器打印执行"); } }, new Date(),
		 * 5000);
		 */ }

}
