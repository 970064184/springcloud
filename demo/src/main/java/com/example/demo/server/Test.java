package com.example.demo.server;

/**
 * 测试抽象类可仅仅实现部分接口中的方法
 */
import java.util.Arrays;
import java.util.List;

import com.example.demo.domain.Person;

public abstract class Test implements PersonInterface {

	@Override
	public List<Person> findAll() {
		return Arrays.asList(new Person(123l, "test", number));
	}
}
