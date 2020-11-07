package com.test.srv.lis.entity;

import com.test.srv.helper.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by nzepa on 10/13/2020.
 */
@Entity
@Table(name = "tbl_application_document")
public class ApplicationDocument extends BaseEntity {
    //region private variables
    @Id
    @Column(name = "documentId")
    private BigInteger documentId;

    @Column(name = "applicationNo")
    private String applicationNo;

    @Column(name = "documentName")
    private String documentName;

    @Column(name = "documentUrl")
    private String documentUrl;

    @Column(name = "documentStage")
    private Character documentStage;

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "updatedDate")
    private Date updatedDate;
    //endregion

    //region setters and getters

    public BigInteger getDocumentId() {
        return documentId;
    }

    public void setDocumentId(BigInteger documentId) {
        this.documentId = documentId;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    public Character getDocumentStage() {
        return documentStage;
    }

    public void setDocumentStage(Character documentStage) {
        this.documentStage = documentStage;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    //endregion
}
