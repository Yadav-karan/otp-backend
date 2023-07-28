package com.otp.otpvalidation.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthRequest {

	@JsonProperty("user_name")
	private String userName;
	@JsonProperty("password")
	private String password;

	public AuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AuthRequest [userName=" + userName + ", password=" + password + "]";
	}

}