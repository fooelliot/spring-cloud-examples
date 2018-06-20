package com.andy;

import com.andy.user.entity.Users;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jja.entity.Users;

//configuration = ConfigurationFei1.class,
@FeignClient(name = "springCloud-provider", fallback = HystrixClientFallback1.class)
public interface UserFeignClient1 {
	@RequestMapping(value="/getUser/{id}",method=RequestMethod.GET)
	public Users getUser(@PathVariable("id")int id);
}


