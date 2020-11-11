package com.test.srv.lis.dao;

import com.test.srv.helper.BaseDao;
import com.test.srv.lis.entity.CountrySetup;
import com.test.srv.lis.entity.YangkhorStaff;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class YangkhorStaffDAO extends BaseDao {

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void save(YangkhorStaff yangkhorStaff) {
        em.merge(yangkhorStaff);
    }
}
