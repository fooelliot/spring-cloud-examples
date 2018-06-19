package com.andy;

import com.andy.entity.Users;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("springCloud-provider")
public interface UserFeignClient {

//	//不支持getmapping和postmapping并且pathvariable的value属性必须填写
//	@RequestMapping(value="/getUser/{id}",method=RequestMethod.GET)
//	public Users getUser(@PathVariable("id")int id);
//
//	@RequestMapping(value="/postUser",method=RequestMethod.POST)
//	public Users postUser(@RequestBody Users user);

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	Users getFeignUser(@PathVariable("id")int id);

	@RequestMapping(value = "/postUser", method = RequestMethod.POST)
	Users postFeignUser(@RequestBody Users users);
	
}
