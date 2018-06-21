package com.andy.feign;

import com.andy.HystrixClientFallback2;
import com.andy.config.ConfigurationFei2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
