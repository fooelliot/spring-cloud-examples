package com.andy.user.controller;

import com.andy.UserFeignClient;
import com.andy.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
//	@GetMapping("/getObj/{id}")
//	public Users getObj(@PathVariable("id")int id) {
//		Users user = userFeignClient.getUser(id);
//		return user;
//	}
//
//	@GetMapping(value="/postUser")
//	public Users getPostUser(Users user){
//		return userFeignClient.postUser(user);
//	}


	@GetMapping("/getObj/{id}")
	public User getObj(@PathVariable("id")int id) {
		User user = userFeignClient.getFeignUser(id);
		return user;
	}

	@PostMapping(value="/postObj")
	public User getPostUser(@RequestBody User user){
		return userFeignClient.postFeignUser(user);
	}

	
}
