package com.example.restwsdemo.domain;

import java.text.ParseException;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Guitar {
	
	private String producer;
	private double price;
	
	public Guitar() {
		super();
	}
	
	public Guitar(String producer, double price) {
		super();
		this.producer = producer;
		this.setPrice(price);
	}
	
	public String getProducer() {
		return producer;
	}
	
	public void setProducer(String producer) {
		this.producer = producer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
