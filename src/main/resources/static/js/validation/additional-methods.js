(function() {
		
	function stripHtml(value) {
		// remove html tags and space chars
		return value.replace(/<.[^<>]*?>/g, ' ').replace(/&nbsp;|&#160;/gi, ' ')
		// remove numbers and punctuation
		.replace(/[0-9.(),;:!?%#$'"_+=\/-]*/g,'');
	}
	jQuery.validator.addMethod("maxWords", function(value, element, params) {
	    return this.optional(element) || stripHtml(value).match(/\b\w+\b/g).length < params;
	}, jQuery.validator.format("Please enter {0} words or less."));

	jQuery.validator.addMethod("minWords", function(value, element, params) {
	    return this.optional(element) || stripHtml(value).match(/\b\w+\b/g).length >= params;
	}, jQuery.validator.format("Please enter at least {0} words."));

	jQuery.validator.addMethod("rangeWords", function(value, element, params) {
	    return this.optional(element) || stripHtml(value).match(/\b\w+\b/g).length >= params[0] && value.match(/bw+b/g).length < params[1];
	}, jQuery.validator.format("Please enter between {0} and {1} words."));

})();

jQuery.validator.setDefaults({ 
	errorContainer: $('#errorMsgWin')
});

jQuery.validator.addMethod("letterswithbasicpunc", function(value, element) {
	return this.optional(element) || /^[a-z-.,()'\"\s]+$/i.test(value);
}, "Letters or punctuation only please");

jQuery.validator.addMethod("alphanumeric", function(value, element) {
	return this.optional(element) || /^\w+$/i.test(value);
}, "只能输入字母和数字");

jQuery.validator.addMethod("lettersonly", function(value, element) {
	return this.optional(element) || /^[a-z]+$/i.test(value);
}, "Letters only please");

jQuery.validator.addMethod("nowhitespace", function(value, element) {
	return this.optional(element) || /^\S+$/i.test(value);
}, "No white space please");

jQuery.validator.addMethod("ziprange", function(value, element) {
	return this.optional(element) || /^90[2-5]\d\{2}-\d{4}$/.test(value);
}, "Your ZIP-code must be in the range 902xx-xxxx to 905-xx-xxxx");

jQuery.validator.addMethod("integer", function(value, element) {
	return this.optional(element) || /^-?\d+$/.test(value);
}, "A positive or negative non-decimal number please");

/**
* Return true, if the value is a valid vehicle identification number (VIN).
*
* Works with all kind of text inputs.
*
* @example <input type="text" size="20" name="VehicleID" class="{required:true,vinUS:true}" />
* @desc Declares a required input element whose value must be a valid vehicle identification number.
*
* @name jQuery.validator.methods.vinUS
* @type Boolean
* @cat Plugins/Validate/Methods
*/
jQuery.validator.addMethod(
	"vinUS",
	function(v){
		if (v.length != 17)
			return false;
		var i, n, d, f, cd, cdv;
		var LL    = ["A","B","C","D","E","F","G","H","J","K","L","M","N","P","R","S","T","U","V","W","X","Y","Z"];
		var VL    = [1,2,3,4,5,6,7,8,1,2,3,4,5,7,9,2,3,4,5,6,7,8,9];
		var FL    = [8,7,6,5,4,3,2,10,0,9,8,7,6,5,4,3,2];
		var rs    = 0;
		for(i = 0; i < 17; i++){
		    f = FL[i];
		    d = v.slice(i,i+1);
		    if(i == 8){
		        cdv = d;
		    }
		    if(!isNaN(d)){
		        d *= f;
		    }
		    else{
		        for(n = 0; n < LL.length; n++){
		            if(d.toUpperCase() === LL[n]){
		                d = VL[n];
		                d *= f;
		                if(isNaN(cdv) && n == 8){
		                    cdv = LL[n];
		                }
		                break;
		            }
		        }
		    }
		    rs += d;
		}
		cd = rs % 11;
		if(cd == 10){cd = "X";}
		if(cd == cdv){return true;}
		return false;
	},
	"The specified vehicle identification number (VIN) is invalid."
);

/**
  * Return true, if the value is a valid date, also making this formal check dd/mm/yyyy.
  *
  * @example jQuery.validator.methods.date("01/01/1900")
  * @result true
  *
  * @example jQuery.validator.methods.date("01/13/1990")
  * @result false
  *
  * @example jQuery.validator.methods.date("01.01.1900")
  * @result false
  *
  * @example <input name="pippo" class="{dateITA:true}" />
  * @desc Declares an optional input element whose value must be a valid date.
  *
  * @name jQuery.validator.methods.dateITA
  * @type Boolean
  * @cat Plugins/Validate/Methods
  */
jQuery.validator.addMethod(
	"dateITA",
	function(value, element) {
		var check = false;
		var re = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
		if( re.test(value)){
			var adata = value.split('/');
			var gg = parseInt(adata[0],10);
			var mm = parseInt(adata[1],10);
			var aaaa = parseInt(adata[2],10);
			var xdata = new Date(aaaa,mm-1,gg);
			if ( ( xdata.getFullYear() == aaaa ) && ( xdata.getMonth () == mm - 1 ) && ( xdata.getDate() == gg ) )
				check = true;
			else
				check = false;
		} else
			check = false;
		return this.optional(element) || check;
	},
	"Please enter a correct date"
);

jQuery.validator.addMethod("dateNL", function(value, element) {
		return this.optional(element) || /^\d\d?[\.\/-]\d\d?[\.\/-]\d\d\d?\d?$/.test(value);
	}, "Vul hier een geldige datum in."
);

jQuery.validator.addMethod("time", function(value, element) {
	return this.optional(element) || /^([01]\d|2[0-3])(:[0-5]\d){0,2}$/.test(value);
}, "Please enter a valid time, between 00:00 and 23:59");
jQuery.validator.addMethod("time12h", function(value, element) {
	return this.optional(element) || /^((0?[1-9]|1[012])(:[0-5]\d){0,2}(\ [AP]M))$/i.test(value);
}, "Please enter a valid time, between 00:00 am and 12:00 pm");

/**
 * matches US phone number format
 *
 * where the area code may not start with 1 and the prefix may not start with 1
 * allows '-' or ' ' as a separator and allows parens around area code
 * some people may want to put a '1' in front of their number
 *
 * 1(212)-999-2345
 * or
 * 212 999 2344
 * or
 * 212-999-0983
 *
 * but not
 * 111-123-5434
 * and not
 * 212 123 4567
 */
jQuery.validator.addMethod("phoneUS", function(phone_number, element) {
    phone_number = phone_number.replace(/\s+/g, "");
	return this.optional(element) || phone_number.length > 9 &&
		phone_number.match(/^(1-?)?(\([2-9]\d{2}\)|[2-9]\d{2})-?[2-9]\d{2}-?\d{4}$/);
}, "Please specify a valid phone number");

jQuery.validator.addMethod('phoneUK', function(phone_number, element) {
return this.optional(element) || phone_number.length > 9 &&
phone_number.match(/^(\(?(0|\+44)[1-9]{1}\d{1,4}?\)?\s?\d{3,4}\s?\d{3,4})$/);
}, 'Please specify a valid phone number');

jQuery.validator.addMethod('mobileUK', function(phone_number, element) {
return this.optional(element) || phone_number.length > 9 &&
phone_number.match(/^((0|\+44)7(5|6|7|8|9){1}\d{2}\s?\d{6})$/);
}, 'Please specify a valid mobile number');

// TODO check if value starts with <, otherwise don't try stripping anything
jQuery.validator.addMethod("strippedminlength", function(value, element, param) {
	return jQuery(value).text().length >= param;
}, jQuery.validator.format("Please enter at least {0} characters"));

// same as email, but TLD is optional
jQuery.validator.addMethod("email2", function(value, element, param) {
	return this.optional(element) || /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)*(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i.test(value);
}, jQuery.validator.messages.email);

// same as url, but TLD is optional
jQuery.validator.addMethod("url2", function(value, element, param) {
	return this.optional(element) || /^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)*(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(value);
}, '请输入一个有效的url地址');

function isUrlAddress(str_url){
	var strRegex = "^((https|http|ftp|rtsp|mms)?://)"
	+ "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@
	+ "(([0-9]{1,3}.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
	+ "|" // 允许IP和DOMAIN（域名）
	+ "([0-9a-z_!~*'()-]+.)*" // 域名- www.
	+ "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]." // 二级域名
	+ "[a-z]{2,6})" // first level domain- .com or .museum
	+ "(:[0-9]{1,4})?" // 端口- :80
	+ "((/?)|" // a slash isn't required if there is no file name
	+ "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
	var re=new RegExp(strRegex);
	if (re.test(str_url)){
		return (true);
	}else{
		return (false);
	}
}

jQuery.validator.addMethod("url3", function(value, element) {
	return this.optional(element) || isUrlAddress(value);
	}, '请输入一个有效的url地址');

// NOTICE: Modified version of Castle.Components.Validator.CreditCardValidator
// Redistributed under the the Apache License 2.0 at http://www.apache.org/licenses/LICENSE-2.0
// Valid Types: mastercard, visa, amex, dinersclub, enroute, discover, jcb, unknown, all (overrides all other settings)
jQuery.validator.addMethod("creditcardtypes", function(value, element, param) {

	if (/[^0-9-]+/.test(value))
		return false;

	value = value.replace(/\D/g, "");

	var validTypes = 0x0000;

	if (param.mastercard)
		validTypes |= 0x0001;
	if (param.visa)
		validTypes |= 0x0002;
	if (param.amex)
		validTypes |= 0x0004;
	if (param.dinersclub)
		validTypes |= 0x0008;
	if (param.enroute)
		validTypes |= 0x0010;
	if (param.discover)
		validTypes |= 0x0020;
	if (param.jcb)
		validTypes |= 0x0040;
	if (param.unknown)
		validTypes |= 0x0080;
	if (param.all)
		validTypes = 0x0001 | 0x0002 | 0x0004 | 0x0008 | 0x0010 | 0x0020 | 0x0040 | 0x0080;

	if (validTypes & 0x0001 && /^(51|52|53|54|55)/.test(value)) { //mastercard
		return value.length == 16;
	}
	if (validTypes & 0x0002 && /^(4)/.test(value)) { //visa
		return value.length == 16;
	}
	if (validTypes & 0x0004 && /^(34|37)/.test(value)) { //amex
		return value.length == 15;
	}
	if (validTypes & 0x0008 && /^(300|301|302|303|304|305|36|38)/.test(value)) { //dinersclub
		return value.length == 14;
	}
	if (validTypes & 0x0010 && /^(2014|2149)/.test(value)) { //enroute
		return value.length == 15;
	}
	if (validTypes & 0x0020 && /^(6011)/.test(value)) { //discover
		return value.length == 16;
	}
	if (validTypes & 0x0040 && /^(3)/.test(value)) { //jcb
		return value.length == 16;
	}
	if (validTypes & 0x0040 && /^(2131|1800)/.test(value)) { //jcb
		return value.length == 15;
	}
	if (validTypes & 0x0080) { //unknown
		return true;
	}
	return false;
}, "Please enter a valid credit card number.");

jQuery.validator.addMethod("ipv4", function(value, element, param) {
    return this.optional(element) || /^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/i.test(value);
}, "Please enter a valid IP v4 address.");

jQuery.validator.addMethod("ipv6", function(value, element, param) {
    return this.optional(element) || /^((([0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){6}:[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){5}:([0-9A-Fa-f]{1,4}:)?[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){4}:([0-9A-Fa-f]{1,4}:){0,2}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){3}:([0-9A-Fa-f]{1,4}:){0,3}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){2}:([0-9A-Fa-f]{1,4}:){0,4}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){6}((\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b)\.){3}(\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b))|(([0-9A-Fa-f]{1,4}:){0,5}:((\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b)\.){3}(\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b))|(::([0-9A-Fa-f]{1,4}:){0,5}((\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b)\.){3}(\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b))|([0-9A-Fa-f]{1,4}::([0-9A-Fa-f]{1,4}:){0,5}[0-9A-Fa-f]{1,4})|(::([0-9A-Fa-f]{1,4}:){0,6}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){1,7}:))$/i.test(value);
}, "Please enter a valid IP v6 address.");

/**
  * Return true if the field value matches the given format RegExp
  *
  * @example jQuery.validator.methods.pattern("AR1004",element,/^AR\d{4}$/)
  * @result true
  *
  * @example jQuery.validator.methods.pattern("BR1004",element,/^AR\d{4}$/)
  * @result false
  *
  * @name jQuery.validator.methods.pattern
  * @type Boolean
  * @cat Plugins/Validate/Methods
  */
jQuery.validator.addMethod("pattern", function(value, element, param) {
    return this.optional(element) || param.test(value);
}, "Invalid format.");

/** 
* 身份证号码验证
*/
function isIdCardNo(num) {
var factorArr = new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2,1);
//var error;
var varArray = new Array();
var intValue;
var lngProduct = 0;
var intCheckDigit;
var intStrLen = num.length;
var idNumber = num;
   // initialize
     //if ((intStrLen != 15) && (intStrLen != 18)) {
         //error = "输入身份证号码长度不对！";
         //alert(error);
         //frmAddUser.txtIDCard.focus();
     //   return false;
     //}
     if(intStrLen != 18) {
    	 error = "输入身份证号码长度不对！";
    	 return false;
     }
     // check and set value
     for(i=0;i<intStrLen;i++) {
         varArray[i] = idNumber.charAt(i);
         if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
             //error = "错误的身份证号码！.";
             //alert(error);
             //frmAddUser.txtIDCard.focus();
             return false;
         } else if (i < 17) {
             varArray[i] = varArray[i]*factorArr[i];
         }
     }
     if (intStrLen == 18) {
         //check date
         var date8 = idNumber.substring(6,14);
         if (isDate8(date8) == false) {
             //error = "身份证中日期信息不正确！.";
             //alert(error);
             return false;
         }
         // calculate the sum of the products
         for(i=0;i<17;i++) {
             lngProduct = lngProduct + varArray[i];
         }
         // calculate the check digit
         intCheckDigit = 12 - lngProduct % 11;
         switch (intCheckDigit) {
             case 10:
                 intCheckDigit = 'X';
                 break;
             case 11:
                 intCheckDigit = 0;
                 break;
             case 12:
                 intCheckDigit = 1;
                 break;
         }
         // check last digit
         if (varArray[17].toUpperCase() != intCheckDigit) {
             //error = "身份证效验位错误!正确为： " + intCheckDigit + ".";
             //alert(error);
             return false;
         }
     }
     else{
		 //length is 15
         //check date
         var date6 = idNumber.substring(6,12);
         if (isDate6(date6) == false) {
             //alert("身份证日期信息有误！.");
             return false;
         }
     }
     //alert ("Correct.");
     return true;
}

