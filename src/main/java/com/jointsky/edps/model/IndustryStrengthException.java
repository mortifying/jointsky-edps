package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Time;

/**
 * Created by root on 2017/6/5.
 */
public class IndustryStrengthException {

    @ApiModelProperty(value = "地区名称",required = true)
    private String regionName;
    @ApiModelProperty(value = "企业名称",required = true)
    private String psName;
    @ApiModelProperty(value = "行业名称",required = true)
    private String industryName;
    @ApiModelProperty(value = "排口名称",required = true)
    private String outputName;
    @ApiModelProperty(value = "污染物名称",required = true)
    private String pollutantName;
    @ApiModelProperty(value = "标准值",required = true)
    private Double standardValue;
    @ApiModelProperty(value = "异常时间",required = true)
    private String exceptionTime;
    @ApiModelProperty(value = "浓度",required = true)
    private Double strength;
    @ApiModelProperty(value = "平均浓度",required = true)
    private Double avgStrength;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getOutputName() {
        return outputName;
    }

    public void setOutputName(String outputName) {
        this.outputName = outputName;
    }

    public String getPollutantName() {
        return pollutantName;
    }

    public void setPollutantName(String pollutantName) {
        this.pollutantName = pollutantName;
    }

    public Double getStandardValue() {
        return standardValue;
    }

    public void setStandardValue(Double standardValue) {
        this.standardValue = standardValue;
    }

    public String getExceptionTime() {
        return exceptionTime;
    }

    public void setExceptionTime(String exceptionTime) {
        this.exceptionTime = exceptionTime;
    }

    public Double getStrength() {
        return strength;
    }

    public void setStrength(Double strength) {
        this.strength = strength;
    }

    public Double getAvgStrength() {
        return avgStrength;
    }

    public void setAvgStrength(Double avgStrength) {
        this.avgStrength = avgStrength;
    }
}
