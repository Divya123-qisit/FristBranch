package com.hcl.busbooking.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.hcl.busbooking.dao.UserRepository;
import com.hcl.busbooking.dto.UserDto;
import com.hcl.busbooking.dto.UsersDto;
import com.hcl.busbooking.exception.UserNotFoundException;
import com.hcl.busbooking.model.User;

public class LoginServiceImplTest {
	@InjectMocks
	LoginServiceImpl loginServiceImpl;
	@Mock
	UserRepository userRepository;
	

	@Test(expected = NullPointerException.class)
	public void testGetUserForPositive() throws UserNotFoundException  {
		UsersDto userDto = new UsersDto();
		userDto.setEmail("bhavani@gmail.com");
		userDto.setPassword("bhavani");
		User user=new User();
		user.setPassword("bhavani");
		user.setEmail("bhavani@gmail.com");
		Mockito.when(userRepository.findByEmailAndPassword(userDto.getEmail(),userDto.getPassword())).thenReturn(user);
		user = loginServiceImpl.login(userDto);
		Assert.assertNotNull(user);
	}
	@Test(expected = NullPointerException.class)
	public void testgetUserForNegitive() throws UserNotFoundException  {
		UsersDto userDto = new UsersDto();
		userDto.setEmail("bhavani@gmail.com");
		userDto.setPassword("bhavani");
		User user=new User();
		user.setPassword("bhavani");
		user.setFirstName("lakshmi");
		
		user.setEmail("bhavani@gmail.com");
		Mockito.when(userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword())).thenReturn(user);

		user= loginServiceImpl.login(userDto);
		Assert.assertNotNull(user);
		Assert.assertEquals(user.getEmail(),userDto.getEmail());
	}
	
	@Test(expected = Exception.class)
	public void testgetUserForExce(){
		UserDto userDto = new UserDto();
		Mockito.when(userRepository.findByEmailAndPassword(userDto.getEmail(),userDto.getPassword())).thenThrow(Exception.class);
	}
}
