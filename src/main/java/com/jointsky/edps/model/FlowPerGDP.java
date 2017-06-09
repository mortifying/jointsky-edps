package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by root on 2017/6/9.
 */
public class FlowPerGDP {


    @ApiModelProperty(value = "行政区编码",required = true)
    private Long regionCode;
    @ApiModelProperty(value = "行政区名称",required = true)
    private String regionName;
    @ApiModelProperty(value = "年份",required = true)
    private int year;
    @ApiModelProperty(value = "季度",required = true)
    private int quarter;
    @ApiModelProperty(value = "GDP（亿元）",required = true)
    private Double gdp;
    @ApiModelProperty(value = "单位GDP烟尘排放量（千克）",required = true)
    private Double dustFlowPerGDP;
    @ApiModelProperty(value = "单位GDP二氧化硫排放量（千克）",required = true)
    private Double so2FlowPerGDP;
    @ApiModelProperty(value = "单位GDP氮氧化物排放量（千克）",required = true)
    private Double noxFlowPerGDP;
    @ApiModelProperty(value = "单位GDP化学需氧量排放量（千克）",required = true)
    private Double codFlowPerGDP;
    @ApiModelProperty(value = "单位GDP氨氮排放量（千克）",required = true)
    private Double nh4FlowPerGDP;
    @ApiModelProperty(value = "单位GDP总排放量（千克）",required = true)
    private Double totalFlowPerGDP;


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

    public Double getGdp() {
        return gdp;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
    }

    public Double getDustFlowPerGDP() {
        return dustFlowPerGDP;
    }

    public void setDustFlowPerGDP(Double dustFlowPerGDP) {
        this.dustFlowPerGDP = dustFlowPerGDP;
    }

    public Double getSo2FlowPerGDP() {
        return so2FlowPerGDP;
    }

    public void setSo2FlowPerGDP(Double so2FlowPerGDP) {
        this.so2FlowPerGDP = so2FlowPerGDP;
    }

    public Double getNoxFlowPerGDP() {
        return noxFlowPerGDP;
    }

    public void setNoxFlowPerGDP(Double noxFlowPerGDP) {
        this.noxFlowPerGDP = noxFlowPerGDP;
    }

    public Double getCodFlowPerGDP() {
        return codFlowPerGDP;
    }

    public void setCodFlowPerGDP(Double codFlowPerGDP) {
        this.codFlowPerGDP = codFlowPerGDP;
    }

    public Double getNh4FlowPerGDP() {
        return nh4FlowPerGDP;
    }

    public void setNh4FlowPerGDP(Double nh4FlowPerGDP) {
        this.nh4FlowPerGDP = nh4FlowPerGDP;
    }

    public Double getTotalFlowPerGDP() {
        return totalFlowPerGDP;
    }

    public void setTotalFlowPerGDP(Double totalFlowPerGDP) {
        this.totalFlowPerGDP = totalFlowPerGDP;
    }
}
