package com.andy.order.feign;

import com.andy.order.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements UserFeignClient {
		@Override
		public Users getUser(int id) {
			Users user = new Users();
			user.setId(0);
			user.setUsername("默认名称");
			return user;
		}
	}