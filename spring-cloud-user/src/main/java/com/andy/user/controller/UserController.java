package com.andy.user.controller;

import com.andy.user.entity.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <p>
 *
 * @author Leone
 * @since 2018-03-10
 **/
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
    public String serviceInfo() {
        log.info("用户微服务-A");
//		log.info("用户微服务-B");
        List<String> list = discoveryClient.getServices();
        return "success";
    }

    @GetMapping(value = "/user/{id}", produces = {"application/json;charset=UTF-8"})
    public User user(@PathVariable("id") int id) {
        log.info("用户微服务get();");
        return new User(12, new Date(), "james", "password", "15687793324");
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
        user.add(new User(12, new Date(), "james", "password", "15687793324"));
        user.add(new User(12, new Date(), "james", "password", "15687793324"));
        user.add(new User(12, new Date(), "james", "password", "15687793324"));
        user.add(new User(12, new Date(), "james", "password", "15687793324"));
        user.add(new User(12, new Date(), "james", "password", "15687793324"));
        return user;
    }

}
