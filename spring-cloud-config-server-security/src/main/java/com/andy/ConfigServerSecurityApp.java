package com.andy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerSecurityApp {
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerSecurityApp.class, args);
	}
}
