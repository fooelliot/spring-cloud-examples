package com.andy.config.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.config.ConfigurationFei2;
import com.jja.HystrixClientFallback2;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ruolin
 * create by 2017年11月19日上午7:58:57
 */
@FeignClient(name="xxx",url="http://localhost:8761/", configuration = ConfigurationFei2.class,fallback=HystrixClientFallback2.class)
public interface FeignClient2 {
	
	@RequestMapping(value="/eureka/apps/{serviceName}",method = RequestMethod.GET)
	public String findEurekaServiceByName(@PathVariable("serviceName")String serviceName);
}
