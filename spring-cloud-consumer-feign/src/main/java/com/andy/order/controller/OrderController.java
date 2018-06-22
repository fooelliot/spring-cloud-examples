package com.andy.order.controller;

import com.andy.order.feign.UserFeignClient;
import com.andy.order.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Mr.lyon
 * @CreateBy: 2017-10-22 22:58
 **/
@RestController
public class OrderController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User user(@PathVariable("id") int id) {
        User user = userFeignClient.user(id);
        return user;
    }

    @PostMapping(value = "/user")
    public User user(@RequestBody User user) {
        return userFeignClient.user(user);
    }


}
