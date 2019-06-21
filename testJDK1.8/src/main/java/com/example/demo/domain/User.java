package com.example.demo.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

	@ApiModelProperty(value = "用户ID", required = true)
	private String id;

	@ApiModelProperty("用户名")
	private String userName;

	@ApiModelProperty("用户手机号")
	private String phone;

	private Integer departmentId;

	private String email;

	private String password;

	private Integer sort;

	private String status;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date created;

	private Date updated;

}
