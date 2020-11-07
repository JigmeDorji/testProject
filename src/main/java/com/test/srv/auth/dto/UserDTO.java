package com.test.srv.auth.dto;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
public class UserDTO {
    //region private variables
    private String userId;

    private String userFullName;

    private BigInteger userMobileNo;

    private String userPassword;

    private String txtConfirmPassword;

    private Character userStatus;

    private Integer userRoleTypeId;

    private Integer companyId;

    private String updatedBy;

    private Date updatedDate;

    private String createdBy;

    private Date createdDate;

    private String userRoleTypeName;

    private String companyName;

    private String emailId;

    private BigInteger userAuditId;

    private Character cmdFlag;

    private String createdByFullName;

    private String updatedByFullName;

    private String createdTime;

    private String updatedTime;

    //endregion

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

    public String getTxtConfirmPassword() {
        return txtConfirmPassword;
    }

    public void setTxtConfirmPassword(String txtConfirmPassword) {
        this.txtConfirmPassword = txtConfirmPassword;
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

    public String getUserRoleTypeName() {
        return userRoleTypeName;
    }

    public void setUserRoleTypeName(String userRoleTypeName) {
        this.userRoleTypeName = userRoleTypeName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

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

    public String getCreatedByFullName() {
        return createdByFullName;
    }

    public void setCreatedByFullName(String createdByFullName) {
        this.createdByFullName = createdByFullName;
    }

    public String getUpdatedByFullName() {
        return updatedByFullName;
    }

    public void setUpdatedByFullName(String updatedByFullName) {
        this.updatedByFullName = updatedByFullName;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    //empty constructor

//endregion
}
