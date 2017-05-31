package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by root on 2017/5/22.
 */
public class IndustryGDPFlow {

    @ApiModelProperty(value = "年份",required = true)
    private int year;
    @ApiModelProperty(value = "国内GDP（亿元）",required = true)
    private Double gdp;
    @ApiModelProperty(value = "第一产业GDP（亿元）",required = true)
    private Double priindustry;
    @ApiModelProperty(value = "第二产业GDP（亿元）",required = true)
    private Double secindustry;
    @ApiModelProperty(value = "第三产业GDP（亿元）",required = true)
    private Double thiindustry;
    @ApiModelProperty(value = "农林牧渔业GDP（亿元）",required = true)
    private Double nlmy;
    @ApiModelProperty(value = "工业GDP（亿元）",required = true)
    private Double industry;
    @ApiModelProperty(value = "建筑业GDP（亿元）",required = true)
    private Double construction;
    @ApiModelProperty(value = "批发和零售业GDP（亿元）",required = true)
    private Double sale;
    @ApiModelProperty(value = "交通运输、仓库和邮政业GDP（亿元）",required = true)
    private Double trans;
    @ApiModelProperty(value = "住宿和餐饮业GDP（亿元）",required = true)
    private Double hotel;
    @ApiModelProperty(value = "金融业GDP（亿元）",required = true)
    private Double finance;
    @ApiModelProperty(value = "房地产业GDP（亿元）",required = true)
    private Double estate;
    @ApiModelProperty(value = "人均GDP（亿元）",required = true)
    private Double pcgdp;
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


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getGdp() {
        return gdp;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
    }

    public Double getPriindustry() {
        return priindustry;
    }

    public void setPriindustry(Double priindustry) {
        this.priindustry = priindustry;
    }

    public Double getSecindustry() {
        return secindustry;
    }

    public void setSecindustry(Double secindustry) {
        this.secindustry = secindustry;
    }

    public Double getThiindustry() {
        return thiindustry;
    }

    public void setThiindustry(Double thiindustry) {
        this.thiindustry = thiindustry;
    }

    public Double getNlmy() {
        return nlmy;
    }

    public void setNlmy(Double nlmy) {
        this.nlmy = nlmy;
    }

    public Double getIndustry() {
        return industry;
    }

    public void setIndustry(Double industry) {
        this.industry = industry;
    }

    public Double getConstruction() {
        return construction;
    }

    public void setConstruction(Double construction) {
        this.construction = construction;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public Double getTrans() {
        return trans;
    }

    public void setTrans(Double trans) {
        this.trans = trans;
    }

    public Double getHotel() {
        return hotel;
    }

    public void setHotel(Double hotel) {
        this.hotel = hotel;
    }

    public Double getFinance() {
        return finance;
    }

    public void setFinance(Double finance) {
        this.finance = finance;
    }

    public Double getEstate() {
        return estate;
    }

    public void setEstate(Double estate) {
        this.estate = estate;
    }

    public Double getPcgdp() {
        return pcgdp;
    }

    public void setPcgdp(Double pcgdp) {
        this.pcgdp = pcgdp;
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
