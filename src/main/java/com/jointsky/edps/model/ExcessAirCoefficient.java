package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by root on 2017/6/6.
 */
public class ExcessAirCoefficient {

    @ApiModelProperty(value = "地区名称",required = true)
    private String regionName;
    @ApiModelProperty(value = "企业名称",required = true)
    private String psName;
    @ApiModelProperty(value = "行业名称",required = true)
    private String industryName;
    @ApiModelProperty(value = "排口名称",required = true)
    private String outputName;
    @ApiModelProperty(value = "实测氧含量平均值",required = true)
    private Double facO2Avg;
    @ApiModelProperty(value = "标准基准氧含量",required = true)
    private Double standardO2;
    @ApiModelProperty(value = "实际基准氧含量平均值",required = true)
    private Double facStandardO2Avg;
    @ApiModelProperty(value = "异常说明",required = true)
    private String comment;
    @ApiModelProperty(value = "开始时间",required = true)
    private String startTime;
    @ApiModelProperty(value = "结束时间",required = true)
    private String endTime;



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

    public Double getFacO2Avg() {
        return facO2Avg;
    }

    public void setFacO2Avg(Double facO2Avg) {
        this.facO2Avg = facO2Avg;
    }

    public Double getStandardO2() {
        return standardO2;
    }

    public void setStandardO2(Double standardO2) {
        this.standardO2 = standardO2;
    }

    public Double getFacStandardO2Avg() {
        return facStandardO2Avg;
    }

    public void setFacStandardO2Avg(Double facStandardO2Avg) {
        this.facStandardO2Avg = facStandardO2Avg;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
}
