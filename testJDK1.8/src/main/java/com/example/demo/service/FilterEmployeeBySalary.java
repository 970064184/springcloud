package com.example.demo.service;

import com.example.demo.domain.Employee;

public class FilterEmployeeBySalary implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee t) {
		return t.getSalary() > 5000;
	}

}
