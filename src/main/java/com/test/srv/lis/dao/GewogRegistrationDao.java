package com.test.srv.lis.dao;

import com.test.srv.helper.BaseDao;
import com.test.srv.lis.entity.GewogRegistration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GewogRegistrationDao extends BaseDao {

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void save(GewogRegistration gewogRegistration) {
        em.persist(gewogRegistration);
    }
}
