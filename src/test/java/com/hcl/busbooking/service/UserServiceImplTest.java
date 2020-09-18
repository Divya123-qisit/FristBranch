package com.hcl.busbooking.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import com.hcl.busbooking.dao.UserRepository;
import com.hcl.busbooking.dto.ResponseMessage;
import com.hcl.busbooking.dto.UserDto;
import com.hcl.busbooking.model.Booking;
import com.hcl.busbooking.model.User;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceImplTest {
	@Mock
	UserRepository userRepository;
	@InjectMocks
	UserServiceImpl userServiceImpl;
	static User user=null;
	static UserDto dto=null;
	static Booking booking=null;
	List<Booking> bookings=new ArrayList<Booking>();
	@BeforeClass
	public static void setUp() {
		
		user=new User();
		dto=new UserDto();
		booking=new Booking();
		user.setFirstName("bhavani");
		user.setPassword("bhavani123");
		List<Booking> bookings=new ArrayList<Booking>();
		booking.setNoOfSeats(1);
		booking.setUser(user);
		bookings.add(booking);
		dto.setFirstName("bhavani");
		dto.setPassword("bhavani123");

		
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void Useregistration() {
		UserDto dto1=new UserDto();
		dto1.setFirstName("bhavani");
		dto1.setPassword("bhavani123");
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(dto1);
		ResponseMessage s1 = userServiceImpl.registration(dto1);
		Assert.assertNotEquals(s1, s1);

	}
		
		
	}
	


