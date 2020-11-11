package com.test.srv.lis.entity;

import javax.persistence.*;

/**
 * Created by jigme.dorji on 11/8/2020.
 */
@Entity
@Table(name = "tbl_chiwog")
public class ChiwogRegistration {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "chiwogName")
    private String chiwogName;

    @Column(name = "mobile")
    private Integer mobile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChiwogName() {
        return chiwogName;
    }

    public void setChiwogName(String chiwogName) {
        this.chiwogName = chiwogName;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }
}
