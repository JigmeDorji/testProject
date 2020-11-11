package com.test.srv.lis.dto;

public class CountrySetupDTO {
    private Integer id;
    private String countryName;
    private Integer sumtotal;



    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
