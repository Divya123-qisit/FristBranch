package com.hcl.busbooking.controller;

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

import com.hcl.busbooking.dto.BookingDto;
import com.hcl.busbooking.dto.BookingsDto;
import com.hcl.busbooking.model.Booking;
import com.hcl.busbooking.service.BookingServiceImpl;
@RunWith(MockitoJUnitRunner.Silent.class)

public class BookingControllerTest {
	/*
	
		@InjectMocks
		private BookingController bookingController;
		@Mock
		private BookingServiceImpl bookingServiceImpl;
		static  Booking booking;
		@BeforeClass
		public static void setUp() {
			booking=new Booking();
			booking.setBookingId(1);
			booking.setNoOfSeats(2);
		}
		@Test
		public void testBooking() {
			BookingDto dto=new BookingDto();
			dto.setBusName("kaveri");
			dto.setNoOfSeats(2);
			Mockito.when(bookingServiceImpl.bookTheSeat(booking)).thenReturn(dto);
			bookingController.bookingtheTicket(booking);
		}
		@Test
		public void testBookingForPositive() {
			BookingsDto dto=new BookingsDto();
			dto.setBusName("kaveri");
			dto.setNoOfSeats(2);
			Mockito.when(bookingServiceImpl.bookTheSeat(dto)).thenReturn(dto);
			ResponseEntity<BookingDto> booking1=bookingController.bookingtheTicket(booking);
			Assert.assertEquals(HttpStatus.CREATED,booking1.getStatusCode());
			
		}
*/
		
	}



