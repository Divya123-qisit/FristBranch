package com.hcl.busbooking.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.busbooking.dao.BookingRepository;
import com.hcl.busbooking.dto.BookingDto;
import com.hcl.busbooking.dto.BookingsDto;
import com.hcl.busbooking.model.Booking;
import com.hcl.busbooking.model.BusRoute;


@RunWith(MockitoJUnitRunner.Silent.class)
public class BookingServiceImplTest {
	
	@InjectMocks
	BookingServiceImpl bookingServiceImpl;
	@Mock
	BookingRepository bookingRepository;
	
	static Booking booking = null;
	static BusRoute route=null;

	@BeforeClass
	public static void setUp() {
		booking = new Booking();
		route=new BusRoute();

	}

	@Before
	public void beforeMethod() {
		booking.setBookingId(12);
		booking.setMobileNumber(51671671);
		route.setBusName("kaveri");
		route.setBusServiceNumber(323);
		booking.setBusroute(route);
	}
	
	
	@Test
	public void testbookTheTicket() {
		BookingsDto dto=new BookingsDto();
		dto.setBusServiceNumber(123);
		dto.setNumberOfSeats(2);
		Mockito.when(bookingRepository.save(booking)).thenReturn(booking);
		BookingDto s1 = bookingServiceImpl.bookTheSeat(dto, 0, 0);
		Assert.assertNotEquals("kaveri1", s1.getBusName());
	}
	@Test
	public void testaddBookingNe() {
		BookingsDto dto=new BookingsDto();
		dto.setBusServiceNumber(123);
		dto.setNumberOfSeats(2);
		dto.setUserId(2);
		Mockito.when(bookingRepository.save(booking)).thenReturn(booking);
		BookingDto s1 = bookingServiceImpl.bookTheSeat(dto, 0, 0);
		Assert.assertEquals("kaveri", s1.getBusName());
	}

}
