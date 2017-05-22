package com.jointsky.edps.controller;

import com.jointsky.edps.model.RegionAQIFlow;
import com.jointsky.edps.service.RegionAQIFlowService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

/**
 * Created by root on 2017/5/19.
 */

@Api(value = "环境质量入口",description = "长天长大数据平台环境质量与污染源监控数据分析API")
@RestController
public class RegionAQIFlowController {

    private Logger logger = Logger.getLogger(RegionAQIFlowController.class);

    @Autowired
    private RegionAQIFlowService regionAQIFlowService;

    @ApiResponses({
        @ApiResponse(code = 400,message = "请求参数没有设置好"),
        @ApiResponse(code=401,message="未授权访问"),
        @ApiResponse(code=403,message="请求被拒绝"),
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "环境质量和排放量信息",notes = "根据城市名和日期获取环境质量和排放量信息结果入口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "regionName",value = "城市名",required = true,dataType = "String",paramType = "query",defaultValue = "北京市"),
        @ApiImplicitParam(name = "date",value = "日期",required = true,dataType = "Date",paramType = "query",defaultValue = "2016-05-01")
    })
    @RequestMapping(value = "/regionAQIFlow",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public RegionAQIFlow getRegionAQIFlowInfo(@RequestParam(value = "regionName")  String regionName, @RequestParam(value = "date") Date date){

        return regionAQIFlowService.getRegionAQIFlow(regionName,date);
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "环境质量和排放量信息集",notes = "根据城市名和日期获取环境质量和排放量信息集结果入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "regionName",value = "城市名",required = true,dataType = "String",paramType = "query",defaultValue = "北京市"),
            @ApiImplicitParam(name = "start",value = "日期",required = true,dataType = "Date",paramType = "query",defaultValue = "2016-05-01"),
            @ApiImplicitParam(name = "end",value = "日期",required = true,dataType = "Date",paramType = "query",defaultValue = "2016-05-10")
    })
    @RequestMapping(value = "/regionAQIFlowList",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<RegionAQIFlow> getRegionAQIFlowListInfo(@RequestParam(value = "regionName")  String regionName, @RequestParam(value = "start") Date start,
                                                       @RequestParam(value = "end") Date end){

        return regionAQIFlowService.getRegionAQIFlowList(regionName,start,end);
    }


}
