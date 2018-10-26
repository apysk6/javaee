package com.example.servletjspdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.servletjspdemo.domain.Guitar;

public class StorageService {
	
	private List<Guitar> db = new ArrayList<Guitar>();
	private List<Guitar> cart = new ArrayList<Guitar>();
	
	public void add(Guitar guitar){
		Guitar newGuitar = new Guitar(guitar.getId(), guitar.getProducer(), guitar.getMakeDate(), guitar.getPrice(), guitar.getIsReserved());
		db.add(newGuitar);
	}
	
	public void addToCart(Guitar guitar){
		Guitar newGuitar = new Guitar(guitar.getId(), guitar.getProducer(), guitar.getMakeDate(), guitar.getPrice(), guitar.getIsReserved());
		cart.add(newGuitar);
	}
	
	public List<Guitar> getAllGuitars(){
		return db;
	}
	
	public List<Guitar> getAllCart() {
		return cart;
	}
}