package com.vikas.shopping.helper;

import java.time.LocalDateTime;

public class OTP {
	private int otp;
	private LocalDateTime expiryTime;

	public OTP() {
	}

	public OTP(int otp, LocalDateTime expiryTime) {
		this.otp = otp;
		this.expiryTime = expiryTime;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public LocalDateTime getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(LocalDateTime expiryTime) {
		this.expiryTime = expiryTime;
	}

	public boolean isExpired() {
		return LocalDateTime.now().isAfter(this.expiryTime);
	}
}
