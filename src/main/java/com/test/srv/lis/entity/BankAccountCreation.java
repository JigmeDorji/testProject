package com.test.srv.lis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_application_document")
public class BankAccountCreation {

    @Id
    @Column(name = "bankId")
    private Integer bankId;

    @Column(name = "cidNo")
    private Integer cidNo;

    @Column(name = "bankaccountName")
    private String bankaccountName;

    @Column(name = "mobileNo")
    private Integer mobileNo;

    @Column(name = "emailId")
    private String emailId;

    @Column(name = "dzongkhagId")
    private String dzongkhagId;


    public Integer getCidNo() {
        return cidNo;
    }

    public void setCidNo(Integer cidNo) {
        this.cidNo = cidNo;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getBankaccountName() {
        return bankaccountName;
    }

    public void setBankaccountName(String bankaccountName) {
        this.bankaccountName = bankaccountName;
    }

    public Integer getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Integer mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDzongkhagId() {
        return dzongkhagId;
    }

    public void setDzongkhagId(String dzongkhagId) {
        this.dzongkhagId = dzongkhagId;
    }
}
