package com.example.demo.server;

import java.util.List;

import com.example.demo.domain.User;

public interface TestService {

	User findByUserId(String id);

	List<User> findByStatus(String status);

	void saveUser(User user);

	void updateUser(User user);

}
