/****************************************************
 *
 *        控件初始化WebOffice方法
 *
 ****************************************************/
function MyOffice(CtrlReady) {
    //组件初始化好执行的function 不能为匿名函数
    this.ctrlReady = CtrlReady;


    var getFnName = function (callee) {
        var _callee = callee.toString().replace(/[\s\?]*/g, ""),
            comb = _callee.length >= 50 ? 50 : _callee.length;
        _callee = _callee.substring(0, comb);
        var name = _callee.match(/^function([^\(]+?)\(/);
        if (name && name[1]) {
            return name[1];
        }
        var caller = callee.caller,
            _caller = caller.toString().replace(/[\s\?]*/g, "");
        var last = _caller.indexOf(_callee),
            str = _caller.substring(last - 30, last);
        name = str.match(/var([^\=]+?)\=/);
        if (name && name[1]) {
            return name[1];
        }
        return "anonymous"
    };

    //初始化weboffice
    this.initOffice = function (target) {
        if (!document.getElementById("WebOffice1")) {
            var office = "";
            office += '<scr ipt language=javascr ipt for=WebOffice1 event=NotifyCtrlReady>';
            office += '' + getFnName(this.ctrlReady) + '();';
            office += '</scr ipt>';
            office += '<object id="WebOffice1" height="768" width="100%" height="100%" style="LEFT: 0px; TOP: 0px" classid="clsid:E77E049B-23FC-4DB8-B756-60529A35FAD5" codebase="' + context + '/static/cab/weboffice_v6.0.5.0.cab#Version=6,0,5,0">';
            office += '    <param name="_ExtentX" value="6350"><param name="_ExtentY" value="6350">';
            office += '</object>';
            var office = office.replace(/scr ipt/g, 'script');
            if (!target) {
                $("body").append(office);
            }
            else $(target).append(office)
        }
    }


    //获取当前的文档对象
    this.getOffice = function () {
        this.initOffice();
        return document.all.item("WebOffice1");
    }

    //打开文档
    this.openDocument = function (url, docType) {
        try {
            if (!docType)
                docType = "doc";
            this.getOffice().LoadOriginalFile(url, docType);


        } catch (e) {
            alert("异常\r\nError:" + e + "\r\nError Code:" + e.number + "\r\nError Des:" + e.description);
        }


    }

    //创建文档
    this.createDocument = function (type) {
        try {
            var currOffice=this.getOffice();
            var types = ['doc', 'xls', 'ppt'];
            if (types[type]) {
                currOffice.LoadOriginalFile('', types[type]);
            }
            else
                currOffice.LoadOriginalFile("", 'doc');

        } catch (e) {
            alert("异常\r\nError:" + e + "\r\nError Code:" + e.number + "\r\nError Des:" + e.description);
        }

    }

    //关闭文档
    this.closeDocument = function () {
        try {
            this.getOffice().CloseDoc(0);
        } catch (e) {
            alert("异常\r\nError:" + e + "\r\nError Code:" + e.number + "\r\nError Des:" + e.description);
        }

    }

    //保存文档
    this.saveDocument = function (DocTitle, url, param) {

        try {
            var currOffice=this.getOffice();
            //初始化Http引擎
            currOffice.HttpInit();
            currOffice.HttpAddPostString("docTitle", encodeURIComponent(DocTitle));
            if (param) {
                for (var i in param) {
                    if (param.hasOwnProperty(i)) {
                        currOffice.HttpAddPostString(i, encodeURIComponent(param[i]));
                    }
                }
            }
            currOffice.HttpAddPostCurrFile("DocContent", "");

            // 上传文件
            return currOffice.HttpPost(url);


        } catch (e) {
            alert("异常\r\nError:" + e + "\r\nError Code:" + e.number + "\r\nError Des:" + e.description);
            return false;
        }


    }


}