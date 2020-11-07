package com.test.srv.lis.dto;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by nzepa on 10/14/2020.
 */
public class ApplicationDocumentDTO {
    //region private variables
    private BigInteger documentId;

    private String applicationNo;

    private String documentName;

    private String documentUrl;

    private Character documentStage;

    private String updatedBy;

    private Date updatedDate;

    private String createdBy;

    private Date createdDate;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    //endregion
}
