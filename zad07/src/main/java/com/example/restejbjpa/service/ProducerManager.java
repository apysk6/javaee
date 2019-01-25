package com.example.restejbjpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Guitar;
import com.example.restejbjpa.domain.Owner;
import com.example.restejbjpa.domain.Producer;
import com.example.restejbjpa.domain.Serial;

@Stateless
public class ProducerManager {

	@PersistenceContext
	EntityManager em;
	
	public void addProducer(Producer producer) {
		em.persist(producer);
	}
	
	public Producer getProducer(long id) {
		return em.find(Producer.class, id);
	}
	
	public Producer updateProducer(Producer newProducer) {
		return em.merge(newProducer);
	}
	
	public Object getCountByProducer(String producerName) {
		return em.createNamedQuery("producer.countGuitars").setParameter("name", producerName).getResultList().get(0);
	}
	
	public void deleteProducer(long id) {
		em.remove(em.find(Producer.class, id));
	}
	
	public void deleteAllProducers() {
		em.createNamedQuery("producer.deleteAll").executeUpdate();
	}
	
    public List<Guitar> getGuitarsOfProducer(long id) {
    	Producer received = em.find(Producer.class, id);
    	List<Guitar> guitars = new ArrayList<>(received.getGuitars());
    	
    	return guitars;	
    }
	
	@SuppressWarnings("unchecked")
	public List<Producer> getAllProducers() {
		return em.createNamedQuery("producer.getAll").getResultList();
	}
}