package com.vikas.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class Main_controller {
	@GetMapping("/")
	public ModelAndView home_page() {
		ModelAndView andView = new ModelAndView("Home");
		return andView;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession httpSession) {
		ModelAndView andView = new ModelAndView();
		andView.addObject("pass","Logout Success");
		andView.setViewName("Admin_Login");
		return andView;
	}
}
