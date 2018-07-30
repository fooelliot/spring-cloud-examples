package com.andy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudApp.class, args);

        // 创建 Annotation 驱动的 Spring 应用上下文

    }


}
