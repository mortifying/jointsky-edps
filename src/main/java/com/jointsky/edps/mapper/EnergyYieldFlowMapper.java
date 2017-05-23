package com.jointsky.edps.mapper;

import com.jointsky.edps.model.EnergyConsumeFlow;
import com.jointsky.edps.model.EnergyYieldFlow;

import java.sql.Date;
import java.util.List;

/**
 * Created by root on 2017/5/23.
 */
public interface EnergyYieldFlowMapper {


    public EnergyYieldFlow getEnergyYieldFlowByMonth(Date month);

    public List<EnergyYieldFlow> getEnergyYieldFlowStartEndMonth(Date start,Date end);

    public EnergyConsumeFlow getEnergyConsumeFlowByRegionYear(String region,int year);

    public List<EnergyConsumeFlow> getEnergyConsumeFlowByRegionStartEndYear(String region,int start,int end);
}
