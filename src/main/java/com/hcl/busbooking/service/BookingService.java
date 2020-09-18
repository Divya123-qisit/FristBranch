package com.hcl.busbooking.service;

import org.json.JSONException;

import com.hcl.busbooking.dto.BookingDto;
import com.hcl.busbooking.dto.BookingsDto;
import com.hcl.busbooking.model.Booking;

public interface BookingService {
	
	public BookingDto bookTheSeat(BookingsDto bookingsDto,long userAccountNumber,long busoperatorAccountNumber)throws JSONException;

}
