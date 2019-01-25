package com.example.restejbjpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import com.example.restejbjpa.domain.Guitar;
import com.example.restejbjpa.domain.Owner;
import com.example.restejbjpa.domain.Owner_;

@Stateless
public class OwnerManager {

	@PersistenceContext(unitName= "demoPU")
    private EntityManager em;

    public void addOwner(Owner owner) {
        em.persist(owner);
    }

    public Owner getOwner(long id){
        return em.find(Owner.class, id);
    }

    public Owner updateOwner(Owner newOwner) {
        return em.merge(newOwner);
    }

    public void deleteAllOwners(){
        em.createNamedQuery("owner.deleteAll").executeUpdate();
    }
    
    public List<Guitar> getGuitarsOfOwner(long id) {
    	Owner received = em.find(Owner.class, id);
    	List<Guitar> guitars = new ArrayList<>(received.getGuitars());
    	
    	return guitars;	
    }
    
    @SuppressWarnings("unchecked")
	public List<Object[]> getOwnerGuitars(String surname) {
    	return em.createNamedQuery("owner.getGuitarsOfOwner").setParameter("surname", surname).getResultList();
    }
    
    public Owner getOwnerBySurname(String surname) {
    	CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Owner> ownerCriteriaQuery = criteriaBuilder.createQuery(Owner.class);

        Root<Owner> ownerRoot = ownerCriteriaQuery.from(Owner.class);

        Predicate predicate = criteriaBuilder.equal(ownerRoot.get(Owner_.surname), surname);

        ownerCriteriaQuery.where(predicate);

        TypedQuery<Owner> ownerTypedQuery = em.createQuery(ownerCriteriaQuery);

        return ownerTypedQuery.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<Owner> getAllOwners(){
        return em.createNamedQuery("owner.getAll").getResultList();
    }
}
