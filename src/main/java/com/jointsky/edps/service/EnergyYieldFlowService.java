package com.jointsky.edps.service;

import com.jointsky.edps.mapper.EnergyYieldFlowMapper;
import com.jointsky.edps.model.EnergyConsumeFlow;
import com.jointsky.edps.model.EnergyYieldFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by root on 2017/5/23.
 */

@Service
public class EnergyYieldFlowService {

    @Autowired
    private EnergyYieldFlowMapper energyYieldFlowMapper;


    public EnergyYieldFlow getEnergyYieldFlow(Date month){
        return energyYieldFlowMapper.getEnergyYieldFlowByMonth(month);
    }

    public List<EnergyYieldFlow> getEnergyYieldFlowList(Date start,Date end){
        return energyYieldFlowMapper.getEnergyYieldFlowStartEndMonth(start,end);
    }

    public EnergyConsumeFlow getEnergyConsumeFlow(String region,int year){
        return energyYieldFlowMapper.getEnergyConsumeFlowByRegionYear(region,year);
    }

    public List<EnergyConsumeFlow> getEnergyConsumeFlowList(String region,int start,int end){

        return energyYieldFlowMapper.getEnergyConsumeFlowByRegionStartEndYear(region,start,end);
    }
}
