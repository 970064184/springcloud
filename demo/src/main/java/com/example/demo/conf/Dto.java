package com.example.demo.conf;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("统一返回值")
public class Dto<T> {
	@ApiModelProperty("状态码")
	private Long code = 200l;
	@ApiModelProperty("错误信息")
	private String msg;
	@ApiModelProperty("返回值")
	private T data;

	public Dto() {
		super();
	}

	public Dto(T data) {
		super();
		this.data = data;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String toJson() {
		return JSONObject.toJSONString(this);
	}

	@Override
	public String toString() {
		return "Dto [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

}
