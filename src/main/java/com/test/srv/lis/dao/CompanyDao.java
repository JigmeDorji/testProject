package com.test.srv.lis.dao;

import com.test.srv.lis.dto.CompanyDTO;
import com.test.srv.lis.entity.Company;
import com.test.srv.lis.entity.Company_a;
import com.test.srv.helper.BaseDao;
import com.test.srv.helper.DropdownDTO;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by nzepa on 10/11/2020.
 */
@Repository
public class CompanyDao extends BaseDao {

    @Transactional(readOnly = true)
    public List<DropdownDTO> getPortfolioList() {
        String sqlQuery = properties.getProperty("CompanyDao.getPortfolioList");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getCompanyTypeList() {
        String sqlQuery = properties.getProperty("CompanyDao.getCompanyTypeList");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<CompanyDTO> getCompanyList() {
        String sqlQuery = properties.getProperty("CompanyDao.getCompanyList");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery, CompanyDTO.class);
        return hQuery.list();
    }

    @Transactional(readOnly = true)
    public CompanyDTO getCompanyDetail(Integer companyId) {
        String query = properties.getProperty("CompanyDao.getCompanyDetail");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(query, CompanyDTO.class);
        hQuery.setParameter("companyId", companyId);
        return (CompanyDTO) hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public Character getParentCompany() {
        String sqlQuery = properties.getProperty("CompanyDao.getParentCompany");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery);
        return (Character) hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public Character getParentCompanyByCompanyId(Integer companyId) {
        String sqlQuery = properties.getProperty("CompanyDao.getParentCompanyByCompanyId");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery).setParameter("companyId", companyId);
        return (Character) hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public Integer getLastCompanyId() {
        String sqlQuery = properties.getProperty("CompanyDao.getLastCompanyId");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery);
        return (Integer) hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public BigInteger getLastCompanyAuditId() {
        String sqlQuery = properties.getProperty("CompanyDao.getLastCompanyAuditId");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery);
        return (BigInteger) hQuery.uniqueResult();
    }

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void addCompany(Company company, Company_a company_a) {
        em.merge(company);
        em.merge(company_a);
    }
}
