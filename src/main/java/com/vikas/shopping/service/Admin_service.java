package com.vikas.shopping.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.vikas.shopping.helper.Login;

import jakarta.servlet.http.HttpSession;

@Service
public class Admin_service {

	public ModelAndView render_login() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("Admin_Login");
		return andView;
	}

	public ModelAndView login(Login login, HttpSession httpSession) {
		ModelAndView andView = new ModelAndView();
		if (login.getEmail().equals("admin") && login.getPassword().equals("admin")) {
			andView.addObject("pass", "Login Sucess");
			andView.setViewName("Admin_Home");
		} else {
			andView.addObject("fail", "Fail to Login");
			andView.setViewName("Admin_Login");
		}
		return andView;
	}

}
