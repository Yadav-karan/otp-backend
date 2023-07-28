package com.otp.otpvalidation.service;

import com.otp.otpvalidation.dto.OtpSecretDto;
import com.otp.otpvalidation.dto.SendOtpCodeDto;

public interface OtpService {
	
	String FROM ="vcode369@gmail.com";
	String SUBJECT = "OTP Code for validation";
	String TEXT = "Your OTP code for validation is ";

	String generateSecretKey();
	
	boolean verifyCode(OtpSecretDto otpSecretDto);
	
	public void sendOtpCode(SendOtpCodeDto sendOtpCodeDto);
}
