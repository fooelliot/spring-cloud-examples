package com.andy.order.controller;

import com.andy.order.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.andy.order.config.UserFeignClient;

import java.util.Date;

/**
 * @Author: Mr.lyon
 * @CreateBy: 2017-12-22 23:46
 **/
@RestController
//@DefaultProperties(defaultFallback = "defaultFallback")
public class OrderController {

    @Autowired
    private UserFeignClient userFeignClient;

//    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/user/{id}")
    public User getObj(@PathVariable("id") int id) {
        User user = userFeignClient.user(id);
        return user;
    }

    public User fallback(int id) {
        return new User(1, new Date(), "fallback", "password", 12000.00);
    }

    public User defaultFallback(int id) {
        return new User(2, new Date(), "defaultFallback", "password", 22000.00);
    }

}
