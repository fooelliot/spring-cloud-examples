package com.andy.zuul;

import com.andy.zuul.filter.PreZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ZuulFilterApp {
    public static void main(String[] args) {
        SpringApplication.run(ZuulFilterApp.class, args);

    }

    @Bean
    public PreZuulFilter preZuulFilter() {
        return new PreZuulFilter();
    }

}
