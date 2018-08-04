package com.example.project.conf.redis;

public interface KeyPrefix {

	int expireSeconds();

	String getPrefix();
}
