package com.jointsky.edps.model;


import java.sql.Date;

/**
 * Created by root on 2017/5/19.
 */
public class RegionFPCOFlow {

    private String regionCode;
    private String regionName;
    private Date month;
    private Double firePower;
    private Double crudeOil;
    private Double dustFlow;
    private Double so2Flow;
    private Double noxFlow;
    private Double codFlow;
    private Double nh4Flow;


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


    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Double getFirePower() {
        return firePower;
    }

    public void setFirePower(Double firePower) {
        this.firePower = firePower;
    }

    public Double getCrudeOil() {
        return crudeOil;
    }

    public void setCrudeOil(Double crudeOil) {
        this.crudeOil = crudeOil;
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
