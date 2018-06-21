package com.andy.config;

import com.andy.order.entity.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "springCloud-provider", fallback = HystrixClientFallback.class)
public interface UserFeignClient {
	
	@RequestMapping(value="/getUser/{id}",method=RequestMethod.GET)
	Users getUser(@PathVariable("id")int id);
	
}


