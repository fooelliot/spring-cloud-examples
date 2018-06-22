package com.andy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: Mr.lyon
 * @CreateBy: 2017-011-22 23:00
 **/
@EnableFeignClients
@SpringCloudApplication
public class SpringCloudApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudApp.class, args);
    }
}
