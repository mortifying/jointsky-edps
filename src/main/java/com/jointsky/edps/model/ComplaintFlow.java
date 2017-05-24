package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;
/**
 * Created by LiuZifan on 2017/5/22.
 */
public class ComplaintFlow {
    @ApiModelProperty(value = "  省份名称")
    private String regionName;
    @ApiModelProperty(value = "  日期(年月)")
    private Date month;
    @ApiModelProperty(value = "  被举报/投诉次数")
    private int count;
    @ApiModelProperty(value = "  烟尘平均浓度(毫克/立方米)")
    private double dustStrength;
    @ApiModelProperty(value = "  烟尘总排放量(千克)")
    private double dustFlow;
    @ApiModelProperty(value = "  二氧化硫平均浓度(毫克/立方米)")
    private double so2Strength;
    @ApiModelProperty(value = "  二氧化硫总排放量(千克)")
    private double so2Flow;
    @ApiModelProperty(value = "  二氧化硫平均浓度(毫克/立方米)")
    private double noxStrength;
    @ApiModelProperty(value = "  氮氧化物总排放量(千克)")
    private double noxFlow;
    @ApiModelProperty(value = "  化学需氧量平均浓度(毫克/立方米)")
    private double codStrength;
    @ApiModelProperty(value = "  化学需氧量总排放量(千克)")
    private double codFlow;
    @ApiModelProperty(value = "  氨氮平均浓度(毫克/立方米)")
    private double nh4Strength;
    @ApiModelProperty(value = "  氨氮总排放量(千克)")
    private double nh4Flow;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getDustStrength() {
        return dustStrength;
    }

    public void setDustStrength(double dustStrength) {
        this.dustStrength = dustStrength;
    }

    public double getDustFlow() {
        return dustFlow;
    }

    public void setDustFlow(double dustFlow) {
        this.dustFlow = dustFlow;
    }

    public double getSo2Strength() {
        return so2Strength;
    }

    public void setSo2Strength(double so2Strength) {
        this.so2Strength = so2Strength;
    }

    public double getSo2Flow() {
        return so2Flow;
    }

    public void setSo2Flow(double so2Flow) {
        this.so2Flow = so2Flow;
    }

    public double getNoxStrength() {
        return noxStrength;
    }

    public void setNoxStrength(double noxStrength) {
        this.noxStrength = noxStrength;
    }

    public double getNoxFlow() {
        return noxFlow;
    }

    public void setNoxFlow(double noxFlow) {
        this.noxFlow = noxFlow;
    }

    public double getCodStrength() {
        return codStrength;
    }

    public void setCodStrength(double codStrength) {
        this.codStrength = codStrength;
    }

    public double getCodFlow() {
        return codFlow;
    }

    public void setCodFlow(double codFlow) {
        this.codFlow = codFlow;
    }

    public double getNh4Strength() {
        return nh4Strength;
    }

    public void setNh4Strength(double nh4Strength) {
        this.nh4Strength = nh4Strength;
    }

    public double getNh4Flow() {
        return nh4Flow;
    }

    public void setNh4Flow(double nh4Flow) {
        this.nh4Flow = nh4Flow;
    }
}
