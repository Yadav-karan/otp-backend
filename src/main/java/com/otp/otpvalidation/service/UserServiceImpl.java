package com.otp.otpvalidation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otp.otpvalidation.dto.UserDto;
import com.otp.otpvalidation.exceptions.NoSuchUserException;
import com.otp.otpvalidation.model.User;
import com.otp.otpvalidation.repository.UserRepository;
import com.otp.otpvalidation.utils.Utils;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User registerUser(UserDto userDto) {
		return userRepository.save(Utils.parseUserDtoToUser(userDto));
	}

	@Override
	public User getUserById(int userId) throws NoSuchUserException {
		User user = userRepository.findById(userId).
				orElseThrow(()-> new NoSuchUserException("User with userid: "+userId+" not found !!!!"));
		return user;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public String getEmailByUserName(String userName) {
		return userRepository.findByUserName(userName).getEmail();
	}

}
