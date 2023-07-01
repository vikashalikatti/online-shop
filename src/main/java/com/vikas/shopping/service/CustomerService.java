package com.vikas.shopping.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class CustomerService {

	public ModelAndView gotologin() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("CustomerLogin");
		return andView;
	}

	public ModelAndView gotoForgotoPassword() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("gotoForgotoPassword");
		return andView;
	}

	public ModelAndView gotosingup() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("CustomerSignup");
		return andView;
	}

}
