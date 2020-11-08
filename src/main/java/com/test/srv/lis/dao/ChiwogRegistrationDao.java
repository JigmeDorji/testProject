package com.test.srv.lis.dao;

import com.test.srv.helper.BaseDao;
import com.test.srv.lis.entity.ChiwogRegistration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by jigme.dorji on 11/8/2020.
 */
@Repository
public class ChiwogRegistrationDao extends BaseDao {

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void save(ChiwogRegistration chiwogRegistration) {
        em.merge(chiwogRegistration);


    }
}
