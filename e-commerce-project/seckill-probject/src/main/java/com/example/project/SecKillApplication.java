package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @ComponentScan({ "com.example.project",
// "org.springframework.boot.autoconfigure.data.redis" })
public class SecKillApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecKillApplication.class, args);
	}
}
