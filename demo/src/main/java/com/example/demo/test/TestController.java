package com.example.demo.test;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.conf.Dto;
import com.example.demo.conf.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author zb
 * @date 2018年7月16日 上午11:23:59
 */
@Api(tags = "swaggerTestController的 API")
@RestController
public class TestController {

	@ApiOperation(value = "第一个swagger测试", notes = "第一个swagger测试")
	@GetMapping("test")
	public String test() {
		return "test!";
	}

	@ApiOperation(value = "获取请求url上的参数值", notes = "获取请求url上的参数值")
	@GetMapping("/getPathVariable/{param}")
	public int getPathVariable(@ApiParam(value = "参数", required = true) @PathVariable("param") Integer param) {
		return param;
	}

	@ApiOperation(value = "获取请求参数值", notes = "获取请求参数值")
	@GetMapping("/getRestquestParam")
	public Long getRestquestParam(@ApiParam(value = "参数", required = true) @RequestParam("id") Long id) {
		return id;
	}

	@ApiOperation(value = "json测试", notes = "获取请求url上的参数值")
	@PostMapping("/postByJson")
	public Dto<User> postByJson(@RequestBody User user) {
		return new Dto<>(user);
	}

	@ApiOperation(value = "json测试", notes = "获取请求url上的参数值", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "form", dataType = "Long", name = "id", value = "信息id", required = true) })
	@RequestMapping(value = "/postByForm", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, method = RequestMethod.POST)
	public Dto<User> postByForm(User user) {
		System.out.println(user);
		return new Dto<>(user);
	}

}
