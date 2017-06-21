package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by root on 2017/6/21.
 */
public class PSFlowRank {

    @ApiModelProperty(value = "企业编码",required = true)
    private Long psCode;
    @ApiModelProperty(value = "企业名称",required = true)
    private String psName;
    @ApiModelProperty(value = "月份",required = true)
    private int month;
    @ApiModelProperty(value = "总排放量（千克）",required = true)
    private Double sumFlow;


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

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Double getSumFlow() {
        return sumFlow;
    }

    public void setSumFlow(Double sumFlow) {
        this.sumFlow = sumFlow;
    }
}
