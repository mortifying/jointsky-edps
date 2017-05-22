package com.jointsky.edps.mapper;

import com.jointsky.edps.model.ComplaintFlow;

import java.sql.Date;
import java.util.List;

/**
 * Created by LiuZifan on 2017/5/22.
 */
public interface ComplaintFlowMapper {
    //通过地区名称、月份获取地区投诉及排放量、污染物浓度信息
    public ComplaintFlow getComplaintFlowByRegionDate(String regionName, Date month);
    //通过地区名称，月份区间获取地区投诉及排放量、污染物浓度信息
    public List<ComplaintFlow> getComplaintFlowByRegionDateList(String regionName, Date startMonth, Date endMonth);
}
