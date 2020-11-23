
package com.test.srv.auth.dao;

import com.test.srv.auth.dto.UserDTO;
import com.test.srv.auth.entity.User;
import com.test.srv.auth.entity.User_a;
import com.test.srv.helper.BaseDao;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
@Repository()
public class UserDao extends BaseDao {

    //region public methods
    @Transactional(readOnly = true)
    public Boolean isLoginIdAlreadyExists(String userId) {
        String sqlQuery = properties.getProperty("UserDao.isLoginIdAlreadyExists");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery);
        hQuery.setParameter("userId", userId);
        return hQuery.uniqueResult().equals(BigInteger.ONE);
    }

    @Transactional(readOnly = true)
    public List<UserDTO> getUserList() {
        String sqlQuery = properties.getProperty("UserDao.getUserList");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery, UserDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public BigInteger getLastAuditId() {
        String sqlQuery = properties.getProperty("UserDao.getLastAuditId");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery);
        return (BigInteger) hQuery.uniqueResult();
    }

    public void addUser(User user, User_a user_a) {
        em.persist(user);
        em.persist(user_a);
    }

    @Transactional(readOnly = true)
    public String getOldPassword(String loginId) {
        String sqlQuery = properties.getProperty("UserDao.getOldPassword");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery);
        hQuery.setParameter("loginId", loginId);
        return (String) hQuery.uniqueResult();
    }

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void updateUserInfo(User user, User_a user_a) {
        em.merge(user);
        em.persist(user_a);
    }

    @Transactional(readOnly = true)
    public UserDTO getUserDetail(String userId) {
        String query = properties.getProperty("UserDao.getUserDetail");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(query, UserDTO.class);
        hQuery.setParameter("userId", userId);
        return (UserDTO) hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public List<UserDTO> getUserLog(String userId) {
        String sqlQuery = properties.getProperty("UserDao.getUserLog");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery, UserDTO.class)
                .setParameter("username", userId);
        return hQuery.list();
    }

    @Transactional(readOnly = true)
    public UserDTO getUserLogDetail(BigInteger userAuditId) {
        String query = properties.getProperty("UserDao.getUserLogDetail");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(query, UserDTO.class);
        hQuery.setParameter("userAuditId", userAuditId);
        return (UserDTO) hQuery.uniqueResult();
    }

    @Transactional
    public void deleteUser(String userId) {
        String sqlQuery = properties.getProperty("UserDao.deleteUser");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery);
        hQuery.setParameter("userId", userId);
        hQuery.executeUpdate();
    }

    @Transactional(readOnly = true)
    public String checkEmailOnAddNew(String email) {
        String sqlQuery = properties.getProperty("UserDao.checkEmailOnAddNew");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery);
        hQuery.setParameter("email", email);
        return (String) hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public String checkEmailOnUpdate(String username, String email) {
        String sqlQuery = properties.getProperty("UserDao.checkEmailOnUpdate");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery);
        hQuery.setParameter("username", username)
                .setParameter("email", email);
        return (String) hQuery.uniqueResult();
    }
    //endregion
}
