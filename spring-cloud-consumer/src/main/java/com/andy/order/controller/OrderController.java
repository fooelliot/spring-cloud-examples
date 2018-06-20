package com.andy.order.controller;

import com.andy.order.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: Mr.lyon
 * @CreateBy: 2018-06-20 23:42
 **/
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User user(@PathVariable("id")int id) {
        String url = "http://localhost:8001/user/" + id;
        User user = restTemplate.getForObject(url, User.class);
        log.info("[get->{}],:return->{}",url, user);
        return user;
    }

    @GetMapping(value="/list")
    public List<User> list(){
        String url = "http://localhost:8001/list";
        ParameterizedTypeReference<List<User>> typeRef = new ParameterizedTypeReference<List<User>>() {};
        List<User> users = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {}).getBody();
        log.info("[get->{}],:return->{}",url, users);
        return users;
    }

}
