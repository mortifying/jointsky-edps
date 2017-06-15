/**
 * 扩展easyui的验证
 */


var rulesConfig = {
    trueFalse:{
        validator:function(value,param){
            return param[0];
        },
        message: '非真即假'
    },
    compareNum:{
        validator: function (value, param) {
            if(($("#" + param[0]).val())!= ''){
                return Number(value) <= Number($("#" + param[0]).val());
            }
            return true;
        },
        message: "请输入合适的数字"
    },
    idcard: {// 验证身份证
        validator: function (value) {
            return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value);
        },
        message: '身份证号码格式不正确'
    },
    minLength: {
        validator: function (value, param) {
            return value.length >= param[0];
        },
        message: '请输入至少{0}个字符.'
    },
    length: {
        validator: function (value, param) {
            //var len = $.trim(value).length;
            var len = value.length;
            return len >= param[0] && len <= param[1];
        },
        message: "输入内容长度必须介于{0}和{1}之间."
    },
    faxno: {// 验证传真
        validator: function (value) {
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
        },
        message: '号码格式有误<br>例如010-88888888'
    },
    phone: {// 验证电话号码
        validator: function (value) {
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
        },
        message: '格式不正确,请使用下面格式:020-88888888'
    },
    mobile: {// 验证手机号码
        validator: function (value) {
            //return /^(13|14|15|18|17)\d{9}$/i.test(value);
            return /^[0-9]{11}$/i.test(value);
        },
        message: '号码格式有误<br>例如13300001111'
    },
    currency: {// 验证货币
        validator: function (value) {
            return /^\d+(\.\d+)?$/i.test(value);
        },
        message: '货币格式不正确'
    },
    decimal: {
        validator: function (value, param) {
            var regStr = "^\\d+(\\.\\d+)?$";
            if (param)
                regStr = "^\\+?(\\d*\\.\\d{" + param[0] + "})$";
            var reg = new RegExp(regStr);
            return reg.test(value);
        },
        message: '输入的数据格式不正确'
    },
    intOrFloat: {// 验证整数或小数
        validator: function (value, param) {
            var pattStr = "^\\d+(\\.\\d+)?$";
            if (param) {
                pattStr = "^\\d+(\\.\\d{0," + param[0] + "})?$";
            }
            return (new RegExp(pattStr)).test(value);
            //如果有参数则验证小数的保留位数,下面是原正则表达式
            //return /^\d+(\.\d+)?$/i.test(value);
        },
        message: '请输入数字，并确保格式正确'
    },
    integer: {// 验证整数
        validator: function (value, param) {
            var pattern = /^[0-9]+\d*$/i;
            if (param)
                pattern = new RegExp("^[0-9]\d{" + param[0] + "}$");
            return pattern.test(value);
        },
        message: '请输入整数'
    },
	numberOrFloat: {// 验证可以为负数整数或小数
        validator: function (value, param) {
            var pattStr = "^[\\-\\+]?\\d+(\\.\\d+)?$";
            if (param) {
                pattStr = "^[\\-\\+]?\\d+(\\.\\d{0,"+param[0]+"})?$";
            }
            return (new RegExp(pattStr)).test(value);
            //如果有参数则验证小数的保留位数,下面是原正则表达式
            //return /^\d+(\.\d+)?$/i.test(value);
        },
        message: '请输入数字，并确保格式正确'
    },
    number:{
        validator: function (value, param) {
            var pattern = /^-?[0-9]+\d*$/i;
            return pattern.test(value);
        },
        message: '请输入数字'
    },
    range: {
        validator: function (value, param) {
            var v1 = parseFloat(param[0]), v2 = parseFloat(value), v3 = parseFloat(param[1]);
            if (isNaN(v1) || isNaN(v2) || isNaN(v3)) {
                return false;
            }
            return (v1 <= v2 && v2 <= v3);
        },
        message: '请输入{0}到{1}之间的数字'
    },
    qq: {// 验证QQ,从10000开始
        validator: function (value) {
            return /^[1-9]\d{4,9}$/i.test(value);
        },
        message: 'QQ号码格式不正确'
    },
    age: {// 验证年龄
        validator: function (value) {
            return /^(?:[1-9][0-9]?|1[01][0-9]|120)$/i.test(value);
        },
        message: '年龄必须是0到120之间的整数'
    },
    chinese: {// 验证中文
        validator: function (value, param) {

            var pattern = new RegExp("^[\u4e00-\u9fa5]{" + param[0] + "," + param[1] + "}$");
            return pattern.test(value);
            //return /^[\Α-\￥]+$/i.test(value);
        },
        message: '请输入中文'
    },
    english: {// 验证英语
        validator: function (value) {
            return /^[A-Za-z]+$/i.test(value);
        },
        message: '请输入英文'
    },
    unnormal: {// 验证是否包含空格和非法字符
        validator: function (value) {
            return /.+/i.test(value);
        },
        message: '输入值不能为空和包含其他非法字符'
    },
    username: {// 验证用户名
        validator: function (value) {
            return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);
        },
        message: '用户名不合法（字母开头，允许6-16字节，允许字母数字下划线）'
    },
    address: {
        validator: function (value) {
            var reg = /^[< >]+$/;
            return !reg.test(value);//匹配是否含有特殊的字符
        },
        message: '只能输入包括汉字、字母、数字、符号'
    },
    ip: {// 验证IP地址
        validator: function (value) {
            return /d+.d+.d+.d+/i.test(value);
        },
        message: 'IP地址格式不正确'
    },
    name: {// 验证姓名，可以是中文或英文
        validator: function (value) {
            return /^[\Α-\￥]+$/i.test(value) | /^\w+[\w\s]+\w+$/i.test(value);
        },
        message: '请输入姓名'
    },
    date: {// 验证姓名，可以是中文或英文
        validator: function (value) {
            //格式yyyy-MM-dd或yyyy-M-d
            return /^(?:(?!0000)[0-9]{4}([-]?)(?:(?:0?[1-9]|1[0-2])\1(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])\1(?:29|30)|(?:0?[13578]|1[02])\1(?:31))|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)([-]?)0?2\2(?:29))$/i.test(value);
        },
        message: '请输入正确的<br>日期格式,<br>例如：2015-01-01。'
    },
    date1: {
        validator: function (value, param) {
            var reg = /\d{4}-\d{2}-\d{2}/;
            return !reg.test(value);
        },
        message: "时间格式不正确,例如：2016-12-22"
    },
    msn: {
        validator: function (value) {
            return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value);
        },
        message: '请输入有效的msn账号(例：abc@hotnail(msn/live).com)'
    },
    unequals: {
        validator: function (value, param) {
            if ($("#" + param[0]).val() != "" && value != "") {
                return $("#" + param[0]).val() != value;
            } else {
                return true;
            }
        },
        message: '两次输入不能一致'
    },
    equals: {
        validator: function (value, param) {
            if ($("#" + param[0]).val() != "" && value != "") {
                return $("#" + param[0]).val() == value;
            } else {
                return true;
            }
        },
        message: '两次输入的密码不一致！'
    },
    compareDate: {
        validator: function (value, param) {
            return dateCompare($(param[0]).datetimebox('getValue'), value); //注意easyui 时间控制获取值的方式
        },
        message: '开始日期不能大于结束日期'
    },
    linkMan: {
        validator: function (value, param) {
            var pattern = /^[\u4e00-\u9fa5]{2,4}$|^[a-zA-Z]{2,20}$/gi;
            return pattern.test(value);
        },
        message: "请输入2-4个汉字或者20个字母"
    },
    phoneMobile: {//手机或者固话
        validator: function (value, param) {
            var pattern = /(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(^((\(\d{3}\))|(\d{3}\-))?(1[358]\d{9})$)/;
            return pattern.test(value);
        },
        message: "号码格式有误<br>例如010-88888888或者13300001111"
    },
    postCode: {
        validator: function (value, param) {
            //var pattern = /^[1-9]\d{5}$/;
            var pattern = /^[0-9]\d{5}$/;
            return pattern.test(value);
        },
        message: "请输入格式正确的邮编"
    },
    product: {
        validator: function (value, param) {
            var pattern = new RegExp("^([\u4e00-\u9fa5]|[,]|[，]|[“]|[”]|[\"]|[\"]){" + param[0] + "," + param[1] + "}$");
            return pattern.test(value);
        },
        message: "请输入主要产品"
    },
    companyCode: {
        validator: function (value, param) {
            var pattern = new RegExp("[a-zA-Z0-9]{8}-[a-zA-Z0-9]");
            return pattern.test(value);
        },
        message: "请输入组织机构代码证"
    },
    organizCode: {
        validator: function (value, param) {
            //var pattern = new RegExp("[a-zA-Z0-9]{8}-[a-zA-Z0-9]");
            //修改
            var pattern = /^[a-zA-Z0-9]{8}-([1-9]{2}|([a-zA-Z0-9]{2}\([a-zA-Z0-9]*\)))$/;
            if (pattern.test(value)) {
                var reg = /\(.*?\)/;
                //如果结尾有(XX)
                if (value.match(reg)) {
                    var c1 = value.match(reg)[0].replace(/[( )]/g, '');
                    reg = /-[1-9]{2}/;
                    var c2 = value.match(reg)[0].replace(/-/, '');
                    return c1 == c2;
                }
                return true;
            }
            else
                return false;
        },
        message: "请输入组织机构代码证"
    },
    organizCodes: {
        validator: function (value, param) {
            var pattern = /(^[A-Z0-9]{8}-[A-Z0-9]{1}(\([A-Z0-9]{1,2}\)){0,1}$)|(^[A-Z0-9]{18}$)/;
            return pattern.test(value);
        },
        message: "请输入组织机构代码证"
    },
    flEmpty: {
        validator: function (value, param) {
            /* var reg = /^[ ]|[ ]$/gi;
             return !reg.test(value);*/
            //return !(/^\s+|\s+$/.test(value));
            return true;
        },
        message: "首尾不能有空格"
    },
    timeDiff: {//时间范围验证
        validator: function (value, param) {
            //validType:'timeDiff[]'
            if (param != undefined && param.length == 2) {
                try {
                    var d1 = null,
                        date = new Date(value.replace(/-/g, "/")),
                        d3 = null;
                    if (param[0] == 0) {//第一个参数=0 那么必须小于等于第二个参数
                        if (param[1] == "")
                            return true;
                        d3 = new Date(param[1].replace(/-/g, "/"));
                        rulesConfig.timeDiff.message = "您选择的时间必须大于等于{1}。";
                        return (date <= d3);
                    } else if (param[1] == 0) {//第二个参数=0 那么必须大于等于第一个参数
                        if (param[0] == "")
                            return true;
                        d1 = new Date(param[0].replace(/-/g, "/"));
                        rulesConfig.timeDiff.message = "您选择的时间必须大于等于{0}。";
                        return (date >= d1);
                    } else {
                        d1 = new Date(param[0].replace(/-/g, "/"));
                        d3 = new Date(param[1].replace(/-/g, "/"));
                        rulesConfig.timeDiff.message = "您选择的时间必须在{0}和{1}之间。";
                        return d1 <= date && date <= d2
                    }
                } catch (e) {
                    rulesConfig.timeDiff.message = "您选择的时间不正确。";
                    return false;

                }

                return false;
            }
            return true;

            /*  var d = new Date(value.replace(/-/g, "/"))
             var d1 = null;
             var d2 = null;
             if (param[0] != undefined && param[1] != undefined) {//两个都不为空的时候需要在时间之间
             d1 = new Date(param[0].replace(/-/g, "/"));
             d2 = new Date(param[1].replace(/-/g, "/"));
             return (d1 < d1 < d2);
             } else if (param[1] != undefined) {//第二个参数不为空,则需要时间小于参数
             d2 = new Date(param[1].replace(/-/g, "/"));
             return (d < d2);
             } else if (param[0] != undefined) {//第一个参数不为空,则需要时间大于参数
             d1 = new Date(param[0].replace(/-/g, "/"));
             return (d > d1);
             }
             return true;*/
        },
        message: "时间范围选择有误{0}{1}"
    },
    timeValDiff: {//时间范围验证
        validator: function (value, param) {
            var d1 = new Date(param[0].replace(/-/g, "/")),
                d2 = new Date(param[1].replace(/-/g, "/"));
            return d2 >= d1;
        },
        message: "时间范围选择有误{0}{1}"
    },
    less: {
        //验证当前项小于等于前几项的差
        validator: function (value, param) {
            if (param.length > 1) {
                //验证当前项小于等于前几项的差
                var total = 0;

                $.each(param, function (k, p) {
                    if (k == 0) {
                        total = Number($(p).val());
                    } else {
                        total = total - Number($(p).val());
                    }
                });
                return (total - Number(value)) > 0;
            }
            return Number(value) < Number($(param[0]).val());
        },
        message: "填写的数值必须小于{0}"
    },
    lessEq: {
        //验证当前项小于等于前几项的差
        validator: function (value, param) {
            if (param.length > 1) {
                //验证当前项小于等于前几项的差
                var total = 0;

                $.each(param, function (k, p) {
                    if (k == 0) {
                        total = Number($(p).val());
                    } else {
                        total = total - Number($(p).val());
                    }
                });
                return (total - Number(value)) >= 0;
            }
            return Number(value) <= Number($(param[0]).val());
        },
        message: "填写的数值必须小于{0}"
    },
    mdEq: {
        //验证当前项小于等于前几项的差
        validator: function (value, param) {

            return Number(value) >= Number($(param[0]).val());
        },
        message: "填写的数值必须小于{0}"
    },
    lessSum: {
        //验证当前项小于等于前几项的合
        validator: function (value, param) {
            if (param.length > 1) {
                //验证一项大于等其他几项
                var total = 0;

                $.each(param, function (k, p) {
                    total += Number($(p).val());
                });
                return Number(value) <= total;
            }
            return Number(value) <= Number($(param[0]).val());
        },
        message: "填写的数值必须小于{0}"
    },
    md: {
        validator: function (value, param) {
            var startTime2 = $(param[0]).datebox('getValue');
            var d1 = $.fn.datebox.defaults.parser(startTime2);
            var d2 = $.fn.datebox.defaults.parser(value);
            if (param[1] == 1)
                return d2 >= d1;
            return d2 > d1;
        },
        message: '结束时间要大于开始时间！'
    },
    mde: {
        validator: function (value, param) {
            var startTime2 = $(param[0]).val().replace(/-/g, '/');
            var d1 = new Date(startTime2);
            var d2 = new Date(value.replace(/-/g, '/'));
            if (param[1] == 1)
                return d2 >= d1;
            return d2 > d1;

        },
        message: '结束时间要大于开始时间！'
    },
    code: {
        validator: function (value, param) {
            //var reg=/<(\/?)(script|i?frame|div|p|b|font|table|td|th|strong|style|html|t?body|title|link|meta|t?head|br|h(1|2|3|4|5|6)|\?|%)([^>]*?)>/ig;
            var reg = /<([a-zA-Z]+)[^>]*>/ig;
            return !reg.test(value);
        },
        message: "您输入了非法危险字符"
    },
    bfbNum: {//百分比 只允许输入0或者1-100之间的数字
        validator: function (value, param) {
            if (param == undefined)
                param = [2];
            //先验证是否是浮点型
            if (rulesConfig.intOrFloat.validator(value, param)) {
                var n = parseFloat(value);
                if (n == 0 || (1 <= n && n <= 100))
                    return true;
                else
                    return false;
            }
            return false;
        },
        message: "请输入0或者1-100之间的数字"
    },
    mstEmpty: {
        validator: function (value, param) {
            //验证必须为空
            return value == "";
        },
        message: "不能输入"
    },
    danger: {
        validator: function (value, param) {
            //过滤英文：" ' ! % <script> <head>
            var pattern = new RegExp("^\"|\"$|[\!\_\^\']", "g");
            return !pattern.test(value) && rulesConfig.code.validator(value, param);
        },
        message: "不能输入% ! _"
    },
    letOrNumb: {
        validator: function (value, param) {
            var pattern = new RegExp("[a-zA-Z0-9]");
            if (param[0] == 1) {
                pattern = new RegExp("[A-Z0-9]");
            }
            return pattern.test(value);
        },
        message: "请输入字母或者数字"
    }

};


