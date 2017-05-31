package com.jointsky.edps.controller;

import com.jointsky.edps.model.EnergyConsumeFlow;
import com.jointsky.edps.model.EnergyYieldFlow;
import com.jointsky.edps.service.EnergyYieldFlowService;
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
 * Created by root on 2017/5/23.
 */

@Api(value = "能源数据入口",description = "长天长大数据平台能源数据与污染源监控数据分析API")
@RestController
public class EnergyYieldFlowController {


    private Logger logger = Logger.getLogger(EnergyYieldFlowController.class);

    @Autowired
    private EnergyYieldFlowService energyYieldFlowService;

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "全国各种能源资源产量与排放量的信息",notes = "根据月份获取全国各种能源产量与排放量信息结果入口")
    @ApiImplicitParam(name = "date",value = "月份",required = true,dataType = "Date",paramType = "query",defaultValue = "2016-05-01")
    @RequestMapping(value = "/energyYieldFlow",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public EnergyYieldFlow getEnergyYieldFlowInfo(@RequestParam(value = "date") Date date){

        return energyYieldFlowService.getEnergyYieldFlow(date);
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "全国各种能源资源产量与排放量的信息集",notes = "根据月份获取全国各种能源产量与排放量信息集结果入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "start",value = "月份",required = true,dataType = "Date",paramType = "query",defaultValue = "2016-01-01"),
            @ApiImplicitParam(name = "end",value = "月份",required = true,dataType = "Date",paramType = "query",defaultValue = "2016-05-01")
    })
    @RequestMapping(value = "/energyYieldFlowList",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<EnergyYieldFlow> getEnergyYieldFlowListInfo(@RequestParam(value = "start") Date start,
                                                            @RequestParam(value = "end") Date end){
        return energyYieldFlowService.getEnergyYieldFlowList(start,end);
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "各省各种能源资源消费量与排放量的信息",notes = "根据年份获取全省各种能源消费量与排放量信息结果入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "region",value = "省份",required = true,dataType = "String",paramType = "query",defaultValue = "北京市"),
            @ApiImplicitParam(name = "year",value = "年份",required = true,dataType = "int",paramType = "query",defaultValue = "2015")
    })
    @RequestMapping(value = "/energyConsumeFlow",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public EnergyConsumeFlow getEnergyConsumeFlowInfo(@RequestParam(value = "region") String region,
                                                        @RequestParam(value = "year") int year){
        return energyYieldFlowService.getEnergyConsumeFlow(region,year);
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "各省各种能源资源消费量与排放量的信息集",notes = "根据年份获取全省各种能源消费量与排放量信息集结果入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "region",value = "省份",required = true,dataType = "String",paramType = "query",defaultValue = "北京市"),
            @ApiImplicitParam(name = "start",value = "年份",required = true,dataType = "int",paramType = "query",defaultValue = "2010"),
            @ApiImplicitParam(name = "end",value = "年份",required = true,dataType = "int",paramType = "query",defaultValue = "2015")
    })
    @RequestMapping(value = "/energyConsumeFlowList",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<EnergyConsumeFlow> getEnergyConsumeFlowListInfo(@RequestParam(value = "region") String region,
                                                      @RequestParam(value = "start") int start,@RequestParam(value = "end") int end){
        return energyYieldFlowService.getEnergyConsumeFlowList(region,start,end);
    }
}

