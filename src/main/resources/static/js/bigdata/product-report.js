/**
 * Created by Administrator on 2017/6/18.
 */
(function ($) {
    $(document).ready(function () {

        $(".dt_year").datetimepicker({
            format: "yyyy",
            autoclose: true,
            todayBtn: true,
            todayHighlight: true,
            showMeridian: true,
            pickerPosition: "bottom-left",
            language: 'zh-CN',//中文，需要引用zh-CN.js包
            startView: 4,//年视图
            minView: 4//日期时间选择器所能够提供的最精确的时间选择视图
        });

        $(".dt_month").datetimepicker({
            format: "yyyy-mm",
            autoclose: true,
            todayBtn: true,
            todayHighlight: true,
            showMeridian: true,
            pickerPosition: "bottom-left",
            language: 'zh-CN',//中文，需要引用zh-CN.js包
            startView: 3,//月视图
            minView: 3//日期时间选择器所能够提供的最精确的时间选择视图
        });

        $(".dt_date").datetimepicker({
            format: "yyyy-mm-dd",
            autoclose: true,
            todayBtn: true,
            todayHighlight: true,
            showMeridian: true,
            pickerPosition: "bottom-left",
            language: 'zh-CN',//中文，需要引用zh-CN.js包
            startView: 2,//日视图
            minView: 2//日期时间选择器所能够提供的最精确的时间选择视图
        });

    })
})(jQuery);