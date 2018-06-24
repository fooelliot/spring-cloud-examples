package com.andy.order.feign;

import com.andy.order.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("spring-cloud-provider")
public interface UserFeignClient {

//	不支持getMapping和postMapping并且pathVariable的value属性必须填写
//	@RequestMapping(value="/getUser/{id}",method=RequestMethod.GET)
//    User getUser(@PathVariable("id")int id);
//
//	@RequestMapping(value="/postUser",method=RequestMethod.POST)
//	User postUser(@RequestBody User user);

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User user(@PathVariable("id")int id);

	@RequestMapping(value = "/user", method = RequestMethod.POST)
    User user(@RequestBody User user);

}