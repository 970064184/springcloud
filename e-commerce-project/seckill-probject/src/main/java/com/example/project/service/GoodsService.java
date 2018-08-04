package com.example.project.service;

import java.util.List;

import com.example.project.vo.GoodsVo;

public interface GoodsService {

	List<GoodsVo> listGoodsVo();

	GoodsVo getGoodsVoByGoodsId(long goodsId);

	void reduceStock(GoodsVo goods);
}
