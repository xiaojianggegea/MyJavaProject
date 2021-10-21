package com.ghj.entity;

/**
 * @program: mybatis
 * @description: 电话号码类
 * @author: 小江
 * @create: 2021-10-21 13:30
 **/

public class PhoneNumber {
    private String countryCode;
    private String stateCode;
    private String number;

    public PhoneNumber() {

    }

    public PhoneNumber(String countryCode, String stateCode, String number) {
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.number = number;
    }

    public PhoneNumber(String str) {
        if (str != null) {
            String[] args = str.split("-");
            this.countryCode = args[0];
            this.stateCode = args[1];
            this.number = args[2];
        }
    }

    public String getAsString() {
        return countryCode + "-" + stateCode + "-" + number;
    }

}
