package com.andy.config;

import com.andy.user.entity.Users;
import org.springframework.stereotype.Component;
@Component
public class HystrixClientFallback implements UserFeignClient {
		@Override
		public Users getUser(int id) {
			Users user = new Users();
			user.setId(0);
			user.setUsername("默认名称(fallback方法)");
			user.setSalary(1.0);
			return user;
		}
}