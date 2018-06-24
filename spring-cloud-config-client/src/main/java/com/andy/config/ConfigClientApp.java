package com.andy.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Mr.lyon
 * @CreateBy: 2018-1-23 10:12
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApp.class, args);
    }
}