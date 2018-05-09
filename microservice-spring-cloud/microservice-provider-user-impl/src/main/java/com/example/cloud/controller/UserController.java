package com.example.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud.entity.User;
import com.example.cloud.feign.UserFeignClient;
import com.example.cloud.repository.UserRepository;

@RestController
public class UserController implements UserFeignClient{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findById(@PathVariable Long id) {
		return userRepository.findOne(id);
	}
	@Override
	public User postUser(@RequestBody User user) {
		return user;
	}
	@Override
	public User getUser(@RequestBody User user) {
		return user;
	}

	
	/*@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id) {
		return userRepository.findOne(id);
	}
	
	@GetMapping("/eureka-instance")
	public String serviceUrl() {
	    InstanceInfo instance = eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
	    return instance.getHomePageUrl();
	}
	@GetMapping("instance-info")
	public ServiceInstance showInfo() {
		ServiceInstance instance = discoveryClient.getLocalServiceInstance();
		return instance;
	}
	
	@PostMapping("/user")
	public User postUser(@RequestBody User user) {
		return user;
	}
	
	@GetMapping("/get-user")
	public User getUser(User user) {
		return user;
	}
	@GetMapping("/list-all")
	public List<User> listAll() {
		ArrayList<User> list = Lists.newArrayList();
		User user1 = new User(1L,"zhangsan");
		User user2 = new User(1L,"zhangsan");
		User user3 = new User(1L,"zhangsan");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		return list;
	}*/
}

