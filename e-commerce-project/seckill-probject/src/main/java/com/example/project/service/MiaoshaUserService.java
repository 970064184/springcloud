package com.example.project.service;

import javax.servlet.http.HttpServletResponse;

import com.example.project.domain.MiaoshaUser;
import com.example.project.vo.LoginVo;

public interface MiaoshaUserService {

	boolean login(HttpServletResponse response, LoginVo loginVo);

	MiaoshaUser findByToken(HttpServletResponse response, String token);

}
