package com.hcl.busbooking.controller;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner.Silent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.busbooking.dto.ResponseMessage;
import com.hcl.busbooking.dto.UsersDto;
import com.hcl.busbooking.exception.UserNotFoundException;
import com.hcl.busbooking.model.User;
import com.hcl.busbooking.service.LoginServiceImpl;
@RunWith(Silent.class)
public class LoginControllerTest {
	@InjectMocks
	LoginController logincontroller;
	@Mock
	LoginServiceImpl userloginService;
	private User user;
	static UsersDto login = null;

	@BeforeClass
	public static void setUp() {
		login = new UsersDto();
	}
	@Test
	public void testforUserLogin() throws UserNotFoundException {
		login.setEmail("divya@gmail.com");
		login.setPassword("sam");
		UsersDto userDto = null;
		Mockito.when(userloginService.login(userDto)).thenReturn(user);
		ResponseEntity<ResponseMessage> result = logincontroller.login(userDto);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	@Test(expected = Exception.class)
	 public void testLoginforexce() throws UserNotFoundException {
		 login.setEmail("sowjanya@gmail.com");
		 login.setPassword("sowji");
		UsersDto userDto = null;
		Mockito.when(userloginService.login(userDto)).thenThrow(Exception.class);
		 ResponseEntity<ResponseMessage> result=logincontroller.login(userDto);
		 Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
	 }
	@Test
	public void testforUserLoginNegtive() throws UserNotFoundException {
		login.setEmail("divya@gmail.com");
		login.setPassword("-sam");
		UsersDto userDto = null;
		Mockito.when(userloginService.login(userDto)).thenReturn(user);
		ResponseEntity<ResponseMessage> result = logincontroller.login(userDto);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
	}

}
