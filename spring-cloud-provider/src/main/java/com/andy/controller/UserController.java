package com.andy.controller;

import java.util.ArrayList;
import java.util.List;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.andy.entity.User;

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
//	    ServiceInstance info = discoveryClient.getLocalServiceInstance();
	    return null;
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id")int id) {
		log.info("A用户微服务getUsAer();");
		return new User(id, "user", "password", 12000);
	}
	
	@PostMapping("/user")
	public User postUser(@RequestBody User user) {
		log.info("用户微服务postUser()");
		return user;
	}
	
	@GetMapping("/list")
	public List<User> getAllUser() {
		List<User> user = new ArrayList<>();
		user.add(new User(12, "张三", "zhangsan", 12000));
		user.add(new User(13, "赵六", "zhaoliu", 12000));
		user.add(new User(14, "王五", "wangwu", 12000));
		user.add(new User(15, "李四", "lisi", 12000));
		return user;
	}

}
