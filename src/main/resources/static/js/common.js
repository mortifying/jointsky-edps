(function (w) {
    if (!w.location.origin) {
        w.location.origin = w.location.protocol + "//" + w.location.hostname + (w.location.port ? ':' + w.location.port : '');
    }
}(window));

var ajaxConfig = {
    //建议将此值修改成为POST避免缓存
    reqMtd: "GET",
    //成功标识字段
    successField: "status",
    //消息字段
    messageField: "msg",
    successValue: "101"
};

Public = {
    post: function (url, param, callback) {
        $.ajax({
            url: url,
            type: "POST",
            data: param,
            dataType: "json",
            success: function (data) {
                if ((data[ajaxConfig.successField] == ajaxConfig.successValue)) {
                    callback(data);

                }
                else {
                    alert(data[ajaxConfig.messageField]);
                    return false;
                }


            },
            error: function (msg) {
                //alert(msg);
            }
        });

    },
    get: function (url, param, callback) {

        $.ajax({
            url: url,
            type: "get",
            data: param,
            dataType: "json",
            success: function (data) {
                if ((data[ajaxConfig.successField] == ajaxConfig.successValue)) {
                    callback(data);

                }
                else {
                    alert(data[ajaxConfig.messageField]);
                    return false;
                }

            },
            error: function (msg) {
                //alert(msg);
            }
        });

    },
    /**
     *此方法使用于ajax提交上传文件，依赖jquery.form.js
     *利用jquery.form提交form表单
     * @param config
     */
    ajaxForm: function (config) {
        var _default = {
            url: "",
            form: null,//form选择器，或者jquery对象
            beforeSubmit: function (formdata, form, options) {

            },
            showLoading: true,
            success: function (response) {

            }
        };

        $.extend(_default, config);
        if (!_default.param)
            _default.param = $(_default.form).serializeJson();
        //判断是否是选择器
        if (typeof _default.form == "string")
            _default.form = $(_default.form);

        var loading;
        if (_default.showLoading)
            loading = Public.showLoading();
        //设置表单属性
        $(_default.form).prop({
            "method": "post",
            "enctype": "multipart/form-data"
        });
        //设置事件源的type位submit
        $(this.ajaxForm.caller.arguments[0].target).prop("type", "submit");

        //开始提交表单
        $(_default.form).ajaxSubmit({
            url: _default.url,
            type: "post",
            dataType: "json",
            beforeSubmit: function (formdata, form, options) {
                return _default.beforeSubmit.call(this, formdata, form, options);
            },
            success: function (response) {
                if (loading)
                    loading.hide();
                _default.success(response);
            },
            error: function (data) {
                if (loading)
                    loading.hide();
                Public.alert("操作提示", "操作失败", "info");
            }
        });
        return false; // 阻止表单自动提交事件
    },
    guid: function () {
        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
            var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
            return v.toString(16);
        });
    },
    /**
     /**
     * 次函数不适应在窗口嵌套,如果需要嵌套，则需要重新配置一个id就行了。例如
     * importExcel({
 *      width: 700,
 *      height: 300,
 *      title: "窗口1",
 *      okText: "保&nbsp;&nbsp;存",
 *      okCallback: function () {
 *          importExcel({
 *              id:guid(),
 *              width: 700,
 *              height: 300,
 *              title: "窗口2",
 *              okText: "保&nbsp;&nbsp;存",
 *              okCallback: function () {
 *
 *              }
 *          });
 *      }
 *  })
     * 文件导入
     * opt{url,callback}
     * @opt{
 * url 嵌入页面地址
 * title 窗口标题
 * onClose 窗口关闭事件
 * okCallback 点击确定事件回调，
 * width 窗口宽度
 * height 窗口高度
 * showbtns ：是否显示按钮
 * cancelText 取消按钮文字
 * okText 确定按钮文字
 * }
     */
    openWindow: function (opt) {
        var _default = {
            "id": "window-cdtrkxab",
            param: {},
            url: null,
            content: null,
            okCallback: function () {
                //alert(1);
            },
            onClose: function () {

            },
            onInit: function () {

            },
            onLoad: function () {

            },
            isFrame: false,
            method: ajaxConfig.reqMtd,
            width: 450,
            height: 400,
            title: "标题",
            resizable: false,
            showHead: true,
            closable: true,
            showbtns: true,
            cancelText: "取消",
            okText: "确定"
        };
        var options = $.extend(_default, opt);

        var start = {
            getTemplate: function () {

                if (options.isFrame) {
                    options.frameId = Public.guid().replace(/-/g, '');
                    options.content = "<div style='width:100%;height:100%;overflow:hidden;'><iframe id='frame_" + options.frameId + "' name='frame_" + options.frameId + "' src='about:blank' frameborder='0' marginwidth='0' marginheight='0' scrolling='yes' style='margin:0px;padding:0px;width:100%;height:100%;overflow: hidden;border:none;background:transparent;visibility: hidden' allowtransparency='true'></iframe></div>";
                }

                var html = [];
                html.push('<div id="' + options.id + '" data-options="closed:false" style="width:450px;height:400px;">');
                html.push('    <div class="ui-layout layout-cdtrkxab" data-options="fit:true,border:false">');
                html.push('        <div data-options="region:\'center\',style:{overflow:\'hidden\'}">');
                if (!isNullOrEmpty(options.content))
                    html.push(options.content);
                html.push('        </div>');

                if (options.showbtns) {
                    html.push('        <div style="height:55px;overflow:hidden;text-align: right;border:none;" data-options="region:\'south\',height:40,border:false">');
                    html.push('            <div  class="south center mt10" style="display:none"><button type="button" class="bt-red btn-sm mr10 ok">' + options.okText + '</button>');
                    html.push('            <button type="button" class="bt-Wgray btn-sm mr10 cancel">' + options.cancelText + '</button></div>');
                    html.push('        </div>');
                }
                html.push('    </div>');
                html.push('</div>');
                return html.join('');
            },
            create: function () {
                var winTemplate = this.getTemplate();
                var target = this.getWindow();
                var window;
                if (target) {
                    window = $(target).html($(winTemplate).html());
                }

                else {

                    window = $(winTemplate).appendTo("body");
                    window.window({
                        title: options.title,
                        width: options.width,
                        height: options.height,
                        modal: true,
                        shadow: true,
                        draggable: true,
                        minimizable: false,
                        collapsible: false,
                        maximizable: false,
                        resizable: options.resizable,
                        closed: true,
                        closable: options.closable,
                        noheader: !options.showHead
                    });
                }


                $.parser.parse(window);

                //如果是iframe，且配置了url
                if (options.isFrame && options.url) {
                    var frameLoading = Public.showLoading({
                        target: window.children().get(0),

                    });

                    //把url参数转换成Object
                    var parseQueryString = function (url) {
                        var reg_url = /^[^\?]+\?([\w\W]+)$/,
                            reg_para = /([^&=]+)=([\w\W]*?)(&|$)/g, //g is very important
                            arr_url = reg_url.exec(url),
                            ret = {};
                        if (arr_url && arr_url[1]) {
                            var str_para = arr_url[1], result;
                            while ((result = reg_para.exec(str_para)) != null) {
                                ret[result[1]] = result[2];
                            }
                        }
                        return ret;
                    };

                    //合并url参数和param配置参数
                    var _param = $.extend({}, parseQueryString(options.url), options.param);
                    //重新处理URL
                    var url = options.url;
                    if (url.indexOf('?') != -1)
                        url = url.substring(0, url.indexOf('?')) + "?" + $.param(_param);

                    this.frame = window.find('#frame_' + options.frameId).load(function () {
                        $(this).css("visibility", "visible").fadeIn();
                        frameLoading.hide();
                        options.onLoad();
                    }).prop('src', url);

                }

                //绑定事件
                $(window).find(".cancel").off().on("click", function (e) {
                    e.preventDefault();
                    setTimeout(function () {
                        $("#" + options.id).window("close");
                    });
                });

                $(window).find(".ok").off().on("click", function (e) {
                    e.preventDefault();
                    setTimeout(function () {
                        options.okCallback.apply(window, []);
                    });
                });

                //合并属性
                $.extend(window.window("options"), {
                    queryParams: options.param,
                    method: options.method,
                    onOpen: function () {
                        setTimeout(function () {
                            options.onInit();
                        }, 200);
                        if (options.showbtns)
                            window.find(".south").fadeIn(200);
                    },
                    onClose: function () {
                        options.onClose();
                    }
                });

                window.window("setTitle", options.title);
                window.window("resize", {
                    width: options.width,
                    height: options.height
                });
                window.window("open").window("center");
                var centerPanel = window.find(".layout-cdtrkxab").layout('panel', 'center').css('overflow-x', 'hidden');

                $.extend(centerPanel.panel("options"), {
                    queryParams: options.param,
                    onLoad: function () {
                        options.onLoad();
                    }
                });

                if (!isNullOrEmpty(options.url) && !options.isFrame) {
                    window.find(".layout-cdtrkxab").layout('panel', 'center').panel("refresh", options.url);
                }

                return {
                    iframe: this.frame,
                    window: window,
                    close: function () {
                        window.window('close');
                    },
                    reload: function (url) {
                        if (!options.isFrame)
                            window.find(".layout-cdtrkxab").layout('panel', 'center').panel("refresh", (!url ? options.url : url));
                        else {
                            this.frame.prop('src', (!url ? this.frame.prop('src') : url));
                        }
                    }
                }

            },
            getWindow: function () {
                return document.getElementById(options.id);
            }
        }

        return start.create();

    },
    /**
     * 展示一个等待提示框
     *@param["target"]: "body", //需要展示的遮罩的目标
     *@param["cssName"]: "_showloading", //class名称，可以自定义class
     *@param["loadingImg"]: "/static/themes/bd/ui-images/loading.gif", //遮罩图片的路径
     *@param["loadingText"]: "数据正在加载,请稍后...", //提示层的提示文字
     *@param["hideCall"]: null, //关闭回调函数
     *@param["timeout"]: 0 //是否自动关闭
     * @returns {ShowLoading}
     * @constructor
     */
    showLoading: function (opt) {
        var loading = new ShowLoading(opt);
        loading.show();
        return loading
    },
    //信息提示
    alert: function (title, msg, icon, onClose) {
        var ico = "info";
        var icons = ["info", "warning", "error", "question"];
        if (typeof icon == "number" && icons[(icon - 1)]) {
            ico = icons[(icon - 1)];
        }
        else {
            ico = icon;
        }

        $.messager.alert({title: title, msg: msg, icon: ico, onClose: onClose});
    },
    //确认提示
    confirm: function (title, msg, ok, cancel) {
        $.messager.confirm(title, msg, function (yes) {
            if (yes) {
                if (typeof ok == "function")
                    ok();
            }

            else {
                if (typeof cancel == "function")
                    cancel();
            }

        });
    },
    //带输入的确认提示
    prompt: function (title, msg, ok) {
        $.messager.prompt(title, msg, function (r) {
            if (r) {
                ok(r);
            }
        });


    },
    //自动消失提示框
    tips: function (title, msg, onClose, timeout) {
        var _timeout = (timeout == null ? 1500 : timeout);
        $.messager.show({
            title: title,
            msg: msg,
            timeout: _timeout,
            showType: 'fade',
            style: {
                right: '',
                bottom: ''
            }
        });
        setTimeout(function () {
            if (typeof onClose == "function") {
                onClose();
            }
        }, _timeout);


    }

};


