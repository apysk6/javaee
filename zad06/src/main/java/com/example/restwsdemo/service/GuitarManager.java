package com.example.restwsdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;

import com.example.restwsdemo.domain.Guitar;

@Singleton
public class GuitarManager {
	
	private List<Guitar> db = Collections.synchronizedList(new ArrayList<>());

	public void addGuitar(Guitar guitar) {
		db.add(guitar);
	}

	public void deleteGuitar(Guitar guitar){
		db.remove(guitar);
 	}
	
	public Guitar getGuitar(Integer id) {
		return db.get(id);
	}
	
	public List<Guitar> getAllGuitars(){
		return db;
	}
	
	public void deleteAllGuitars(){
		db.clear();
	}

}
