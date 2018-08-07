package com.andy;

import com.andy.order.ribbon.ExcludeFromComponentScan;
import com.andy.order.ribbon.IRuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * @author: lyon
 * @createBy: 2018-12-21 21:27
 **/
@SpringCloudApplication
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class)})
@RibbonClients({@RibbonClient(name = "spring-cloud-provider", configuration = IRuleConfiguration.class)})
public class SpringCloudApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudApp.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
