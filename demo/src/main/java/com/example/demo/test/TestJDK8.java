package com.example.demo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.domain.Person;

public class TestJDK8 {

	public static void main(String[] args) {

		List<Person> list = Arrays.asList(Person.builder().age(15).build(),
				Person.builder().age(20).gender(1).height(155).build(), Person.builder().age(33).height(160).build());
		System.out.println(list);

		testStream1(list);
		testLambda1(list);

	}

	private static void testLambda1(List<Person> list) {
		// 用for增强版的写法
		List<Person> p = new ArrayList<>();
		list.forEach(l -> {
			if (l.getAge() > 20) {
				p.add(l);
			}
		});
		System.out.println(p);

		// 优化方式1：策略设计模式
		// 优化方式2：匿名内部类
		// 优化方式3：lambda表达式
		// 优化方式4：stream API

	}

	private static void testStream1(List<Person> list) {
		// 获取所有Person的年龄段

		// 测试jdk新特性--》Stream
		List<Integer> aList = list.stream().map(person -> person.getAge()).collect(Collectors.toList());
		System.out.println(aList);

		// for增强版
		List<Integer> ageList = new ArrayList<>();
		list.forEach(l -> ageList.add(l.getAge()));
		System.out.println(ageList);
	}

}
