package com.example.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.domain.MiaoshaUser;
import com.example.project.domain.OrderInfo;
import com.example.project.service.GoodsService;
import com.example.project.service.MiaoshaService;
import com.example.project.service.OrderService;
import com.example.project.vo.GoodsVo;

@Service
public class MiaoshaServiceImpl implements MiaoshaService {

	@Autowired
	GoodsService goodsService;

	@Autowired
	OrderService orderService;

	@Override
	@Transactional
	public OrderInfo miaosha(MiaoshaUser user, GoodsVo goods) {
		// 减库存 下订单 写入秒杀订单
		goodsService.reduceStock(goods);
		// order_info maiosha_order
		return orderService.createOrder(user, goods);
	}

}
