package com.example.demo.conf;

/**
 * 自定义异常
 * 
 * @author zb
 * @date 2018年7月16日 下午1:25:02
 */
public class MyException extends Exception {

	private int value;

	public MyException() {
		super();
	}

	public MyException(String msg, int value) {
		super(msg);
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
