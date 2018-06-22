package com.andy.order.controller;

import com.andy.order.feign.UserFeignClient2;
import com.andy.order.feign.UserFeignClient1;
import com.andy.order.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Mr.lyon
 * @CreateBy: 2017-11-22 23:36
 **/
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private UserFeignClient1 userFeignClient1;

    @Autowired
    private UserFeignClient2 userFeignClient2;


    @GetMapping("/user/{id}")
    public User user(@PathVariable("id") int id) {
        User user = userFeignClient2.user(id);
        return user;
    }

    @PostMapping("/user")
    public User user(@RequestBody User users) {
        return userFeignClient2.user(users);
    }

    @GetMapping("/{serviceName}")
    public String findEurekaServiceByName(@PathVariable("serviceName") String serviceName) {
        return userFeignClient1.findEurekaServiceByName(serviceName);
    }


}
