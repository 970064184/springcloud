package com.example.demo.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User findByUserId(String id) {
		String sql = "select * from pms_user u where id=?";
		User user = jdbcTemplate.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<>(User.class));
		return user;
	}

	@Override
	public List<User> findByStatus(String status) {
		String sql = "select * from pms_user u where u.status =?";
		List<User> user = jdbcTemplate.query(sql, new Object[] { status }, new BeanPropertyRowMapper<>(User.class));
		return user;
	}

	@Override
	public void saveUser(User user) {
		String sql = "insert into pms_user(id,user_name,phone) values(?,?,?)";
		int update = jdbcTemplate.update(sql, new Object[] { user.getId(), user.getUserName(), user.getPhone() });
	}

	@Override
	public void updateUser(User user) {
		String sql = "update pms_user set phone= ? where id=?";
		jdbcTemplate.update(sql, new Object[] { user.getPhone(), user.getId() });
	}

}
