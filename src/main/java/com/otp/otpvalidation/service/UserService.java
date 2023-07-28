package com.otp.otpvalidation.service;

import java.util.List;

import com.otp.otpvalidation.dto.UserDto;
import com.otp.otpvalidation.exceptions.NoSuchUserException;
import com.otp.otpvalidation.model.User;

public interface UserService {

	User registerUser(UserDto userDto);
	
	User getUserById(int userId) throws NoSuchUserException;
	
	List<User> getAllUser();
	
	String getEmailByUserName(String userName);
}
