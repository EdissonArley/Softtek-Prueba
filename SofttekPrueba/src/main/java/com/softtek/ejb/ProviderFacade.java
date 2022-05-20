package com.softtek.ejb;

import com.softtek.model.Provider;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProviderFacade extends AbstractFacade<Provider> implements ProviderFacadeLocal {

    @PersistenceContext(unitName = "softtekPersistence")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProviderFacade() {
        super(Provider.class);
    }
    
}
