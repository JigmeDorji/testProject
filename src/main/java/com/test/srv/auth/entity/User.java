
package com.test.srv.auth.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
@Entity
@Table(name = "tbl_user")
public class User implements Serializable {

    private static final long serialVersionUID = -723583058586873479L;
    //region private column fields
    @Id
    @NotNull
    @Column(name = "userId")
    private String userId;

    @NotNull
    @Column(name = "userFullName")
    private String userFullName;

    @Column(name = "userMobileNo")
    private BigInteger userMobileNo;

    @NotNull
    @Column(name = "userPassword")
    private String userPassword;

    @NotNull
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

    @NotNull
    @Column(name = "createdBy")
    private String createdBy;

    @NotNull
    @Column(name = "createdDate")
    private Date createdDate;
    //endregion


    //region public setter and getter
    public static long getSerialVersionUID() {
        return serialVersionUID;
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