var gridHelper = {
    appendRow: function (target, row) {
        var removeRow = false;
        if (target.datagrid("getRows").length == 0) {
            target.datagrid("loadData", {"total": 0, "rows": [[]]});
            removeRow = true;
        }
        if (!row)
            row = {"id": guid()};
        row.isCreate = true;
        target.datagrid('appendRow', row);
        if (removeRow) {
            target.datagrid('deleteRow', 0);
        }

    }
};


if (window["context"] == undefined) {
    window["context"] = location.origin;
}



//release Application 将下面的值修改为false
var VocDebug = false;
/*====================配置结束==================*/

//把mydate97时间插件集成jquery插件
(function ($) {

    $.fn.mydatePicker = function (options) {
        return this.each(function (i, target) {


            var opt = $.fn.validatebox.parseOptions(this, [{
                border: 'boolean',
                required: 'boolean',
                dateFmt: 'string'
            }]);

            //兼容老版本(VOC的写法)
            var _fmt = $(target).data('fmt');
            if (_fmt) opt.dateFmt = _fmt;

            var opts = $.extend({}, $.fn.mydatePicker.defaults, opt, options);


            $(target).validatebox(opts);

            opts.el = $(target).get(0);

            $(target).off("focus").on("focus", function (e) {

                if ($(target).attr("readonly")) {
                    setTimeout(function () {
                        $(target).trigger("mouseenter");
                    }, 200);
                    return;
                }
                var _d = $.data(e.target, "validatebox");
                var _e = $(e.target);
                _d.validating = true;
                _d.value = undefined;
                (function () {
                    if (_d.validating) {
                        if (_d.value != _e.val()) {
                            _d.value = _e.val();
                            if (_d.timer) {
                                clearTimeout(_d.timer);
                            }
                            _d.timer = setTimeout(function () {
                                $(e.target).validatebox("validate");
                            }, _d.options.delay);
                        } else {
                            //_f(e.target);
                        }
                        setTimeout(arguments.callee, 200);
                    }
                })();
            });


            opts.onpicked = opts.oncleared = function () {
                $(target).validatebox("validate");
                opts.onSelected();
            };


            $(target).prop("readonly", opts.readOnly);

            //绑定
            $(target).unbind("click").bind("click", function (e) {
                e.preventDefault();
                e.stopPropagation();
                WdatePicker(opts);
            });
        })
    }
    $.fn.mydatePicker.defaults = {
        missingMessage: "请选择时间",
        required: false,
        autoUpdateOnChanged: true,
        autoPickDate: true,
        isShowClear: true,
        readOnly: true,
        isShowOK: true,
        dateFmt: 'yyyy-MM-dd',
        ychanged: function () {

        },
        Mchanged: function () {

        },
        dchanged: function () {

        },
        Hchanged: function () {

        },
        schanged: function () {

        },
        onSelected: function () {

        },
        oncleared: function () {

        }
    };
    //自动创建
    $(document).ready(function () {
        $('.mydate').mydatePicker();
    });

})(jQuery);


