package com.jointsky.edps.controller;

import com.jointsky.edps.model.ComplaintFlow;
import com.jointsky.edps.model.RegionAQIFlow;
import com.jointsky.edps.service.ComplaintFlowService;
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
 * Created by LiuZifan on 2017/5/22.
 */

@Api(value = "举报投诉数据入口",description = "长天长大数据平台举报投诉与污染源监控数据分析API")

@RestController
public class ComplaintFlowController {

    private Logger logger = Logger.getLogger(ComplaintFlowController.class);

    @Autowired
    private ComplaintFlowService complaintFlowService;

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })

    @ApiOperation(value = "按省份环境举报投诉、排放总量、平均排放浓度信息",notes = "根据省份和日期获取环境举报投诉和污染物平均浓度、排放总量信息结果入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "regionName",value = "省份名",required = true,dataType = "String",paramType = "query",defaultValue = "上海市"),
            @ApiImplicitParam(name = "month",value = "月份",required = true,dataType = "Date",paramType = "query",defaultValue = "2014-02-01")
    })
    @RequestMapping(value = "/ComplaintFlow",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public ComplaintFlow getComplaintFlowInfo(@RequestParam(value = "regionName")  String regionName, @RequestParam(value = "month") Date month){

        return complaintFlowService.getComplaintFlow(regionName, month);
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })

    @ApiOperation(value = "按省份及时间区间环境举报投诉、排放总量、平均排放浓度信息",notes = "根据省份和日期获取环境举报投诉和污染物平均浓度、排放总量信息结果入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "regionName",value = "省份名",required = true,dataType = "String",paramType = "query",defaultValue = "上海市"),
            @ApiImplicitParam(name = "startMonth",value = "起始月份",required = true,dataType = "Date",paramType = "query",defaultValue = "2014-02-01"),
            @ApiImplicitParam(name = "endMonth",value = "结束月份",required = true,dataType = "Date",paramType = "query",defaultValue = "2014-05-01")
    })
    @RequestMapping(value = "/ComplaintFlowList",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<ComplaintFlow> getComplaintFlowListInfo(@RequestParam(value = "regionName")  String regionName, @RequestParam(value = "startMonth") Date startMonth, @RequestParam(value = "endMonth") Date endMonth){

        return complaintFlowService.getComplaintFlowList(regionName, startMonth,endMonth);
    }
}


