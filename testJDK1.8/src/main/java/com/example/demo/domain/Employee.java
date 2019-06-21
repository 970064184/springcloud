package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Employee {

	private String name;

	private int age;

	private double salary;

	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

}
