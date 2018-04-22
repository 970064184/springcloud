package com.example.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.cloud.entity.User;

@RestController
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LoadBalancerClient LoadBalancerClient;
	
	@RequestMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		
		ServiceInstance choose = LoadBalancerClient.choose("microservice-provider-user");
		System.out.println("===="+":"+choose.getPort()+";"+choose.getHost()+";"+choose.getServiceId());
//		return restTemplate.getForObject("http://localhost:7900/simple/"+id, User.class);
		return restTemplate.getForObject("http://microservice-provider-user/simple/"+id, User.class);
	}
	
	@GetMapping("/test")
	public void test() {
		ServiceInstance choose = LoadBalancerClient.choose("microservice-provider-user");
		System.out.println("1111"+":"+choose.getPort()+";"+choose.getHost()+";"+choose.getServiceId());
		ServiceInstance choose2 = LoadBalancerClient.choose("microservice-provider-user2");
		System.out.println("2222"+":"+choose2.getPort()+";"+choose2.getHost()+";"+choose2.getServiceId());
	}
	
}
