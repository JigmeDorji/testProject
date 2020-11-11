package com.test.srv.lis.dto;

/**
 * Created by jigme.dorji on 11/8/2020.
 */
public class ChiwogRegistrationDTO {
    private Integer id;
    private String chiwogName;
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
