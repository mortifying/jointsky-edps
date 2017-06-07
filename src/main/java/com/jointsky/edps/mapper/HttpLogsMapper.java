package com.jointsky.edps.mapper;

import com.jointsky.edps.model.HttpLogs;

/**
 * Created by root on 2017/6/7.
 */
public interface HttpLogsMapper {

    public void insertHttpLogs(HttpLogs httpLogs);

    public int getHttpLogsTotal();
}
