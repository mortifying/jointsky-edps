package com.jointsky.edps.mapper;

import com.jointsky.edps.model.EnvQty;

import java.util.List;


public interface EnvQtyMapper {
    public EnvQty findEnvQtyInfo(String name);

    public List<EnvQty> findEnvQtyInfos();
}

