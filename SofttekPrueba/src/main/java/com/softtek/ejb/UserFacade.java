package com.softtek.ejb;

import com.softtek.model.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "softtekPersistence")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    @Override
    public User signIn(User us) {
        User user = null;
        String nameQuery;
        try {
            nameQuery = "FROM User u WHERE u.userName = ?1 and u.password = ?2";
            List<User> list
                    = (List<User>) em.createQuery(nameQuery)
                            .setParameter(1, us.getUserName())
                            .setParameter(2, us.getPassword())
                            .getResultList();
            if (!list.isEmpty()) {
                user = list.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return user;
    }
}
