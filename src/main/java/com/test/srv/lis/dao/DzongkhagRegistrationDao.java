package com.test.srv.lis.dao;

import com.test.srv.helper.BaseDao;
import com.test.srv.lis.entity.DzongkhagRegistration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DzongkhagRegistrationDao extends BaseDao {

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void save(DzongkhagRegistration dzongkhagRegistration) {
        em.merge(dzongkhagRegistration);  // Insert data into db table
    }
}
