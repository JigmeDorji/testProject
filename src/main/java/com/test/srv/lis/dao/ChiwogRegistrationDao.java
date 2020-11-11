package com.test.srv.lis.dao;

import com.test.srv.auth.dto.UserDTO;
import com.test.srv.helper.BaseDao;
import com.test.srv.lis.dto.ChiwogRegistrationDTO;
import com.test.srv.lis.entity.ChiwogRegistration;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by jigme.dorji on 11/8/2020.
 */
@Repository
public class ChiwogRegistrationDao extends BaseDao {

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void save(ChiwogRegistration chiwogRegistration) {
        em.merge(chiwogRegistration);


    }
    @Transactional(readOnly = true)
    public List<ChiwogRegistrationDTO> getChiwogList() {
        String sqlQuery = properties.getProperty("ChiwogRegistrationDao.getChiwogList");
       NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery, ChiwogRegistrationDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }
    @Transactional
    public void deleteChiwogInfoByChiwogId(Integer chiwogId) {
        String sqlQuery = properties.getProperty("ChiwogRegistrationDao.deleteChiwogInfoByChiwogId");
        hibernateQuery(sqlQuery)
                .setParameter( "chiwogId", chiwogId)
                .executeUpdate();

    }
    @Transactional
    public void update(ChiwogRegistration chiwogRegistration) {
        em.merge(chiwogRegistration);
    }
}
