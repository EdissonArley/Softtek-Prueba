package com.softtek.ejb;

import com.softtek.model.Brand;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BrandFacade extends AbstractFacade<Brand> implements BrandFacadeLocal {

    @PersistenceContext(unitName = "softtekPersistence")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BrandFacade() {
        super(Brand.class);
    }

}
