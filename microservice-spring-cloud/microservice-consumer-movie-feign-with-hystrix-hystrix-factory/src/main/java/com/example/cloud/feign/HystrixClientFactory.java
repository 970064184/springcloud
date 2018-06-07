package com.example.cloud.feign;

/**
 * 
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.cloud.entity.User;

import feign.hystrix.FallbackFactory;

/**
 * 
 * @description feign with hystrix factory
 * @author zb
 * @date 2018年6月7日 下午4:57:08
 */
@Component
public class HystrixClientFactory implements FallbackFactory<UserFeignClient> {

	private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFactory.class);

	@Override
	public UserFeignClient create(Throwable cause) {
		LOGGER.info("fallback:reason was:{}", cause.getMessage());
		return id -> {
			User user = new User();
			user.setId(-1L);
			return user;
		};
	}

}
