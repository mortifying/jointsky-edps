package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by root on 2017/5/23.
 */
public class EnergyConsumeFlow {

    @ApiModelProperty(value = "  省份代码",required = true)
    private String regionCode;
    @ApiModelProperty(value = "  省份名称",required = true)
    private String region;
    @ApiModelProperty(value = "  时间(年)",required = true)
    private int year;
    @ApiModelProperty(value = "  煤炭消费量（万吨）",required = true)
    private Double mtxfl;
    @ApiModelProperty(value = "  焦炭消费量（万吨）",required = true)
    private Double jtxfl;
    @ApiModelProperty(value = "  原油消费量（万吨）",required = true)
    private Double yyxfl;
    @ApiModelProperty(value = "  汽油消费量（万吨）",required = true)
    private Double qyxfl;
    @ApiModelProperty(value = "  煤油消费量（万吨）",required = true)
    private Double myxfl;
    @ApiModelProperty(value = "  柴油消费量（万吨）",required = true)
    private Double chyxfl;
    @ApiModelProperty(value = "  燃料油消费量（万吨）",required = true)
    private Double rlyxfl;
    @ApiModelProperty(value = "  天然气消费量（万吨）",required = true)
    private Double trqxfl;
    @ApiModelProperty(value = "  电力消费量（万吨）",required = true)
    private Double dlxfl;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getMtxfl() {
        return mtxfl;
    }

    public void setMtxfl(Double mtxfl) {
        this.mtxfl = mtxfl;
    }

    public Double getJtxfl() {
        return jtxfl;
    }

    public void setJtxfl(Double jtxfl) {
        this.jtxfl = jtxfl;
    }

    public Double getYyxfl() {
        return yyxfl;
    }

    public void setYyxfl(Double yyxfl) {
        this.yyxfl = yyxfl;
    }

    public Double getQyxfl() {
        return qyxfl;
    }

    public void setQyxfl(Double qyxfl) {
        this.qyxfl = qyxfl;
    }

    public Double getMyxfl() {
        return myxfl;
    }

    public void setMyxfl(Double myxfl) {
        this.myxfl = myxfl;
    }

    public Double getChyxfl() {
        return chyxfl;
    }

    public void setChyxfl(Double chyxfl) {
        this.chyxfl = chyxfl;
    }

    public Double getRlyxfl() {
        return rlyxfl;
    }

    public void setRlyxfl(Double rlyxfl) {
        this.rlyxfl = rlyxfl;
    }

    public Double getTrqxfl() {
        return trqxfl;
    }

    public void setTrqxfl(Double trqxfl) {
        this.trqxfl = trqxfl;
    }

    public Double getDlxfl() {
        return dlxfl;
    }

    public void setDlxfl(Double dlxfl) {
        this.dlxfl = dlxfl;
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
