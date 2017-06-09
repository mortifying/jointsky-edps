package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by LiuZifan on 2017/6/9.
 */
public class ProvinceYearCharge {
    @ApiModelProperty(value = "省份名称",required = true)
    private String regionName;
    @ApiModelProperty(value = "年份",required = true)
    private int year;
    @ApiModelProperty(value = "总费用",required = true)
    private double charge;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }
}

