package com.otp.otpvalidation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.otp.otpvalidation.dto.OtpSecretDto;
import com.otp.otpvalidation.dto.SendOtpCodeDto;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

@Service
public class OtpServiceImpl implements OtpService {

	private static final Logger logger = LoggerFactory.getLogger(OtpServiceImpl.class);
	
	@Autowired
	private JavaMailSender emailSender;
	
	@Override
	public String generateSecretKey() {
		GoogleAuthenticator gAuth = new GoogleAuthenticator();
		final GoogleAuthenticatorKey key = gAuth.createCredentials();
		return key.getKey();
	}

	@Override
	public boolean verifyCode(OtpSecretDto otpSecretDto) {
		GoogleAuthenticator gAuth = new GoogleAuthenticator();
		return gAuth.authorize(otpSecretDto.getSecretKey().replace(" ", ""), otpSecretDto.getCode());
	}

	@Override
	public void sendOtpCode(SendOtpCodeDto sendOtpCodeDto) {
		logger.info("Sending OTP Email.........");
		GoogleAuthenticator gAuth = new GoogleAuthenticator();
		
		int code = gAuth.getTotpPassword(sendOtpCodeDto.getSecretKey());
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(sendOtpCodeDto.getEmail());
		message.setFrom(OtpService.FROM);
		message.setSubject(OtpService.SUBJECT);
		message.setText(OtpService.TEXT + code);
		emailSender.send(message);
		logger.info("OTP sent Successfully");
	}

}
