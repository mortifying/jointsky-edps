package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by root on 2017/6/9.
 */
public class FlowYear {

    @ApiModelProperty(value = "行政区编码",required = true)
    private Long regionCode;
    @ApiModelProperty(value = "行政区名称",required = true)
    private String regionName;
    @ApiModelProperty(value = "年份",required = true)
    private int year;
    @ApiModelProperty(value = "烟尘排放量（千克）",required = true)
    private Double dustFlow;
    @ApiModelProperty(value = "二氧化硫排放量（千克）",required = true)
    private Double so2Flow;
    @ApiModelProperty(value = "氮氧化物排放量（千克）",required = true)
    private Double noxFlow;
    @ApiModelProperty(value = "化学需氧量排放量（千克）",required = true)
    private Double codFlow;
    @ApiModelProperty(value = "氨氮排放量（千克）",required = true)
    private Double nh4Flow;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getDustFlow() {
        return dustFlow;
    }

    public void setDustFlow(Double dustFlow) {
        this.dustFlow = dustFlow;
    }

    public Double getSo2Flow() {
        return so2Flow;
    }

    public void setSo2Flow(Double so2Flow) {
        this.so2Flow = so2Flow;
    }

    public Double getNoxFlow() {
        return noxFlow;
    }

    public void setNoxFlow(Double noxFlow) {
        this.noxFlow = noxFlow;
    }

    public Double getCodFlow() {
        return codFlow;
    }

    public void setCodFlow(Double codFlow) {
        this.codFlow = codFlow;
    }

    public Double getNh4Flow() {
        return nh4Flow;
    }

    public void setNh4Flow(Double nh4Flow) {
        this.nh4Flow = nh4Flow;
    }

    public Double getTotalFlow() {
        return totalFlow;
    }

    public void setTotalFlow(Double totalFlow) {
        this.totalFlow = totalFlow;
    }
}
