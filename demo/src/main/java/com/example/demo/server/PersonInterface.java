package com.example.demo.server;

import java.util.List;

import com.example.demo.domain.Person;

/**
 * 测试接口的多继承
 * 
 * @author zb
 * @date 2018年7月13日 下午6:40:20
 */
public interface PersonInterface extends PersonService {

	List<Person> findAll();
}
