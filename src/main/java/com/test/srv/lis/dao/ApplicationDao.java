package com.test.srv.lis.dao;

import com.test.srv.helper.BaseDao;
import com.test.srv.helper.DropdownDTO;
import com.test.srv.lis.dto.ApplicationCommentDTO;
import com.test.srv.lis.dto.ApplicationDTO;
import com.test.srv.lis.dto.ApplicationDocumentDTO;
import com.test.srv.lis.entity.Application;
import com.test.srv.lis.entity.ApplicationComment;
import com.test.srv.lis.entity.ApplicationDocument;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by nzepa on 10/13/2020.
 */
@Repository
public class ApplicationDao extends BaseDao {

    @Transactional(readOnly = true)
    public List<DropdownDTO> getCompanyList() {
        String sqlQuery = properties.getProperty("ApplicationDao.getCompanyList");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void submitApplication(Application application) {
        em.merge(application);
    }

    @Transactional(readOnly = true)
    public BigInteger getLastApplicationDocumentId() {
        String sqlQuery = properties.getProperty("ApplicationDao.getLastApplicationDocumentId");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery);
        return (BigInteger) hQuery.uniqueResult();
    }

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void saveApplicationDocument(ApplicationDocument applicationDocument) {
        em.persist(applicationDocument);
    }

    @Transactional(readOnly = true)
    public List<ApplicationDTO> getApplicationList() {
        String sqlQuery = properties.getProperty("ApplicationDao.getApplicationList");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery, ApplicationDTO.class);
        return hQuery.list();
    }

    @Transactional(readOnly = true)
    public ApplicationDTO getApplicationDetail(String applicationNo) {
        String query = properties.getProperty("ApplicationDao.getApplicationDetail");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(query, ApplicationDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return (ApplicationDTO) hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public List<ApplicationDocumentDTO> getSubmittedApplicationDocuments(String applicationNo) {
        String sqlQuery = properties.getProperty("ApplicationDao.getSubmittedApplicationDocuments");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery, ApplicationDocumentDTO.class)
                .setParameter("applicationNo", applicationNo);
        return hQuery.list();
    }
    @Transactional(readOnly = true)
    public List<ApplicationCommentDTO> getApplicationComments(String applicationNo) {
        String sqlQuery = properties.getProperty("ApplicationDao.getApplicationComments");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery, ApplicationCommentDTO.class)
                .setParameter("applicationNo", applicationNo);
        return hQuery.list();
    }
    @Transactional(readOnly = true)
    public ApplicationDocumentDTO downloadSubmittedDocument(BigInteger documentId) {
        String query = properties.getProperty("ApplicationDao.downloadSubmittedDocument");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(query, ApplicationDocumentDTO.class);
        hQuery.setParameter("documentId", documentId);
        return (ApplicationDocumentDTO) hQuery.uniqueResult();
    }
    @Transactional(readOnly = true)
    public BigInteger getLastCommentId() {
        String sqlQuery = properties.getProperty("ApplicationDao.getLastCommentId");
        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery);
        return (BigInteger) hQuery.uniqueResult();
    }

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void saveComment(ApplicationComment applicationComment) {
        em.persist(applicationComment);
    }
}
