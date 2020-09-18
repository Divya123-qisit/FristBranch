package com.hcl.busbooking.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
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

import com.hcl.busbooking.dao.UserRepository;
import com.hcl.busbooking.dto.BusRoutescurdDto;
import com.hcl.busbooking.dto.BusSearchDto;
import com.hcl.busbooking.dto.ResponseMessage;
import com.hcl.busbooking.exception.AdminNotFoundException;
import com.hcl.busbooking.model.BusRoute;
import com.hcl.busbooking.model.User;
import com.hcl.busbooking.service.BusRouteServiceImpl;
@RunWith(MockitoJUnitRunner.Silent.class)
public class BusRouteControllerTest {
	private static final int userId = 0;
	private static final int busServiceNumber = 0;
	@InjectMocks
	BusRouteController busRouteController;
	@Mock
	BusRouteServiceImpl busRouteServiceImpl;
	@Mock
	UserRepository userRepository;
	
	static BusSearchDto dto=new BusSearchDto();
	static BusRoute route=null;
	@BeforeClass
	public static void setUp() {
		
		route =new BusRoute();
		route.setSource("kandukur");
		route.setDestination("chennai");
		route.setDate(new Date());
		dto.setSource("kandukur1");
		dto.setDestination("chennai");
		dto.setJourneyDate(new Date());
		
	}
	@Test
	public void testSearchBus() {
		List<BusRoute> routes=new ArrayList<BusRoute>();
		routes.add(route);
		Mockito.when(busRouteServiceImpl.searchBuses(dto)).thenReturn(routes);
		ResponseEntity<List<BusRoute>> b1=busRouteController.searchBuses(dto);
		Assert.assertEquals(HttpStatus.FOUND, b1.getStatusCode());
		
	}
	@Test
	public void testSearchBusForPositive() {
		List<BusRoute> routes=new ArrayList<BusRoute>();
		routes.add(route);
		Mockito.when(busRouteServiceImpl.searchBuses(dto)).thenReturn(routes);
         busRouteController.searchBuses(dto);
		Assert.assertEquals(route.getDestination(),dto.getDestination());
		
	}
	@Test
	public void testcreateBuspositive() throws AdminNotFoundException {
		BusRoutescurdDto dto = new BusRoutescurdDto();
		User user=new User();

		Mockito.when(userRepository.findByUserId(user.getUserId())).thenReturn(user);

		Mockito.when(busRouteServiceImpl.addBusRoute(dto,userId )).thenReturn(dto);

		ResponseEntity<BusRoutescurdDto> p1 = busRouteController.addBusRoute(dto, user.getUserId());
		Assert.assertNotNull(p1);
		Assert.assertNotNull(dto);
		Assert.assertEquals(HttpStatus.OK, p1.getStatusCode());

	}
	@Test
	public void testcreateBuspositiveNegtive() throws AdminNotFoundException {
		BusRoutescurdDto dto = new BusRoutescurdDto();
		User user=new User();

		Mockito.when(userRepository.findByUserId(user.getUserId())).thenReturn(user);

		Mockito.when(busRouteServiceImpl.addBusRoute(dto,userId )).thenReturn(dto);

		ResponseEntity<BusRoutescurdDto> p1 = busRouteController.addBusRoute(dto, user.getUserId());
		Assert.assertNotNull(p1);
		Assert.assertNotNull(dto);
		Assert.assertEquals(HttpStatus.OK, p1.getStatusCode());

	}
	@Test
	public void testupdateBuspositiveNegtive() throws AdminNotFoundException {
		BusRoutescurdDto dto = new BusRoutescurdDto();
		User user=new User();

		Mockito.when(userRepository.findByUserId(user.getUserId())).thenReturn(user);

		Mockito.when(busRouteServiceImpl.updateBusRoute(dto,userId )).thenReturn(dto);

		ResponseEntity<BusRoutescurdDto> p1 = busRouteController.updateBusRoute(dto, user.getUserId());
		Assert.assertNotNull(p1);
		Assert.assertNotNull(dto);
		Assert.assertEquals(HttpStatus.OK, p1.getStatusCode());

	}
	@Test
	public void testdeleteposve() {
		ResponseMessage dto = new ResponseMessage();
		User user=new User();
         Mockito.when(userRepository.findByUserId(user.getUserId())).thenReturn(user);
		Mockito.when(busRouteServiceImpl.deleteByBusroute(busServiceNumber, userId)).thenReturn(dto);

		ResponseEntity<ResponseMessage> p1 = busRouteController.deleteBybus(77, 0);
		Assert.assertNotNull(p1);
		Assert.assertNotNull(dto);
		Assert.assertEquals(HttpStatus.OK, p1.getStatusCode());

	}
	@Test
	public void testgetBuspositive() throws AdminNotFoundException {
		BusRoute dto = new BusRoute();
		User user=new User();

		Mockito.when(userRepository.findByUserId(user.getUserId())).thenReturn(user);

		Mockito.when(busRouteServiceImpl.getById(busServiceNumber, userId)).thenReturn(dto);

		ResponseEntity<BusRoute> p1 = busRouteController.getById(busServiceNumber, user.getUserId());
		Assert.assertNotNull(p1);
		Assert.assertNotNull(dto);
		Assert.assertEquals(HttpStatus.OK, p1.getStatusCode());

	}
	@AfterClass
	public static void tearDown() {
		route=null;
		
	}

}
