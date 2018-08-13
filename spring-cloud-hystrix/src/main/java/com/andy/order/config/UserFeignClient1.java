package com.andy.order.config;

import com.andy.order.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//configuration = ConfigurationFei1.class,
@FeignClient(name = "spring-cloud-provider"/*, fallback = HystrixClientFallback1.class*/)
public interface UserFeignClient1 {

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    User user(@PathVariable("userId") Integer userId);

}


