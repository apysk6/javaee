package com.example.restejbjpa.util;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.example.restejbjpa.domain.Guitar;

@XmlRootElement
public class GuitarResponse {
	
	private List<Guitar> guitar;

	public List<Guitar> getGuitar() {
		return guitar;
	}

	public void setGuitar(List<Guitar> guitar) {
		this.guitar = guitar;
	}

}
