package com.andy.order.ribbon;

import com.netflix.client.config.IClientConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Slf4j
@Configuration
@ExcludeFromComponentScan
public class IRuleConfiguration {
	
//	@Autowired
//	private IClientConfig clientConfig;
	
	@Bean
	public IRule ribbonRule(){
		log.info("ribbonRule->随机");
		return new RandomRule();
	}
	
	
}