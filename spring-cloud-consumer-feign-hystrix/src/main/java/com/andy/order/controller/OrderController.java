package com.andy.order.controller;

import com.andy.order.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.andy.config.UserFeignClient;

/**
 * @Author: Mr.lyon
 * @CreateBy: 2017-12-22 23:46
 **/
@RestController
public class OrderController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User getObj(@PathVariable("id") int id) {
        User user = userFeignClient.user(id);
        return user;
    }

}
