package com.hcl.busbooking.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;

public class BusSearchDto {
	
	private String source;
	private String destination;
	@Temporal(TemporalType.DATE)
	@Future
	private Date journeyDate;
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
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public BusSearchDto(String source, String destination, Date journeyDate) {
		super();
		this.source = source;
		this.destination = destination;
		this.journeyDate = journeyDate;
	}
	public BusSearchDto() {
		super();
	}
	
	

}
