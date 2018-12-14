package com.example.restejbjpa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Guitar;


@Stateless
public class GuitarManager {
	
	@PersistenceContext(unitName= "demoPU")
    private EntityManager em;

    public void addGuitar(Guitar guitar) {
        em.persist(guitar);
    }

    public Guitar getGuitar(int id){
        return em.find(Guitar.class, id);
    }

    public Guitar updateGuitar(Guitar transientGuitar) {
        return em.merge(transientGuitar);
    }

    public void deleteAllGuitars(){
        em.createNamedQuery("Guitar.deleteAll").executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Guitar> getAllGuitars(){
        return em.createNamedQuery("guitar.getAll").getResultList();
    }

}
