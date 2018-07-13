package com.example.demo.test;

import com.example.demo.domain.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestMain {

	public static void main(String[] args) {
		new Person();
		// Person p = new Person();
		// Person p = new Person(2l, "test", 25);
		// Person p = Person.builder().age(8).userName("ggg").build();
		// p.setId(1233456l);
		// System.out.println(p);
		log.info("测试日志");

		Person p1 = new Person();
		Person p2 = new Person();
		System.out.println(p1.equals(p2));// true
		System.out.println(p1 == p2);// false

	}

}
