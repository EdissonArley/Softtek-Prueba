package com.softtek.ejb;

import com.softtek.model.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class VehicleFacade extends AbstractFacade<Vehicle> implements VehicleFacadeLocal {

    @PersistenceContext(unitName = "softtekPersistence")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehicleFacade() {
        super(Vehicle.class);
    }

    @Override
    public List search(String filter) throws Exception {
        List<Vehicle> list = null;
        try {
            String search = "FROM Vehicle v , Person p WHERE v.personId.id = p.id AND v.plate LIKE ?1 OR p.dni LIKE ?2";
            System.out.println("asda" + em);
            Query query = em.createQuery(search);
            query.setParameter(1, "%" + filter + "%");
            query.setParameter(2, "%" + filter + "%");
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

}
