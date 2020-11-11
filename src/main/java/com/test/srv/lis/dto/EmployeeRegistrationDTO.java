package com.test.srv.lis.dto;


import java.util.Date;

public class EmployeeRegistrationDTO {

    private Integer id;
    private String employeeName;
    private String employeeDesignation;
    private String employeeDepartment;
    private String employeeContactNumber;
    private Date employeeDateOfBirth;

    private Integer employeeDzongkhagId;
    private Integer employeeGewogId;

    private String geogName;
    private String dzongkhagName;

    public String getDzongkhagName() {
        return dzongkhagName;
    }

    public void setDzongkhagName(String dzongkhagName) {
        this.dzongkhagName = dzongkhagName;
    }

    public String getGeogName() {
        return geogName;
    }

    public void setGeogName(String geogName) {
        this.geogName = geogName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public String getEmployeeContactNumber() {
        return employeeContactNumber;
    }

    public void setEmployeeContactNumber(String employeeContactNumber) {
        this.employeeContactNumber = employeeContactNumber;
    }

    public Date getEmployeeDateOfBirth() {
        return employeeDateOfBirth;
    }

    public void setEmployeeDateOfBirth(Date employeeDateOfBirth) {
        this.employeeDateOfBirth = employeeDateOfBirth;
    }

    public Integer getEmployeeDzongkhagId() {
        return employeeDzongkhagId;
    }

    public void setEmployeeDzongkhagId(Integer employeeDzongkhagId) {
        this.employeeDzongkhagId = employeeDzongkhagId;
    }

    public Integer getEmployeeGewogId() {
        return employeeGewogId;
    }

    public void setEmployeeGewogId(Integer employeeGewogId) {
        this.employeeGewogId = employeeGewogId;
    }
}


