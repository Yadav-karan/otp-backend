package com.otp.otpvalidation.utils;

import com.otp.otpvalidation.dto.UserDto;
import com.otp.otpvalidation.model.User;

public class Utils {
	
	public static User parseUserDtoToUser(UserDto userDto) {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setUserName(userDto.getUserName());
		return user;
	}

}
