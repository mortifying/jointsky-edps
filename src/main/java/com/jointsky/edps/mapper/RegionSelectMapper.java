package com.jointsky.edps.mapper;

import com.jointsky.edps.model.RegionSelect;

import java.util.List;

/**
 * Created by shilin on 2017/6/14.
 * 城市下拉列表持久层
 */
public interface RegionSelectMapper {
    List<RegionSelect> getRegionSelect(String code);

    public List<String> getCity();
}
