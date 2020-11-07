package com.test.srv.auth.entity;

import com.test.srv.helper.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by nzepa on 10/7/2020.
 */
@Entity
@Table(name = "tbl_user_a")
public class User_a extends BaseEntity implements Serializable {
    //region private column fields
    @Id
    @Column(name = "userAuditId")
    private BigInteger userAuditId;

    @Column(name = "cmdFlag")
    private Character cmdFlag;

    @Column(name = "userId")
    private String userId;

    @Column(name = "userFullName")
    private String userFullName;

    @Column(name = "userMobileNo")
    private BigInteger userMobileNo;

    @Column(name = "userPassword")
    private String userPassword;

    @Column(name = "userStatus")
    private Character userStatus;

    @Column(name = "userRoleTypeId")
    private Integer userRoleTypeId;

    @Column(name = "companyId")
    private Integer companyId;

    @Column(name = "emailId")
    private String emailId;

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "updatedDate")
    private Date updatedDate;

    //endregion

    //region setters and getters
    public BigInteger getUserAuditId() {
        return userAuditId;
    }

    public void setUserAuditId(BigInteger userAuditId) {
        this.userAuditId = userAuditId;
    }

    public Character getCmdFlag() {
        return cmdFlag;
    }

    public void setCmdFlag(Character cmdFlag) {
        this.cmdFlag = cmdFlag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public BigInteger getUserMobileNo() {
        return userMobileNo;
    }

    public void setUserMobileNo(BigInteger userMobileNo) {
        this.userMobileNo = userMobileNo;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Character getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Character userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserRoleTypeId() {
        return userRoleTypeId;
    }

    public void setUserRoleTypeId(Integer userRoleTypeId) {
        this.userRoleTypeId = userRoleTypeId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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
