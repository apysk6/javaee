package com.example.servletjspdemo.domain;

import java.text.ParseException;
import java.util.Date;

public class Guitar {
	
	private long id;
	private String producer;
	private Date makeDate;
	private double price;
	private boolean isReserved;
	
	public Guitar() {
		super();
	}
	
	public Guitar(long id, String producer, Date makeDate, double price, boolean isReserved) {
		super();
		this.id = id;
		this.producer = producer;
		this.makeDate = makeDate;
		this.price = price;
		this.isReserved = isReserved;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getProducer() {
		return producer;
	}
	
	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	public Date getMakeDate() {
		return makeDate;
	}
	
	public void setMakeDate(Date makeDate) throws ParseException {
		this.makeDate = makeDate;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean getIsReserved() {
		return isReserved;
	}
	
	public void setIsReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
}