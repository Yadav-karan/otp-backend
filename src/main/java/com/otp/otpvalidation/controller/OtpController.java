package com.otp.otpvalidation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otp.otpvalidation.dto.BasicResponse;
import com.otp.otpvalidation.dto.OtpSecretDto;
import com.otp.otpvalidation.dto.SendOtpCodeDto;
import com.otp.otpvalidation.service.OtpService;

@RestController
@RequestMapping("/otp")
@CrossOrigin("*")
public class OtpController {

	@Autowired
	private OtpService otpService;
	
	@GetMapping("/generate")
	public ResponseEntity<?> generateOtpSecretKey() {
		String secretKey = otpService.generateSecretKey();
		return new ResponseEntity<>(new BasicResponse(true,secretKey), HttpStatus.OK);
	}
	
	@PostMapping("/send-otp")
	public ResponseEntity<?> sendOtpCode(@RequestBody SendOtpCodeDto sendOtpCodeDto ) { 
		otpService.sendOtpCode(sendOtpCodeDto);
		return new ResponseEntity<>(new BasicResponse(true,"OTP Sent Successfullly"), HttpStatus.OK);
	}
	
	@PostMapping("/verify")
	public ResponseEntity<?> verifyOtpCode(@RequestBody OtpSecretDto otpSecretDto) {
		boolean isCodeValid = otpService.verifyCode(otpSecretDto);
		
		if (isCodeValid) {
			return new ResponseEntity<>(new BasicResponse(true,"OTP Verified Successfullly") , HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new BasicResponse(false,"Invalid OTP, Please Enter Valid OTP"), HttpStatus.BAD_REQUEST);
		}
	}
}
