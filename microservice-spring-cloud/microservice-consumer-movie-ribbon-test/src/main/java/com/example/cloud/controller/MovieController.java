package com.example.cloud.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
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
	
	@GetMapping("/list-all")
	public List<User> listAll() {
		//错误的写法
		/*List<User> list = restTemplate.getForObject("http://microservice-provider-user/list-all", List.class);
		list.forEach((user)->{
			System.out.println(user);
		});*/
		
		//正确的写法
		User[] user = restTemplate.getForObject("http://microservice-provider-user/list-all", User[].class);
		List<User> asList = Arrays.asList(user);
		asList.forEach((u)->{
			System.out.println(u);
		});
		
		
		return asList; 
	}
	
}
