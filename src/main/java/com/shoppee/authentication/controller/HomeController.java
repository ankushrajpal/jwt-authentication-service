package com.shoppee.authentication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@RequestMapping("/index")
	public String index() {
		return "<h1 style=\"color:red;text-align:center;\">Home Page </h1>"
				+ "<h2>Hello guys, this is the <b>home page</b> and can be accesssed by anyone "
				+ "<b><i>(without using spring security)</i></b></h2>";
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "<h1 style=\"color:red;text-align:center;\">Protected Page </h1>"
				+ "<h2>Hello guys, this is a <b>protected page</b> and can be accesssed after login/authentication only"
				+ "<b><i>(without using spring security)</i></b></h2>";
	}
	
	
	


}
