package com.example.restejbjpa.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "serial.getAll", query = "Select p from Serial p"),
        @NamedQuery(name = "serial.deleteAll", query="Delete from Serial ")
})
public class Serial {
	private long id;
	private long serialNumber;
	
	public Serial(long serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public Serial() { }
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}
}
