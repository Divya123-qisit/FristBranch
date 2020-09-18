package com.hcl.busbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.busbooking.dto.ResponseMessage;
import com.hcl.busbooking.dto.UserDto;
import com.hcl.busbooking.model.Booking;
import com.hcl.busbooking.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping("/user/{id}")
	public List<Booking> myBookings(@PathVariable int id){
		return userService.myBookings(id);
		
		
	}

	@PostMapping("/registration")
	public ResponseEntity<Object> registration(@RequestBody UserDto userDto){
		ResponseMessage user1=userService.registration(userDto);
		return new ResponseEntity<>("sucess", HttpStatus.OK);
		
	}

}
