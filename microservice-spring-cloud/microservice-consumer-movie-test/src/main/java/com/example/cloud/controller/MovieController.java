package com.example.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud.entity.User;
import com.example.cloud.feign.UserFeignClient;

@RestController
public class MovieController {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@RequestMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		
		return userFeignClient.findById(id);
	}
	
	
}
