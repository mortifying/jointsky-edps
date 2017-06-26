/**
 * Created by Administrator on 2017/6/17.
 */
var apiObj;
function apiTest(key,key2) {
    var testContainer = $("#"+ key.substr(1,key.length)+"Test");
    testContainer.empty();

    var a = $('<DIV />', {
        class:"col-xs-12 alingnL form-danger"
    }).appendTo(testContainer);
    var a1 = $('<h4>Response Content Type:</h4>').appendTo(a);
    var a2 = $('<label>'+apiObj.paths[key][key2].produces[0]+'</label>').appendTo(a);

}
