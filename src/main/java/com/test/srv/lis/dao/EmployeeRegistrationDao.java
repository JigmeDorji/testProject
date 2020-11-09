package com.test.srv.lis.dao;

import com.test.srv.helper.BaseDao;
import com.test.srv.lis.entity.EmployeeRegistrationEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Repository
public class EmployeeRegistrationDao extends BaseDao{

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void save(EmployeeRegistrationEntity employeeRegistration) {
        em.merge(employeeRegistration);
    }
}
