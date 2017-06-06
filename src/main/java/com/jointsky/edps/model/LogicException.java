package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by root on 2017/6/6.
 */
public class LogicException {


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
    @ApiModelProperty(value = "异常时间",required = true)
    private String exceptionTime;
    @ApiModelProperty(value = "浓度",required = true)
    private Double strength;
    @ApiModelProperty(value = "流量",required = true)
    private Double flow;
    @ApiModelProperty(value = "排放量",required = true)
    private Double pFlow;
    @ApiModelProperty(value = "异常说明",required = true)
    private String comment;


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

    public Double getFlow() {
        return flow;
    }

    public void setFlow(Double flow) {
        this.flow = flow;
    }

    public Double getpFlow() {
        return pFlow;
    }

    public void setpFlow(Double pFlow) {
        this.pFlow = pFlow;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
