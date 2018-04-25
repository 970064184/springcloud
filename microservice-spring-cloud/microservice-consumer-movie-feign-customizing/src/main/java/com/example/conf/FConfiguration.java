package com.example.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.Logger;

@Configuration
public class FConfiguration {
	
	@Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
	
	@Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

}
