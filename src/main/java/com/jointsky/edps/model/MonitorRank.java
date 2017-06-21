package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by root on 2017/6/21.
 */
public class MonitorRank {

    @ApiModelProperty(value = "生产设备厂商",required = true)
    private String manufacture;
    @ApiModelProperty(value = "年份",required = true)
    private int year;
    @ApiModelProperty(value = "季度",required = true)
    private int quarter;
    @ApiModelProperty(value = "设备可靠性得分",required = true)
    private Double totalScore;


    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }
}
