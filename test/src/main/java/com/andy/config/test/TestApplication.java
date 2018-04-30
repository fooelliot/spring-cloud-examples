package com.andy.config.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableEurekaServer
public class TestApplication {

	public static void main(String[] args) {
		System.out.println("系统正在启动。。。");
		SpringApplication.run(TestApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(){
		return "hello world";
	}

}
