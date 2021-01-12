package com.anfegagra.gateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
	name = "anything",
	url = "https://localhost:9002",
	configuration = SSLFeignConfiguration.class
)
public interface ServerFeignClient {

	@GetMapping("/server/test")
	String getData();
}
