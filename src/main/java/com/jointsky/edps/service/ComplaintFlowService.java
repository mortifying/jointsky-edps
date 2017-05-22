package com.jointsky.edps.service;

import com.jointsky.edps.mapper.ComplaintFlowMapper;
import com.jointsky.edps.model.ComplaintFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by LiuZifan on 2017/5/22.
 */
@Service
public class ComplaintFlowService {
    @Autowired
    private ComplaintFlowMapper complaintFlowMapper;

    public ComplaintFlow getComplaintFlow (String regionName, Date month){
        return complaintFlowMapper.getComplaintFlowByRegionDate(regionName,month);
    }
    public List<ComplaintFlow> getComplaintFlowList (String regionName, Date startMonth, Date endMonth) {
        return complaintFlowMapper.getComplaintFlowByRegionDateList(regionName,startMonth,endMonth);
    }
}
