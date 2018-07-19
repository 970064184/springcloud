package com.example.demo.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.conf.Dto;
import com.example.demo.conf.TestUser;
import com.example.demo.domain.User;
import com.example.demo.server.TestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author zb
 * @date 2018年7月16日 上午11:23:59
 */
@Api(tags = "swaggerTestController的 API")
@RestController
public class TestController {
	@Autowired
	private TestService testService;

	@ApiOperation(value = "第一个swagger测试", notes = "第一个swagger测试")
	@GetMapping("test")
	public String test() {
		return "test!";
	}

	@ApiOperation(value = "获取请求url上的参数值", notes = "获取请求url上的参数值")
	@GetMapping("/getPathVariable/{param}")
	public int getPathVariable(@ApiParam(value = "参数", required = true) @PathVariable("param") Integer param) {
		return param;
	}

	@ApiOperation(value = "获取请求参数值", notes = "获取请求参数值")
	@GetMapping("/getRestquestParam")
	public Long getRestquestParam(@ApiParam(value = "参数", required = true) @RequestParam("id") Long id) {
		return id;
	}

	@ApiOperation(value = "json测试", notes = "获取请求url上的参数值")
	@PostMapping("/postByJson")
	public Dto<TestUser> postByJson(@RequestBody TestUser user) {
		return new Dto<>(user);
	}

	@ApiOperation(value = "form测试", notes = "获取请求url上的参数值", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "form", dataType = "Long", name = "id", value = "信息id", required = true) })
	@RequestMapping(value = "/postByForm", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, method = RequestMethod.POST)
	public Dto<TestUser> postByForm(TestUser user) {
		System.out.println(user);
		return new Dto<>(user);
	}

	@ApiOperation(value = "根据用户id查找对应的记录", notes = "用户详情")
	@GetMapping("/findByUserId")
	public Dto<User> findByUserId(@RequestParam("id") String id) {
		User data = testService.findByUserId(id);
		return new Dto<User>(data);
	}

	@ApiOperation(value = "根据用户状态查找对应的记录", notes = "根据状态查出一批相同状态的记录")
	@GetMapping("/findByStatus")
	public Dto<List<User>> findByStatus(@RequestParam("status") String status) {
		List<User> data = testService.findByStatus(status);
		return new Dto<List<User>>(data);
	}

	@ApiOperation(value = "新增用户信息", notes = "保存用户信息")
	@RequestMapping(value = "/saveUser", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public String saveUser(@RequestBody User user) {
		Dto dto = new Dto<>();
		testService.saveUser(user);
		dto.setData("success");
		System.out.println(dto);
		return dto.toJson();
	}

	@ApiOperation(value = "更新用户信息", notes = "更新用户信息")
	@RequestMapping(value = "/updateUser", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public String updateUser(@RequestBody User user) {
		Dto dto = new Dto<>();
		testService.updateUser(user);
		dto.setData("success");
		System.out.println(dto);
		return dto.toJson();
	}

}
