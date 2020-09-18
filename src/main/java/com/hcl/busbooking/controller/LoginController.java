package com.hcl.busbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.busbooking.dto.ResponseMessage;
import com.hcl.busbooking.dto.UsersDto;
import com.hcl.busbooking.exception.UserNotFoundException;
import com.hcl.busbooking.service.LoginService;


@RestController
public class LoginController {
	@Autowired
	LoginService loginService;

	private ResponseMessage Responsedto = new ResponseMessage();

	@PostMapping(value = "/login")
	public ResponseEntity<ResponseMessage> login(@RequestBody UsersDto userDto) throws UserNotFoundException {

		loginService.login(userDto);
		Responsedto.setMessage("user Sucessfully login");
		return new ResponseEntity<>(Responsedto, HttpStatus.OK);

	}
}
