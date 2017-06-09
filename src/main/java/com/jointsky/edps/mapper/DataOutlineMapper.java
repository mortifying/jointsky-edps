package com.jointsky.edps.mapper;

import com.jointsky.edps.model.ProvinceCharge;
import com.jointsky.edps.model.ProvinceYearCharge;

import java.util.List;

/**
 * Created by root on 2017/6/8.
 */
public interface DataOutlineMapper {

    public int getTotalDataRecordNum();

    public int getPSNum();

    public int getPSOutputNum();

    public int getPwshfPSNum();

    public List<ProvinceCharge> getTop10ChargeProvince(int dataMonth);

    public List<ProvinceYearCharge> getYearTop10ChargeProvince(int year);
}
