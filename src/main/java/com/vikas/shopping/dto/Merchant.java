package com.vikas.shopping.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.vikas.shopping.helper.OTP;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Component
@Data
public class Merchant {
	private String name;
	@Id
	private String email;
	private long mobile;
	private String password;
	private LocalDate dob;
	private String gender;
	private String address;
	private boolean otpstatus;

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	byte[] picture;
}