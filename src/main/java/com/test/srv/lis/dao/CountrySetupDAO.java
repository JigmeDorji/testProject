package com.test.srv.lis.dao;

import com.test.srv.helper.BaseDao;
import com.test.srv.lis.entity.CountrySetup;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CountrySetupDAO extends BaseDao {

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void save(CountrySetup countrySetup) {
        em.merge(countrySetup);
    }
}
