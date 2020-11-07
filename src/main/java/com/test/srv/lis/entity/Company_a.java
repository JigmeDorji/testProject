package com.test.srv.lis.entity;

import com.test.srv.helper.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by nzepa on 10/13/2020.
 */

@Entity
@Table(name = "tbl_company_a")
public class Company_a extends BaseEntity {
    //region private variables
    @Id
    @Column(name = "companyAuditId")
    private BigInteger companyAuditId;

    @Column(name = "cmdFlag")
    private Character cmdFlag;

    @Column(name = "companyId")
    private Integer companyId;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "logo")
    private byte[] logo;

    @Column(name = "logoName")
    private String logoName;

    @Column(name = "logoExtension")
    private String logoExtension;

    @Column(name = "isParent")
    private Character isParent;

    @Column(name = "shortForm")
    private String shortForm;

    @Column(name = "description")
    private String description;

    @Column(name = "companyTypeId")
    private Integer companyTypeId;

    @Column(name = "portfolioId")
    private Integer portfolioId;

    @Column(name = "shareAmount")
    private BigDecimal shareAmount;

    @Column(name = "status")
    private Character status;

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "updatedDate")
    private Date updatedDate;
    //endregion

    //region setters and getters
    public BigInteger getCompanyAuditId() {
        return companyAuditId;
    }

    public void setCompanyAuditId(BigInteger companyAuditId) {
        this.companyAuditId = companyAuditId;
    }

    public Character getCmdFlag() {
        return cmdFlag;
    }

    public void setCmdFlag(Character cmdFlag) {
        this.cmdFlag = cmdFlag;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getLogoName() {
        return logoName;
    }

    public void setLogoName(String logoName) {
        this.logoName = logoName;
    }

    public String getLogoExtension() {
        return logoExtension;
    }

    public void setLogoExtension(String logoExtension) {
        this.logoExtension = logoExtension;
    }

    public Character getIsParent() {
        return isParent;
    }

    public void setIsParent(Character isParent) {
        this.isParent = isParent;
    }

    public String getShortForm() {
        return shortForm;
    }

    public void setShortForm(String shortForm) {
        this.shortForm = shortForm;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCompanyTypeId() {
        return companyTypeId;
    }

    public void setCompanyTypeId(Integer companyTypeId) {
        this.companyTypeId = companyTypeId;
    }

    public Integer getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Integer portfolioId) {
        this.portfolioId = portfolioId;
    }

    public BigDecimal getShareAmount() {
        return shareAmount;
    }

    public void setShareAmount(BigDecimal shareAmount) {
        this.shareAmount = shareAmount;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
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
