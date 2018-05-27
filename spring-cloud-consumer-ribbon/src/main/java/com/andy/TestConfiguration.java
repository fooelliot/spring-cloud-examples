package com.andy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {
	
//	@Autowired
//	IClientConfig clientConfig;
	
	@Bean
	public IRule ribbonRule(){
		System.out.println("随机");
		return new RandomRule();
	}
	
	
}