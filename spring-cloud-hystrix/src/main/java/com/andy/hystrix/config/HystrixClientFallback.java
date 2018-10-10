package com.andy.hystrix.config;

import com.andy.hystrix.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Leone
 * @since 2018-02-22
 **/
@Slf4j
@Component
public class HystrixClientFallback implements UserFeignClient2 {

    @Override
    public User user(Integer userId) {
        log.info("进入fallback方法");
        return new User(11, new Date(), "default", "defPassword", 12000.00);
    }

    @Override
    public List<User> list() {
        log.info("进入fallback方法");
        return new ArrayList<>();
    }


}