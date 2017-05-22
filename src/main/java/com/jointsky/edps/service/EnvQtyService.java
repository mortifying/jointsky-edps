package com.jointsky.edps.service;

import com.jointsky.edps.mapper.EnvQtyMapper;
import com.jointsky.edps.model.EnvQty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class EnvQtyService {

    @Autowired
    private EnvQtyMapper envQtyMapper;
    public EnvQty getEnvQtyInfo(String envParam){
        EnvQty envQty=envQtyMapper.findEnvQtyInfo(envParam);
        return envQty;
    }
    public List<EnvQty> getEnvQtyInfos(){
        List envQtys=envQtyMapper.findEnvQtyInfos();
        return envQtys;
    }

}
