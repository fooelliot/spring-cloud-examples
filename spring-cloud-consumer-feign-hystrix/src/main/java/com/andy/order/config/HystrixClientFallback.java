//package com.andy.order.config;
//
//import com.andy.order.entity.User;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
///**
// * @Author: Mr.lyon
// * @CreateBy: 2018-06-22 23:42
// **/
//@Slf4j
//@Component
//public class HystrixClientFallback implements UserFeignClient {
//
//		@Override
//		public User user(int id) {
//			log.info("进入hystrix的fallback方法");
//			return new User(11, new Date(), "kobe", "password", 12000.00);
//		}
//
//}