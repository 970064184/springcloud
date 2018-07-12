package com.example.demo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Person {

	@Getter
	@Setter
	private Long id;

	private String userName;

	private int age;

}
