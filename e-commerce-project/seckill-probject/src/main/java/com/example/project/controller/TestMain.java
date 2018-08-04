package com.example.project.controller;

/**
 * 测试类
 * 
 * @author zb
 * @date 2018年7月30日 上午11:44:23
 */
public class TestMain {

	public static void main(String[] args) {
		String str = "hello,%s";
		String strFormat = String.format(str, "张三");
		System.out.println(strFormat);
		// test("shangdskd", new Date(), "好天气");

		System.out.printf("字母a的大写是：%c， %s", 'A', "大写A");
	}

	public static String test(Object... args) {
		String format = "hello,%s,今天星期几,%tc%n,%s";
		String strFormat = String.format(format, args);
		System.out.println(strFormat);
		return strFormat;
	}
}
