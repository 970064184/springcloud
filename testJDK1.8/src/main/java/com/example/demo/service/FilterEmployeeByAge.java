package com.example.demo.service;

import com.example.demo.domain.Employee;

public class FilterEmployeeByAge implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee t) {
		return t.getAge() > 35;
	}

}
