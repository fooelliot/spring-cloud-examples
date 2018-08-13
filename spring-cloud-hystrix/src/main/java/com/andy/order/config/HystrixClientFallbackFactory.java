package com.andy.order.config;

import com.andy.order.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author: lyon
 * @since: 2018-02-13
 **/
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<UserFeignClient1> {

    @Override
    public UserFeignClient1 create(Throwable cause) {
        return new UserFeignClient1() {
            @Override
            public User user(Integer userId) {
                return new User();
            }

            @Override
            public List<User> list() {
                return new ArrayList<>();
            }
        };
    }
}
