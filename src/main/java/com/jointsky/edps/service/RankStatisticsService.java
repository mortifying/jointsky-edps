package com.jointsky.edps.service;

import com.jointsky.edps.mapper.RankStatisticsMapper;
import com.jointsky.edps.model.MonitorRank;
import com.jointsky.edps.model.PSFlowRank;
import com.jointsky.edps.model.RegionFlowRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by root on 2017/6/21.
 */
@Service
public class RankStatisticsService {

    @Autowired
    private RankStatisticsMapper rankStatisticsMapper;

    public List<MonitorRank> getMonitorRankList(int year, int quarter){

        return rankStatisticsMapper.getMonitorRank(year,quarter);
    }

    public List<RegionFlowRank> getRegionFlowRankList(int month){

        return rankStatisticsMapper.getRegionFlowRank(month);
    }

    public List<PSFlowRank> getPSFlowRankList(int month){
        return rankStatisticsMapper.getPSFlowRank(month);
    }

}
