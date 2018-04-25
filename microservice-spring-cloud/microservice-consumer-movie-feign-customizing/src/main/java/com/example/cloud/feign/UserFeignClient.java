package com.example.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.example.cloud.entity.User;
import com.example.conf.FConfiguration;

import feign.Param;
import feign.RequestLine;


@FeignClient(name="microservice-provider-user",configuration=FConfiguration.class)
public interface UserFeignClient {
	
//	@RequestMapping(value="/simple/{id}",method=RequestMethod.GET)
	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Long id); 
	
}
