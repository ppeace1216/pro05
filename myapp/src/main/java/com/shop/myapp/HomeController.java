package com.shop.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	@ResponseBody
	public String goMain(HttpServletRequest request) {
		return "Ok Spring Boot Main";
	}
	
	@RequestMapping(value = "/home", method=RequestMethod.GET)
	@ResponseBody
	public String goHome(HttpServletRequest request) {
		System.out.println("OK~!");
		return "Hello Spring Boot";
	}
}
