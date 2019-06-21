package com.example.demo.test;

import java.util.Optional;

import org.junit.Test;

import com.example.demo.domain.Employee;

public class TestOptional {

	@Test
	public void test() {
		// 创建一个Optional实例
		// Optional<Employee> op = Optional.of(new Employee());//Employee(name=null,
		// age=0, salary=0.0)
		Optional<Employee> op = Optional.of(null);// java.lang.NullPointerException
		Employee employee = op.get();
		System.out.println(employee);
	}

	@Test
	public void test1() {
		// 创建一个Optional实例
		Optional<Employee> op = Optional.empty();// java.util.NoSuchElementException: No value present
		Employee employee = op.get();
		System.out.println(employee);
	}

	@Test
	public void test2() {
		// 创建一个Optional实例
		Optional<Employee> op = Optional.ofNullable(null);// java.util.NoSuchElementException: No value
		if (op.isPresent()) {// 有值
		}
		Employee emp = op.orElse(new Employee("默认值", 0));
		System.out.println(emp);
	}

	@Test
	public void test3() {
		Optional<Employee> op = Optional.of(new Employee("zhangs", 2));// zhangs
		Optional<String> map = op.map((e) -> e.getName());
		String str = map.get();
		System.out.println(str);
	}
}
