package com.anfegagra.gateway.controller;

import com.anfegagra.gateway.feign.ServerFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway")
public class DemoController {

	private final ServerFeignClient serverFeignClient;

	public DemoController(ServerFeignClient serverFeignClient) {
		this.serverFeignClient = serverFeignClient;
	}

	@GetMapping("/test")
	public String getMessageFromServer() {
		return serverFeignClient.getData();
	}
}
