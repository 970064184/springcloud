package com.example.cloud.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 练习lambda表达式
 * 
 * @author zb
 * @date 2018年6月8日 下午5:15:45
 */
public class MainTest {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> str = Arrays.asList("papa", "aaa", "bbb", "anana");
		System.out.println("str排序前：" + str);
		Collections.sort(str);// 排序
		System.out.println("str排序后（默认正序）：" + str);

		Collections.sort(str, (a, b) -> b.compareTo(a));
		System.out.println(str);

		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		System.out.println("names排序前：" + names);
		Collections.sort(names, (a, b) -> b.compareTo(a));
		System.out.println("names排序后：" + names);

		Formula formula = new Formula() {

			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}
		};
		double calculate = formula.calculate(100);
		System.out.println(calculate);
		double sqrt = formula.sqrt(16);
		System.out.println(sqrt);

		// Converter<String, Integer> converter = from -> Integer.valueOf(from);
		Converter<String, Integer> converter = Integer::valueOf;
		Integer convert = converter.convert("123");
		System.out.println(convert);

	}
}
