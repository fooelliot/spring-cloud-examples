package com.andy.order.controller;

import com.andy.UserFeignClient1;
import com.andy.order.feign.FeignClient2;
import com.andy.order.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
	
	@Autowired
	private UserFeignClient1 userFeignClient1;


	@Autowired
	private FeignClient2 feignClient2;

	
	@RequestMapping(value="/getObj/{id}", method = RequestMethod.GET)
	public Users getObj(@PathVariable("id")int id) {
		Users user = userFeignClient1.getUser(id);
		return user;
	}

	@RequestMapping(value="/eureka/apps/{serviceName}",method = RequestMethod.GET)
	public String findEurekaServiceByName(@PathVariable("serviceName")String serviceName){
		String result = feignClient2.findEurekaServiceByName(serviceName);
		return result;
	}
	
}
