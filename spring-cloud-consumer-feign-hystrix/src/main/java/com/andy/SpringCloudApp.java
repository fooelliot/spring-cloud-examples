package com.andy;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringCloudApplication
public class SpringCloudApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudApp.class, args);
    }
}
