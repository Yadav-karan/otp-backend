package com.otp.otpvalidation.exceptions;

public class NoSuchUserException extends Exception {

	public NoSuchUserException(){
		
	}
	
	public NoSuchUserException(String msg) {
		super(msg);
	}
}
