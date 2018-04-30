package com.andy.config.controller;

import java.util.ArrayList;
import java.util.List;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jja.entity.Users;

@RestController
public class UserController {
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/eureka-instance")
	public String serviceUrl() {
	    InstanceInfo instance = eurekaClient.getNextServerFromEureka("SPRINGCLOUD-PROVIDER", false);
	    return instance.getHomePageUrl();
	}

	@GetMapping("/eureka-info")
	public ServiceInstance serviceInfo() {
	    ServiceInstance info = discoveryClient.getLocalServiceInstance();
	    return info;
	}
	
	@GetMapping("/getUser/{id}")
	public Users getUser(@PathVariable("id")int id) {
		System.out.println("A用户微服务getUsAer();");
		Users user = new Users();
		user.setId(id);
		//user.setBirthday(new Date());
		user.setUsername("user");
		user.setPassword("userpassword");
		user.setSalary(12000);
		return user;
	}
	
	@PostMapping("/postUser")
	public Users postUser(@RequestBody Users user) {
		System.out.println("用户微服务postUser();");
		return user;
	}
	
	@GetMapping("/list-all")
	public List<Users> getAllUser() {
		List<Users> user = new ArrayList<>();
		user.add(new Users(12, "张三", "zhangsan", 12000));
		user.add(new Users(13, "赵六", "zhangsan", 12000));
		user.add(new Users(14, "王五", "zhangsan", 12000));
		user.add(new Users(15, "李四", "zhangsan", 12000));
		return user;
	}

}
