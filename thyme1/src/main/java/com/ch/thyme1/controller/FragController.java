package com.ch.thyme1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FragController {
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}
