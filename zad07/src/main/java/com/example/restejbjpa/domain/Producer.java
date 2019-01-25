package com.example.restejbjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "producer.getAll", query = "Select p from Producer p"),
        @NamedQuery(name = "producer.deleteAll", query="Delete from Producer "),
        @NamedQuery(name = "producer.countGuitars", query="Select COUNT(*) from Guitar g JOIN g.producer p where p.name = :name")
})
public class Producer {
	
	private long id;
	private String name;
	private List<Guitar> guitars = new ArrayList<Guitar>();
	
	public Producer(String name) {
		this.name = name;
	}
	
	public Producer( ) {
		super();
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}  
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "producer", fetch = FetchType.EAGER)
    @JsonIgnore
	public List<Guitar> getGuitars() {
		return guitars;
	}
	
    @JsonIgnore
	public void setGuitars(List<Guitar> guitars) {
		this.guitars = guitars;
	}
}
