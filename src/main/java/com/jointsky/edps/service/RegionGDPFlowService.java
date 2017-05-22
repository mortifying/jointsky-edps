package com.jointsky.edps.service;

import com.jointsky.edps.mapper.RegionGDPFlowMapper;
import com.jointsky.edps.model.IndustryGDPFlow;
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

    public RegionGDPFlow getRegionGDPFlow(String region, Date date){
        return regionGDPFlowMapper.getGDPFlowByRegionQuarter(region,date);
    }

    public List<RegionGDPFlow> getRegionGDPFlowList(String region,Date start,Date end){
        return regionGDPFlowMapper.getGDPFlowByRegionStartEndQuarter(region,start,end);
    }

    public IndustryGDPFlow getIndustryGDPFlow(int year){
        return regionGDPFlowMapper.getIndustryGDPFlowByYear(year);
    }

    public List<IndustryGDPFlow> getIndustryGDPFlowList(int start,int end){

        return regionGDPFlowMapper.getIndustryGDPFlowStartEndYear(start,end);
    }
}
