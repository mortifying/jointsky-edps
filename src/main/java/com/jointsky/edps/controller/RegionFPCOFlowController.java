package com.jointsky.edps.controller;

import com.jointsky.edps.model.*;
import com.jointsky.edps.service.RegionFPCOFlowService;
import com.jointsky.edps.service.RegionGDPFlowService;
import com.jointsky.edps.util.DateTransition;
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
 * Created by root on 2017/5/22.
 */
@Api(value = "国家统计入口",description = "长天长大数据平台国家统计数据与污染源监控数据分析API")
@RestController
public class RegionFPCOFlowController {

    private Logger logger = Logger.getLogger(RegionFPCOFlowController.class);

    @Autowired
    private RegionFPCOFlowService regionFPCOFlowService;
    @Autowired
    private RegionGDPFlowService regionGDPFlowService;
    private DateTransition dateTransition = new DateTransition();

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "火力发电和原油与排放量的信息",notes = "根据省份和月份获取火力发电量和原油生产量与排放量信息结果入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "regionName",value = "省份",required = true,dataType = "String",paramType = "query",defaultValue = "北京市"),
            @ApiImplicitParam(name = "month",value = "月份",required = true,dataType = "String",paramType = "query",defaultValue = "2016年05月")
    })
    @RequestMapping(value = "/regionFPCOFlow",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public RegionFPCOFlow getRegionFPCOFlowInfo(@RequestParam(value = "regionName") String regionName, @RequestParam(value = "month") String month){

        return regionFPCOFlowService.getRegionFPCOFlow(regionName,dateTransition.monthToDate(month));
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "火力发电和原油与排放量的信息集",notes = "根据省份和月份获取火力发电量和原油生产量与排放量信息集结果入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "regionName",value = "省份",required = true,dataType = "String",paramType = "query",defaultValue = "北京市"),
            @ApiImplicitParam(name = "start",value = "月份",required = true,dataType = "String",paramType = "query",defaultValue = "2016年05月"),
            @ApiImplicitParam(name = "end",value = "月份",required = true,dataType = "String",paramType = "query",defaultValue = "2016年07月")
    })
    @RequestMapping(value = "/regionFPCOFlowList",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<RegionFPCOFlow> getRegionFPCOFlowListInfo(@RequestParam(value = "regionName") String regionName, @RequestParam(value = "start") String start,
                                                          @RequestParam(value = "end") String end){
        return regionFPCOFlowService.getRegionFPCOFlowList(regionName,dateTransition.monthToDate(start),dateTransition.monthToDate(end));
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "GDP数据与排放量的信息",notes = "根据省份和月份获取GDP数据与排放量信息结果入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "regionName",value = "省份",required = true,dataType = "String",paramType = "query",defaultValue = "北京市"),
            @ApiImplicitParam(name = "date",value = "季度",required = true,dataType = "String",paramType = "query",defaultValue = "2016年第一季度"),
    })
    @RequestMapping(value = "/regionGDPFlow",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public RegionGDPFlow getRegionGDPFlowInfo(@RequestParam(value = "regionName") String region,@RequestParam(value = "date") String date ){
        return regionGDPFlowService.getRegionGDPFlow(region,dateTransition.quarterToDate(date));
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "GDP数据与排放量的信息集",notes = "根据省份和月份获取GDP数据与排放量信息集结果入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "regionName",value = "省份",required = true,dataType = "String",paramType = "query",defaultValue = "北京市"),
            @ApiImplicitParam(name = "start",value = "季度",required = true,dataType = "String",paramType = "query",defaultValue = "2016年第一季度"),
            @ApiImplicitParam(name = "end",value = "季度",required = true,dataType = "String",paramType = "query",defaultValue = "2016年第三季度")
    })
    @RequestMapping(value = "/regionGDPFlowList",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<RegionGDPFlow> getRegionGDPFlowListInfo(@RequestParam(value = "regionName") String region, @RequestParam(value = "start") String start,
                                                        @RequestParam(value = "end") String end){
        return regionGDPFlowService.getRegionGDPFlowList(region,dateTransition.quarterToDate(start),dateTransition.quarterToDate(end));
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "全国行业GDP数据与排放量的信息",notes = "根据年份获取全国各行业GDP数据与排放量信息结果入口")
    @ApiImplicitParam(name = "year",value = "年份",required = true,dataType = "int",paramType = "query",defaultValue = "2015")
    @RequestMapping(value = "/industryGDPFlow",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public IndustryGDPFlow getIndustryGDPFlowInfo(@RequestParam(value = "year") int year ){
        return regionGDPFlowService.getIndustryGDPFlow(year);
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "全国行业GDP数据与排放量的信息集",notes = "根据年份获取全国行业GDP数据与排放量信息集结果入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "start",value = "年份",required = true,dataType = "int",paramType = "query",defaultValue = "2010"),
            @ApiImplicitParam(name = "end",value = "年份",required = true,dataType = "int",paramType = "query",defaultValue = "2015")
    })
    @RequestMapping(value = "/industryGDPFlowList",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<IndustryGDPFlow> getIndustryGDPFlowListInfo(@RequestParam(value = "start") int start,
                                                        @RequestParam(value = "end") int end){
        return regionGDPFlowService.getIndustryGDPFlowList(start,end);
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "全国主要城市GDP与排放量的信息",notes = "根据城市和年份获取城市GDP与排放量信息结果入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "regionName",value = "城市",required = true,dataType = "String",paramType = "query",defaultValue = "北京市"),
            @ApiImplicitParam(name = "year",value = "年份",required = true,dataType = "int",paramType = "query",defaultValue = "2015")
    })
    @RequestMapping(value = "/mainCityGDPFlow",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public MainCityGDPFlow getMainCityGDPFlowInfo(@RequestParam(value = "regionName") String regionName, @RequestParam(value = "year") int year){

        return regionGDPFlowService.getMainCityGDPFlow(regionName,year);
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "全国主要城市GDP与排放量的信息集",notes = "根据城市和年份获取城市GDP与排放量信息集结果入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "regionName",value = "城市",required = true,dataType = "String",paramType = "query",defaultValue = "北京市"),
            @ApiImplicitParam(name = "start",value = "年份",required = true,dataType = "int",paramType = "query",defaultValue = "2010"),
            @ApiImplicitParam(name = "end",value = "年份",required = true,dataType = "int",paramType = "query",defaultValue = "2015")
    })
    @RequestMapping(value = "/mainCityGDPFlowList",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<MainCityGDPFlow> getMainCityGDPFlowListInfo(@RequestParam(value = "regionName") String regionName, @RequestParam(value = "start") int start,
                                                          @RequestParam(value = "end") int end){
        return regionGDPFlowService.getMainCityGDPFlowList(regionName,start,end);
    }
}
