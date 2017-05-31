package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

/**
 * Created by root on 2017/5/23.
 */
public class EnergyYieldFlow {

    @ApiModelProperty(value = "  日期(年月)",required = true)
    private Date date;
    @ApiModelProperty(value = "  原煤产量（万吨）",required = true)
    private Double ymchl;
    @ApiModelProperty(value = "  原油产量（万吨）",required = true)
    private Double yychl;
    @ApiModelProperty(value = "  天然气产量（万吨）",required = true)
    private Double trqchl;
    @ApiModelProperty(value = "  煤层气产量（万吨）",required = true)
    private Double mcqchl;
    @ApiModelProperty(value = "  液化天然气产量（万吨）",required = true)
    private Double yhtrqchl;
    @ApiModelProperty(value = "  原油加工量（万吨）",required = true)
    private Double yyjglchl;
    @ApiModelProperty(value = "  汽油产量（万吨）",required = true)
    private Double qychl;
    @ApiModelProperty(value = "  煤油产量（万吨）",required = true)
    private Double mychl;
    @ApiModelProperty(value = "  柴油产量（万吨）",required = true)
    private Double chychl;
    @ApiModelProperty(value = "  燃料油产量（万吨）",required = true)
    private Double rlychl;
    @ApiModelProperty(value = "  石脑油产量（万吨）",required = true)
    private Double shnychl;
    @ApiModelProperty(value = "  液化石油气产量（万吨）",required = true)
    private Double yhshyqchl;
    @ApiModelProperty(value = "  石焦油产量（万吨）",required = true)
    private Double shjychl;
    @ApiModelProperty(value = "  石油沥青产量（万吨）",required = true)
    private Double shylqchl;
    @ApiModelProperty(value = "  焦炭产量（万吨）",required = true)
    private Double mtchl;
    @ApiModelProperty(value = "  火力发电量（亿千瓦时）",required = true)
    private Double hlfdchl;
    @ApiModelProperty(value = "  水力发电量（亿千瓦时）",required = true)
    private Double shlfdchl;
    @ApiModelProperty(value = "  核能发电量（亿千瓦时）",required = true)
    private Double hnfdchl;
    @ApiModelProperty(value = "  风力发电量（亿千瓦时）",required = true)
    private Double flfdchl;
    @ApiModelProperty(value = "  太阳能发电量（亿千瓦时）",required = true)
    private Double tynfdchl;
    @ApiModelProperty(value = "  煤气产量（亿立方米）",required = true)
    private Double mqchl;
    @ApiModelProperty(value = "  烟尘总排放量(千克)",required = true)
    private Double dustFlow;
    @ApiModelProperty(value = "  二氧化硫总排放量(千克)",required = true)
    private Double so2Flow;
    @ApiModelProperty(value = "  氮氧化物总排放量(千克)",required = true)
    private Double noxFlow;
    @ApiModelProperty(value = "  化学需氧量总排放量(千克)",required = true)
    private Double codFlow;
    @ApiModelProperty(value = "  氨氮总排放量(千克)",required = true)
    private Double nh4Flow;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getYmchl() {
        return ymchl;
    }

    public void setYmchl(Double ymchl) {
        this.ymchl = ymchl;
    }

    public Double getYychl() {
        return yychl;
    }

    public void setYychl(Double yychl) {
        this.yychl = yychl;
    }

    public Double getTrqchl() {
        return trqchl;
    }

    public void setTrqchl(Double trqchl) {
        this.trqchl = trqchl;
    }

    public Double getMcqchl() {
        return mcqchl;
    }

    public void setMcqchl(Double mcqchl) {
        this.mcqchl = mcqchl;
    }

    public Double getYhtrqchl() {
        return yhtrqchl;
    }

    public void setYhtrqchl(Double yhtrqchl) {
        this.yhtrqchl = yhtrqchl;
    }

    public Double getYyjglchl() {
        return yyjglchl;
    }

    public void setYyjglchl(Double yyjglchl) {
        this.yyjglchl = yyjglchl;
    }

    public Double getQychl() {
        return qychl;
    }

    public void setQychl(Double qychl) {
        this.qychl = qychl;
    }

    public Double getMychl() {
        return mychl;
    }

    public void setMychl(Double mychl) {
        this.mychl = mychl;
    }

    public Double getChychl() {
        return chychl;
    }

    public void setChychl(Double chychl) {
        this.chychl = chychl;
    }

    public Double getRlychl() {
        return rlychl;
    }

    public void setRlychl(Double rlychl) {
        this.rlychl = rlychl;
    }

    public Double getShnychl() {
        return shnychl;
    }

    public void setShnychl(Double shnychl) {
        this.shnychl = shnychl;
    }

    public Double getYhshyqchl() {
        return yhshyqchl;
    }

    public void setYhshyqchl(Double yhshyqchl) {
        this.yhshyqchl = yhshyqchl;
    }

    public Double getShjychl() {
        return shjychl;
    }

    public void setShjychl(Double shjychl) {
        this.shjychl = shjychl;
    }

    public Double getShylqchl() {
        return shylqchl;
    }

    public void setShylqchl(Double shylqchl) {
        this.shylqchl = shylqchl;
    }

    public Double getMtchl() {
        return mtchl;
    }

    public void setMtchl(Double mtchl) {
        this.mtchl = mtchl;
    }

    public Double getHlfdchl() {
        return hlfdchl;
    }

    public void setHlfdchl(Double hlfdchl) {
        this.hlfdchl = hlfdchl;
    }

    public Double getShlfdchl() {
        return shlfdchl;
    }

    public void setShlfdchl(Double shlfdchl) {
        this.shlfdchl = shlfdchl;
    }

    public Double getHnfdchl() {
        return hnfdchl;
    }

    public void setHnfdchl(Double hnfdchl) {
        this.hnfdchl = hnfdchl;
    }

    public Double getFlfdchl() {
        return flfdchl;
    }

    public void setFlfdchl(Double flfdchl) {
        this.flfdchl = flfdchl;
    }

    public Double getTynfdchl() {
        return tynfdchl;
    }

    public void setTynfdchl(Double tynfdchl) {
        this.tynfdchl = tynfdchl;
    }

    public Double getMqchl() {
        return mqchl;
    }

    public void setMqchl(Double mqchl) {
        this.mqchl = mqchl;
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
