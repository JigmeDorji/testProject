package com.test.srv.lis.dao;


import com.test.srv.helper.BaseDao;
import com.test.srv.lis.dto.CustomerSetupDTO;
import com.test.srv.lis.entity.CustomerSetup;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerSetupDao extends BaseDao {
    @Transactional(readOnly = true)
    public List<CustomerSetupDTO> getCustomerSetup() {
        String sqlQuery = "SELECT id,customerName,contactNo FROM customer_setup";
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery, CustomerSetupDTO.class);
        return hQuery.list();
    }

    @Transactional
    public void saveCustomerSetup(CustomerSetup customerSetup)
    {
        em.merge(customerSetup);
    }

    @Transactional
    public void delete(Integer id) {
        String sqlQuery = "DELETE FROM customer_setup WHERE id=:id";
        hibernateQuery(sqlQuery)
                .setParameter("id", id)
                .executeUpdate();

    }

    @Transactional
    public void update(CustomerSetup customerSetup)
    {
        em.merge(customerSetup);
    }
}
