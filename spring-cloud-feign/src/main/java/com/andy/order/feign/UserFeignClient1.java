package com.andy.order.feign;

import com.andy.order.feign.config.ConfigurationFei2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: lyon
 * @createBy: 2017-11-19 7:58:57
 **/
@FeignClient(name = "user", url = "http://localhost:8761/", configuration = ConfigurationFei2.class)
public interface UserFeignClient1 {

    @RequestMapping(value = "/eureka/apps/{serviceName}")
    String findEurekaServiceByName(@PathVariable("serviceName") String serviceName);

}