/**
* 判断是否为“YYYYMM”式的时期
*
*/
function isDate6(sDate) {
	if(!/^[0-9]{6}$/.test(sDate)) {
	  return false;
	}
	var year, month, day;
	year = sDate.substring(0, 4);
	month = sDate.substring(4, 6);
	if (year < 1900 || year > 2100) return false
	if (month < 1 || month > 12) return false 
	return true;
} 
/**
* 判断是否为“YYYYMMDD”式的时期
*
*/
function isDate8(sDate) {
	if(!/^[0-9]{8}$/.test(sDate)) {
	  return false;
	}
	var year, month, day;
	year = sDate.substring(0, 4);
	month = sDate.substring(4, 6);
	day = sDate.substring(6, 8);
	var iaMonthDays = [31,28,31,30,31,30,31,31,30,31,30,31]
	if (year < 1900 || year > 2100){
		return false;
	}
	if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) iaMonthDays[1]=29;
	if (month < 1 || month > 12) {
		return false;
	}
	if (day < 1 || day > iaMonthDays[month - 1]) {
		return false;
	}
	return true;
} 

function isDate9(sDate) {
	if(!/^[1-2]{1}[0-9]{3}\-[0-1]{1}[1-9]{1}$/.test(sDate)) {
	  return false;
	}
	var year, month, day;
	year = sDate.substring(0, 4);
	month = sDate.substring(5, 7);
	if (year < 1900 || year > 2100) return false
	if (month < 1 || month > 12) return false 
	return true;
} 

