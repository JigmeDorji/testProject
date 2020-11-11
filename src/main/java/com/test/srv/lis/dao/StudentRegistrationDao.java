package com.test.srv.lis.dao;

import com.test.srv.auth.dto.UserDTO;
import com.test.srv.helper.BaseDao;
import com.test.srv.lis.dto.StudentRegDTO;
import com.test.srv.lis.entity.StudentRegistration;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description: StudentRegistrationDao
 * Date:  2020-Nov-08
 *
 * @author: Bikash Rai
 * @version: 1.0.0
 * ======================
 * Change History:
 * Version:1.0.0
 * Author:
 * Date: 2020-Nov-08
 * Change Description:
 * Search Tag:
 */
@Repository
public class StudentRegistrationDao extends BaseDao {

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void save(StudentRegistration studentRegistration) {
        em.persist(studentRegistration);
    }

    @Transactional(readOnly = true)
    public List<StudentRegDTO> getStudentList() {
        String sqlQuery = properties.getProperty("StudentRegistrationDao.getStudentList");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery, StudentRegDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional
    public void deleteStudentInfoByStudentId(Integer studentId) {
        String sqlQuery = properties.getProperty("StudentRegistrationDao.deleteStudentInfoByStudentId");
        hibernateQuery(sqlQuery)
                .setParameter("studentId", studentId)
                .executeUpdate();
    }

    @Transactional
    public void update(StudentRegistration studentRegistration) {
        em.merge(studentRegistration);
    }
}
