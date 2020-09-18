package com.hcl.busbooking.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class BookingsDto {

	private int busServiceNumber;
	private int userId;
	private int numberOfSeats;
	private Long mobileNumber;
	@Temporal(TemporalType.DATE)
	private Date journeyDate;
	 private int fare;
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public int getBusServiceNumber() {
		return busServiceNumber;
	}
	public void setBusServiceNumber(int busServiceNumber) {
		this.busServiceNumber = busServiceNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	
	
	

}
