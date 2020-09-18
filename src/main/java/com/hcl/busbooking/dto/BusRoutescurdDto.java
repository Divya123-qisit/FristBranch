package com.hcl.busbooking.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class BusRoutescurdDto {
	private int busServiceNumber;
	private String source;
	private String destination;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String busName;
	public int getBusServiceNumber() {
		return busServiceNumber;
	}
	public void setBusServiceNumber(int busServiceNumber) {
		this.busServiceNumber = busServiceNumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	

}
