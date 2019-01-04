package com.example.restejbjpa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Owner;

@Stateless
public class OwnerManager {

	@PersistenceContext(unitName= "demoPU")
    private EntityManager em;

    public void addOwner(Owner owner) {
        em.persist(owner);
    }

    public Owner getOwner(int id){
        return em.find(Owner.class, id);
    }

    public Owner updateOwner(Owner newOwner) {
        return em.merge(newOwner);
    }

    public void deleteAllOwners(){
        em.createNamedQuery("owner.deleteAll").executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Owner> getAllOwners(){
        return em.createNamedQuery("owner.getAll").getResultList();
    }
}
