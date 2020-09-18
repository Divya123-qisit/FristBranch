package com.hcl.busbooking.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private long mobileNumber;
	private int noOfSeats;
	@Temporal(TemporalType.DATE)
	private Date journeyDate;
	private int ammount;
	public int getAmmount() {
		return ammount;
	}
	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="busServiceNumber")
	@JsonIgnore
	private BusRoute busroute;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="userId")
	private User user;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public BusRoute getBusroute() {
		return busroute;
	}
	public void setBusroute(BusRoute busroute) {
		this.busroute = busroute;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Booking(long mobileNumber, int noOfSeats, Date journeyDate, BusRoute busroute, User user) {
		super();
		this.mobileNumber = mobileNumber;
		this.noOfSeats = noOfSeats;
		this.journeyDate = journeyDate;
		this.busroute = busroute;
		this.user = user;
	}
	public Booking() {
		super();
	}
	
}
