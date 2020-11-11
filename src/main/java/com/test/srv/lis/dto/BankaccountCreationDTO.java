package com.test.srv.lis.dto;


public class BankaccountCreationDTO {
    private String bankaccountName;
    private Integer cidNo;
    private Integer mobileNo;
    private String emailId;
    private String dzongkhagId;

    public String getBankaccountName() {
        return bankaccountName;
    }

    public void setBankaccountName(String bankaccountName) {
        this.bankaccountName = bankaccountName;
    }

    public Integer getCidNo() {
        return cidNo;
    }

    public void setCidNo(Integer cidNo) {
        this.cidNo = cidNo;
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
