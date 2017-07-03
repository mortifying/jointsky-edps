package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * Created by root on 2017/6/5.
 */
public class SteepRiseFall {


    @ApiModelProperty(value = "地区名称",required = true)
    private String regionName;
    @ApiModelProperty(value = "行业名称",required = true)
    private String industryName;
    @ApiModelProperty(value = "企业编码",required = true)
    private Long psCode;
    @ApiModelProperty(value = "企业名称",required = true)
    private String psName;
    @ApiModelProperty(value = "排口编码",required = true)
    private Long outputCode;
    @ApiModelProperty(value = "排口名称",required = true)
    private String outputName;
    @ApiModelProperty(value = "污染物编码",required = true)
    private String pollutantCode;
    @ApiModelProperty(value = "污染物名称",required = true)
    private String pollutantName;
    @ApiModelProperty(value = "开始时间",required = true)
    private String startTime;
    @ApiModelProperty(value = "结束时间",required = true)
    private String endTime;
    @ApiModelProperty(value = "陡变前值",required = true)
    private Double beforeValue;
    @ApiModelProperty(value = "陡变后值",required = true)
    private Double afterValue;


    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public Long getPsCode() {
        return psCode;
    }

    public void setPsCode(Long psCode) {
        this.psCode = psCode;
    }

    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName;
    }

    public Long getOutputCode() {
        return outputCode;
    }

    public void setOutputCode(Long outputCode) {
        this.outputCode = outputCode;
    }

    public String getOutputName() {
        return outputName;
    }

    public void setOutputName(String outputName) {
        this.outputName = outputName;
    }

    public String getPollutantCode() {
        return pollutantCode;
    }

    public void setPollutantCode(String pollutantCode) {
        this.pollutantCode = pollutantCode;
    }

    public String getPollutantName() {
        return pollutantName;
    }

    public void setPollutantName(String pollutantName) {
        this.pollutantName = pollutantName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Double getBeforeValue() {
        return beforeValue;
    }

    public void setBeforeValue(Double beforeValue) {
        this.beforeValue = beforeValue;
    }

    public Double getAfterValue() {
        return afterValue;
    }

    public void setAfterValue(Double afterValue) {
        this.afterValue = afterValue;
    }
}
