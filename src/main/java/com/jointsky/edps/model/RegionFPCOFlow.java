package com.jointsky.edps.model;


import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

/**
 * Created by root on 2017/5/19.
 */
public class RegionFPCOFlow {


    @ApiModelProperty(value = "省级行政区编码")
    private String regionCode;
    @ApiModelProperty(value = "省级行政区名")
    private String regionName;
    @ApiModelProperty(value = "月份")
    private Date month;
    @ApiModelProperty(value = "火力发电量（亿千瓦时）")
    private Double firePower;
    @ApiModelProperty(value = "原油加工量（万吨）")
    private Double crudeOil;
    @ApiModelProperty(value = "烟尘排放量（千克）")
    private Double dustFlow;
    @ApiModelProperty(value = "二氧化硫排放量（千克）")
    private Double so2Flow;
    @ApiModelProperty(value = "氮氧化物排放量（千克）")
    private Double noxFlow;
    @ApiModelProperty(value = "化学需氧量排放量（千克）")
    private Double codFlow;
    @ApiModelProperty(value = "氨氮排放量（千克）")
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


    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Double getFirePower() {
        return firePower;
    }

    public void setFirePower(Double firePower) {
        this.firePower = firePower;
    }

    public Double getCrudeOil() {
        return crudeOil;
    }

    public void setCrudeOil(Double crudeOil) {
        this.crudeOil = crudeOil;
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
