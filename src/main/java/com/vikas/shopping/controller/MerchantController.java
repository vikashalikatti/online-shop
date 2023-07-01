package com.vikas.shopping.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.vikas.shopping.dto.Merchant;
import com.vikas.shopping.service.MerchantService;

@Controller
@RequestMapping("/merchant")
public class MerchantController {

	@Autowired
	MerchantService merchantService;

	@GetMapping("/login")
	public ModelAndView gotoLogin() {
		return merchantService.gotologin();
	}

	@GetMapping("/forgotpassword")
	public ModelAndView gotoForgotoPassword() {
		return merchantService.gotoForgotoPassword();
	}

	@GetMapping("/signup")
	public ModelAndView gotoSignup() {
		return merchantService.gotoSign();
	}

	@PostMapping("/signup")
	public ModelAndView signup(Merchant merchant, @RequestParam String date, @RequestParam MultipartFile pic)
			throws IOException {
		return merchantService.signup(merchant, date, pic);
	}
}