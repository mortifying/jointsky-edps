package com.jointsky.edps.controller;

import com.jointsky.edps.service.DataOutlineService;
import com.jointsky.edps.service.HttpLogsService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


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

/*测试一下能否合并
    、、
    、
    、
    、*/

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

}
