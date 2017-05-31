package com.jointsky.edps.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by root on 2017/5/31.
 */
@ApiModel
public class MainCityGDPFlow {

    @ApiModelProperty(value = "城市编码",required = true)
    private String regionCode;
    @ApiModelProperty(value = "城市名",required = true)
    private String regionName;
    @ApiModelProperty(value = "年份",required = true,position = 1)
    private int year;
    @ApiModelProperty(value = "国内生产总值（亿元）",required = true)
    private Double gngdp;
    @ApiModelProperty(value = "第一产业生产总值（亿元）",required = true)
    private Double dycygdp;
    @ApiModelProperty(value = "第二产业生产总值（亿元）",required = true)
    private Double decygdp;
    @ApiModelProperty(value = "第三产业生产总值（亿元）",required = true)
    private Double dscygdp;
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


    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
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

    public Double getGngdp() {
        return gngdp;
    }

    public void setGngdp(Double gngdp) {
        this.gngdp = gngdp;
    }

    public Double getDycygdp() {
        return dycygdp;
    }

    public void setDycygdp(Double dycygdp) {
        this.dycygdp = dycygdp;
    }

    public Double getDecygdp() {
        return decygdp;
    }

    public void setDecygdp(Double decygdp) {
        this.decygdp = decygdp;
    }

    public Double getDscygdp() {
        return dscygdp;
    }

    public void setDscygdp(Double dscygdp) {
        this.dscygdp = dscygdp;
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
}
