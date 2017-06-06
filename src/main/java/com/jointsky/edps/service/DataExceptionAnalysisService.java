package com.jointsky.edps.service;

import com.jointsky.edps.mapper.DataExceptionAnalysisMapper;
import com.jointsky.edps.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by root on 2017/6/5.
 */
@Service
public class DataExceptionAnalysisService {

    @Autowired
    private DataExceptionAnalysisMapper dataExceptionAnalysisMapper;

    public List<SteepRiseFall> getSteepRiseFall(){
        return dataExceptionAnalysisMapper.getSteepRiseFallAll();
    }

    public List<SteepRiseFall> getSteepRiseFall(Long psCode,Long outputCode,String pollutantCode){
        return dataExceptionAnalysisMapper.getSteepRiseFallByPSInfo(psCode,outputCode,pollutantCode);
    }

    public List<IndustryStrengthException> getIndustryStrengthExceptionByRegionSet(String regionName){
        return dataExceptionAnalysisMapper.getIndustryStrengthExceptionByRegion(regionName);
    }

    public List<IndustryStrengthException> getIndustryStrengthExceptionByIndustrySet(String industryName){
        return dataExceptionAnalysisMapper.getIndustryStrengthExceptionByIndustry(industryName);
    }

    public List<StrengthConstantValue> getStrengthConstantValueByRegionSet(String regionName){
        return dataExceptionAnalysisMapper.getStrengthConstantValueByRegion(regionName);
    }

    public List<StrengthConstantValue> getStrengthConstantValueByIndustrySet(String industryName){
        return dataExceptionAnalysisMapper.getStrengthConstantValueByIndustry(industryName);
    }

    public List<StrengthConstantValue> getStrengthConstantValueByPSInfoSet(String psName,String outputName,String pollutantName){
        return dataExceptionAnalysisMapper.getStrengthConstantValueByPSInfo(psName,outputName,pollutantName);
    }

    public List<FlowConstantValue> getFlowConstantValueByRegionSet(String regionName){
        return dataExceptionAnalysisMapper.getFlowConstantValueByRegion(regionName);
    }

    public List<FlowConstantValue> getFlowConstantValueByIndustrySet(String industryName){
        return dataExceptionAnalysisMapper.getFlowConstantValueByIndustry(industryName);
    }

    public List<FlowConstantValue> getFlowConstantValueByPSInfoSet(String psName,String outputName){
        return dataExceptionAnalysisMapper.getFlowConstantValueByPSInfo(psName,outputName);
    }

    public List<FlowException> getFlowExceptionByRegionSet(String regionName){
        return dataExceptionAnalysisMapper.getFlowExceptionByRegion(regionName);
    }

    public List<FlowException> getFlowExceptionByIndustrySet(String industryName){
        return dataExceptionAnalysisMapper.getFlowExceptionByIndustry(industryName);
    }

    public List<FlowException> getFlowExceptionByPSInfoSet(String psName,String outputName){
        return dataExceptionAnalysisMapper.getFlowExceptionByPSInfo(psName,outputName);
    }

    public List<LogicException> getLogicExceptionByRegionSet(String regionName){
        return dataExceptionAnalysisMapper.getLogicExceptionByRegion(regionName);
    }

    public List<LogicException> getLogicExceptionByIndustrySet(String industryName){
        return dataExceptionAnalysisMapper.getLogicExceptionByIndustry(industryName);
    }

    public List<LogicException> getLogicExceptionByPSInfoSet(String psName,String outputName,String pollutantName){
        return dataExceptionAnalysisMapper.getLogicExceptionByPSInfo(psName,outputName,pollutantName);
    }

    public List<ExcessAirCoefficient> getExcessAirCoefficientByRegionSet(String regionName){
        return dataExceptionAnalysisMapper.getExcessAirCoefficientByRegion(regionName);
    }

    public List<ExcessAirCoefficient> getExcessAirCoefficientByIndustrySet(String industryName){
        return dataExceptionAnalysisMapper.getExcessAirCoefficientByIndustry(industryName);
    }

    public List<ExcessAirCoefficient> getExcessAirCoefficientByPSInfoSet(String psName,String outputName){
        return dataExceptionAnalysisMapper.getExcessAirCoefficientByPSInfo(psName,outputName);
    }
}
