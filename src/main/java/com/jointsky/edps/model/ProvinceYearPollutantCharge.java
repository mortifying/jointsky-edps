package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by LiuZifan on 2017/6/9.
 */
public class ProvinceYearPollutantCharge {

    @ApiModelProperty(value = "省份名称",required = true)
    private String regionName;
    @ApiModelProperty(value = "年份",required = true)
    private int year;
    @ApiModelProperty(value = "污染物名称，可取的值：[ 氮氧化物, 烟尘, 二氧化硫, 一般性粉尘, 化学需氧量(COD), 氨氮, 悬浮物(SS), 石油类, 废气排放量, 污水排放量 ] ",required = true)
    private String pollutantName;
    @ApiModelProperty(value = "费用",required = true)
    private String charge;

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

    public String getPollutantName() {
        return pollutantName;
    }

    public void setPollutantName(String pollutantName) {
        this.pollutantName = pollutantName;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }
}
