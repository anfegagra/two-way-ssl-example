package com.anfegagra.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class DemoController {

	@GetMapping("/test")
	public String sayHello() {
		return "Hello from server";
	}

}