//把mydate97时间插件集成双日历jquery插件
(function ($) {
    $.fn.mydoublePicker = function (opt, arg) {


        if (typeof opt == "string") {
            var _24 = $.fn.mydoublePicker.methods[opt];
            if (_24) {
                return _24(this, arg);
            }
            else {
                return this.mydoublePicker(opt, arg);
            }
        }


        return this.each(function () {

            var p = $.fn.combo.parseOptions(this, ['width', 'height', 'panelWidth', 'panelHeight', 'panelHeight', {
                border: 'boolean'
            }, {min: 'number'}]);
            var config = $.extend({}, $.fn.mydoublePicker.defaults, p, opt);


            $.data(this, "mydoublePicker", {options: config});


            var combodate = $(this).combo({
                hasDownArrow: false,
                editable: false,
                height: config.height,
                width: config.width,
                panelWidth: config.panelWidth,
                panelHeight: config.panelHeight,
                onShowPanel: function () {
                    if (!this.isCreate) {
                        WdatePicker({
                            //startDate: "2017-04-05",
                            dateFmt: 'yyyy-MM-dd',
                            eCont: "star_date_" + starId,
                            onpicked: function (dp) {
                                $("#star_" + starId).val(dp.cal.getDateStr());

                            }
                        });
                        WdatePicker({
                            //startDate: "2017-09-25",
                            dateFmt: 'yyyy-MM-dd',
                            eCont: "end_date_" + endId,
                            onpicked: function (dp) {
                                $("#end_" + endId).val(dp.cal.getDateStr());
                            }
                        });
                        setTimeout(function () {
                            var WdateDivs = body.find("iframe").css({margin: "3px"});
                        }, 100);
                        this.isCreate = true;
                    }

                }
            });
            var panel = $(this).combo("panel");
            var starId = Public.guid(), endId = Public.guid();
            var dateHtml = "";
            dateHtml += '<div id="panel1" style="width:382px;">';
            dateHtml += '    <div style="margin: 10px 0px 0px 0px">';
            dateHtml += $.format('&nbsp;从&nbsp;<input id="star_{0}" type="text" class="textBox" style="width:85px;" readonly>&nbsp;{1}&nbsp;', starId, config.splitChar);
            dateHtml += $.format('<input id="end_{0}" type="text" class="textBox" style="width:85px;" readonly>&nbsp;', endId);
            dateHtml += '        <input type="button" value="清&nbsp;空" class="bt_yellow  doubletime-clear" style="margin-left:30px;width:60px;min-width:60px;padding:0px 5px;" /><input type="button" value="确&nbsp;定" class="bt_blue doubletime-ok" style="margin-left:5px;width:60px;min-width:60px;padding:0px 5px;" />';
            dateHtml += '    </div>';
            dateHtml += '    <div style="margin: 10px 0px 0px 0px">';
            dateHtml += $.format('<div id="star_date_{0}" style="float:left;"></div>', starId);
            dateHtml += $.format('<div id="end_date_{0}" style="float:left;"></div>', endId);
            dateHtml += '        <div style="clear:both"></div>';
            dateHtml += '    </div>';
            dateHtml += '</div>';
            var body = panel.panel("body").html(dateHtml).css("overflow", "hidden");
            body.find('.doubletime-ok').click(function (e) {
                var _value = $.format('{0}{2}{1}', $("#star_" + starId).val(), $("#end_" + endId).val(), config.splitChar);
                var r = config.onSelect(_value);
                if (r != false) {
                    combodate.mydoublePicker("setValue", _value);
                }
            });
            body.find('.doubletime-clear').click(function (e) {
                combodate.mydoublePicker("clear");
            });
        });
    };

    $.fn.mydoublePicker.defaults = {
        missingMessage: "请选择时间",
        required: false,
        splitChar: "至",
        editable: false,
        height: 32,
        width: 200,
        panelWidth: 382,
        panelHeight: 240,
        onSelect: function () {

        }
    };

    $.fn.mydoublePicker.methods = {
        options: function (jq) {
            return $.data(jq[0], "mydoublePicker").options;
        },
        setValue: function (jq, value) {
            return jq.each(function () {
                $(this).combo("setText", value);
                $(this).combo("setValue", value);
                $(this).combo("hidePanel");
            });
        },
        getValue: function (jq) {
            return $(jq).combo("getValue");
        },
        clear: function (jq) {
            return jq.each(function () {
                $(this).combo("panel").find(":text").val("");
                $(this).combo("clear");
                $(this).combo("hidePanel");
            });
        }
    }
    //自动创建
    $(document).ready(function () {
        $(".mydoubledate").mydoublePicker();
    });

})(jQuery);

/*
 *扩展jquery 字符串format函数
 */
(function ($) {
    $.format = function (source, params) {
        if (arguments.length == 1)
            return function () {
                var args = $.makeArray(arguments);
                args.unshift(source);
                return $.format.apply(this, args);
            };
        if (arguments.length > 2 && params.constructor != Array) {
            params = $.makeArray(arguments).slice(1);
        }
        if (params.constructor != Array) {
            params = [params];
        }
        $.each(params, function (i, n) {
            source = source.replace(new RegExp("\\{" + i + "\\}", "g"), n);
        });
        return source;
    };
}(jQuery));


/**
 * datagrid 长字段显示tips
 * @param value
 * @param row
 * @param index
 * @returns {string}
 */
function gridShowTips(value, row, index, length) {
    if (!value)
        return "";
    var val = htmlEncode(String(value));
    return "<div class='remark-toolstip' style='overflow: hidden;white-space: nowrap;text-overflow: ellipsis;'>" + val + "</div>";
}


$(document).ready(function () {





    //给气泡绑定初始化
    $(document).on('mouseover mouseout', '.datagrid-cell', function (e) {
        if ($(this).find(".remark-toolstip").length > 0) {
            if (e.type == 'mouseover') {
                $(this).tooltip({
                    position: 'bottom',
                    content: $(this).find('.remark-toolstip').html().replace(/\n/g, "<br />"),
                    onShow: function (et) {

                    }
                }).tooltip('show');
            } else {
                $('.remark-toolstip').tooltip('hide');
            }
        }
    });

});


