package com.jointsky.edps.mapper;

import com.jointsky.edps.model.RegionAQIFlow;

import java.sql.Date;
import java.util.List;

/**
 * Created by root on 2017/5/19.
 */
public interface RegionAQIFlowMapper {

    public RegionAQIFlow getAQIFlowByRegionNameDate(String regionName, Date date);

    public List<RegionAQIFlow> getAQIFlowByRegionStartEndDate(String regionName,Date start,Date end);
}
