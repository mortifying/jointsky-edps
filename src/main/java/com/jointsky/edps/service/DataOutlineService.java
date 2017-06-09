package com.jointsky.edps.service;

import com.jointsky.edps.mapper.DataOutlineMapper;
import com.jointsky.edps.model.ProvinceCharge;
import com.jointsky.edps.model.ProvinceYearCharge;
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

    public List<ProvinceCharge> getTop10ChargeProvince(int dataMonth) {
        return dataOutlineMapper.getTop10ChargeProvince(dataMonth);
    }

    public List<ProvinceYearCharge> getYearTop10ChargeProvince(int year) {
        return dataOutlineMapper.getYearTop10ChargeProvince(year);
    }
}