(function ($) {

    if ($.parser) {
        /**
         * 重写easyui alert组件
         */
        $.extend($.messager.defaults, {
            width: 350,
            onOpen: function () {
                //设置默认图标
                if ($(this).window('body').find("div:eq(0)").attr("class") == "")
                    $(this).window('body').find("div:eq(0)").attr("class", "messager-icon messager-info");
                //给提示文字添加一个class
                if ($(this).window('body').find('.messager-icon').length > 0) {
                    if (!$(this).window('body').find('.messager-icon').next('div').hasClass('messager-text')) {
                        $(this).window('body').find('.messager-icon').next('div').addClass('messager-text');
                    }
                    //用块级元素来计算文本宽度，用来自适应居中显示
                    var sp_title = $("<span />", {text: $(this).text(), style: 'display:none'}).appendTo(this);
                    var text_width = sp_title.width();
                    var icon_width = $(this).window('body').find('.messager-icon').width() + $(this).window('body').find('.messager-icon').position().left;
                    if (text_width >= 200) {
                        text_width = 200;
                        $(this).window('body').find('.messager-text').css('marginLeft', parseInt((350 - 200 + icon_width) / 2) + 'px');
                    }
                    //等待panel构建完成获取文本的高度，让图标在文本高度的居中显示
                    var _this = this;
                    setTimeout(function () {
                        var text_height = $(_this).find('.messager-text').outerHeight();
                        //alert(text_height);
                        if (text_height > 32) {
                            $(_this).window('body').find('.messager-icon').css('top', parseInt((text_height - 32) / 2) + 'px');
                        }
                        $(_this).window('body').find('.messager-icon').show();
                    }, 200);
                    $(this).window('body').find('.messager-text').css('width', text_width + 'px');
                    //让图标在提示文本的相对位置显示
                    $(this).window('body').find('.messager-icon').prependTo($(this).window('body').find('.messager-text').get(0));
                }
            }
        });

        /**
         * 重写window的默认值
         */
        $.extend($.fn.window.defaults, {
            collapsible: false,
            minimizable: false,
            maximizable: false,
            closed: true,
            draggable: false,
            resizable: false
        });

        $.extend($.fn.combobox.defaults, {
            onHidePanel: function () {
                if ($(this).combobox("options").editable)
                    onComboboxHidePanel.call(this, null);
            }
        });
    }


})(jQuery);


/**
 * description:获取URL的参数的value
 *@name：参数名称
 */
function getUrlParam(name, url) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if (r != null) return unescape(r[2]);
    return null; //返回参数值
}


/**
 * 将url参数转换成JSON
 * @param param
 * @returns {{}}
 */
function urlToJson(url) {
    if (!url)
        url = window.location.href.substring(window.location.href.indexOf("?") + 1, window.location.href.length);

    var obj = {};
    var keyvalue = [];
    var key = "",
        value = "";
    var paraString = url.split("&");
    for (var i in paraString) {
        if (paraString.hasOwnProperty(i)) {
            keyvalue = paraString[i].split("=");
            key = keyvalue[0];
            value = keyvalue[1];
            obj[key] = value;
        }
    }
    return obj;
}
/**
 *检测是否是空值
 * @param data
 * @returns {boolean}
 */
function isNullOrEmpty(data) {

    return (data == "" || data === undefined || data === null);
}


/**
 * description：阻止事件冒泡
 * time：2015/06/16
 * @param e：事件的对象
 */
function stopPropagation(e) {
    window.event ? window.event.cancelBubble = true : e.stopPropagation();
    window.event ? window.event.returnValue = false : e.preventDefault();
}

/**
 * =======================================================================
 ***--------------------------加载一个等待提示框--------------------------
 * =======================================================================
 * 配置项：｛｝
 *@target: "body",//需要展示的遮罩的对象
 *@cssName: "_showloading",//class名称，可以自定义class
 *@loadingImg: "/static/themes/bd/ui-images/loading.gif",//遮罩图片的路径
 *@loadingText: "数据正在加载,请稍后...",//提示层的提示文字
 *@hideCall: null,//关闭回调函数
 *@timeout: 0//是否自动关闭
 * @param {Object} {target:'',cssName:'',loadingImg:'',loadingText:''}
 */
function ShowLoading(opt) {
    //默认配置项
    var _default = {
        "target": "body", //需要展示的遮罩的目标
        "cssName": "_showloading", //class名称，可以自定义class
        "loadingImg": location.origin + "/static/themes/images/loading.gif", //遮罩图片的路径
        "loadingText": "数据正在加载,请稍后...", //提示层的提示文字
        "hideCall": null, //关闭回调函数
        "timeout": 0 //是否自动关闭
    };
    $.extend(this, _default, opt);
    if (typeof this.target == "string")
        this.target = $(this.target);

    var me = this;
    var isBody = $(me.target).prop("nodeName") == "BODY";
    //获取目标的大小
    var getSize = function () {

        var scrollTop = isBody ? $(window).scrollTop() : $(me.target).scrollTop();
        var scrollLeft = isBody ? $(window).scrollLeft() : $(me.target).scrollLeft();
        //var w = isBody ? (scrollLeft+$(window).width()) : (scrollLeft+$(me.target).width());
        //var h = isBody ? (scrollTop + $(window).height()) : (scrollTop + $(me.target).height());
        var w = isBody ? ($(window).width()) : ($(me.target).width());
        var h = isBody ? ($(window).height()) : ($(me.target).height());
        return {width: w, height: h, scrollTop: scrollTop, scrollLeft: scrollLeft};
    }
    var setPsIntv;
    var $loading;
    this.show = function (msg, callBack) {

        if (!$loading) {
            this.loadingId = "_load" + (new Date()).valueOf();
            if (!isBody)
                $(me.target).css("position", "relative");
            $loading = $("<div>", {
                "id": this.loadingId,
                "class": this.cssName,
                //"style": "border:1px solid red",
                "html": "<div class='" + this.cssName + "-msg'  style='background-image:url(" + this.loadingImg + ");background-repeat: no-repeat;background-position: 5px 10px;text-indent:25px;'>" + this.loadingText + "</div>"
            }).appendTo(this.target);
            var setPostion = function () {
                $loading.css({
                    // width: getSize().width + "px",
                    width: getSize().width + "px",
                    height: getSize().height + "px",
                    top: getSize().scrollTop + "px",
                    left: getSize().scrollLeft + "px"
                });
                var sefWidth = $loading.children().width(),
                    sefHeight = $loading.children().height();
                $loading.children().css({
                    "top": function () {
                        return parseInt((getSize().height - sefHeight) / 2) + "px"
                    },
                    "left": function () {
                        return parseInt((getSize().width - sefWidth) / 2) + "px"
                    }
                })

            }

            setPsIntv = setInterval(function () {
                setPostion();
            }, 50);


        }
        if (msg) {
            this.loadingText = msg;
            $loading.children().text(msg);
        }


        //是否有回调函数
        if (callBack != undefined && typeof callBack == "function") {
            this.hideCall = callBack;
        }
        //是否是定时关闭
        if (this.timeout > 0) {
            setTimeout(function () {
                me.hide();
            }, this.timeout);
        }
        return this;
    };
    this.hide = function () {
        if ($loading) {
            $loading.remove();
            $loading = null;
        }
        if (typeof this.hideCall == "function") {
            this.hideCall();
        }
        if (setPsIntv)
            clearInterval(setPsIntv);
    };
}
/**
 * Html编码获取Html转义实体
 * @param value
 * @returns {string}
 */
