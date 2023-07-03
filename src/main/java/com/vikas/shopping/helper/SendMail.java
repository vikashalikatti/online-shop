package com.vikas.shopping.helper;

import java.io.IOException;
import java.io.StringWriter;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.vikas.shopping.dto.Merchant;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class SendMail {
	@Autowired
	JavaMailSender javaMailSender;

	@Autowired
	Configuration configuration;

	public boolean send_mail(OTP otp, Merchant merchant) {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {
			helper.setFrom("E-Market");
			helper.setTo(merchant.getEmail());
			helper.setSubject("OTP for Email Verification");

			// Format expiry time to display in the email
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
			String formattedExpiryTime = otp.getExpiryTime().format(formatter);

			String content = "<span style='color:blue'>Dear " + merchant.getName() + ",</p>"
					+ "<p>Thanks for registering. Your one-time password (OTP) for email verification is " + "<b>"
					+ otp.getOtp() + "</b>" + "</p>" + "<p>This OTP is valid until " + formattedExpiryTime + ".</p>"
					+ "<p>Please enter this OTP to complete your registration process.</p>"
					+ "<p>If you did not initiate this request, please ignore this email.</p>" + "<p>Thank you,</p>"
					+ "<p>Our Team</p>";
			helper.setText(content, true);

			javaMailSender.send(message);
			return true; // assuming the method returns true when the mail has been sent successfully
		} catch (MessagingException e) {
			e.printStackTrace();
			return false; // in case of an exception, return false
		}
	}

	public Boolean sendWelcomeMail(Merchant exist) {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {
			helper.setFrom("gangsteryt222@gmail.com");
			helper.setTo(exist.getEmail());
			helper.setText(getEmailContent(exist), true);
			javaMailSender.send(message);
			return true; // Successfully sent email
		} catch (MessagingException e) {
			// Log error message
			System.out.println("Failed to send email: " + e.getMessage());
			e.printStackTrace();
			return false; // Failed to send email
		}
	}

	private String getEmailContent(Merchant exist) {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		StringWriter writer = new StringWriter();
		Map<String, Object> model = new HashMap<>();
		model.put("exist", exist);
		try {
			configuration.getTemplate("exist.ftl").process(model, writer);
		} catch (TemplateException | IOException e) {
			// Log error message
			System.out.println("Failed to process email template: " + e.getMessage());
			e.printStackTrace();
		}
		return writer.getBuffer().toString();
	}
}
