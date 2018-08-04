package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.project.common.ResultDto;
import com.example.project.conf.redis.RedisService;
import com.example.project.domain.MiaoshaUser;
import com.example.project.service.MiaoshaUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	MiaoshaUserService userService;

	@Autowired
	RedisService redisService;

	@RequestMapping("/info")
	@ResponseBody
	public String info(Model model, MiaoshaUser user) {
		System.out.println(user);
		return ResultDto.success(user);
	}

}
