package com.example.cloud.feign;

public class FeignClient2Fallback implements UserFeignClient2{

	@Override
	public String findServiceInfoFromEurekaByServiceName(String serviceName) {
		return "hahaha";
	}

}
