package com.jointsky.edps.controller;

import com.jointsky.edps.model.IndustryGDPFlow;
import com.jointsky.edps.model.RegionFPCOFlow;
import com.jointsky.edps.model.RegionGDPFlow;
import com.jointsky.edps.service.RegionFPCOFlowService;
import com.jointsky.edps.service.RegionGDPFlowService;
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

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "火力发电和原油与排放量的信息",notes = "根据省份和月份获取火力发电量和原油生产量与排放量信息结果入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "regionName",value = "省份",required = true,dataType = "String",paramType = "query",defaultValue = "北京市"),
            @ApiImplicitParam(name = "date",value = "月份",required = true,dataType = "Date",paramType = "query",defaultValue = "2016-05-01")
    })
    @RequestMapping(value = "/regionFPCOFlow",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public RegionFPCOFlow getRegionFPCOFlowInfo(@RequestParam(value = "regionName") String regionName, @RequestParam(value = "date") Date date){

        return regionFPCOFlowService.getRegionFPCOFlow(regionName,date);
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
            @ApiImplicitParam(name = "start",value = "月份",required = true,dataType = "Date",paramType = "query",defaultValue = "2016-05-01"),
            @ApiImplicitParam(name = "end",value = "月份",required = true,dataType = "Date",paramType = "query",defaultValue = "2016-07-01")
    })
    @RequestMapping(value = "/regionFPCOFlowList",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<RegionFPCOFlow> getRegionFPCOFlowListInfo(@RequestParam(value = "regionName") String regionName, @RequestParam(value = "start") Date start,
                                                          @RequestParam(value = "end") Date end){
        return regionFPCOFlowService.getRegionFPCOFlowList(regionName,start,end);
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
            @ApiImplicitParam(name = "date",value = "季度（最后一天）",required = true,dataType = "Date",paramType = "query",defaultValue = "2016-03-31"),
    })
    @RequestMapping(value = "/regionGDPFlow",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public RegionGDPFlow getRegionGDPFlowInfo(@RequestParam(value = "regionName") String region,@RequestParam(value = "date") Date date ){
        return regionGDPFlowService.getRegionGDPFlow(region,date);
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
            @ApiImplicitParam(name = "start",value = "季度（最后一天）",required = true,dataType = "Date",paramType = "query",defaultValue = "2016-03-31"),
            @ApiImplicitParam(name = "end",value = "季度（最后一天）",required = true,dataType = "Date",paramType = "query",defaultValue = "2016-09-30")
    })
    @RequestMapping(value = "/regionGDPFlowList",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<RegionGDPFlow> getRegionGDPFlowListInfo(@RequestParam(value = "regionName") String region, @RequestParam(value = "start") Date start,
                                                        @RequestParam(value = "end") Date end){
        return regionGDPFlowService.getRegionGDPFlowList(region,start,end);
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
    @RequestMapping(value = "/industryGDPFlowList",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<IndustryGDPFlow> getIndustryGDPFlowListInfo(@RequestParam(value = "start") int start,
                                                        @RequestParam(value = "end") int end){
        return regionGDPFlowService.getIndustryGDPFlowList(start,end);
    }

}
