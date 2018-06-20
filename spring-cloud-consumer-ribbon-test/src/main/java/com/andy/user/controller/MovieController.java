package com.andy.user.controller;

import java.util.List;

import com.andy.user.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ruolin
 * create by 2017年11月19日下午12:44:45
 */
@SuppressWarnings("unchecked")
@RestController
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/getObj/{id}")
	public Users getObj(@PathVariable("id")int id) {
		System.out.println("访问到了");
		return restTemplate.getForObject("http://springCloud-provider/getUser/"+id, Users.class);
	}
	
	@GetMapping("/test")
	public String test(){
		ServiceInstance choose = loadBalancerClient.choose("springCloud-provider");
		System.out.println("app1:"+choose.getHost()+"=="+choose.getPort()+"=="+choose.getServiceId());
		
		ServiceInstance choose2 = loadBalancerClient.choose("springCloud-provider2");
		System.out.println("app2:"+choose2.getHost()+"=="+choose2.getPort()+"=="+choose2.getServiceId());

		return "success";
	}
	
	
	
	@GetMapping("/list-all")
	public List<Users> getAll(){
		return restTemplate.getForObject("http://springCloud-provider/list-all", List.class);
	}
	
	
	
}
