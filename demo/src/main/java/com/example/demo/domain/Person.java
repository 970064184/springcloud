package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

public class Person {

	@Getter
	@Setter
	private Long id;

	private String userName;

	private int age;

}
