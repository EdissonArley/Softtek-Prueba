package com.softtek.ejb;

import com.softtek.model.Status;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StatusFacade extends AbstractFacade<Status> implements StatusFacadeLocal {

    @PersistenceContext(unitName = "softtekPersistence")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StatusFacade() {
        super(Status.class);
    }
    
}
