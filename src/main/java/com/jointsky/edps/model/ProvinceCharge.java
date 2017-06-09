package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by LiuZifan on 2017/6/8.
 */
public class ProvinceCharge {
    @ApiModelProperty(value = "省份名称",required = true)
    private String regionName;
    @ApiModelProperty(value = "年月",required = true)
    private int dataMonth;
    @ApiModelProperty(value = "总费用",required = true)
    private double charge;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getDataMonth() {
        return dataMonth;
    }

    public void setDataMonth(int dataMonth) {
        this.dataMonth = dataMonth;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }
}
