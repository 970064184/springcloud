package com.example.demo.test;

public interface MyFun {

	default String getName() {
		return "默认方法返回值";
	}

	public static void show() {
		System.out.println("静态方法！");
	}
}
