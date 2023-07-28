package com.otp.otpvalidation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendOtpCodeDto {

	@JsonProperty("email")
	private String email;
	@JsonProperty("secret_key")
	private String secretKey;
	
	
	public SendOtpCodeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendOtpCodeDto(String email, String secretKey) {
		super();
		this.email = email;
		this.secretKey = secretKey;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSecretKey() {
		return secretKey;
	}
	
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	@Override
	public String toString() {
		return "SendOtpCodeDto [email=" + email + ", secretKey=" + secretKey + "]";
	}
	
}