// 字符验证 
jQuery.validator.addMethod("stringCheck", function(value, element) {
    return this.optional(element) || /^\w+$/.test(value);
}, "只能包括英文字母、数字和下划线"); 

jQuery.validator.addMethod("stringCheck1", function(value, element) {
    return this.optional(element) || /^[A-Za-z0-9]+$/.test(value);
}, "只能包括英文字母、数字"); 

jQuery.validator.addMethod("stringCheck2", function(value, element) {
	return this.optional(element) || /^[A-Za-z0-9_.]+$/.test(value);
}, "只能包括英文字母、数字、.和下划线"); 

jQuery.validator.addMethod("stringCheck3", function(value, element) {
	return this.optional(element) || /^[A-Za-z0-9_.\s]+$/.test(value);
}, "只能包括英文字母、数字、下划线、.和空格"); 

//中文字符串
jQuery.validator.addMethod("cnString", function(value, element) {
    return this.optional(element) || /^[\u4e00-\u9fa5]+$/.test(value);
}, "只能输入中文字符串"); 

// 手机号码验证 
jQuery.validator.addMethod("mobile", function(value, element) {
    var length = value.length;
    return this.optional(element) || (length == 11 && /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/.test(value));
}, "请正确填写您的手机号码");

// 电话号码验证 
jQuery.validator.addMethod("phone", function(value, element) {
    var tel = /^((^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)|(^[0-9]{3,4}\-[0-9]{3,8}\-[0-9]{2,5}$))$/;
    return this.optional(element) || (tel.test(value));
}, "请正确填写您的电话号码");