function htmlEncode(value) {
    if (typeof value != "string") {
        return value;
    }
    if (value.length == 0) return "";
    var s = value;
    s = s.replace(/&/g, "&amp;");
    s = s.replace(/</g, "&lt;");
    s = s.replace(/>/g, "&gt;");
    s = s.replace(/ /g, "&nbsp;");
    s = s.replace(/\'/g, "&#39;");
    s = s.replace(/\"/g, "&quot;");
    return s;
}


/**
 * Html解码获取Html实体
 * @param value
 * @returns {string}
 */
function htmlDecode(value) {
    if (typeof value != "string") {
        return value;
    }
    if (value.length == 0) return "";
    var s = value;
    s = s.replace(/&amp;/g, "&");
    s = s.replace(/&lt;/g, "<");
    s = s.replace(/&gt;/g, ">");
    s = s.replace(/&nbsp;/g, " ");
    s = s.replace(/&#39;/g, "\'");
    s = s.replace(/&quot;/g, "\"");
    return s;
}

//Html编码获取Html转义实体
function jQhtmlEncode(value) {
    return $('<div/>').text(value).html();
}
//Html解码获取Html实体
function jQhtmlDecode(value) {
    return $('<div/>').html(value).text();
}


/**
 * 开始一个ajax请求
 * @param 请求路径
 * @param 请求方式POST GET
 * @param 请求数据(object){}
 * @param 请求回调
 * @constructor
 */
function JqAjax(url, method, param, callback, target) {
    //如果没有指定target 默认是body
    if (typeof target == "undefined") {
        target = "body";
    }
    var load = new ShowLoading({
        "target": target
    });
    if (target)
        load.show();
    $.ajax({
        url: url,
        type: method,
        data: param,
        dataType: "json",
        global: false,
        success: function (data) {
            load.hide();
            if (data.result && data.result == "failed") {
                if (typeof data.targetUrl != "undefined")
                    top.location.href = data.targetUrl;
                else
                    $.messager.alert("操作提示", "操作失败", 'error');
            } else {
                if (typeof callback == "function") {
                    callback.call(this, data);
                }
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            load.hide();
            alert('当前出现错误');
        }
    });
}

/**
 * 构造年份下拉列表
 * @returns {Array}
 */
function setYear() {
    if (typeof currTime == "undefined") {
        currTime = '2016-05-20';
    }
    currTime.replace(/-/g, '/');
    var curYear = (new Date(currTime)).getFullYear(),
        _opt = [];
    _opt.push({
        "text": curYear + "年",
        "Value": curYear,
        "selected": true
    });
    for (var i = 1; i < 5; i++) {
        var _val = curYear - i;
        //从2015年开始
        if (_val < 2015) {
            break;
        }
        _opt.push({
            "text": _val + "年",
            "Value": _val
        });
    }
    return _opt;
}

/**
 * 设置表单只读
 * @param formSelctor
 */
function readOnlyForm(formSelctor) {
    setTimeout(function () {
        $(':radio,:checkbox').prop("disabled", true);
        $(":input:not(':button'),a.choose-btn").addClass("disabled").prop("readonly", true).off("click focus");
        $(".combo,.combo > *").prop("disabled", true).off("click focus");
    }, 200);
}
/**
 * 扩展jquery function 将表单序列化JSON
 */

(function ($) {
    $.fn.serializeJson = function () {
        var serializeObj = {};
        var array = this.serializeArray();
        var str = this.serialize();
        $(array).each(function () {
            if (serializeObj[this.name]) {
                if ($.isArray(serializeObj[this.name])) {
                    serializeObj[this.name].push(this.value);
                } else {
                    serializeObj[this.name] = [serializeObj[this.name], this.value];
                }
            } else {
                serializeObj[this.name] = this.value;
            }
        });
        return serializeObj;
    };
})(jQuery);

/*
 *lodop 打印构造函数
 */
function LodopPrint() {

    var lodopPath = function (sys) {
        if (sys == 32)
            return context + "/static/lodop/install_lodop32.exe";
        return context + "/static/lodop/install_lodop64.exe"
    }

    var checkIsInstall = function () {
        var result = false;
        var errorMsg = "";
        var strHtmInstall = "<br><font color='#FF00FF'>打印控件未安装!点击这里<a href='" + lodopPath(32) + "' target='_self'>执行安装</a>,安装后请刷新页面或重新进入。</font>";
        var strHtmUpdate = "<br><font color='#FF00FF'>打印控件需要升级!点击这里<a href='" + lodopPath(32) + "' target='_self'>执行升级</a>,升级后请重新进入。</font>";
        var strHtm64_Install = "<br><font color='#FF00FF'>打印控件未安装!点击这里<a href='" + lodopPath(64) + "' target='_self'>执行安装</a>,安装后请刷新页面或重新进入。</font>";
        var strHtm64_Update = "<br><font color='#FF00FF'>打印控件需要升级!点击这里<a href='" + lodopPath(64) + "' target='_self'>执行升级</a>,升级后请重新进入。</font>";
        var strHtmFireFox = "<br><br><font color='#FF00FF'>（注意：如曾安装过Lodop旧版附件npActiveXPLugin,请在【工具】->【附加组件】->【扩展】中先卸它）</font>";
        var strHtmChrome = "<br><br><font color='#FF00FF'>(如果此前正常，仅因浏览器升级或重安装而出问题，需重点击这里<a href='" + lodopPath(32) + "' target='_self'>执行安装</font>";

        try {
            //判断浏览器类型
            var isIE = (navigator.userAgent.indexOf('MSIE') >= 0) || (navigator.userAgent.indexOf('Trident') >= 0);
            var is64IE = isIE && (navigator.userAgent.indexOf('x64') >= 0);
            var LODOP = getLodop();
            if ((LODOP != null) && (typeof(LODOP.VERSION) != "undefined")) {
                if (LODOP.VERSION < "6.1.9.8") {
                    if (is64IE) {
                        errorMsg = strHtm64_Update;
                    } else if (isIE) {
                        errorMsg = strHtmUpdate;
                    } else {
                        errorMsg = strHtmUpdate;
                    }
                }
                else {
                    result = true;
                }
            } else {

                if (navigator.userAgent.indexOf('Chrome') >= 0)
                    errorMsg = strHtmChrome;
                else if (navigator.userAgent.indexOf('Firefox') >= 0)
                    errorMsg = strHtmFireFox;
                else if (is64IE)
                    errorMsg = strHtm64_Install;
                else if (isIE)
                    errorMsg = strHtmInstall;
                else
                    errorMsg = strHtmInstall;

            }

        } catch (err) {
            result = false;

        }


        return result;
    }

    //获取lodop对象
    this.getLodop = function () {
        if (checkIsInstall()) {
            $("body").append('<div style="position:absolute;top:0px;left:-1000em;"><object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>\
                <embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0 pluginspage="' + lodopPath().win32 + '"></embed>\
                <param name="CompanyName" value="西安交大长天软件股份有限公司">\
                <param name="License" value="747606062808075747594958093190"></object></div>');
            var isIE = (navigator.userAgent.indexOf('MSIE') >= 0) || (navigator.userAgent.indexOf('Trident') >= 0);
            var oOBJECT = document.getElementById('LODOP_OB'),
                oEMBED = document.getElementById('LODOP_EM');
            return (isIE ? oOBJECT : oEMBED);

        }
        return null;
    }

    //lodop打印
    this.lodopPrint = function (opt) {
        var _default = {
            "paperName": "A4",
            "fontSize": null,//配置数值，不用带单位，lodop默认单位是pt
            "URL": null,
            "content": "",
            "footer": {
                html: "",
                top: "",
                left: "",
                width: "",
                height: ""
            },
            pagation: false,
            "isPreview": false,
            "printIndex": -1,
            "complate": null,
            "printCount": 1,
            "msg": "",
            "title": "打印VOCs排污费缴纳决定书",
            "width": "210mm",
            "height": "297mm",
            "top": "30mm",
            "left": "0mm"
        };
        var options = $.extend(_default, opt);
        var PrintResult = -1;//打印结果
        try {

            var LODOP = this.getLodop();
            if (LODOP) {
                //"FontSize"是系统关键字，表示设置字体大小，11是字体大小值，单位是pt。
                if (options.fontSize) {
                    LODOP.SET_PRINT_STYLE("FontSize", options.fontSize);
                }
                //初始化并指定打印任务名是"打印插件功能演示_代码功能_名片"
                LODOP.PRINT_INIT(options.title);
                //如果传递的是一个地址
                if (options.URL != null) {
                    //直接加载地址ADD_PRINT_URL(Top,Left,Width,Height,strURL);
                    LODOP.ADD_PRINT_URL(options.top, options.left, options.width, options.height, options.URL);
                }
                else {
                    //前俩参数设置超文本对象位置，两个100%设置对象区域可达纸张边，最后参数是超文本代码
                    //LODOP.ADD_PRINT_HTM(10, 55, "100%", "100%", strHtml);
                    var _html = "<!doctype html>" + options.content;
                    if (options.paperName != '') {
                        //设置打印纸张大小
                        //LODOP.SET_PRINT_MODE("POS_BASEON_PAPER",true);
                        LODOP.SET_PRINT_MODE("WINDOW_DEFPAGESIZE:" + options.printIndex, options.paperName);
                        //LODOP.SET_PRINT_PAGESIZE(0, '560pt', 2450, options.paperName);
                        //ADD_PRINT_HTM(Top,Left,Width,Height,strHtml);


                        LODOP.ADD_PRINT_HTM(options.top, options.left, options.width, options.height, _html);
                    } else
                        LODOP.ADD_PRINT_HTM(options.top, options.left, options.width, options.height, _html);


                    if (options.footer.html.length > 0) {
                        var footerHTML = "<body>" + options.footer.html + "</body>";
                        LODOP.ADD_PRINT_HTM(options.footer.top, options.footer.left, options.footer.width, options.footer.height, footerHTML);
                        LODOP.SET_PRINT_STYLEA(0, "ItemType", 1);

                    }
                    if (options.pagation) {
                        var pagationStr = "第#页/共&页";
                        if (options.pagation.text) {
                            pagationStr = options.pagation.text;
                        }
                        LODOP.ADD_PRINT_TEXT(options.pagation.top, options.pagation.left, 300, 100, pagationStr);
                        LODOP.SET_PRINT_STYLEA(0, "ItemType", 2);
                        LODOP.SET_PRINT_STYLEA(0, "Horient", 1);

                    }
                }


                LODOP.SET_PRINT_COPIES(options.printCount);
                if (options.isPreview) {
                    LODOP.PREVIEW();
                } else {
                    //用如下语句可指定Windows默认打印机：打印机设置为操作系统的默认打印机，成功返回OK，否则返回错误信息
                    //LODOP.SET_PRINT_MODE("WINDOW_DEFPRINTER",打印机名称或序号);
                    if (LODOP.GET_PRINTER_COUNT() == 0) {
                        $.messager.alert("系统提示", "您的机器上没有检测到打印机连接！", "warning");
                        return false;
                    }
                    if (options.printIndex > -1) {
                        LODOP.SET_PRINTER_INDEXA(options.printIndex); //选择打印机
                        LODOP.SET_PRINT_MODE("WINDOW_DEFPRINTER", options.printIndex); //设为默认打印机
                    }
                    //打印进度
                    $.messager.progress({
                        title: '打印进度',
                        text: (options.msg == "" ? '正在打印......' : options.msg),
                        interval: 300
                    });

                    PrintResult = LODOP.PRINT();
                    LODOP.SET_PRINT_STYLEA(0, "Horient", 2);
                    LODOP.SET_PRINT_STYLEA(0, "HtmWaitMilSecs", 300);
                }
            }
        }
        catch (ex) {
            $.messager.alert("打印提示", "请更换<font color='#C41A16'><strong>IE浏览器</strong></font>再次尝试，如果还无法打印请联系管理员！", 'info');
        }
        finally {
            $.messager.progress('close');
            if (options.complate != undefined && typeof options.complate == "function") {
                options.complate.call(this, PrintResult);
            }
        }
        return PrintResult > 0;
    }
}


/*
 * 兼容VOC打印方法
 */
function vocsPrint(opt) {
    var ldp = new LodopPrint();
    return ldp.lodopPrint(opt);
}


/**
 * 将复杂的json对象转换成URL参数
 * @param param
 * @param key
 * @returns {string}
 * 调用方式：
 * var obj={name:'tom','class':{className:'class1'},classMates:[{name:'lily'}]};
 * parseParam(obj);
 * 结果："name=tom&class.className=class1&classMates[0].name=lily"
 * parseParam(obj,'stu');
 * 结果："stu.name=tom&stu.class.className=class1&stu.classMates[0].name=lily"
 */
function parseParam(param, key) {
    var paramStr = "";
    if (param instanceof String || param instanceof Number || param instanceof Boolean) {
        paramStr += "&" + key + "=" + encodeURIComponent(param);
    } else {
        $.each(param, function (i, p) {
            if (p == null || p == undefined)
                return true;
            var k = key == null ? i : key + (param instanceof Array ? "[" + i + "]" : "." + i);
            paramStr += '&' + parseParam(this, k);
        });
    }
    return paramStr.substr(1);
};

//转换数字
function parseNumber(val) {
    var v1 = parseFloat(val);
    if (isNaN(v1))
        return 0;
    else
        return v1;
}

/**
 *
 * @param number {number}要格式化的数字
 * @param decimals {number}保留的小数位数
 * @param dec_point {string}分隔小数字符
 * @param thousands_sep {string}千位分隔符
 * @returns {string}
 */
function number_format(number, decimals, dec_point, thousands_sep) {
    number = (number + '')
        .replace(/[^0-9+\-Ee.]/g, '');
    var n = !isFinite(+number) ? 0 : +number,
        prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
        sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
        dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
        s = '',
        toFixedFix = function (n, prec) {
            var k = Math.pow(10, prec);
            return '' + (Math.round(n * k) / k)
                    .toFixed(prec);
        };
    // Fix for IE parseFloat(0.55).toFixed(0) = 0;
    s = (prec ? toFixedFix(n, prec) : '' + Math.round(n))
        .split('.');
    if (s[0].length > 3) {
        s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
    }
    if ((s[1] || '')
            .length < prec) {
        s[1] = s[1] || '';
        s[1] += new Array(prec - s[1].length + 1)
            .join('0');
    }
    return s.join(dec);
}

/**
 * datagrid-数字格式化-(000,000.00)
 */
function numberToformatMoney(value, row, index) {
    if (value == null) {
        return '';
    }
    return number_format(value, 2);
}
/**
 * datagrid-数字格式化-统计查询（kg -> t）(000,000.000)
 */
function numberToformatAmount(value, row, index) {
    value = value / 1000;
    return number_format(value, 3);
}
/**
 *datagrid-数字格式化-(000,000)
 */
function numberToformatPerson(value, row, index) {
    return number_format(value, 0);
}
/**
 * 去掉小数点后面的多余的0
 * @param num
 * @returns {string}
 */
String.prototype.fix0 = function (num) {
    var value = this.valueOf();
    if (/\.?\d+$|^\d+$/.test(value)) {
        var reg = /0+?$/;
        value = this.valueOf().replace(reg, '').replace(/[.]$/, '');
    }
    return value;

}

//控制换行
String.prototype.warp = function (num) {
    var start = 1;
    var strArray = this.valueOf().match(/./g);
    for (var i = 0; i < strArray.length; i++) {
        if (i >= num * start) {
            //console.log(num * start);
            var m = num * start;
            if (start > 1)
                m = num * start + start - 1;
            start++;
            strArray.splice(m, 0, "<br>");
        }
    }
    return strArray.join("");
}

String.prototype.bool = function () {
    return (/^true$/i).test(this);
};

String.prototype.trim = function () {
    return this.replace(/(^\s+)|(\s+$)/g, '')
}
/**
 * 扩展string.format
 * @returns {string}
 */
String.prototype.format = function () {
    var s = this;
    for (var i = 0; i < arguments.length; i++) {
        var reg = new RegExp("\\{" + i + "\\}", "gm");
        s = s.replace(reg, arguments[i]);
    }
    return s;
}

/**
 * 数组插入到指定位置
 * @param index
 * @param item
 */
Array.prototype.insert = function (index, item) {
    this.splice(index, 0, item);
};
/**
 *对Date的扩展，将 Date 转化为指定格式的String
 *月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
 *年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 *例子：
 *(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
 *(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
 */
Date.prototype.format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

if (!Array.prototype.hasOwnProperty("forEach")) {
    Array.prototype.forEach = function (callback, thisArg) {
        var T, k;
        if (this == null) {
            throw new TypeError(" this is null or not defined");
        }
        var O = Object(this);
        var len = O.length >>> 0; // Hack to convert O.length to a UInt32
        if ({}.toString.call(callback) != "[object Function]") {
            throw new TypeError(callback + " is not a function");
        }
        if (thisArg) {
            T = thisArg;
        }
        k = 0;
        while (k < len) {
            var kValue;
            if (k in O) {
                kValue = O[k];
                callback.call(T, kValue, k, O);
            }
            k++;
        }
    };
}


function onComboboxHidePanel() {
    var el = $(this);
    el.combobox('textbox').focus();
    // 检查录入内容是否在数据里
    var opts = el.combobox("options");
    var data = el.combobox("getData");
    var value = el.combobox("getValue");
    // 有高亮选中的项目, 则不进一步处理
    var panel = el.combobox("panel");
    var items = panel.find(".combobox-item-selected");
    if (items.length > 0) {
        var values = el.combobox("getValues");
        el.combobox("setValues", values);
        return;
    }
    var allowInput = opts.allowInput;
    if (allowInput) {
        var idx = data.length;

        data[idx] = [];
        data[idx][opts.textField] = value;
        data[idx][opts.valueField] = value;
        el.combobox("loadData", data);
    } else {
        // 不允许录入任意项, 则清空
        el.combobox("clear");
    }
}


//定义tab选项卡
(function ($) {
    $.fn.jtabs = function (opt) {
        return this.each(function (i, tb) {

            var _defaults = {
                tabSelector: 'li',
                panelSelector: '',
                fit: true,
                activeCls: "active",
                onSelect: null,
                onComplate: null,
                onResize: null

            };

            var options = $.extend(_defaults, opt);

            $(tb).find(options.tabSelector).click(function (e) {
                e.preventDefault();
                $(tb).find(options.tabSelector).removeClass(options.activeCls).eq($(this).index()).addClass(options.activeCls);
                $(tb).find(options.panelSelector).hide().eq($(this).index()).show();
                if (options.onSelect)
                    options.onSelect.call(this, $(this).index(), $(this).text());

            })

            function resize() {
                setTimeout(function () {
                    $(tb).width(function () {
                        return $(this).parent().width();
                    }).height(function () {
                        if ($(this).siblings().length > 0) {
                            var siblingH = 0;
                            $(this).siblings().each(function () {
                                siblingH += $(this).height();
                            })
                            if ($(this).parent().get(0).tagName == "BODY")
                                return $(window).height() - siblingH;

                            return $(this).parent().height() - siblingH;
                        }

                        return $(this).parent().height();
                    }).children().height(function (index, height) {
                        if (index > 0) {
                            $(this).css({
                                "position": "relative",
                                //"top": $(this).parent().children().first().height()+"px",
                                "top": "0px",
                                "overflow-y": "auto"
                            });
                            return $(this).parent().height() - $(this).parent().children().first().height();
                        }
                        $(this).css({"position": "relative", "top": "0px", "left": "0px"});

                        return $(this).height();

                    }).width(function () {
                        return $(this).parent().width();
                    });
                    if (options.onResize)
                        options.onResize.call($(tb), $(tb).find(options.panelSelector).width(), $(tb).find(options.panelSelector).height());
                }, 200)

            }

            resize();
            if (options.onComplate)
                setTimeout(function () {
                    options.onComplate.call($(tb), null);
                }, 200);
            $(window).resize(function () {
                resize();
            })


        })
    }
})(jQuery);

/*
 *定义小分页控件
 *使用方法
 * $(selector).smallPagination({total: @Number,pageNumber: @Number,onSelectPage:function(pageNumber, pageSize){}});
 */
(function ($) {

    $.fn.smallPagination = function (options) {
        var _default = {
            total: 1,
            pageSize: 10,
            pageNumber: 1,
            width: 200,
            onSelectPage: function (pageNumber, pageSize) {

            }
        };

        var opt = $.extend(_default, options);

        var target = $(this);

        var _w = opt.width;
        if (typeof opt.width == "number")
            _w = _w + "px";
        target.css("width", _w);
        target.addClass("ui-smallPagination");
        var createagination = function (opt) {
            var pageStr = $.format('<div class="ui-smallPagination-btns"><span class="arrow-left ui-prev"></span><span class="text">第{0}页</span><span class="arrow-right  ui-next"></span><span class="total">共{1}页</span></div>', opt.pageNumber, opt.total);
            var _pagination = target.html(pageStr);
            if (opt.pageNumber > 0 && opt.pageNumber != 1) {
                target.find('.ui-prev').off('click').click(function () {
                    opt.pageNumber--;
                    if (opt.pageNumber <= 0)
                        opt.pageNumber = 1;
                    createagination(opt);
                    opt.onSelectPage(opt.pageNumber, opt.pageSize);
                });
            }
            if (opt.total > 0 && opt.total != opt.pageNumber)
                target.find('.ui-next').off('click').click(function () {

                    opt.pageNumber++;
                    if (opt.pageNumber >= opt.total)
                        opt.pageNumber = opt.total;
                    createagination(opt);
                    opt.onSelectPage(opt.pageNumber, opt.pageSize);
                });
        };

        createagination(opt);
        return {
            target: target,
            getPage: function () {
                return {pageNumber: opt.pageNumber, pageSize: opt.pageSize};
            }
        };


    }

}(jQuery));


(function ($) {
    //用模版话引擎创建datagridlist
    $.fn.templateList = function (opt, args) {


        if (typeof opt == "string") {
            var _24 = $.fn.templateList.methods[opt];
            if (_24) {
                return _24(this, args);
            }
            else {
                return this.templateList(opt, args);
            }
        }
        var options = $.extend({}, $.fn.templateList.default, opt);


        return this.each(function (i, templ) {
            $.data(this, "options", options);
            var page = {}
            page[options["pageSizeField"]] = options.pageSize;
            page[options["pageNumberField"]] = options.pageNumber;
            $(templ).templateList("load", page);
        });


    };

    $.fn.templateList.default = {
        //一个URL从远程站点请求数据
        url: null,
        //数据加载array,object
        data: null,
        //模版ID
        tempId: null,
        //请求参数
        param: null,
        //分页属性
        pagination: true,
        onSelectPage: function (pageNumber, pageSize) {

        },
        total: 0,
        pagetarget: null,
        pageCls: "tcdPageCode",
        pageSize: 10,
        pageNumber: 1,
        pageSizeField: "pageSize",
        pageNumberField: "pageNo",
        //返回过滤数据显示
        loadFilter: function (data) {

        },
        onBeforeLoad: function () {

        },
        //加载完成事件
        onLoadSuccess: function (data) {

        }
    };


    $.fn.templateList.default[$.fn.templateList.default.pageSizeField] = $.fn.templateList.default.pageSize;
    $.fn.templateList.default[$.fn.templateList.default.pageNumberField] = $.fn.templateList.default.pageNumber;

    $.fn.templateList.methods = {

        load: function (jq, page) {
            var options = $(jq).templateList("options");

            if (!options.tempId) {
                alert("没有配置模版id");
                return false;
            }

            options[options["pageSizeField"]] = page[options["pageSizeField"]];
            options[options["pageNumberField"]] = page[options["pageNumberField"]];

            var queryParam = $.extend({}, options.param, page);
            if (options.url) {
                if (options.onBeforeLoad.call(jq, null) == false) {
                    return false;
                }
                Public.post(options.url, queryParam, function (response) {

                    var filter = options.loadFilter(response);
                    var data = (!filter ? response : filter);
                    try {
                        var html = "";
                        if (data != "null")
                            html = template(options.tempId, data);
                        //解析数据
                        $(jq).empty().html(html);
                    } catch (e) {
                        alert(e);
                    }

                    //是否显示分页
                    if (options.pagination) {
                        var total = response.data.totalCount;
                        var pageTarget = options.pagetarget == null ? $("<div/>").appendTo(jq) : $(options.pagetarget);
                        //创建分页
                        $(pageTarget).addClass(options.pageCls).paginationM({
                            totalData: total,//数据总条数
                            pageCount: (Math.ceil(total / queryParam[options["pageSizeField"]])),//总页数
                            showData: (queryParam[options["pageSizeField"]]),//每页显示的条数
                            current: (queryParam[options["pageNumberField"]]),//当前第几页
                            jump: true,
                            coping: true,
                            isHide: false,
                            keepShowPN: true,
                            callback: function (p) {
                                options[options["pageSizeField"]] = page[options["pageSizeField"]] = options.pageSize;
                                options[options["pageNumberField"]] = page[options["pageNumberField"]] = p;
                                $(jq).templateList("load", page);
                                options.onSelectPage(options[options["pageSizeField"]], p);
                            }
                        });
                    }


                    options.onLoadSuccess.call(jq, response, filter);
                });
            }
            if (options.data) {
                var filter = options.loadFilter(options.data);
                var data = (!filter ? options.data : filter);
                try {
                    var html = "";
                    if (data != "null")
                        html = template(options.tempId, data);
                    //解析数据
                    $(jq).empty().html(html);
                } catch (e) {
                    alert(e);
                }

                //是否显示分页
                if (options.pagination) {
                    var total = options.data.totalCount;
                    var pageTarget = options.pagetarget == null ? $("<div/>").appendTo(jq) : $(options.pagetarget);
                    //创建分页
                    $(pageTarget).addClass(options.pageCls).paginationM({
                        totalData: total,
                        showData: (queryParam[options["pageSizeField"]]),
                        current: (queryParam[options["pageNumberField"]]),
                        pageCount: (Math.ceil(total / queryParam[options["pageSizeField"]])),
                        jump: true,
                        coping: true,
                        isHide: false,
                        keepShowPN: true,
                        callback: function (p) {
                            options[options["pageSizeField"]] = page[options["pageSizeField"]] = options.pageSize;
                            options[options["pageNumberField"]] = page[options["pageNumberField"]] = p;
                            $(jq).templateList("load", page);
                            options.onSelectPage(options[options["pageSizeField"]], p);
                        }
                    });
                }


                options.onLoadSuccess.call(jq, options.data, filter);
            }


            return jq;
        },

        reload: function (jq, param) {
            var options = $(jq).templateList("options");
            //合并参数
            $.extend(options.param, param);
            var page = {}
            page[options["pageSizeField"]] = options.pageSize;
            page[options["pageNumberField"]] = 1;
            return $(jq).templateList("load", page);
        },
        options: function (jq) {
            return $.data(jq.get(0), "options");
        }
    }


})(jQuery);


(function ($, _window) {


    /*用户登录操作*/
    _window.loginUser = {
        setUser: function (userInfo) {
            $.cookie("userInfo", JSON.stringify(userInfo), {path: '/'});
        },
        getUser: function () {

            if (!$.cookie("userInfo")) {
                top.location.href = context + "/content/pub/login.html?from=" + location.href;
                return null;
            }

            return JSON.parse($.cookie("userInfo"));
        }
    };


})(jQuery, window);