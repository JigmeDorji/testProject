package com.test.srv.helper;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by nzepa on 9/14/2020.
 */
public class BaseService {

    //region connection manager
    protected EntityManager em;

    @PersistenceContext(unitName = "default")
    public void setEm(EntityManager em) {
        this.em = em;
    }

    protected Session getCurrentSession() {
        return em.unwrap(Session.class);
    }
    //endregion
}
