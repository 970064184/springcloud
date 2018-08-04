package com.example.project.service;

import com.example.project.domain.MiaoshaOrder;
import com.example.project.domain.MiaoshaUser;
import com.example.project.domain.OrderInfo;
import com.example.project.vo.GoodsVo;

public interface OrderService {

	MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(long id, long goodsId);

	OrderInfo createOrder(MiaoshaUser user, GoodsVo goods);

}
