package com.jointsky.edps.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

/**
 * Created by root on 2017/5/19.
 */
public class RegionAQIFlow {

    @ApiModelProperty(value = "城市代码",required = true)
    private String regionCode;
    @ApiModelProperty(value = "城市名",required = true)
    private String regionName;
    @ApiModelProperty(value = "日期",required = true)
    private Date date;
    @ApiModelProperty(value = "环境质量等级",required = true)
    private String aqiLevel;
    @ApiModelProperty(value = "环境质量指数",required = true)
    private String aqi;
    @ApiModelProperty(value = "AQI当天排名",required = true)
    private String aqiOrder;
    @ApiModelProperty(value = "PM2.5指数",required = true)
    private String pm25;
    @ApiModelProperty(value = "PM10指数",required = true)
    private String pm10;
    @ApiModelProperty(value = "二氧化硫指数",required = true)
    private String so2;
    @ApiModelProperty(value = "二氧化氮指数",required = true)
    private String no2;
    @ApiModelProperty(value = "一氧化碳指数",required = true)
    private String co;
    @ApiModelProperty(value = "臭氧指数",required = true)
    private String o3;
    @ApiModelProperty(value = "烟尘排放量（千克）",required = true)
    private Double dustFlow;
    @ApiModelProperty(value = "二氧化硫排放量（千克）",required = true)
    private Double so2Flow;
    @ApiModelProperty(value = "氮氧化物排放量（千克）",required = true)
    private Double noxFlow;

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAqiLevel() {
        return aqiLevel;
    }

    public void setAqiLevel(String aqiLevel) {
        this.aqiLevel = aqiLevel;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getAqiOrder() {
        return aqiOrder;
    }

    public void setAqiOrder(String aqiOrder) {
        this.aqiOrder = aqiOrder;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getSo2() {
        return so2;
    }

    public void setSo2(String so2) {
        this.so2 = so2;
    }

    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getO3() {
        return o3;
    }

    public void setO3(String o3) {
        this.o3 = o3;
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
}
