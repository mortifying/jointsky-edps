package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by LiuZifan on 2017/6/9.
 */
public class ProvincePollutantCharge {
    @ApiModelProperty(value = "省份名称",required = true)
    private String regionName;
    @ApiModelProperty(value = "年月",required = true)
    private int dataMonth;
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

    public int getDataMonth() {
        return dataMonth;
    }

    public void setDataMonth(int dataMonth) {
        this.dataMonth = dataMonth;
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
