package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.project.common.CodeMsg;
import com.example.project.common.ResultDto;
import com.example.project.conf.redis.RedisService;
import com.example.project.conf.redis.UseKey;
import com.example.project.domain.User;
import com.example.project.service.UserService;

@Controller
@RequestMapping("test")
public class TestController {

	@Autowired
	private UserService userService;
	@Autowired
	private RedisService redisService;

	@GetMapping(value = "/hello")
	@ResponseBody
	public String hello() {
		return "hello world!";
	}

	@RequestMapping(value = "/helloHtml")
	public String helloHtml(Model model) {
		model.addAttribute("name", "zhang");
		return "hello";
	}

	@GetMapping(value = "/getSuccessJson")
	@ResponseBody
	public String getSuccessJson() {
		return ResultDto.success("hello");
	}

	@GetMapping(value = "/getErrorJson")
	@ResponseBody
	public String getErrorJson() {
		return ResultDto.error(CodeMsg.SERVER_ERROR);
	}

	@GetMapping(value = "/findById/{id}")
	@ResponseBody
	public String findById(@PathVariable("id") int id) {
		User data = userService.findById(id);
		return ResultDto.success(data);
	}

	@GetMapping(value = "/redis/get")
	@ResponseBody
	public String getRedisValue() {
		// String string = redisService.get(UseKey.getById, "key1", String.class);
		User user = redisService.get(UseKey.getById, "key1", User.class);
		return ResultDto.success(user);
	}

	@GetMapping(value = "/redis/set")
	@ResponseBody
	public String setRedisValue() {
		// boolean set = redisService.set(UseKey.getById, "key1", "hello redis!");
		User user = new User(1, "fhdhfkhsd");
		boolean set = redisService.set(UseKey.getById, "key1", user);// UseKey:idkey1
		return ResultDto.success(set);
	}

}
