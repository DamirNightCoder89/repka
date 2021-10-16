package com.someday.somework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SomeworkApplication.class, args);
	}

//	@Bean
//	public ErrorDecoder errorDecoder() {
//		return new CustomErrorDecoder();
//	}

}


