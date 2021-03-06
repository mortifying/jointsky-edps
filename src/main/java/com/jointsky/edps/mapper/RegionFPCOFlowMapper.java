package com.jointsky.edps.mapper;

import com.jointsky.edps.model.RegionFPCOFlow;

import java.sql.Date;
import java.util.List;

/**
 * Created by root on 2017/5/22.
 */
public interface RegionFPCOFlowMapper {

    public RegionFPCOFlow getFPOCFlowByRegionNameDate(String regionName, String date);

    public List<RegionFPCOFlow> getFPOCFlowByRegionStartEndDate(String regionName,String start,String end);
}
