package com.example.restejbjpa.domain;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "guitar.getAll", query = "Select p from Guitar p"),
        @NamedQuery(name = "guitar.deleteAll", query="Delete from Guitar ")
})
public class Guitar {
	
	private long id;
	private String producer;
	private double price;
	
	private List<Owner> owners = new ArrayList<>();
	
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToMany(mappedBy = "guitars", fetch = FetchType.EAGER)
	public List<Owner> getOwners() {
		return owners;
	}

	public void setOwners(List<Owner> owners) {
		this.owners = owners;
	}
}
