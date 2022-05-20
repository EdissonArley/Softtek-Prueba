package com.softtek.ejb;

import com.softtek.model.Person;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonFacade extends AbstractFacade<Person> implements PersonFacadeLocal {

    @PersistenceContext(unitName = "softtekPersistence")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonFacade() {
        super(Person.class);
    }
    
}
