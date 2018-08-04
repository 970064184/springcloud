package com.example.project.conf.redis;

public class UseKey extends BasePrefix {

	public UseKey(String prefix) {
		super(prefix);
	}

	public static UseKey getById = new UseKey("id");
	public static UseKey getByName = new UseKey("name");

}
