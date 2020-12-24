package com.jkd.springboot.bean;

import java.text.DecimalFormat;

public class Hospital {
    private  String hospitalId;
    private  String cityId;

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            String format = new DecimalFormat("0.000").format(1 + Math.random() * (1.5 - 1));
                System.out.println(format);
        }
    }
}
