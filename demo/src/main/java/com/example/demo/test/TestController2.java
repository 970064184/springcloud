package com.example.demo.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author zb
 * @date 2018年7月16日 上午11:23:59
 */
@Api(tags = "TestController2的 API")
@RestController
public class TestController2 {

	@ApiOperation(value = "第一个swagger测试", notes = "第一个swagger测试")
	@GetMapping("test2")
	public String test(HttpServletRequest request) {
		System.out.println(request.getRemoteHost());
		System.out.println(request.getHeader("User-Agent"));
		if (request.getHeader("User-Agent").contains("Android")) {
			return "android test";
		} else {
			return "test2!";
		}
	}

}
