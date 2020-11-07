package com.test.srv.enumeration;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
public enum ChildMenuEnum {

    USER_CREATION(1, "User Creation"),
    USER_ACCESS_PERMISSION_SETUP(2, "User Access Permission"),
    COMPANY_REGISTRATION(5, "Company Registration"),
    FINANCIAL_YEAR_SETUP(6, "Financial Year Setup");

    private final Integer value;
    private final String text;

    ChildMenuEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
