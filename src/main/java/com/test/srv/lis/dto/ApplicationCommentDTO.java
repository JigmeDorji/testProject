package com.test.srv.lis.dto;

//import org.exolab.castor.types.DateTime;
import org.joda.time.DateTime;
import java.math.BigInteger;
import java.util.Date;

public class ApplicationCommentDTO {
    //region private variables
    private BigInteger commentId;
    private String applicationNo;
    private String comments;
    private Character applicationStatus;
    private String updatedBy;
    private Date updatedDate;
    private String createdBy;
    private Date createdDate;
    private String commentedBy;
    private String commentedDate;
    private String commentedByShortForm;
    //endregion

    //region setters and getters

    public String getCommentedByShortForm() {
        return commentedByShortForm;
    }

    public void setCommentedByShortForm(String commentedByShortForm) {
        this.commentedByShortForm = commentedByShortForm;
    }

    public String getCommentedBy() {
        return commentedBy;
    }

    public void setCommentedBy(String commentedBy) {
        this.commentedBy = commentedBy;
    }

    public String getCommentedDate() {
        return commentedDate;
    }

    public void setCommentedDate(String commentedDate) {
        this.commentedDate = commentedDate;
    }

    public BigInteger getCommentId() {
        return commentId;
    }

    public void setCommentId(BigInteger commentId) {
        this.commentId = commentId;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Character getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(Character applicationStatus) {
        this.applicationStatus = applicationStatus;
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
