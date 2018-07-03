package com.andy.order.feign;

import com.andy.order.entity.User;
import com.andy.order.feign.config.ConfigurationFei1;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "spring-cloud-provider", configuration = ConfigurationFei1.class)
public interface UserFeignClient2 {

    @RequestLine("GET /user/{id}")
    User user(@Param("id") int id);

    @RequestLine("POST /user")
    User user(User users);

}
