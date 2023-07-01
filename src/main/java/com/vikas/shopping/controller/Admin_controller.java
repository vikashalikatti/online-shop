package com.vikas.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vikas.shopping.helper.Login;
import com.vikas.shopping.service.Admin_service;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class Admin_controller {
	@Autowired
	Admin_service admin_service;

	
	@GetMapping("/login")
	public ModelAndView render_login() {
		return admin_service.render_login();
	}
	
	
	@PostMapping("/login")
	public ModelAndView login(Login login,HttpSession httpSession) {
		return admin_service.login(login,httpSession);
	}
}
