package com.vikas.shopping.helper;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.vikas.shopping.dto.Merchant;

@Service
public class Otp_Helper {

	// In-memory storage for OTPs
	private Map<String, OTP> otpStorage = new HashMap<>();

	public int generateOTP() {
		// generate a 6-digit integer
		int otp = (int) ((Math.random() * 900000) + 100000);
		return otp;
	}

	public OTP createAndSaveOTP(String key) {
		int otp = generateOTP();
		LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(5);
		OTP OTP = new OTP(otp, expiryTime);

		// Save the OTP associated with the provided key (e.g., email or phone number)
		otpStorage.put(key, OTP);

		return OTP;
	}

	public void saveOtp(String key, OTP OTP) {
		// Save the provided OTP associated with the provided key (e.g., email or phone
		// number)
		otpStorage.put(key, OTP);
	}

	public OTP getOtp(String key) {
		return otpStorage.get(key);
	}

	public boolean validateOTP(String key, int otp) {
		OTP OTP = otpStorage.get(key);

		if (OTP == null || OTP.isExpired()) {
			return false;
		}

		return OTP.getOtp() == otp;
	}

	public OTP createAndSaveOTPFoMobile(String mobileNumber) {
		int otp = generateOTP();
		LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(5);
		OTP OTP = new OTP(otp, expiryTime);
		otpStorage.put(mobileNumber, OTP);

		return OTP;
	}

	public OTP createAndSaveOTP(Merchant merchant) {
		int otp = generateOTP();
		LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(5);
		OTP OTP = new OTP(otp, expiryTime);
		otpStorage.put(merchant.getEmail(), OTP);

		return OTP;
	}

}
