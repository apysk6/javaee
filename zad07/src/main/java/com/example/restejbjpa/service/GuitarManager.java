package com.example.restejbjpa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Guitar;
import com.example.restejbjpa.domain.Owner;


@Stateless
public class GuitarManager {
	
	@PersistenceContext(unitName= "demoPU")
    private EntityManager em;

    public void addGuitar(Guitar guitar) {
        em.persist(guitar);
    }

    public Guitar getGuitar(long id){
        return em.find(Guitar.class, id);
    }

    public Guitar updateGuitar(Guitar transientGuitar) {
        return em.merge(transientGuitar);
    }

    public void deleteAllGuitars(){
        em.createNamedQuery("Guitar.deleteAll").executeUpdate();
    }
    
    public Guitar getGuitarBySerialNumber(long serialNumber){
        return (Guitar) em.createNamedQuery("guitar.bySerialNumber").setParameter("serialNumber", serialNumber).getSingleResult();
    }
    
    public List<Owner> getOwnersOfGuitar(long id) {
    	Guitar received = em.find(Guitar.class, id);
    	List<Owner> owners = new ArrayList<>(received.getOwners());
    	
    	return owners;	
    }

    @SuppressWarnings("unchecked")
    public List<Guitar> getAllGuitars(){
        return em.createNamedQuery("guitar.getAll").getResultList();
    }

}
