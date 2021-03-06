package com.jointsky.edps.service;

import com.jointsky.edps.mapper.RegionGDPFlowMapper;
import com.jointsky.edps.model.IndustryGDPFlow;
import com.jointsky.edps.model.MainCityGDPFlow;
import com.jointsky.edps.model.RegionGDPFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by root on 2017/5/22.
 */
@Service
public class RegionGDPFlowService {

    @Autowired
    private RegionGDPFlowMapper regionGDPFlowMapper;

    public RegionGDPFlow getRegionGDPFlow(String region, String date){
        return regionGDPFlowMapper.getGDPFlowByRegionQuarter(region,date);
    }

    public List<RegionGDPFlow> getRegionGDPFlowList(String region,String start,String end){
        return regionGDPFlowMapper.getGDPFlowByRegionStartEndQuarter(region,start,end);
    }

    public IndustryGDPFlow getIndustryGDPFlow(int year){
        return regionGDPFlowMapper.getIndustryGDPFlowByYear(year);
    }

    public List<IndustryGDPFlow> getIndustryGDPFlowList(int start,int end){

        return regionGDPFlowMapper.getIndustryGDPFlowStartEndYear(start,end);
    }

    public MainCityGDPFlow getMainCityGDPFlow(String regionName,int year){
        return regionGDPFlowMapper.getMainCityGDPFlowByYear(regionName,year);
    }

    public List<MainCityGDPFlow> getMainCityGDPFlowList(String regionName,int start,int end){
        return regionGDPFlowMapper.getMainCityGDPFlowStartEndYear(regionName,start,end);
    }
}
