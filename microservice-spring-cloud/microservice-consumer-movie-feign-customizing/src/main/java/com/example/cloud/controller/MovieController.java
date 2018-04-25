package com.example.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud.entity.User;
import com.example.cloud.feign.UserFeignClient;
import com.example.cloud.feign.UserFeignClient2;

@RestController
public class MovieController {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private UserFeignClient2 userFeignClient2;
	
	
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return userFeignClient.findById(id);
	}
	
	@GetMapping("/{serviceName}")
	public String findServiceInfoFromEurekaByServiceName(@PathVariable String serviceName) {
		return userFeignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
	}
	
}
