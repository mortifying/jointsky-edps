function screenCtrl(objname) {
     var screenWidth = 1024;
     var screenHeight = 768;
     if (navigator.appName == 'Netscape') {
            screenWidth = screen.availWidth; //屏幕宽度
            screenHeight = screen.availHeight; //屏幕高度
     }
      else if (navigator.appName == 'Microsoft Internet Explorer') {
          screenWidth = screen.width; //屏幕宽度
          screenHeight = screen.height; //屏幕高度
      }
      $("#"+objname).css("height",screenHeight);
}
/**
 * js中自定义QueryString方法，获取url中的参数值
 * @param key 参数名
 * @returns
 */
function QueryString(key) {

	var reg= new RegExp (key + "=([^&#]*)","i");

	var value = reg.exec(window.location.href);

	if ( value == null )return null;
	if ( value == "undefined" )return "";
	return decodeURI(value[1]);

}
/**
 * 
 * @param dom对象 input类型
 */
function checkOrder(obj){
	var a = obj.value;
	if(/^\d*$/.test(a)){
		
	}else if(/\d+/.test(a)){
		var b= a.match(/\d/g).join("");//取所有数字字符，放入数组，再连成串。
  		obj.value=b;//转为数字。
	}else{
		obj.value=1;
	}
}
/**
 * 
 * @param dom对象 input类型
 */
function checkLetters(obj){
	var a = obj.value;
	if(/^\w*$/.test(a)){
		
	}else if(/\w+/.test(a)){
		var b= a.match(/\w/g).join("");//取所有数字字符，放入数组，再连成串。
  		obj.value=b;//转为数字。
	}else{
		obj.value="";
	}
}
/**
 * 字符串截取中英文  str 要截取字符串  len 截取长度  hasDot 是否有省略号
 */
function subString(str, len, hasDot)
{
    var newLength = 0;
    var newStr = "";
    var chineseRegex = /[^\x00-\xff]/g;
    var singleChar = "";
    var strLength = str.replace(chineseRegex,"**").length;
    for(var i = 0;i < strLength;i++){
        singleChar = str.charAt(i).toString();
        if(singleChar.match(chineseRegex) != null){
            newLength += 2;
        }else{
            newLength++;
        }
        if(newLength > len){
            break;
        }
        newStr += singleChar;
    }
    
    if(hasDot && strLength > len){
        newStr += "...";
    }
    return newStr;
}
//非常好用的JsonToString方法
function JsonToStr(o) {
    var r = [];
    if (typeof o == "string" || o == null) {
        return o;
    }
    if (typeof o == "object") {
        if (!o.sort) {
            r[0] = "{";
            for (var i in o) {
                r[r.length] = '"'+i+'"';
                r[r.length] = ":";
                r[r.length] = '"'+JsonToStr(o[i])+'"';
                r[r.length] = ",";
            }
            r[r.length - 1] = "}";
        } else {
            r[0] = "[";
            for (var i = 0; i < o.length; i++) {
                r[r.length] = JsonToStr(o[i]);
                r[r.length] = ",";
            }
            r[r.length - 1] = "]";
        }
        return r.join("");
    }
    return o.toString();
}
function addZero(a){
	if(a<10){
		return "0"+a;
	}else{
		return ""+a;
	}
}
function replaceHtml(str){
//	var regEx_script = /<[\s]*?script[^>]*?>[\s\S]*?<[\s]*?\/[\s]*?script[\s]*?>/; //定义script的正则表达式{或<script[^>]*?>[\s\S]*?<\/script> } 
//    var regEx_style = /<[\s]*?style[^>]*?>[\s\S]*?<[\s]*?\/[\s]*?style[\s]*?>/; //定义style的正则表达式{或<style[^>]*?>[\s\S]*?<\/style> } 
    var regEx_html = /<[^>]+>/ig; //定义HTML标签的正则表达式 

//    htmlStr = str.replaceAll(regEx_script," "); //过滤script标签 

 //   htmlStr = str.replaceAll(regEx_style," "); //过滤style标签 

    htmlStr = str.replace(regEx_html," "); //过滤html标签 
    htmlStr =htmlStr.replace(/&nbsp;/ig,'');//去掉&nbsp;
    return htmlStr;
}
function getDate(strDate) {  
    var date = eval('new Date(' + strDate.replace(/\d+(?=-[^-]+$)/,  
     function (a) { return parseInt(a, 10) - 1; }).match(/\d+/g) + ')');  
    return date;  
} 
function formatStrToDate(str){
	var strArray = str.split("-");
    return new Date(strArray[1] + '/' + strArray[2] + '/' + strArray[0]);   //转换为12/13/2008格式
}
function formatDateToDateStr(date){
	return date.getFullYear()+"-"+addZero(date.getMonth()+1)+"-"+addZero(date.getDate());
}
function formatDateTimeToStr(date){
 	return date.getFullYear()+"/"+addZero(date.getMonth()+1)+"/"+addZero(date.getDate()) + " " +addZero(date.getHours()) + ":" +addZero(date.getMinutes()) + ":" + addZero(date.getSeconds());
}
function formatDateTimeToStrNOs(date){
 	return date.getFullYear()+"/"+addZero(date.getMonth()+1)+"/"+addZero(date.getDate()) + " " +addZero(date.getHours()) + ":" +addZero(date.getMinutes());
}


var Public = {
    post: function (url, param, callback) {
        $.ajax({
            url: url,
            type: "GET",
            data: param,
            dataType: "json",
            success: function (data) {
                if ((data.status == "001" || data.status == "002")) {
                    alert(data.msg);
                    return false;
                }
                else
                    callback(data);
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
                if ((data.status == "001" || data.status == "002")) {
                    alert(data.msg);
                    return false;
                }
                else

                    callback(data);
            },
            error: function (msg) {
                //alert(msg);
            }
        });

    }
}
//function alert(content){
//	$("#myModal").modal({
//	  keyboard: false,
//	  show:true
//	});
//	$("#myModal").on('shown.bs.modal', function (e) {
//	  // do something...
//	  $("#myModalBody").text(content);
//	});
//	//$('#myModal').modal('hide');
//	
//}