package com.vikas.shopping.service;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.vikas.shopping.dao.MerchantDao;
import com.vikas.shopping.dto.Merchant;
import com.vikas.shopping.helper.Login;
import com.vikas.shopping.helper.OTP;
import com.vikas.shopping.helper.Otp_Helper;
import com.vikas.shopping.helper.SendMail;

import jakarta.servlet.http.HttpSession;

@Service
public class MerchantService {

	@Autowired
	MerchantDao merchantDao;
	@Autowired
	Otp_Helper otp_Helper;

	@Autowired
	SendMail mail;

	public ModelAndView signup(Merchant merchant, String date, MultipartFile pic) throws IOException {
		ModelAndView andView = new ModelAndView();
		if (merchantDao.findByEmail(merchant.getEmail()) == null
				&& merchantDao.findByMobile(merchant.getMobile()) == null) {
			merchant.setDob(LocalDate.parse(date));

			byte[] picture = new byte[pic.getInputStream().available()];
			pic.getInputStream().read(picture);
			merchant.setPicture(picture);

			// Logic for generating otp
			// Logic For Sending Mail
			OTP otpDto = otp_Helper.createAndSaveOTP(merchant.getEmail());
			if (mail.send_mail(otpDto, merchant)) {
				merchantDao.save(merchant);
				andView.addObject("merchant", merchant.getEmail());
				andView.addObject("pass", "Otp Sent Sucessfully");
				andView.setViewName("Otp_Signup");
			} else {
				andView.addObject("fail", "Your email is Worong Please Enter the Correct Email");
				andView.setViewName("MerchantSignup.jsp");
			}

		} else {
			andView.addObject("fail", "Our System Has Detected Ur Email or Phone number Soo... Please Login");
			andView.setViewName("MerchantLogin");
		}
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

	public ModelAndView verify_otp(int otp, Merchant merchant, String email) {
		ModelAndView andView = new ModelAndView();
		Merchant exist = merchantDao.findByEmail(email);
		if (exist != null) {
			OTP otp2 = otp_Helper.getOtp(email);
			if (otp2 != null) {
				boolean isvalid = otp_Helper.validateOTP(email, otp);
				if (isvalid) {
					exist.setOtpstatus(true);
					merchantDao.save(exist);
					mail.sendWelcomeMail(exist);
					andView.setViewName("MerchantLogin");
					andView.addObject("pass", "Aoccunt Verified Suessfully");
				} else {
					andView.setViewName("MerchantLogin");
					andView.addObject("fail", "You Can Verify Your Email Using Login");
				}
			}
		}
		return andView;
	}

	public ModelAndView login(Login login, HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		String email = login.getEmail();
		Merchant merchant = merchantDao.findByEmail(email);
		if (merchant == null) {
			modelAndView.setViewName("MerchantLogin");
			modelAndView.addObject("fail", "Email not Found");
		} else {
			if (login.getPassword().equals(merchant.getPassword())) {
				if (merchant.isOtpstatus()) {
					httpSession.setAttribute("merchant", merchant);
					modelAndView.setViewName("MerchantHome");
					modelAndView.addObject("pass", "Login Success");
				} else {
					modelAndView.addObject("email", email);
					OTP otp = otp_Helper.createAndSaveOTP(email);
					mail.send_mail(otp, merchant);
					modelAndView.setViewName("Otp_Signup");
					modelAndView.addObject("fail", "Please Verify Your Email to Login");
				}
			} else {
				modelAndView.setViewName("MerchantLogin");
				modelAndView.addObject("fail", "Wrong password");
			}
		}
		return modelAndView;
	}

}
