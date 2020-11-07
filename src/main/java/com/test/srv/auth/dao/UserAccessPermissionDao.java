package com.test.srv.auth.dao;

import com.test.srv.auth.dto.UserAccessPermissionListDTO;
import com.test.srv.auth.entity.UserAccessPermission;
import com.test.srv.helper.BaseDao;
import com.test.srv.helper.DropdownDTO;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by jigme.dorji Sawa on 22/04/2020.
 */
@Repository()
public class UserAccessPermissionDao extends BaseDao {


    @Transactional(readOnly = true)
    public List<DropdownDTO> getUserRoleList() {
        String sqlQuery = properties.getProperty("CommonDao.getUserRoleList");
        NativeQuery hQuery = (NativeQuery)hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<UserAccessPermissionListDTO> getScreenList(Integer userRoleTypeId) {
        String sqlQuery = properties.getProperty("CommonDao.getScreenList");
        NativeQuery hQuery = (NativeQuery)hibernateQuery(sqlQuery, UserAccessPermissionListDTO.class);
        hQuery.setParameter("userRoleTypeId", userRoleTypeId);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<UserAccessPermissionListDTO> getUnScreenList() {
        String sqlQuery = properties.getProperty("CommonDao.getUnScreenList");
        NativeQuery hQuery = (NativeQuery)hibernateQuery(sqlQuery, UserAccessPermissionListDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public Boolean isUserRoleAssigned(Integer roleTypeId) {
        String sqlQuery = properties.getProperty("CommonDao.isUserRoleAssigned");
        NativeQuery hQuery = (NativeQuery)hibernateQuery(sqlQuery);
        hQuery.setParameter("roleTypeId", roleTypeId);
        return hQuery.list().size() > 0;
    }

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void update(UserAccessPermission userAccessPermission) {
        getReportingSession().update(userAccessPermission);
    }

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void save(UserAccessPermission userAccessPermission) {
        em.merge(userAccessPermission);
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getCompanyList() {
        String sqlQuery = properties.getProperty("CommonDao.getCompanyList");
        NativeQuery hQuery = (NativeQuery)hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();

    }

    @Transactional(readOnly = true)
    public BigInteger getUserAccessPermissionIdSerial() {
        String sqlQuery = properties.getProperty("UserAccessPermissionDao.getUserAccessPermissionIdSerial");
        NativeQuery hQuery = (NativeQuery)hibernateQuery(sqlQuery);
        return (BigInteger)hQuery.uniqueResult();
    }
}
