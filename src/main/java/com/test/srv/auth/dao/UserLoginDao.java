package com.test.srv.auth.dao;

import com.test.srv.auth.dto.UserDTO;
import com.test.srv.helper.BaseDao;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
@Repository()
public class UserLoginDao extends BaseDao {

    /**
     * to get the user information while logging in.
     *
     * @param username --- username
     * @return -- UserDTO
     */
    @Transactional(readOnly = true)
    public UserDTO login(String username) {
        String query = properties.getProperty("CommonDao.login");
        NativeQuery nativeQuery = (NativeQuery) hibernateQuery(query, UserDTO.class)
                .setParameter("username", username);
        return (UserDTO) nativeQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public Boolean isEmailIdValid(String emailId) {
        String query = properties.getProperty("CommonDao.isEmailIdValid");
        NativeQuery nativeQuery = (NativeQuery) hibernateQuery(query).setParameter("emailId", emailId);
        return !nativeQuery.uniqueResult().equals(BigInteger.ZERO);
    }

    @Transactional
    public void resetPassword(String emailId, String newPassword) {
        String query = properties.getProperty("CommonDao.resetPassword");
        NativeQuery nativeQuery = (NativeQuery) hibernateQuery(query, UserDTO.class)
                .setParameter("emailId", emailId)
                .setParameter("newPassword", newPassword);
        nativeQuery.executeUpdate();
    }

    public String getAddressName(String emailId) {
        String query = properties.getProperty("CommonDao.getAddressName");
        NativeQuery nativeQuery = (NativeQuery) hibernateQuery(query).setParameter("emailId", emailId);
        return (String) nativeQuery.uniqueResult();
    }

    public String getEmail(String username) {
        String sqlQuery = properties.getProperty("CommonDao.getEmail");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery);
        hQuery.setParameter("username", username);
        return (String) hQuery.uniqueResult();
    }

    //endregion
}
