package com.andy.order.config;

import com.andy.order.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: lyon
 * @since: 2018-02-22
 **/
@Slf4j
@Component
public class HystrixClientFallback implements UserFeignClient2 {

    @Override
    public User user(Integer userId) {
        log.info("进入hystrix的fallback方法");
        return new User(11, new Date(), "kobe", "password", 12000.00);
    }

    @Override
    public List<User> list() {
        return new ArrayList<>();
    }


}