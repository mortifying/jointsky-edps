package com.jointsky.edps.controller;

import com.jointsky.edps.model.EnergyYieldFlow;
import com.jointsky.edps.model.MonitorRank;
import com.jointsky.edps.model.PSFlowRank;
import com.jointsky.edps.model.RegionFlowRank;
import com.jointsky.edps.service.RankStatisticsService;
import com.jointsky.edps.util.DateTransition;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by root on 2017/6/21.
 */
@Api(value = "排行统计入口",description = "长天长大数据平台数据排行统计情况")
@RestController
public class RankStatisticsController {

    @Autowired
    private RankStatisticsService rankStatisticsService;

    private DateTransition dateTransition = new DateTransition();


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "在线监控设备排行",notes = "根据季度获取在线监控设备可靠性排行结果入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year",value = "年份",required = true,dataType = "int",paramType = "query",defaultValue = "2017"),
            @ApiImplicitParam(name = "quarter",value = "季度",required = true,dataType = "String",paramType = "query",defaultValue = "第一季度")
    })
    @RequestMapping(value = "/getMonitorRankInfo",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<MonitorRank> getMonitorRankInfo(@RequestParam(value = "year") int year,
                                                @RequestParam(value = "quarter") String quarter){
        return rankStatisticsService.getMonitorRankList(year,dateTransition.quarterToNum(quarter));
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "全国重污染域排行",notes = "根据月份获取全国重污染域排行前十结果入口")
    @ApiImplicitParam(name = "month",value = "月份",required = true,dataType = "String",paramType = "query",defaultValue = "2016年01月")
    @RequestMapping(value = "/getRegionFlowRankInfo",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<RegionFlowRank> getRegionFlowRankInfo(@RequestParam(value = "month") String month){
        return rankStatisticsService.getRegionFlowRankList(dateTransition.monthConvert(month));
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "全国重污染企业排行",notes = "根据月份获取全国重污染企业排行前三十结果入口")
    @ApiImplicitParam(name = "month",value = "月份",required = true,dataType = "String",paramType = "query",defaultValue = "2016年01月")
    @RequestMapping(value = "/getPSFlowRankInfo",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<PSFlowRank> getPSFlowRankInfo(@RequestParam(value = "month") String month){
        return rankStatisticsService.getPSFlowRankList(dateTransition.monthConvert(month));
    }
}
