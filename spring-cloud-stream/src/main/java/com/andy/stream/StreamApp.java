package com.andy.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: Mr.lyon
 * @createBy: 2018-06-23 12:45
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class StreamApp {
    public static void main(String[] args) {
        SpringApplication.run(StreamApp.class, args);
    }
}
