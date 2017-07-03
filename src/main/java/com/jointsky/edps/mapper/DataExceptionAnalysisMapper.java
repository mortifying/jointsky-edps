package com.jointsky.edps.mapper;

import com.jointsky.edps.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by root on 2017/6/5.
 */
public interface DataExceptionAnalysisMapper {

    public List<SteepRiseFall> getSteepRiseFallAll();

    public List<SteepRiseFall> getSteepRiseFallByPSInfo(String psName,String outputName,@Param(value = "exceptionTime") String exceptionTime);

    public List<IndustryStrengthException> getIndustryStrengthExceptionByRegion(String regionName);

    public List<IndustryStrengthException> getIndustryStrengthExceptionByIndustry(String industryName);

    public List<IndustryStrengthException> getIndustryStrengthExceptionByPSInfo(String psName,String outputName,@Param(value = "exceptionTime") String exceptionTime);

    public List<StrengthConstantValue> getStrengthConstantValueByRegion(String regionName);

    public List<StrengthConstantValue> getStrengthConstantValueByIndustry(String industryName);

    public List<StrengthConstantValue> getStrengthConstantValueByPSInfo(String psName,String outputName,@Param(value = "exceptionTime") String exceptionTime);

    public List<FlowConstantValue> getFlowConstantValueByRegion(String regionName);

    public List<FlowConstantValue> getFlowConstantValueByIndustry(String industryName);

    public List<FlowConstantValue> getFlowConstantValueByPSInfo(String psName,String outputName,@Param(value = "exceptionTime") String exceptionTime);

    public List<FlowException> getFlowExceptionByRegion(String regionName);

    public List<FlowException> getFlowExceptionByIndustry(String industryName);

    public List<FlowException> getFlowExceptionByPSInfo(String psName,String outputName,@Param(value = "exceptionTime") String exceptionTime);

    public List<LogicException> getLogicExceptionByRegion(String regionName);

    public List<LogicException> getLogicExceptionByIndustry(String industryName);

    public List<LogicException> getLogicExceptionByPSInfo(String psName,String outputName,@Param(value = "exceptionTime") String exceptionTime);

    public List<ExcessAirCoefficient> getExcessAirCoefficientByRegion(String regionName);

    public List<ExcessAirCoefficient> getExcessAirCoefficientByIndustry(String industryName);

    public List<ExcessAirCoefficient> getExcessAirCoefficientByPSInfo(String psName,String outputName,@Param(value = "exceptionTime") String exceptionTime);

    public List<ExceptionOutline> getExceptionOutlineByRegionIndustry(String regionName,String industryName,String startTime,String endTime);


}
