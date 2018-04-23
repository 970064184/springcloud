package com.example.cloud.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud.entity.User;

@RestController
public class MovieController {
	
	@RequestMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return null;
	}
}
