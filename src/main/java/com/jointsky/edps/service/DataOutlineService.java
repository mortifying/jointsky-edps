package com.jointsky.edps.service;

import com.jointsky.edps.mapper.DataOutlineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by root on 2017/6/8.
 */
@Service
public class DataOutlineService {

    @Autowired
    private DataOutlineMapper dataOutlineMapper;

    public int dataRecordNum(){
        return dataOutlineMapper.getTotalDataRecordNum();
    }
}
