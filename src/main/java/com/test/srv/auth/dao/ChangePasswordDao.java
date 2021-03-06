
package com.test.srv.auth.dao;

import com.test.srv.helper.BaseDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by:jigme.dorji
 * Date: 22-Apr-2020
 */
@Repository()
@SuppressWarnings({"unchecked", "rawtypes"})
public class ChangePasswordDao extends BaseDao {

    /**
     * to get the old credentials
     *
     * @param userId userId
     * @return String
     */
    @Transactional(readOnly = true)
    public String getOldCredentials(String userId) {
        String sqlQuery = properties.getProperty("CommonDao.getOldCredentials");
        org.hibernate.Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("userId", userId);
        return (String) hQuery.uniqueResult();
    }

    /**
     * update system parameter table for application ID
     *
     * @param newPassword newPassword
     * @param userId      userId
     */
    @Transactional
    public void updateUserPassword(String newPassword, String userId) {
        String sqlQuery = properties.getProperty("CommonDao.updateUserPassword");
        org.hibernate.Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("newPassword", newPassword);
        hQuery.setParameter("userId", userId);
        hQuery.executeUpdate();
    }
    //endregion
}
