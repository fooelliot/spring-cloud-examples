package com.andy.order.controller;

import com.andy.order.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.andy.order.config.UserFeignClient;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Random;

/**
 * @author: lyon
 * @createBy: 2017-12-22 23:46
 **/
@Slf4j
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class OrderController {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
//    @HystrixCommand(fallbackMethod = "fallback", defaultFallback = "defaultFallback")
    @GetMapping("/user/{id}")
    public User user(@PathVariable("id") int id) throws Exception {
//        Thread.sleep(2000);
        User user = userFeignClient.user(id);
        return user;
    }

    public User fallback(int id) {
        return new User(1, new Date(), "fallback", "password", 12000.00);
    }

    public User defaultFallback(int id) {
        return new User(2, new Date(), "defaultFallback", "password", 22000.00);
    }

    @GetMapping("/user")
    public User one() {
        return restTemplate.getForObject("http://spring-cloud-provider/user/" + new Random().nextInt(100), User.class);
    }

}
