package com.example.demo.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

import com.example.demo.domain.Employee;

public class TestStreamApi {

	List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

	List<Employee> employees = Arrays.asList(new Employee("张三", 45, 8888), new Employee("李四", 5, 777),
			new Employee("王五", 25, 6666), new Employee("赵六", 25, 8888), new Employee("田七", 65, 9999),
			new Employee("赵8", 25, 8888));

	/**
	 * 需求：给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？ 给定【1,2,3,4,5】，返回【1,4,9,16,25】
	 */
	@Test
	public void test() {
		List<Integer> collect = list.stream().map((i) -> {
			Integer pow = (int) Math.pow(i, 2);
			return pow;
		}).collect(Collectors.toList());
		System.out.println(collect);
	}

	/**
	 * 怎样用map和reduce方法数一数流中有多少个Employee呢？
	 */
	@Test
	public void test2() {
		Optional<Integer> reduce = employees.stream().map((e) -> 1).reduce(Integer::sum);
		Integer integer = reduce.get();
		System.out.println(integer);
	}
}
