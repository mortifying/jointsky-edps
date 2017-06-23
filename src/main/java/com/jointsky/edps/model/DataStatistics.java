package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by root on 2017/6/23.
 */
public class DataStatistics {

    @ApiModelProperty(value = "统计时间",required = true)
    private String currentDate;
    @ApiModelProperty(value = "气日数据量",required = true)
    private Long gasDayDataCount;
    @ApiModelProperty(value = "水日数据量",required = true)
    private Long waterDayDataCount;
    @ApiModelProperty(value = "气小时数据量",required = true)
    private Long gasHourDataCount;
    @ApiModelProperty(value = "水小时数据量",required = true)
    private Long waterHourDataCount;
    @ApiModelProperty(value = "气分钟数据量",required = true)
    private Long gasMinuteDataCount;
    @ApiModelProperty(value = "水分钟数据量",required = true)
    private Long waterMinuteDataCount;
    @ApiModelProperty(value = "气重点污染源数",required = true)
    private Long gasPSCount;
    @ApiModelProperty(value = "水重点污染源数",required = true)
    private Long waterPSCount;
    @ApiModelProperty(value = "气污染排放口数",required = true)
    private Long gasOutputCount;
    @ApiModelProperty(value = "水污染排放口数",required = true)
    private Long waterOutputCount;


    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public Long getGasDayDataCount() {
        return gasDayDataCount;
    }

    public void setGasDayDataCount(Long gasDayDataCount) {
        this.gasDayDataCount = gasDayDataCount;
    }

    public Long getWaterDayDataCount() {
        return waterDayDataCount;
    }

    public void setWaterDayDataCount(Long waterDayDataCount) {
        this.waterDayDataCount = waterDayDataCount;
    }

    public Long getGasHourDataCount() {
        return gasHourDataCount;
    }

    public void setGasHourDataCount(Long gasHourDataCount) {
        this.gasHourDataCount = gasHourDataCount;
    }

    public Long getWaterHourDataCount() {
        return waterHourDataCount;
    }

    public void setWaterHourDataCount(Long waterHourDataCount) {
        this.waterHourDataCount = waterHourDataCount;
    }

    public Long getGasMinuteDataCount() {
        return gasMinuteDataCount;
    }

    public void setGasMinuteDataCount(Long gasMinuteDataCount) {
        this.gasMinuteDataCount = gasMinuteDataCount;
    }

    public Long getWaterMinuteDataCount() {
        return waterMinuteDataCount;
    }

    public void setWaterMinuteDataCount(Long waterMinuteDataCount) {
        this.waterMinuteDataCount = waterMinuteDataCount;
    }

    public Long getGasPSCount() {
        return gasPSCount;
    }

    public void setGasPSCount(Long gasPSCount) {
        this.gasPSCount = gasPSCount;
    }

    public Long getWaterPSCount() {
        return waterPSCount;
    }

    public void setWaterPSCount(Long waterPSCount) {
        this.waterPSCount = waterPSCount;
    }

    public Long getGasOutputCount() {
        return gasOutputCount;
    }

    public void setGasOutputCount(Long gasOutputCount) {
        this.gasOutputCount = gasOutputCount;
    }

    public Long getWaterOutputCount() {
        return waterOutputCount;
    }

    public void setWaterOutputCount(Long waterOutputCount) {
        this.waterOutputCount = waterOutputCount;
    }
}
