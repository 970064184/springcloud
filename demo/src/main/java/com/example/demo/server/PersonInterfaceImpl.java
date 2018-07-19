package com.example.demo.server;

import java.util.Arrays;
import java.util.List;

import com.example.demo.domain.Person;

public class PersonInterfaceImpl implements PersonInterface {

	@Override
	public void findById(Long id) {

	}

	@Override
	public List<Person> findAll() {
		return Arrays.asList(Person.builder().age(9).userName("test").id(12345l).build());
	}

}
