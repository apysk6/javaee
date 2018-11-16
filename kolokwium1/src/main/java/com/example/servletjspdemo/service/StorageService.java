package com.example.servletjspdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.servletjspdemo.domain.Guitar;
import com.example.servletjspdemo.domain.Survey;

public class StorageService {
	
	private List<Guitar> db = new ArrayList<Guitar>();
	private List<Survey> dbSurvey = new ArrayList<Survey>();
	
	public void add(Guitar guitar){
		Guitar newGuitar = new Guitar(guitar.getId(), guitar.getProducer(), guitar.getMakeDate(), guitar.getPrice(), guitar.getIsReserved());
		db.add(newGuitar);
	}
	
	public List<Guitar> getAllGuitars(){
		return db;
	}
	
	public void addSurvey(Survey survey) {
		Survey newSurvey = new Survey(survey.getDateFrom(), survey.getDateTo(), survey.getFrequency(), survey.getComment());
		dbSurvey.add(newSurvey);
	}
}