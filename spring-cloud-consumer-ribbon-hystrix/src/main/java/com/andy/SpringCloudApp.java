package com.andy;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Mr.lyon
 * @CreateBy: 2017-11-22 22:39
 **/
@SpringCloudApplication
public class SpringCloudApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudApp.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}
