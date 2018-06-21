package com.andy.order.controller;

import com.andy.UserFeignClient;
import com.andy.feign.FeignClient2;
import com.andy.order.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private FeignClient2 feignClient2;
	
	
	@GetMapping("/getObj/{id}")
	public Users getObj(@PathVariable("id")int id) {
		Users user = userFeignClient.getUser(id);
		return user;
	}
	
	@GetMapping("/{serviceName}")
	public String findEurekaServiceByName(@PathVariable("serviceName")String serviceName) {
		return feignClient2.findEurekaServiceByName(serviceName);
	}

	@PostMapping("/postObj")
	public Users postObj(@RequestBody Users users) {
		return userFeignClient.postUser(users);
	}

	
}
