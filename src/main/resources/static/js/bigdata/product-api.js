/**
 * Created by Administrator on 2017/6/17.
 */
(function ($) {
    $(document).ready(function () {
        $("#menu").shieldMenu({
            cls: 'p-menu',
            orientation: 'horizontal'
        });
        Public.get("static/json/product.json", null, function (response) {
            apiObj = response;
            var menu_api = $("#menu_api");
            var menu_apiStr="<UL>";
            for(var i = 0; i < response.tags.length; i ++){
                menu_apiStr+='<LI><P>'+response.tags[i].name+'</P></LI>';
                if(i>0){
                    var e0 = $('<DIV />', {
                        id:response.tags[i].name,
                        style:" height: 70px;"//background-image:url(static/themes/bigdata/images/9.jpg);"
                    }).appendTo($('#p-api-details'));
                }
                // 标题
                var e1 = $('<DIV />', {
                    id:response.tags[i].name,
                    class:"container"
                }).appendTo($('#p-api-details'));
                var e2 = $('<DIV />', {
                    id:"row-"+i,
                    class:"row",
                    style:"background-color: #fff;"
                }).appendTo(e1);
                var e3 = $('<DIV />', {
                    id:"row-col-"+i,
                    class:"col-xs-12",
                    style:"text-align: center; color:#428bca;"
                }).appendTo(e2);
                var e4 = $("<h3>"+response.tags[i].name+"</h3>").appendTo(e3);
                var e5 = $("<p>"+response.tags[i].description+"</p>").appendTo(e3);

                var j = 0;

                for (var key in response.paths)
                {
                    for(var key2 in response.paths[key]){
                        if(response.paths[key][key2].tags[0]==response.tags[i].name){
                            // api接口
                            var e6 = $('<DIV />', {
                                id:"container-danger-"+i,
                                class:"bs-callout bs-callout-info"
                            }).appendTo(e1);

                            var e6_1 = $('<DIV />', {
                                id:"container-danger-grid-row"+i,
                                class:"row show-grid margin-0",
                                style:"background-color: #fff;"
                            }).appendTo(e6);

                            var e6_1_1 = $('<DIV />', {
                                class:"col-xs-6"
                            }).appendTo(e6_1);
                            if(key2=="get"){
                                var e6_1_1_1 = $('<span id="apiMethod"'+j+' style="font-size: 18px;"><code style="color: #1b809e;background-color: #f4f9fe;">&nbsp;'+key2+'&nbsp;&nbsp;</code>&nbsp;&nbsp;</span>').appendTo(e6_1_1);
                            }else{
                                var e6_1_1_11 = $('<span id="apiMethod"'+j+' style="font-size: 18px;"><code style="color: #2da64d;background-color: #ebffea;">&nbsp;'+key2+'&nbsp;</code>&nbsp;&nbsp;</span>').appendTo(e6_1_1);
                            }

                            var e6_1_1_2 = $('<span id="apiPath"'+j+' style="font-size: 18px;"><code>'+key+'</code></span>').appendTo(e6_1_1);

                            var e6_1_2 = $('<DIV />', {
                                class:"col-xs-6 alingnR"
                            }).appendTo(e6_1);
                            var e6_1_2_1 =$('<a data-toggle="collapse" href="#'+key.substr(1,key.length)+'" onclick="javascript:showHideApiItem(this)"><span id="tags-name" >'+response.paths[key][key2].summary+'&nbsp;&nbsp;</span><i class="fa fa-angle-double-down"></i></a>').appendTo(e6_1_2);

                            //接口详细内容收缩框
                            var e6_2 = $('<DIV />', {
                                id:key.substr(1,key.length),
                                class:"row collapse show-grid form-danger"
                            }).appendTo(e6);

                            //接口详细内容
                            var e6_2_1 = $('<DIV />', {
                                class:"col-xs-12 alingnL form-danger"
                            }).appendTo(e6_2);
                            var e6_2_1_1 = $('<h4>Description:</h4>').appendTo(e6_2_1);
                            var e6_2_1_2 = $('<label>'+response.paths[key][key2].description +'</label>').appendTo(e6_2_1);


                            /*
                             * Request URL
                             * */
                            var e6_2_2 = $('<DIV />', {
                                class:"col-xs-12 alingnL form-danger"
                            }).appendTo(e6_2);
                            var e6_2_2_1 = $('<h4>Request URL:</h4>').appendTo(e6_2_2);
                            var e6_2_2_2 = $('<label>http://'+response.host+key +'</label>').appendTo(e6_2_2);


                            /*
                             * Parameters
                             * */
                            var e6_2_3 = $('<DIV />', {
                                class:"col-xs-12 alingnL form-danger"
                            }).appendTo(e6_2);
                            var e6_2_3_1 = $('<h4>Parameters:</h4>').appendTo(e6_2_3);
                            if(response.paths[key][key2].parameters==undefined){
                                var e6_2_3_2 = $('<label>无</label>').appendTo(e6_2_3);
                            }else{
                                var tableStr = '<table class="table table-striped"  style="background-color: #fff;"><thead><tr><th>#</th><th>Parameter</th><th>Default Value</th> <th>Description </th> <th>Parameter Type </th> <th>Data Type </th> </tr> </thead> <tbody>';
                                for(var k=0;k<response.paths[key][key2].parameters.length;k++){
                                        tableStr+=' <tr><th scope="row">'+(k+1)+'</th>';
                                        tableStr+='<td>'+response.paths[key][key2].parameters[k].name+'</td>';
                                        tableStr+='<td>'+response.paths[key][key2].parameters[k].default+'</td>';
                                        tableStr+='<td>'+response.paths[key][key2].parameters[k].description+'</td>';
                                        tableStr+='<td>'+response.paths[key][key2].parameters[k].in+'</td>';
                                        tableStr+='<td>'+response.paths[key][key2].parameters[k].type+'</td>';
                                        tableStr+='</tr>';
                                }
                                tableStr+='</tbody>';
                                tableStr+='</table>';
                                var e6_2_3_2 = $(tableStr).appendTo(e6_2_3);
                            }

                            /*
                             * Response Content Type
                             * */
                            var e6_2_4 = $('<DIV />', {
                                class:"col-xs-12 alingnL form-danger"
                            }).appendTo(e6_2);
                            var e6_2_4_1 = $('<h4>Response Content Type:</h4>').appendTo(e6_2_4);
                            var e6_2_4_2 = $('<label>'+response.paths[key][key2].produces[0]+'</label>').appendTo(e6_2_4);

                            /*
                            * Response Messages
                            * */
                            var e6_2_5 = $('<DIV />', {
                                class:"col-xs-12 alingnL form-danger"
                            }).appendTo(e6_2);
                            var e6_2_5_1 = $('<h4>Response Messages:</h4>').appendTo(e6_2_5);
                            var response_messages_str = '<table class="table table-striped"  style="background-color: #fff;"><thead><tr><th>#</th><th>HTTP Status Code</th><th>Reason</th>  </tr> </thead> <tbody>';
                            var r_k = 1;
                            var model_key;
                            var response_model_type="";
                            for(var response_messages_key in response.paths[key][key2].responses){
                                response_messages_str+='<tr><th scope="row">'+r_k+'</th>';
                                response_messages_str+='<td>'+response_messages_key+'</td>';
                                response_messages_str+='<td>'+response.paths[key][key2]["responses"][response_messages_key].description+'</td>';
                                response_messages_str+='</tr>';

                                //获取返回结果对象结构关键字
                                if(response_messages_key=="200"){
                                    if(response.paths[key][key2]["responses"][response_messages_key]["schema"]["type"]==undefined){
                                        for(var ww in response.paths[key][key2]["responses"][response_messages_key]["schema"]){
                                            model_key =response.paths[key][key2]["responses"][response_messages_key]["schema"][ww];
                                            model_key = model_key.substr(model_key.lastIndexOf('/')+1,model_key.length);
                                        }
                                    }else{
                                        for(var ww in response.paths[key][key2]["responses"][response_messages_key]["schema"]["items"]){
                                            model_key =response.paths[key][key2]["responses"][response_messages_key]["schema"]["items"][ww];
                                            model_key = model_key.substr(model_key.lastIndexOf('/')+1,model_key.length);
                                        }
                                    }

                                    if(response.paths[key][key2]["responses"][response_messages_key]["schema"]["type"]==undefined){
                                        response_model_type = "object";
                                    }else{
                                        response_model_type = response.paths[key][key2]["responses"][response_messages_key]["schema"]["type"];
                                    }
                                }
                                r_k++;
                            }
                            response_messages_str+='</tbody>';
                            response_messages_str+='</table>';
                            var e6_2_5_2 = $(response_messages_str).appendTo(e6_2_5);


                            /*
                             * Response Model Type
                             * */
                            var e6_2_6 = $('<DIV />', {
                                class:"col-xs-12 alingnL form-danger"
                            }).appendTo(e6_2);
                            var e6_2_6_1 = $('<h4>Response Model Type:</h4>').appendTo(e6_2_6);

                            var e6_2_6_2 = $('<label>'+response_model_type+'</label>').appendTo(e6_2_6);



                            /*
                             * Response Model
                             * */
                            var e6_2_7 = $('<DIV />', {
                                class:"col-xs-12 alingnL form-danger"
                            }).appendTo(e6_2);
                            var e6_2_7_1 = $('<h4>Response Model(HTTP Status Code:200):</h4>').appendTo(e6_2_7);

                            var tabStr="";
                            if(response_model_type=="integer"){ //返回对象类型为integer时
                                var tabStr_2 = '<table class="table table-striped"  style="background-color: #fff;"><thead><tr>';
                                for(var properties_schema_key in response.paths[key][key2]["responses"]["200"]["schema"]){
                                    tabStr_2+='<th>'+properties_schema_key+'</th>';
                                }
                                tabStr_2+='</tr></thead><tbody><tr>';
                                for(var properties_schema_key_2 in response.paths[key][key2]["responses"]["200"]["schema"]){
                                    tabStr_2+='<td>'+response.paths[key][key2]["responses"]["200"]["schema"][properties_schema_key_2]+'</td>';
                                }
                                tabStr_2+='</tr></tbody></table>';

                                tabStr = tabStr_2;
                            }
                            else{//返回对象类型为array或object时
                                var response_model_str = '<table class="table table-striped"  style="background-color: #fff;"><thead><tr><th>#</th><th>Properties</th><th>Type</th><th>Format</th><th>Description</th>  </tr> </thead> <tbody>';
                                var r_o_k = 1;
                                for(var response_definitions_key in response.definitions){
                                    if(response_definitions_key == model_key){
                                        for(var properties_key in response.definitions[response_definitions_key].properties){
                                            response_model_str+='<tr><th scope="row">'+r_o_k+'</th>';
                                            response_model_str+='<td>'+properties_key+'</td>';
                                            response_model_str+='<td>'+response.definitions[response_definitions_key].properties[properties_key]["type"]+'</td>';
                                            if(response.definitions[response_definitions_key].properties[properties_key]["format"]==undefined){
                                                response_model_str+='<td></td>';
                                            }else {
                                                response_model_str+='<td>'+response.definitions[response_definitions_key].properties[properties_key]["format"]+'</td>';
                                            }
                                            response_model_str+='<td>'+response.definitions[response_definitions_key].properties[properties_key]["description"]+'</td>';
                                            response_model_str+='</tr>';
                                            r_o_k++;
                                        }
                                    }
                                }
                                response_model_str+='</tbody>';
                                response_model_str+='</table>';
                                tabStr = response_model_str;
                            }

                            var e6_2_6_2 = $(tabStr).appendTo(e6_2_7);
                        }
                    }

                }
            }
            menu_apiStr+='</UL>';
            //var menu_api_html = $(menu_apiStr).appendTo(menu_api);
            var pageFlag = QueryString("code");
            if(pageFlag!="null"){
                window.location.hash = pageFlag;
            }

        })
    })
})(jQuery);