package com.hcl.busbooking.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.busbooking.dto.ResponseMessage;
import com.hcl.busbooking.dto.UserDto;
import com.hcl.busbooking.model.Booking;
import com.hcl.busbooking.model.BusRoute;
import com.hcl.busbooking.model.User;
import com.hcl.busbooking.service.UserServiceImpl;


@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {
	@InjectMocks
	UserController userController;
	@Mock
	UserServiceImpl userServiceImpl;
	
	static User user=null;
	static Booking booking=null;
	static List<Booking> bookings=new ArrayList<Booking>();
	static BusRoute busRoute=null;
	@BeforeClass
	public static void setUp() {
		user=new User();
		booking=new Booking();
		user.setUserId(1);
		user.setEmail("bhavani");
		booking.setBookingId(2);
		booking.setBusroute(busRoute);
		booking.setUser(user);
		bookings.add(booking);
		
		
	}
	@Test
	public void testMyBooking() {
		
		Mockito.when(userServiceImpl.myBookings(user.getUserId())).thenReturn(bookings);
		userController.myBookings(user.getUserId());
		
	}
	@Test
	public void testForRegistration() {
		UserDto dto=new UserDto();
		dto.setFirstName("bhavani");
		ResponseMessage msg=new ResponseMessage();
		msg.setMessage("registration");
		Mockito.when(userServiceImpl.registration(dto)).thenReturn(msg);
		userController.registration(dto);
	}
	@Test
	public void testRegistrationPositive() {
		UserDto dto=new UserDto();
		dto.setFirstName("bhavani");
		ResponseMessage msg=new ResponseMessage();
		msg.setMessage("registration");
		Mockito.when(userServiceImpl.registration(dto)).thenReturn(msg);
		ResponseEntity<Object> message=userController.registration(dto);
		Assert.assertEquals(HttpStatus.OK, message.getStatusCode());
	}
	@Test
	public void testRegistration() {
		UserDto dto=new UserDto();
		dto.setFirstName("talluri");
		dto.setLastName("bhavani");
		ResponseMessage message=new ResponseMessage();
		message.setMessage("registration");
		Mockito.when(userServiceImpl.registration(dto)).thenReturn(message);
		ResponseEntity<Object> result=userController.registration(dto);
		Assert.assertNotNull(result);
	}
	@Test
	public void testRegistrationForPos() {
		UserDto dto=new UserDto();
		dto.setFirstName("talluri");
		dto.setLastName("bhavani");
		ResponseMessage message=new ResponseMessage();
		message.setMessage("Registration done!");
		Mockito.when(userServiceImpl.registration(dto)).thenReturn(message);
		ResponseEntity<Object> result=userController.registration(dto);
		Assert.assertNotEquals(result,message);
	}

	
	
	
}
