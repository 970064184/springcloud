package com.example.project.service;

import com.example.project.domain.MiaoshaUser;
import com.example.project.domain.OrderInfo;
import com.example.project.vo.GoodsVo;

public interface MiaoshaService {

	OrderInfo miaosha(MiaoshaUser user, GoodsVo goods);

}
