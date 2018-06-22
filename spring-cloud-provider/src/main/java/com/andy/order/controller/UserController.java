package com.andy.order.controller;

import java.util.ArrayList;
import java.util.List;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import com.andy.order.entity.User;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/instance")
    public String serviceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("SPRING-CLOUD-PROVIDER", false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/info")
    public ServiceInstance serviceInfo() {
        log.info("用户微服务-A");
//		log.info("用户微服务-B");
        List<String> list = discoveryClient.getServices();
        return null;
    }

    @GetMapping(value = "/user/{id}", produces = {"application/json;charset=UTF-8"})
    public User user(@PathVariable("id") int id) {
        log.info("用户微服务get();");
        return new User(id, "user", "password", 12000);
    }

    @DeleteMapping(value = "/user", produces = {"application/json;charset=UTF-8"})
    public void delete(Integer id) {
        log.info("用户微服务delete()");
    }

    @PutMapping(value = "/user", produces = {"application/json;charset=UTF-8"})
    public User put(@RequestBody User user) {
        log.info("用户微服务put();");
        return user;
    }

    @PostMapping(value = "/user", produces = {"application/json;charset=UTF-8"})
    public User user(@RequestBody User user) {
        log.info("用户微服务post()");
        return user;
    }

    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public List<User> getAllUser() {
        List<User> user = new ArrayList<>();
        user.add(new User(12, "张三", "zhangsan", 12000));
        user.add(new User(13, "赵六", "zhaoliu", 12000));
        user.add(new User(14, "王五", "wangwu", 12000));
        user.add(new User(15, "李四", "lisi", 12000));
        return user;
    }

}
