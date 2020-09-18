package com.hcl.busbooking.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table
public class BusRoute {
	@Id
	private int busServiceNumber;
	private String source;
	private String destination;
	@Temporal(TemporalType.DATE)
	private Date date;
	private int toatalSeats;
	private int availableSeats;
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
	public int getToatalSeats() {
		return toatalSeats;
	}
	public void setToatalSeats(int toatalSeats) {
		this.toatalSeats = toatalSeats;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	public BusRoute() {
		super();
	}
	public BusRoute(int busServiceNumber, String source, String destination, Date date, int toatalSeats,
			int availableSeats) {
		super();
		this.busServiceNumber = busServiceNumber;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.toatalSeats = toatalSeats;
		this.availableSeats = availableSeats;
	}
	
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	@Override
	public String toString() {
		return "BusRoute [busServiceNumber=" + busServiceNumber + ", source=" + source + ", destination=" + destination
				+ ", date=" + date + ", toatalSeats=" + toatalSeats + ", availableSeats=" + availableSeats + "]";
	}
	public int getFare() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
