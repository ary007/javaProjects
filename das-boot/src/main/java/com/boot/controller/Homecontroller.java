package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Homecontroller {

	@RequestMapping("/")
	public String home() {
		return "Das-boot";
	}

}