$.extend($.fn.validatebox.defaults.rules, rulesConfig);


var errconfig = {
    lenEmpty: function () {
        //必填非空且有长度限制的
        return "请输入{0}个以内的长度<br>（包括汉字、字母、数字、空格、符号）".format(arguments[0]);
    },
    rangeFloat: function () {
        if (arguments.length == 0)
            return "请输入数字";
        if (arguments.length == 1)
            return "请输入数字，<br>有小数保留{0}位".format(arguments[0]);
        if (arguments[2] == 'n')
            return "请输入{0}-{1}的数字".format(arguments[0], arguments[1]);
        //浮点型必填提示
        return "请输入{0}-{1}的数字，<br>有小数保留{2}位".format(arguments[0], arguments[1], (arguments[2] == undefined ? 2 : arguments[2]));
    },
    rangeInteger: function () {
        //整形范围必填提示
        return "请输入{0}-{1}以内的整数".format(arguments[0], arguments[1]);
    },
    Integer: "请输入整数",
    phoneMobile: "请输入联系方式(手机或者固话)",
    psMobile: function () {
        return "{0}为{1}个长度（不包括：!、_、%、^、\'等特殊字符）".format(arguments[0], arguments[1]);
    },
    comboMsg: function () {
        //选择下拉框
        return "请您选择一项{0}。".format(arguments[0]);
    },
    datebox: function () {
        //时间控件必选提示
        return "请您选择{0}。".format(arguments[0]);
    },
    tipMsg: function () {
        //普通的必填提示
        return "请输入{0}".format(arguments[0])
    },
    listGtValMsg: function () {
        //列表数据超过了规定的值
        return "{0}列表中的有效数据超过了{1}填写的<font color='red' size='+2'>{2}</font>,请您核对数据后再保存。".format(arguments[0], arguments[1], arguments[2])
    },
    bfbNum: function () {
        //百分比
        if (arguments.length == 0)
            return "请输入0或者1-100之间的数字,有小数保留2位。";
        return "请输入0或者1-100之间的数字,有小数保留{0}位。".format(arguments[0]);
    },
    condtion: function () {
        if (arguments.length > 1)
            return "{0}不允许超过{1}个长度<br>（不包括：!、_、%、^、\'等特殊字符）".format(arguments[0], arguments[1]);
        else
            return "{0}<br>（不包括：!、_、%、^、\'等特殊字符）".format(arguments[0], arguments[1]);
    },
    startTimeAlert:function(){
    return "开始时间必须小于或等于结束时间";
    },
    endTimeAlert:function(){
        return "结束时间必须大于或等于开始时间";
    }
};
