package com.jointsky.edps.mapper;

import com.jointsky.edps.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by root on 2017/6/8.
 */
public interface DataOutlineMapper {

    public int getTotalDataRecordNum();

    public int getPSNum();

    public int getPSOutputNum();

    public int getPwshfPSNum();

    public List<FlowByYear> getFlowByYear(int start,int end);

    public List<FlowMonth> getTopTenFlowProvinceByMonth(int month);

    public List<FlowYear> getTopTenFlowProvinceByYear(int year);

    public List<FlowMonth> getTopTenFlowCityByMonth(int month);

    public List<FlowYear> getTopTenFlowCityByYear(int year);

    public List<FlowPerGDP> getTopTenFlowPerGDPByQuarter(int year,int quarter,@Param(value = "order") String order);

    public List<ProvinceCharge> getTop10ChargeProvince(int dataMonth);

    public List<ProvinceYearCharge> getYearTop10ChargeProvince(int year);

    public List<ProvincePollutantCharge> getTop10PollutantChargeProvince(int dataMonth, String pollutantName);

    public List<ProvinceYearPollutantCharge> getYearTop10PollutantChargeProvince(int year, String pollutantName);

    public DataStatistics getDataStatistics();
}
