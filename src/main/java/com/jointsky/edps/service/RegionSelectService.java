package com.jointsky.edps.service;

import com.jointsky.edps.mapper.RegionSelectMapper;
import com.jointsky.edps.model.RegionSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by shilin on 2017/6/14.
 * 城市下拉列表业务层
 */
@Service
public class RegionSelectService {

    @Autowired
    private RegionSelectMapper regionSelectMapper;

    public List<RegionSelect> getRegionSelect(String regionCode) {

        String code = "";
        if(StringUtils.isEmpty(regionCode)){
            code = "0";
        } else {
            code = regionCode;
        }

        return regionSelectMapper.getRegionSelect(code);
    }
}
