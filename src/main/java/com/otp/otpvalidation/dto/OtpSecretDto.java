package com.otp.otpvalidation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OtpSecretDto {

	@JsonProperty("secret_key")
	private String secretKey;
	@JsonProperty("code")
	private int code;
	
	public OtpSecretDto() {
		
	}
	
	public OtpSecretDto(String secretKey, int code) {
		super();
		this.secretKey = secretKey;
		this.code = code;
	}
	
	public String getSecretKey() {
		return secretKey;
	}
	
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "OtpSecretDto [secretKey=" + secretKey + ", code=" + code + "]";
	}
	
	
}
