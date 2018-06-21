package com.andy;

import com.andy.order.entity.Users;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "springCloud-provider", configuration = ConfigurationFei1.class)
public interface UserFeignClient {
	
	@RequestLine("GET /getUser/{id}")
	public Users getUser(@Param("id")int id);

	@RequestLine("POST /postUser")
	public Users postUser(Users users);
	
}
