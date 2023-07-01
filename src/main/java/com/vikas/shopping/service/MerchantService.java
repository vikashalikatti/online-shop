package com.vikas.shopping.service;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.vikas.shopping.dao.MerchantDao;
import com.vikas.shopping.dto.Merchant;

@Service
public class MerchantService {

	@Autowired
	MerchantDao merchantDao;

	public ModelAndView signup(Merchant merchant, String date, MultipartFile pic) throws IOException {
		ModelAndView andView = new ModelAndView();
		merchant.setDob(LocalDate.parse(date));

		byte[] picture = new byte[pic.getInputStream().available()];
		pic.getInputStream().read(picture);
		merchant.setPicture(picture);

		if (merchantDao.findByEmail(merchant.getEmail()) != null
				|| merchantDao.findByMobile(merchant.getMobile()) != null) {
			andView.addObject("fail","Our System Has Detected Ur Email or Phone number Soo... Please Login");
//			model.put("fail", "Email or Mobile Should not be repeated");
//			return "/merchant/signup";
		}

		// Logic for generating otp
		// Logic For Sending Mail

		merchantDao.save(merchant);

		return andView;

	}

	public ModelAndView gotologin() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("MerchantLogin");
		return andView;
	}

	public ModelAndView gotoForgotoPassword() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("gotoForgotoPassword");
		return andView;
	}

	public ModelAndView gotoSign() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("MerchantSignup");
		return andView;
	}

}
