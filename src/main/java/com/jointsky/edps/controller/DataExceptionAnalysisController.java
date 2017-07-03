package com.jointsky.edps.controller;

import com.jointsky.edps.model.*;
import com.jointsky.edps.service.DataExceptionAnalysisService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by root on 2017/6/5.
 */
@Api(value = "数据异常分析入口",description = "长天长大数据平台数据异常分析结果API")
@RestController
public class DataExceptionAnalysisController {

    private Logger logger = Logger.getLogger(DataExceptionAnalysisController.class);

    @Autowired
    private DataExceptionAnalysisService dataExceptionAnalysisService;


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "陡升陡降异常数据",notes = "根据企业、排口和异常时间获取陡升陡降异常的分析结果集入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "psname",value = "企业名称",required = true,dataType = "String",paramType = "query",defaultValue = "北京市火电厂"),
            @ApiImplicitParam(name = "outputname",value = "排口名称",required = true,dataType = "String",paramType = "query",defaultValue = "总排口"),
            @ApiImplicitParam(name = "exceptiontime",value = "异常时间",dataType = "String",paramType = "query",defaultValue = "2016-06-05")
    })
    @RequestMapping(value = "/steepRiseFallData",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<SteepRiseFall> getSteepRiseFallData(@RequestParam(value = "psname") String psName,
                                                    @RequestParam(value = "outputname") String outputName,
                                                    @RequestParam(value = "exceptiontime",required = false) String exceptionTime){

        return dataExceptionAnalysisService.getSteepRiseFall(psName, outputName, exceptionTime);
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "陡升陡降异常数据集",notes = "获取所有陡升陡降异常的分析结果集入口")
    @RequestMapping(value = "/steepRiseFallDataSet",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<SteepRiseFall> getSteepRiseFallDataSet(){

        return dataExceptionAnalysisService.getSteepRiseFall();
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "行业浓度异常（地区）",notes = "根据地区获取行业浓度异常的分析结果集入口")
    @ApiImplicitParam(name = "regionname",value = "地区名称",required = true,dataType = "String",paramType = "query",defaultValue = "北京市")
    @RequestMapping(value = "/industryStrengthExceptionRegionSet",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<IndustryStrengthException> getIndustryStrengthExceptionRegionSet(@RequestParam(value = "regionname") String regionName){

        return dataExceptionAnalysisService.getIndustryStrengthExceptionByRegionSet(regionName);
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "行业浓度异常（行业）",notes = "根据行业获取行业浓度异常的分析结果集入口")
    @ApiImplicitParam(name = "industryname",value = "行业名称",required = true,dataType = "String",paramType = "query",defaultValue = "火电")
    @RequestMapping(value = "/industryStrengthExceptionIndustrySet",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<IndustryStrengthException> getIndustryStrengthExceptionIndustrySet(@RequestParam(value = "industryname") String industryName){

        return dataExceptionAnalysisService.getIndustryStrengthExceptionByIndustrySet(industryName);
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "行业浓度异常企业信息",notes = "根据企业、排口和异常时间获取行业浓度异常的分析结果集入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "psname",value = "企业名称",required = true,dataType = "String",paramType = "query",defaultValue = "北京市火电厂"),
            @ApiImplicitParam(name = "outputname",value = "排口名称",required = true,dataType = "String",paramType = "query",defaultValue = "总排口"),
            @ApiImplicitParam(name = "exceptiontime",value = "异常时间",dataType = "String",paramType = "query",defaultValue = "2016-06-05")
    })
    @RequestMapping(value = "/industryStrengthExceptionPSInfo",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<IndustryStrengthException> getIndustryStrengthExceptionPSInfo(@RequestParam(value = "psname") String psName,@RequestParam(value = "outputname") String outputName,
                                                                      @RequestParam(value = "exceptiontime",required = false) String exceptionTime){

        return dataExceptionAnalysisService.getIndustryStrengthExceptionByPSInfoSet(psName, outputName, exceptionTime);
    }



    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "浓度恒值异常（地区）",notes = "根据地区获取浓度恒值异常的分析结果集入口")
    @ApiImplicitParam(name = "regionname",value = "地区名称",required = true,dataType = "String",paramType = "query",defaultValue = "北京市")
    @RequestMapping(value = "/strengthConstantValueRegionSet",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<StrengthConstantValue> getStrengthConstantValueRegionSet(@RequestParam(value = "regionname") String regionName){

        return dataExceptionAnalysisService.getStrengthConstantValueByRegionSet(regionName);
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "浓度恒值异常（行业）",notes = "根据行业获取浓度恒值异常的分析结果集入口")
    @ApiImplicitParam(name = "industryname",value = "行业名称",required = true,dataType = "String",paramType = "query",defaultValue = "火电")
    @RequestMapping(value = "/strengthConstantValueIndustrySet",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<StrengthConstantValue> getStrengthConstantValueIndustrySet(@RequestParam(value = "industryname") String industryName){

        return dataExceptionAnalysisService.getStrengthConstantValueByIndustrySet(industryName);
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "浓度恒值异常企业信息",notes = "根据企业、排口和异常时间获取浓度恒值异常的分析结果集入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "psname",value = "企业名称",required = true,dataType = "String",paramType = "query",defaultValue = "北京市火电厂"),
            @ApiImplicitParam(name = "outputname",value = "排口名称",required = true,dataType = "String",paramType = "query",defaultValue = "总排口"),
            @ApiImplicitParam(name = "exceptiontime",value = "异常时间",dataType = "String",paramType = "query",defaultValue = "2016-06-05")
    })
    @RequestMapping(value = "/strengthConstantValuePSInfo",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<StrengthConstantValue> getStrengthConstantValuePSInfo(@RequestParam(value = "psname") String psName,@RequestParam(value = "outputname") String outputName,
                                                                      @RequestParam(value = "exceptiontime",required = false) String exceptionTime){

        return dataExceptionAnalysisService.getStrengthConstantValueByPSInfoSet(psName,outputName,exceptionTime);
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "流量恒值异常（地区）",notes = "根据地区获取流量恒值异常的分析结果集入口")
    @ApiImplicitParam(name = "regionname",value = "地区名称",required = true,dataType = "String",paramType = "query",defaultValue = "北京市")
    @RequestMapping(value = "/flowConstantValueRegionSet",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<FlowConstantValue> getFlowConstantValueRegionSet(@RequestParam(value = "regionname") String regionName){

        return dataExceptionAnalysisService.getFlowConstantValueByRegionSet(regionName);
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "流量恒值异常（行业）",notes = "根据行业获取流量恒值异常的分析结果集入口")
    @ApiImplicitParam(name = "industryname",value = "行业名称",required = true,dataType = "String",paramType = "query",defaultValue = "火电")
    @RequestMapping(value = "/flowConstantValueIndustrySet",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<FlowConstantValue> getFlowConstantValueIndustrySet(@RequestParam(value = "industryname") String industryName){

        return dataExceptionAnalysisService.getFlowConstantValueByIndustrySet(industryName);
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "流量恒值异常企业信息",notes = "根据企业、排口和异常时间获取流量恒值异常的分析结果集入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "psname",value = "企业名称",required = true,dataType = "String",paramType = "query",defaultValue = "北京市火电厂"),
            @ApiImplicitParam(name = "outputname",value = "排口名称",required = true,dataType = "String",paramType = "query",defaultValue = "总排口"),
            @ApiImplicitParam(name = "exceptiontime",value = "异常时间",dataType = "String",paramType = "query",defaultValue = "2016-06-05")
    })
    @RequestMapping(value = "/flowConstantValuePSInfo",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<FlowConstantValue> getFlowConstantValuePSInfo(@RequestParam(value = "psname") String psName,
                                                              @RequestParam(value = "outputname") String outputName,
                                                              @RequestParam(value = "exceptiontime",required = false) String exceptionTime){

        return dataExceptionAnalysisService.getFlowConstantValueByPSInfoSet(psName,outputName,exceptionTime);
    }



    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "流量异常（地区）",notes = "根据地区获取流量异常的分析结果集入口")
    @ApiImplicitParam(name = "regionname",value = "地区名称",required = true,dataType = "String",paramType = "query",defaultValue = "北京市")
    @RequestMapping(value = "/flowExceptionRegionSet",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<FlowException> getFlowExceptionRegionSet(@RequestParam(value = "regionname") String regionName){

        return dataExceptionAnalysisService.getFlowExceptionByRegionSet(regionName);
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "流量异常（行业）",notes = "根据行业获取流量异常的分析结果集入口")
    @ApiImplicitParam(name = "industryname",value = "行业名称",required = true,dataType = "String",paramType = "query",defaultValue = "火电")
    @RequestMapping(value = "/flowExceptionIndustrySet",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<FlowException> getFlowExceptionIndustrySet(@RequestParam(value = "industryname") String industryName){

        return dataExceptionAnalysisService.getFlowExceptionByIndustrySet(industryName);
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "流量异常企业信息",notes = "根据企业、排口和异常时间获取流量异常的分析结果集入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "psname",value = "企业名称",required = true,dataType = "String",paramType = "query",defaultValue = "北京市火电厂"),
            @ApiImplicitParam(name = "outputname",value = "排口名称",required = true,dataType = "String",paramType = "query",defaultValue = "总排口"),
            @ApiImplicitParam(name = "exceptiontime",value = "异常时间",dataType = "String",paramType = "query",defaultValue = "2016-06-05")
    })
    @RequestMapping(value = "/flowExceptionPSInfo",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<FlowException> getFlowExceptionPSInfo(@RequestParam(value = "psname") String psName,
                                                      @RequestParam(value = "outputname") String outputName,
                                                      @RequestParam(value = "exceptiontime",required = false) String exceptionTime){

        return dataExceptionAnalysisService.getFlowExceptionByPSInfoSet(psName,outputName,exceptionTime);
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "逻辑异常（地区）",notes = "根据地区获取逻辑异常的分析结果集入口")
    @ApiImplicitParam(name = "regionname",value = "地区名称",required = true,dataType = "String",paramType = "query",defaultValue = "北京市")
    @RequestMapping(value = "/logicExceptionRegionSet",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<LogicException> getLogicExceptionRegionSet(@RequestParam(value = "regionname") String regionName){

        return dataExceptionAnalysisService.getLogicExceptionByRegionSet(regionName);
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "逻辑异常（行业）",notes = "根据行业获取逻辑异常的分析结果集入口")
    @ApiImplicitParam(name = "industryname",value = "行业名称",required = true,dataType = "String",paramType = "query",defaultValue = "火电")
    @RequestMapping(value = "/logicExceptionIndustrySet",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<LogicException> getLogicExceptionIndustrySet(@RequestParam(value = "industryname") String industryName){

        return dataExceptionAnalysisService.getLogicExceptionByIndustrySet(industryName);
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "逻辑异常企业信息",notes = "根据企业、排口和异常时间获取逻辑异常的分析结果集入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "psname",value = "企业名称",required = true,dataType = "String",paramType = "query",defaultValue = "北京市火电厂"),
            @ApiImplicitParam(name = "outputname",value = "排口名称",required = true,dataType = "String",paramType = "query",defaultValue = "总排口"),
            @ApiImplicitParam(name = "exceptiontime",value = "异常时间",dataType = "String",paramType = "query",defaultValue = "2016-06-05")
    })
    @RequestMapping(value = "/logicExceptionPSInfo",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<LogicException> getLogicExceptionPSInfo(@RequestParam(value = "psname") String psName,
                                                        @RequestParam(value = "outputname") String outputName,
                                                        @RequestParam(value = "exceptiontime",required = false) String exceptionTime){

        return dataExceptionAnalysisService.getLogicExceptionByPSInfoSet(psName,outputName,exceptionTime);
    }


    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "过量空气系数异常（地区）",notes = "根据地区获取过量空气系数异常的分析结果集入口")
    @ApiImplicitParam(name = "regionname",value = "地区名称",required = true,dataType = "String",paramType = "query",defaultValue = "北京市")
    @RequestMapping(value = "/excessAirCoefficientRegionSet",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<ExcessAirCoefficient> getExcessAirCoefficientRegionSet(@RequestParam(value = "regionname") String regionName){

        return dataExceptionAnalysisService.getExcessAirCoefficientByRegionSet(regionName);
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "过量空气系数异常（行业）",notes = "根据行业获取过量空气系数异常的分析结果集入口")
    @ApiImplicitParam(name = "industryname",value = "行业名称",required = true,dataType = "String",paramType = "query",defaultValue = "火电")
    @RequestMapping(value = "/excessAirCoefficientIndustrySet",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<ExcessAirCoefficient> getExcessAirCoefficientIndustrySet(@RequestParam(value = "industryname") String industryName){

        return dataExceptionAnalysisService.getExcessAirCoefficientByIndustrySet(industryName);
    }

    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "过量空气系数异常企业信息",notes = "根据企业、排口和异常时间获取过量空气系数异常的分析结果集入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "psname",value = "企业名称",required = true,dataType = "String",paramType = "query",defaultValue = "西安火电厂"),
            @ApiImplicitParam(name = "outputname",value = "排口名称",required = true,dataType = "String",paramType = "query",defaultValue = "总排口"),
            @ApiImplicitParam(name = "exceptiontime",value = "异常时间",dataType = "String",paramType = "query",defaultValue = "2016-06-05")
    })
    @RequestMapping(value = "/excessAirCoefficientPSInfo",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<ExcessAirCoefficient> getExcessAirCoefficientPSInfo(@RequestParam(value = "psname") String psName, @RequestParam(value = "outputname") String outputName,
                                                                    @RequestParam(value = "exceptiontime",required = false) String exceptionTime){

        if(exceptionTime == null){
            logger.info("exceptionTime为null");
        }else {
            logger.info(exceptionTime);
        }
        return dataExceptionAnalysisService.getExcessAirCoefficientByPSInfoSet(psName,outputName,exceptionTime);
    }



    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没有设置好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "地区行业数据异常情况",notes = "根据地区和行业获取该地区该行业的数据异常情况信息入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "regionname",value = "地区名称",required = true,dataType = "String",paramType = "query",defaultValue = "北京市"),
            @ApiImplicitParam(name = "industryname",value = "行业名称",required = true,dataType = "String",paramType = "query",defaultValue = "火电"),
            @ApiImplicitParam(name = "starttime",value = "开始时间",required = true,dataType = "String",paramType = "query",defaultValue = "2016-06-01"),
            @ApiImplicitParam(name = "endtime",value = "结束时间",required = true,dataType = "String",paramType = "query",defaultValue = "2016-06-10")
    })
    @RequestMapping(value = "/exceptionOutlineInfo",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<ExceptionOutline> getExceptionOutlineInfo(@RequestParam(value = "regionname") String regionName, @RequestParam(value = "industryname") String industryName,
                                                          @RequestParam(value = "starttime" ) String startTime,@RequestParam(value = "endtime") String endTime){

        logger.info("获取地区行业异常情况");
        return dataExceptionAnalysisService.getExceptionOutline(regionName, industryName, startTime, endTime);
    }

}
