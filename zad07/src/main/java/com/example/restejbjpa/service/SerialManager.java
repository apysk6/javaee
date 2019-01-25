package com.example.restejbjpa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Serial;

@Stateless
public class SerialManager {

	@PersistenceContext
	EntityManager em;
	
	public void addSerial(Serial serial) {
		em.persist(serial);
	}
	
	public Serial getSerial(long id) {
		return em.find(Serial.class, id);
	}
	
	public Serial updateSerial(Serial newSerial) {
		return em.merge(newSerial);
	}
	
	public void deleteSerial(long id) {
		em.remove(em.find(Serial.class, id));
	}
	
	public void deleteAllSerials() {
		em.createNamedQuery("serial.deleteAll").executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<Serial> getAllSerials() {
		return em.createNamedQuery("serial.getAll").getResultList();
	}
}
