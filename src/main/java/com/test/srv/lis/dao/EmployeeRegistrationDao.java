package com.test.srv.lis.dao;

import com.test.srv.auth.dto.UserDTO;
import com.test.srv.helper.BaseDao;
import com.test.srv.lis.dto.EmployeeRegistrationDTO;
import com.test.srv.lis.entity.EmployeeRegistrationEntity;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Repository
public class EmployeeRegistrationDao extends BaseDao{

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void save(EmployeeRegistrationEntity employeeRegistration) {
        em.persist(employeeRegistration);
    }

    @Transactional(readOnly = true)
    public List<EmployeeRegistrationDTO> getEmployeeList() {
        String query = properties.getProperty("EmployeeRegistrationDao.getEmployeeList");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(query, EmployeeRegistrationDTO.class);
        return hQuery.list().isEmpty()? null : hQuery.list();

    }

    @Transactional
    public void deleteEmployeeByEmployeeId(Integer employeeId) {
        String delSQL = properties.getProperty("EmployeeRegistrationDao.deleteEmployeeById");
        hibernateQuery(delSQL)
                .setParameter("employeeId", employeeId)
                .executeUpdate();

    }

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void update(EmployeeRegistrationEntity employeeRegistration) {
        em.merge(employeeRegistration);
    }

}
