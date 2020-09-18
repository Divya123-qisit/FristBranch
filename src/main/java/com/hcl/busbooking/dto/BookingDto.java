package com.hcl.busbooking.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class BookingDto {
	private String busName;
	private int busServiceNumber;
	private int noOfSeats;
	@Temporal(TemporalType.DATE)
	private Date journeyDate;
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public int getBusServiceNumber() {
		return busServiceNumber;
	}
	public void setBusServiceNumber(int busServiceNumber) {
		this.busServiceNumber = busServiceNumber;
	}
	
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public BookingDto(String busName, int busServiceNumber, int noOfSeats) {
		super();
		this.busName = busName;
		this.busServiceNumber = busServiceNumber;
		this.noOfSeats = noOfSeats;
	}
	public BookingDto() {
		super();
		
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	
	
	

}
