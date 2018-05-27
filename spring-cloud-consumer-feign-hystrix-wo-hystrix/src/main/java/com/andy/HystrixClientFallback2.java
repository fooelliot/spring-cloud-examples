package com.andy;

import com.andy.feign.FeignClient2;
import com.jja.feign.FeignClient2;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback2 implements FeignClient2 {

    @Override
	public String findEurekaServiceByName(String serviceName) {
		return "haha";
	}

}
