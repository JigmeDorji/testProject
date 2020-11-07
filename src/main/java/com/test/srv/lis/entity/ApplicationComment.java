package com.test.srv.lis.entity;

import com.test.srv.helper.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "tbl_application_comment")
public class ApplicationComment extends BaseEntity {
    //region private variables
    @Id
    @Column(name = "commentId")
    private BigInteger commentId;

    @Column(name = "applicationNo")
    private String applicationNo;

    @Column(name = "comments")
    private String comments;

    @Column(name = "applicationStatus")
    private Character applicationStatus;

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "updatedDate")
    private Date updatedDate;
    //endregion

    //region setters and getters
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
    //endregion
}
