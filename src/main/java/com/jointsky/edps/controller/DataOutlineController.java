package com.jointsky.edps.controller;

import com.jointsky.edps.model.FlowByYear;
import com.jointsky.edps.model.FlowMonth;
import com.jointsky.edps.model.FlowPerGDP;
import com.jointsky.edps.model.FlowYear;
import com.jointsky.edps.service.DataOutlineService;
import com.jointsky.edps.service.HttpLogsService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by root on 2017/6/7.
 */
@Api(value = "数据宏观概况",description = "长天长大数据平台数据宏观汇总情况")
@RestController
public class DataOutlineController {

    private Logger logger = Logger.getLogger(DataOutlineController.class);

    @Autowired
    private HttpLogsService httpLogsService;
    @Autowired
    private DataOutlineService dataOutlineService;

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "接口被调用次数",notes = "获取数据平台的所有接口被调用的总次数")
    @RequestMapping(value = "/interfaceCallNumber",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public int getInterfaceCallNumber(){
        return httpLogsService.queryHttpLogsTotal();
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "平台数据录入条数",notes = "获取数据平台的数据录入条数")
    @RequestMapping(value = "/dataRecordNum",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public int getDataRecordNum(){
        return dataOutlineService.dataRecordNum();
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "录入的重点污染源数",notes = "获取数据平台的录入重点污染源数")
    @RequestMapping(value = "/psNum",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public int getPSNum(){
        return dataOutlineService.psNum();
    }



    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "录入的重点污染源排口数",notes = "获取数据平台的录入重点污染源排口数")
    @RequestMapping(value = "/psOutputNum",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public int getPSOutputNum(){
        return dataOutlineService.psOutputNum();
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "录入的排污收费的企业数",notes = "获取数据平台的录入的排污收费的企业数")
    @RequestMapping(value = "/pwshfPSNum",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public int getPwshfPSNum(){
        return dataOutlineService.pwshfPSNum();
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "各污染物年排放总量",notes = "根据年份获取各污染物年排放总量的数据集")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "start",value = "年份",required = true,dataType = "int",paramType = "query",defaultValue = "2010"),
            @ApiImplicitParam(name = "end",value = "年份",required = true,dataType = "int",paramType = "query",defaultValue = "2016")
    })
    @RequestMapping(value = "/flowByYearList",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<FlowByYear> getFlowByYearList(@RequestParam(value = "start") int start, @RequestParam(value = "end") int end){
        return dataOutlineService.flowByYearList(start,end);
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "省级行政区排放量情况（月）",notes = "根据月份获取省级行政区排放量排名前十的省份排放情况")
    @ApiImplicitParam(name = "month",value = "月份",required = true,dataType = "int",paramType = "query",defaultValue = "201612")
    @RequestMapping(value = "/topTenFlowProvinceMonth",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<FlowMonth> getTopTenFlowProvinceMonth(@RequestParam(value = "month") int month){
        return dataOutlineService.topTenFlowProvinceMonth(month);
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "省级行政区排放量情况（年）",notes = "根据年份获取省级行政区排放量排名前十的省份排放情况")
    @ApiImplicitParam(name = "year",value = "年份",required = true,dataType = "int",paramType = "query",defaultValue = "2016")
    @RequestMapping(value = "/topTenFlowProvinceYear",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<FlowYear> getTopTenFlowProvinceYear(@RequestParam(value = "year") int year){
        return dataOutlineService.topTenFlowProvinceYear(year);
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "市级行政区排放量情况（月）",notes = "根据月份获取市级行政区排放量排名前十的城市排放情况")
    @ApiImplicitParam(name = "month",value = "月份",required = true,dataType = "int",paramType = "query",defaultValue = "201612")
    @RequestMapping(value = "/topTenFlowCityMonth",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<FlowMonth> getTopTenFlowCityMonth(@RequestParam(value = "month") int month){
        return dataOutlineService.topTenFlowCityMonth(month);
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "市级行政区排放量情况（年）",notes = "根据年份获取市级行政区排放量排名前十的城市排放情况")
    @ApiImplicitParam(name = "year",value = "年份",required = true,dataType = "int",paramType = "query",defaultValue = "2016")
    @RequestMapping(value = "/topTenFlowCityYear",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<FlowYear> getTopTenFlowCityYear(@RequestParam(value = "year") int year){
        return dataOutlineService.topTenFlowCityYear(year);
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "单位GDP污染物排放总量",notes = "根据季度获取单位GDP污染物季度排放总量前十的省份排放情况")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year",value = "年份",required = true,dataType = "int",paramType = "query",defaultValue = "2016"),
            @ApiImplicitParam(name = "quarter",value = "季度",required = true,dataType = "int",paramType = "query",defaultValue = "1"),
            @ApiImplicitParam(name = "order",value = "最多（desc），最少（asc）",required = true,dataType = "String",paramType = "query",defaultValue = "desc")
    })
    @RequestMapping(value = "/topTenFlowPerGDPQuarter",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<FlowPerGDP> getTopTenFlowPerGDPQuarter(@RequestParam(value = "year") int year, @RequestParam(value = "quarter") int quarter,
                                                       @RequestParam(value = "order") String order){
        return dataOutlineService.topTenFlowPerGDPQuarter(year,quarter,order);
    }

}
