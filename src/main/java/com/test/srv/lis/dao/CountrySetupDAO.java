package com.test.srv.lis.dao;

import com.test.srv.helper.BaseDao;
import com.test.srv.lis.dto.CountrySetupDTO;
import com.test.srv.lis.entity.CountrySetup;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CountrySetupDAO extends BaseDao {

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void save(CountrySetup countrySetup) {
        em.merge(countrySetup);
    }

    @Transactional(readOnly = true)
    public List<CountrySetupDTO> getCountryName() {

        String sqlQuery = properties.getProperty("CountrySetupDAO.getCountryName");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery, CountrySetupDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();

    }

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void deleteCountryId(Integer countryId) {
        String sqlQuery = properties.getProperty("CountrySetupDAO.deleteCountryId");
        hibernateQuery(sqlQuery)
                .setParameter("countryId", countryId)
                .executeUpdate();

    }
    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void update(CountrySetup countrySetup) {
        em.merge(countrySetup);
    }
}
