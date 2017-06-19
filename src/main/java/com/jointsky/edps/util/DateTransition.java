package com.jointsky.edps.util;

/**
 * Created by root on 2017/6/16.
 */

public class DateTransition {


    public String monthToDate(String str){
        String year = str.substring(0,4);
        String month = str.substring(5,7);
        return year+"-"+month+"-01";
    }
}
