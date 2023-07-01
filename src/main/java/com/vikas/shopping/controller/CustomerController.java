package com.vikas.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vikas.shopping.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/login")
	public ModelAndView gotoLogin() {
		return customerService.gotologin();
	}

	@GetMapping("/forgotpassword")
	public ModelAndView gotoForgotoPassword() {
		return customerService.gotoForgotoPassword();
	}

	@GetMapping("/signup")
	public ModelAndView gotoSignup() {
		return customerService.gotosingup();
	}
}
