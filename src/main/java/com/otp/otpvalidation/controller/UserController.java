package com.otp.otpvalidation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otp.otpvalidation.dto.BasicResponse;
import com.otp.otpvalidation.dto.UserDto;
import com.otp.otpvalidation.exceptions.NoSuchUserException;
import com.otp.otpvalidation.model.User;
import com.otp.otpvalidation.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register-user")
	public ResponseEntity<User> registerUser(@RequestBody UserDto userDto){
		User user = userService.registerUser(userDto);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	
	@GetMapping("/get-all-users")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userService.getAllUser();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/get-user-by-id/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId) throws NoSuchUserException{
		User user = userService.getUserById(userId);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/get-email-by-user-name/{userName}")
	public ResponseEntity<?> getEmailByUserName(@PathVariable String userName){
		String email = userService.getEmailByUserName(userName);
		return new ResponseEntity<>(new BasicResponse(true, email),HttpStatus.OK);
	}

}
