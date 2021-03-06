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

    public String quarterToDate(String str){
        String year = str.substring(0,4);
        String lastdate = str.substring(5);
        String quarter = null;
        if(lastdate.equals("第一季度")){
            quarter = year + "-03-31";
        }else if(lastdate.equals("第二季度")){
            quarter = year + "-06-30";
        }else if(lastdate.equals("第三季度")){
            quarter = year + "-09-30";
        }else {
            quarter = year + "-12-31";
        }

        return quarter;
    }

    public int quarterToNum(String str){

        int quarter = 1;
        if(str.equals("第一季度")){
            quarter = 1;
        }else if(str.equals("第二季度")){
            quarter = 2;
        }else if(str.equals("第三季度")){
            quarter = 3;
        }else {
            quarter = 4;
        }

        return quarter;
    }

    public int monthConvert(String str){

        String year = str.substring(0,4);
        String month = str.substring(5,7);
        return Integer.valueOf(year+month);
    }
}
