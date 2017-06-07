package com.jointsky.edps.service;

import com.jointsky.edps.mapper.HttpLogsMapper;
import com.jointsky.edps.model.HttpLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by root on 2017/6/7.
 */
@Service
public class HttpLogsService {

    @Autowired
    private HttpLogsMapper httpLogsMapper;


    public void saveHttpLogs(HttpLogs httpLogs){
        httpLogsMapper.insertHttpLogs(httpLogs);
    }

    public int queryHttpLogsTotal(){
        return httpLogsMapper.getHttpLogsTotal();
    }
}
