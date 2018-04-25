package com.example.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.conf.FConfiguration2;


@FeignClient(name="xxxx",url="http://localhost:8761/",configuration=FConfiguration2.class)
public interface UserFeignClient2 {
	
	@RequestMapping("/eureka/apps/{serviceName}")
	public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName); 
	
}
