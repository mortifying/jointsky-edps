package com.jointsky.edps.service;

import com.jointsky.edps.mapper.RegionFPCOFlowMapper;
import com.jointsky.edps.model.RegionFPCOFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by root on 2017/5/22.
 */
@Service
public class RegionFPCOFlowService {

    @Autowired
    private RegionFPCOFlowMapper regionFPCOFlowMapper;

    public RegionFPCOFlow getRegionFPCOFlow(String regionName , String date){
        RegionFPCOFlow regionFPCOFlow = regionFPCOFlowMapper.getFPOCFlowByRegionNameDate(regionName,date);
        return regionFPCOFlow;
    }

    public List<RegionFPCOFlow> getRegionFPCOFlowList(String regionName,Date start,Date end){
        return regionFPCOFlowMapper.getFPOCFlowByRegionStartEndDate(regionName,start,end);
    }
}
