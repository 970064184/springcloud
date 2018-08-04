package com.example.project.common;

import com.alibaba.fastjson.JSONObject;

/**
 * result统一结果格式封装成json返回
 * 
 * @author zb
 * @date 2018年7月26日 上午10:56:37
 */
public class ResultDto {

	private int code = 0;

	private String msg = "success";

	private Object data = null;

	public ResultDto(CodeMsg codeMsg) {
		if (codeMsg == null)
			return;
		this.code = codeMsg.getCode();
		this.msg = codeMsg.getMsg();
	}

	public ResultDto(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultDto [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

	public String toJson() {
		return JSONObject.toJSONString(this);
	}

	public static String success(Object data) {
		return new ResultDto(0, "success", data).toJson();
	}

	public static String error(CodeMsg codeMsg) {
		return new ResultDto(codeMsg).toJson();
	}
}
