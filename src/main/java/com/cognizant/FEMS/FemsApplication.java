package com.cognizant.FEMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FemsApplication.class, args);
	}

}
