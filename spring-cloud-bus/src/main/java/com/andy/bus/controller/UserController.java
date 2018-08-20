package com.andy.bus.controller;

import com.andy.bus.entity.User;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leone
 * @since: 2018-03-07
 **/
@RestController
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

//	@Autowired
//	private DiscoveryClient discoveryClient;

//	@GetMapping("/eureka-instance")
//	public String serviceUrl() {
//	    InstanceInfo instance = eurekaClient.getNextServerFromEureka("SPRINGCLOUD-PROVIDER", false);
//	    return instance.getHomePageUrl();
//	}
//	
//	@GetMapping("/eureka-info")
//	public ServiceInstance serviceInfo() {
//	    ServiceInstance info = discoveryClient.getLocalServiceInstance();
//	    return info;
//	}

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") int id) {
        System.out.println("A用户微服务getUsAer();");
        User user = new User();
        user.setId(id);
        //user.setBirthday(new Date());
        user.setUsername("james");
        user.setPassword("abwcde");
        user.setSalary(12000);
        return user;
    }

    @PostMapping("/postUser")
    public User postUser(@RequestBody User user) {
        return user;
    }

    @GetMapping("/list-all")
    public List<User> getAllUser() {
        List<User> user = new ArrayList<>();
        user.add(new User(12, "张三", "zhangsan", 12000));
        user.add(new User(13, "赵六", "zhangsan", 12000));
        user.add(new User(14, "王五", "zhangsan", 12000));
        user.add(new User(15, "李四", "zhangsan", 12000));
        return user;
    }


}
