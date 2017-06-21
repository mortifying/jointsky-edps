package com.jointsky.edps.mapper;

import com.jointsky.edps.model.MonitorRank;
import com.jointsky.edps.model.PSFlowRank;
import com.jointsky.edps.model.RegionFlowRank;

import java.util.List;

/**
 * Created by root on 2017/6/21.
 */
public interface RankStatisticsMapper {

    public List<MonitorRank> getMonitorRank(int year,int quarter);

    public List<RegionFlowRank> getRegionFlowRank(int month);

    public List<PSFlowRank> getPSFlowRank(int month);

}
