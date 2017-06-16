package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by shilin on 2017/6/14.
 * 城市下来列表实体
 */
public class RegionSelect {

    @ApiModelProperty(value = "行政编码",required = true)
    private String regionCode;
    @ApiModelProperty(value = "行政名称",required = true)
    private String regionName;

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
}
