package com.example.demo.conf;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户信息")
public class User {
	@ApiModelProperty(value = "用户ID", required = true)
	private Long id;
	@ApiModelProperty("用户名")
	private String name;
	@ApiModelProperty("标识")
	private boolean flag;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

	public User(Long id, String name, boolean flag) {
		super();
		this.id = id;
		this.name = name;
		this.flag = flag;
	}

}
