package com.andy.feign;

import com.andy.entity.Users;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "springCloud-provider", /*fallback = HystrixClientFallback.class,*/ fallbackFactory = HystrixClientFactory.class)
public interface UserFeignClient {
	
	@RequestMapping(value="/getUser/{id}",method=RequestMethod.GET)
	Users getUser(@PathVariable("id")int id);
	
}


