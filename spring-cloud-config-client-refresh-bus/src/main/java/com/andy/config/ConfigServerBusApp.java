package com.andy.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Mr.lyon
 * @CreateBy: 2018-2-23 16:50
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigServerBusApp {
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerBusApp.class, args);
	}
}
