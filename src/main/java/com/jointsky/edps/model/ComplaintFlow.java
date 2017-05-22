package com.jointsky.edps.model;

import java.sql.Date;
/**
 * Created by LiuZifan on 2017/5/22.
 */
public class ComplaintFlow {
    private String regionName;
    private Date month;
    private int count;
    private double dustStrength;
    private double dustFlow;
    private double so2Strength;
    private double so2Flow;
    private double noxStrength;
    private double noxtFlow;
    private double codStrength;
    private double codFlow;
    private double nh4Strength;
    private double nh4Flow;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getDustStrength() {
        return dustStrength;
    }

    public void setDustStrength(double dustStrength) {
        this.dustStrength = dustStrength;
    }

    public double getDustFlow() {
        return dustFlow;
    }

    public void setDustFlow(double dustFlow) {
        this.dustFlow = dustFlow;
    }

    public double getSo2Strength() {
        return so2Strength;
    }

    public void setSo2Strength(double so2Strength) {
        this.so2Strength = so2Strength;
    }

    public double getSo2Flow() {
        return so2Flow;
    }

    public void setSo2Flow(double so2Flow) {
        this.so2Flow = so2Flow;
    }

    public double getNoxStrength() {
        return noxStrength;
    }

    public void setNoxStrength(double noxStrength) {
        this.noxStrength = noxStrength;
    }

    public double getNoxtFlow() {
        return noxtFlow;
    }

    public void setNoxtFlow(double noxtFlow) {
        this.noxtFlow = noxtFlow;
    }

    public double getCodStrength() {
        return codStrength;
    }

    public void setCodStrength(double codStrength) {
        this.codStrength = codStrength;
    }

    public double getCodFlow() {
        return codFlow;
    }

    public void setCodFlow(double codFlow) {
        this.codFlow = codFlow;
    }

    public double getNh4Strength() {
        return nh4Strength;
    }

    public void setNh4Strength(double nh4Strength) {
        this.nh4Strength = nh4Strength;
    }

    public double getNh4Flow() {
        return nh4Flow;
    }

    public void setNh4Flow(double nh4Flow) {
        this.nh4Flow = nh4Flow;
    }
}
