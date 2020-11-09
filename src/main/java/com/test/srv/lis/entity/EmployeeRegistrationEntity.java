package com.test.srv.lis.entity;

import javax.persistence.*;

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
}
