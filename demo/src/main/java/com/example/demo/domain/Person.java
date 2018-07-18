package com.example.demo.domain;

import com.example.demo.conf.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

	private Long id;

	private String userName;

	private int age;

	private User user;

	public void test() {
		user.toString();
	}

}
