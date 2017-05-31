package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

/**
 * Created by root on 2017/5/22.
 */
public class RegionGDPFlow {

    @ApiModelProperty(value = "省级行政区编码",required = true)//dfff
    private String regionCode;
    @ApiModelProperty(value = "省级行政区",required = true)
    private String region;
    @ApiModelProperty(value = "季度",required = true)
    private Date quarter;
    @ApiModelProperty(value = "GDP（亿元）",required = true)
    private Double gdp;
    @ApiModelProperty(value = "农业总产值（亿元）",required = true)
    private Double agri;
    @ApiModelProperty(value = "林业总产值（亿元）",required = true)
    private Double forestry;
    @ApiModelProperty(value = "牧业总产值（亿元）",required = true)
    private Double animal;
    @ApiModelProperty(value = "渔业总产值（亿元）",required = true)
    private Double fishery;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getQuarter() {
        return quarter;
    }

    public void setQuarter(Date quarter) {
        this.quarter = quarter;
    }

    public Double getGdp() {
        return gdp;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
    }

    public Double getAgri() {
        return agri;
    }

    public void setAgri(Double agri) {
        this.agri = agri;
    }

    public Double getForestry() {
        return forestry;
    }

    public void setForestry(Double forestry) {
        this.forestry = forestry;
    }

    public Double getAnimal() {
        return animal;
    }

    public void setAnimal(Double animal) {
        this.animal = animal;
    }

    public Double getFishery() {
        return fishery;
    }

    public void setFishery(Double fishery) {
        this.fishery = fishery;
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
