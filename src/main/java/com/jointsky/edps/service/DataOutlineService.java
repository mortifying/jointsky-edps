package com.jointsky.edps.service;

import com.jointsky.edps.mapper.DataOutlineMapper;
import com.jointsky.edps.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by root on 2017/6/8.
 */
@Service
public class DataOutlineService {

    @Autowired
    private DataOutlineMapper dataOutlineMapper;

    public int dataRecordNum(){
        return dataOutlineMapper.getTotalDataRecordNum();
    }

    public int psNum(){
        return dataOutlineMapper.getPSNum();
    }

    public int psOutputNum(){
        return dataOutlineMapper.getPSOutputNum();
    }

    public int pwshfPSNum(){
        return dataOutlineMapper.getPwshfPSNum();
    }

    public List<FlowByYear> flowByYearList(int start,int end){
        return dataOutlineMapper.getFlowByYear(start,end);
    }

    public List<FlowMonth> topTenFlowProvinceMonth(int month){
        return dataOutlineMapper.getTopTenFlowProvinceByMonth(month);
    }

    public List<FlowYear> topTenFlowProvinceYear(int year){
        return dataOutlineMapper.getTopTenFlowProvinceByYear(year);
    }

    public List<FlowMonth> topTenFlowCityMonth(int month){
        return dataOutlineMapper.getTopTenFlowCityByMonth(month);
    }

    public List<FlowYear> topTenFlowCityYear(int year){
        return dataOutlineMapper.getTopTenFlowCityByYear(year);
    }

    public List<FlowPerGDP> topTenFlowPerGDPQuarter(int year,int quarter,String order){
        return dataOutlineMapper.getTopTenFlowPerGDPByQuarter(year,quarter,order);
    }

    public List<ProvinceCharge> getTop10ChargeProvince(int dataMonth) {
        return dataOutlineMapper.getTop10ChargeProvince(dataMonth);
    }
    public List<ProvinceYearCharge> getYearTop10ChargeProvince(int year) {
        return dataOutlineMapper.getYearTop10ChargeProvince(year);
    }
    public List<ProvincePollutantCharge> getTop10PollutantChargeProvince(int dataMonth, String pollutantName) {
        return dataOutlineMapper.getTop10PollutantChargeProvince(dataMonth,pollutantName);
    }

    public List<ProvinceYearPollutantCharge> getYearTop10PollutantChargeProvince(int year, String pollutantName) {
        return dataOutlineMapper.getYearTop10PollutantChargeProvince(year,pollutantName);
    }
}
