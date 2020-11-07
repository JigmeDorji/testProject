package com.test.srv.enumeration;

/**
 * Created by Bcass Sawa on 4/3/2020.
 */
public enum ParentMenuEnum {

    COMMON_CONTROL(101);

    private final Integer value;

    ParentMenuEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
