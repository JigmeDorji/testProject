package com.test.srv.lis.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by nzepa on 10/11/2020.
 */
public class CompanyDTO {
    //region private variables
    private Integer companyId;
    @NotNull(message = "Company name is required")
    @Size(min = 1, max = 150, message = "Company name  should be maximum of 255 characters")
    private String companyName;
    private Character isParent;
    private Boolean isParentCompany;
    private String shortForm;
    private String description;
    private Integer companyTypeId;
    private String companyTypeName;
    private Integer portfolioId;
    private String portfolioName;
    private BigDecimal shareAmount;
    private Character status;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;

    private MultipartFile logo;

    private byte[] logoByte;

    private String logoName;

    private String logoExtension;
    //endregion

    //region setters and getters

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

    public Character getIsParent() {
        return isParent;
    }

    public void setIsParent(Character isParent) {
        this.isParent = isParent;
    }

    public Boolean getIsParentCompany() {
        return isParentCompany;
    }

    public void setIsParentCompany(Boolean isParentCompany) {
        this.isParentCompany = isParentCompany;
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

    public String getCompanyTypeName() {
        return companyTypeName;
    }

    public void setCompanyTypeName(String companyTypeName) {
        this.companyTypeName = companyTypeName;
    }

    public Integer getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Integer portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
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

    public MultipartFile getLogo() {
        return logo;
    }

    public void setLogo(MultipartFile logo) {
        this.logo = logo;
    }

    public byte[] getLogoByte() {
        return logoByte;
    }

    public void setLogoByte(byte[] logoByte) {
        this.logoByte = logoByte;
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

    //endregion
}
