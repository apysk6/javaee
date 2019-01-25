package com.example.restejbjpa.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "owner.getAll", query = "Select p from Owner p"),
        @NamedQuery(name = "owner.deleteAll", query="Delete from Owner "),
        @NamedQuery(name = "owner.getGuitarsOfOwner", query="Select g.price, p.name, p.surname from Guitar g JOIN g.owners p where p.surname = :surname")
})
public class Owner {

    private long id;
    private String name;
    private String surname;
    private int age;

    private List<Guitar> guitars = new ArrayList<>();

    public Owner(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Owner() {
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
    
    public String getSurname() {
    	return surname;
    }
    
    public void setSurname(String surname) {
    	this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public List<Guitar> getGuitars() {
        return guitars;
    }

    @JsonIgnore
    public void setGuitars(List<Guitar> guitars) {
        this.guitars = guitars;
    }

    public void addGuitars(List<Guitar> guitars) {
        this.setGuitars(guitars);

        for (Guitar guitar: guitars){
            guitar.getOwners().add(this);
        }
    }
}