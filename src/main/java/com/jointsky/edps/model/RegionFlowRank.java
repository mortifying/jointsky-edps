package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by root on 2017/6/21.
 */
public class RegionFlowRank {

    @ApiModelProperty(value = "行政区编码",required = true)
    private Long regionCode;
    @ApiModelProperty(value = "行政区名称",required = true)
    private String regionName;
    @ApiModelProperty(value = "月份",required = true)
    private int month;
    @ApiModelProperty(value = "总排放量（千克）",required = true)
    private Double totalFlow;

    public Long getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Long regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Double getTotalFlow() {
        return totalFlow;
    }

    public void setTotalFlow(Double totalFlow) {
        this.totalFlow = totalFlow;
    }
}
