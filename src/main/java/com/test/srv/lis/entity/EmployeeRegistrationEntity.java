package com.test.srv.lis.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_employee")
public class EmployeeRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "emp_Name")
    private String emp_Name;

    @Column(name = "emp_Designation")
    private String emp_Designation;

    @Column(name = "emp_Department")
    private String emp_Department;

    @Column(name = "emp_Contact_No")
    private String emp_Contact_No;

    @Column(name = "emp_Dob")
    private Date emp_Dob;


    @Column(name = "emp_Dzongkhag_Id")
    private Integer emp_Dzongkhag_Id;


    @Column(name = "emp_Gewog_Id")
    private Integer emp_Gewog_Id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmp_Name() {
        return emp_Name;
    }

    public void setEmp_Name(String emp_Name) {
        this.emp_Name = emp_Name;
    }

    public String getEmp_Designation() {
        return emp_Designation;
    }

    public void setEmp_Designation(String emp_Designation) {
        this.emp_Designation = emp_Designation;
    }

    public String getEmp_Department() {
        return emp_Department;
    }

    public void setEmp_Department(String emp_Department) {
        this.emp_Department = emp_Department;
    }

    public String getEmp_Contact_No() {
        return emp_Contact_No;
    }

    public void setEmp_Contact_No(String emp_Contact_No) {
        this.emp_Contact_No = emp_Contact_No;
    }

    public Date getEmp_Dob() {
        return emp_Dob;
    }

    public void setEmp_Dob(Date emp_Dob) {
        this.emp_Dob = emp_Dob;
    }

    public Integer getEmp_Dzongkhag_Id() {
        return emp_Dzongkhag_Id;
    }

    public void setEmp_Dzongkhag_Id(Integer emp_Dzongkhag_Id) {
        this.emp_Dzongkhag_Id = emp_Dzongkhag_Id;
    }

    public Integer getEmp_Gewog_Id() {
        return emp_Gewog_Id;
    }

    public void setEmp_Gewog_Id(Integer emp_Gewog_Id) {
        this.emp_Gewog_Id = emp_Gewog_Id;
    }
}
