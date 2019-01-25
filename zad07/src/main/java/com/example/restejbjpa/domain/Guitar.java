package com.example.restejbjpa.domain;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "guitar.getAll", query = "Select p from Guitar p"),
        @NamedQuery(name = "guitar.deleteAll", query="Delete from Guitar "),
        @NamedQuery(name = "guitar.bySerialNumber", query = "SELECT p FROM Guitar p JOIN p.serial l WHERE l.serialNumber = :serialNumber"),
})
public class Guitar {
	
	private long id;
	private double price;
	
	private Serial serial;
	private List<Owner> owners = new ArrayList<>();
	
	@JsonBackReference
    private Producer producer;
	
	public Guitar() {
		super();
	}
	
	public Guitar(double price) {
		super();
		this.setPrice(price);
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
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Serial getSerial() {
		return serial;
	}
	
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
