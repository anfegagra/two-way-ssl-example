package com.anfegagra.gateway.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.anfegagra.gateway.feign")
//@EnableFeignClients(clients = ServerFeignClient.class)
public class FeignClientConfig {

}
