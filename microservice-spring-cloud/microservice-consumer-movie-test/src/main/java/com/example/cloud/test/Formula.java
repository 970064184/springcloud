package com.example.cloud.test;

/**
 * 测试jdk8新特性：允许在接口中有默认方法实现
 * 
 * @author zb
 * @date 2018年6月8日 下午5:30:37
 */
public interface Formula {

	double calculate(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}
