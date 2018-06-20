package com.andy;

import com.andy.user.entity.Users;
import org.springframework.cloud.netflix.feign.FeignClient;

import com.jja.entity.Users;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "springCloud-provider", configuration = ConfigurationFei1.class)
public interface UserFeignClient {
	
	@RequestLine("GET /getUser/{id}")
	public Users getUser(@Param("id")int id);

	@RequestLine("POST /postUser")
	public Users postUser(Users users);
	
}
