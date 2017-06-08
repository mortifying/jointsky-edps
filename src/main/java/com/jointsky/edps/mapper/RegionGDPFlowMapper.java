package com.jointsky.edps.mapper;

import com.jointsky.edps.model.IndustryGDPFlow;
import com.jointsky.edps.model.MainCityGDPFlow;
import com.jointsky.edps.model.RegionGDPFlow;

import java.sql.Date;
import java.util.List;

/**
 * Created by root on 2017/5/22.
 */
public interface RegionGDPFlowMapper {

    public RegionGDPFlow getGDPFlowByRegionQuarter(String regionName, Date date);

    public List<RegionGDPFlow> getGDPFlowByRegionStartEndQuarter(String regionName,Date start,Date end);

    public IndustryGDPFlow getIndustryGDPFlowByYear(int year);

    public List<IndustryGDPFlow> getIndustryGDPFlowStartEndYear(int start,int end);

    public MainCityGDPFlow getMainCityGDPFlowByYear(String regionName,int year);

    public List<MainCityGDPFlow> getMainCityGDPFlowStartEndYear(String regionName,int start,int end);
}