// 邮政编码验证 
jQuery.validator.addMethod("zipCode", function(value, element) {
    var tel = /^[0-9]{6}$/;
    return this.optional(element) || (tel.test(value));
}, "请正确填写您的邮政编码"); 

// 中文字两个字节        
jQuery.validator.addMethod("byteRangeLength", function(value, element, param) { 
	var length = value.length;          
	for(var i = 0; i < value.length; i++){ 
		if(value.charCodeAt(i) > 127){ 
			length++;            
		}       
	}
	return this.optional(element) || ( length >= param[0] && length <= param[1] );       
}, "请确保输入的值在3-15个字节之间(一个中文字算2个字节)"); 

// 身份证号码验证        
jQuery.validator.addMethod("isIdCardNo", function(value, element) {
	return this.optional(element) || isIdCardNo(value);        
}, "请正确输入您的身份证号码");  

//大于
jQuery.validator.addMethod("greaterTo", function(value, element, param) {    
    return this.optional(element) || (Number(value) > Number($(param).val()));
}, "输入的最大值必须大于最小值");

//不等于
jQuery.validator.addMethod("notEqualTo", function(value, element, param) {    
	return value != $(param).val();
}, "输入的两个值不应该相同");

//以指定字符开始
jQuery.validator.addMethod("startWith", function(value, element, param) {
	return this.optional(element) || value.match(new RegExp("^" + param, "i"));   
}, "必须以指定字符开始");

