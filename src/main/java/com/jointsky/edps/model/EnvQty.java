package com.jointsky.edps.model;


public class EnvQty {
    private String name;
    private Integer maxValue;
    private Integer minValue;

    public String getName() {
        return name;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public void setName(String name) {
        this.name = name;
    }

}
