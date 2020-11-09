package com.test.srv.lis.entity;

import javax.persistence.*;

/**
 * Description: StudentRegistration
 * Date:  2020-Nov-08
 *
 * @author: Bikash Rai
 * @version: 1.0.0
 * ======================
 * Change History:
 * Version:1.0.0
 * Author:
 * Date: 2020-Nov-08
 * Change Description:
 * Search Tag:
 */
@Entity
@Table(name = "tbl_student_registration")
public class StudentRegistration {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "studentName")
    private String studentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