jQuery.validator.addMethod("float", function(value, element) {
	return this.optional(element) || /^\d{1,4}(\.\d{1,2}){0,1}$/.test(value);   
}, "格式错误，只能输入整数或小数，最多两位小数<br/>");

$.validator.addMethod("checkboxLeastOne", function(value, elem, param) {
    return $("input[type='checkbox'][name='" + param+ "']:checked").length > 0;
},"您必须至少选择一项!");

//计算中英文混合字符串长度
function getFullLength(str){
    var totalCount = 0; 
    for (var i=0; i<str.length; i++) { 
        var c = str.charCodeAt(i); 
        if ((c >= 0x0001 && c <= 0x007e) || (0xff60<=c && c<=0xff9f)) { 
             totalCount++; 
         }else {     
             totalCount+=2; 
         } 
     }
    return totalCount;
}

$.validator.addMethod("maxFullLen", function(value, elem, param) {
	return this.optional(elem) || (getFullLength(value) <= param);        
}, "长度超过限制");

//工作流定时任务开始时间验证
jQuery.validator.addMethod("timePattern", function(value, element, param) {
	var type = $(param).val();
	var reg;
	if(type == '1') {
		reg = /^((\d{2}(([02468][048])|([13579][26]))[\-\/\s]?((((0?[13578])|(1[02]))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\-\/\s]?((0?[1-9])|([1-2][0-9])))))|(\d{2}(([02468][1235679])|([13579][01345789]))[\-\/\s]?((((0?[13578])|(1[02]))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\-\/\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\s((([0-1][0-9])|(2?[0-3]))\:([0-5]?[0-9])((\s)|(\:([0-5]?[0-9])))))?$/;
	}else if(type == '2') {
		reg = /^(0\d{1}|1\d{1}|2[0-3]):[0-5]\d{1}:([0-5]\d{1})$/;
	}else if(type == '3') {
		reg = /^([1-7]):(0\d{1}|1\d{1}|2[0-3]):[0-5]\d{1}:([0-5]\d{1})$/;
	}else if(type == '4') {
		reg = /^((0[1-9])|([1-2][0-9])|30|31):(0\d{1}|1\d{1}|2[0-3]):[0-5]\d{1}:([0-5]\d{1})$/;
	}else if(type == '5') {
		reg = /^((0[1-9])|1[0-2]):(0\d{1}|1\d{1}|2[0-3]):[0-5]\d{1}:([0-5]\d{1})$/;
	}
    return (this.optional(element) || reg.test(value));
}, "输入的数据格式错误");

$.validator.addMethod("equalLength", function(value, elem, param) {
	return this.optional(elem) || (getFullLength(value) == param);        
}, "长度不符合要求");


//检验后台是否已注册此信息
$.validator.addMethod("isInfoExist", function(value, elem, param) {
	var result = false;
	$.ajax({
		url: param.fn(),
		//url: 'http://192.168.3.105:8080/checkEmail?email='+email,
		dataType:'json',
		type:'get',
		async:false,
		success:function(data){
			result=data.flag;
		}
	});
	return result;
}, "该输入已被人使用");
//检验后台是否已注册此信息

$.validator.addMethod("isSame", function(value, elem, param) {
	return value == param.fn();
}, "与原值不匹配");