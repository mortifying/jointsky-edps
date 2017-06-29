//双y轴线图函数
function echart2yLine(){


    //计算出echart要用的对象p

    var p = arguments[0];
    if(typeof(arguments[0])=='string'){

        if(arguments[0]=='reload'){
            if(arguments[1]==null||arguments[1].rootDivId==null){
                alert('第二个参数内没有rootDivId属性！');
                return ;
            }

            p = $('#'+arguments[1].rootDivId).data('myP');

            if(p){
                var p2 = arguments[1];
                $.extend(p,p2);
            }else{
                alert('图标未初始化！');
                return ;
            }
        }

    }else if(typeof(arguments[0])=='object'){
        $('#'+arguments[0].rootDivId).data('myP',p);
    }
    console.log(p);
    //计算出echart要用的对象p


    setTimeout(function(){


        var echartRoot = echarts.init(document.getElementById(p.rootDivId));


        $.ajax({
            url: p.ajaxUrl,
            dataType:'json',
            type:'post',
            async:false,
            success:function(myData){

                //为下面的option内的legend的data算值
                var legendData = [];
                $.each(p.config,function(i,n){
                    legendData.push(p.config[i][1]);
                });
                //为下面的option内的legend的data算值


                //*************定义该line图表要用的横坐标值
                var xDate = []; //xDate存储横坐标的数组值
                $.each(myData,function(i,n){
                    xDate.push(myData[i][p.xValName]);
                });
                //*************定义该line图表要用的横坐标值



                //*************定义该line图表要用的series值

                var series = []; //series为setOption方法中series属性要给的值

                $.each(p.config,function(ii,nn){

                    if( myData[0][p.config[ii][0]]||myData[0][p.config[ii][0]]==0 ){ //检查config数组中存的元素的index0子元素是否是myData[0](myData数组的第一个元素)的一个属性
                        //config[ii]就是一个字符串，如(pm25)
                        var data = []; //定义一个临时数组data

                        $.each(myData,function(i,n){
                            data.push( myData[i][p.config[ii][0]] );
                        });

                        var ser={}; //定义series数组当前元素为一个对象，存在临时变量ser中
                        ser.name = p.config[ii][1];
                        ser.data = data;
                        if(p.config[ii][2]=='R'){
                            ser.yAxisIndex = 1; //****************************设置yAxisIndex极为重要，不然显示不出双y轴
                        }

                        ser.type = 'line';
                        ser.smooth = true;

                        series.push(ser); //把临时变量ser放入数组series中
                    }
                });

                //*************定义该line图表要用的series值

                var option ={
                    baseOption: {
                        legend:{
                            data: legendData,
                            height:'100%',
                            orient:'vertical'
                        },
                        grid:{
                            right:'15%'
                        },
                        xAxis:{
                            data:xDate
                        },
                        yAxis: [
                            {
                                name: p.yLAxisName
                            },
                            {
                                name: p.yRAxisName
                            }
                        ],
                        series: series
                    },
                    media:[
                        {
                            query:{
                                minWidth:0
                            },
                            option:{
                                legend:{
                                    left:'0%',
                                    bottom:'0%'
                                },
                                grid:{
                                    left:'20%',
                                    bottom:'50%',
                                    width:'60%'
                                }
                            }
                        },
                        {
                            query:{
                                minWidth:480
                            },
                            option:{
                                legend:{
                                    right:'0%',
                                    top: '17%'
                                },
                                grid:{
                                    left:'12%',
                                    bottom:'20%',
                                    width:'50%'
                                }
                            }
                        },
                        {
                            query:{
                                minWidth:768
                            },
                            option:{
                                grid:{
                                    width:'60%'
                                }
                            }
                        }
                    ]
                };
                echartRoot.resize();

                setTimeout(function(){
                    echartRoot.setOption(option);
                },30);


                $(window).resize(function(){
                    echartRoot.resize();
                });

            }
        });
    },200);

}
//双y轴线图函数

//双y轴条形图函数
function echart2yBar(){

    //计算出echart要用的对象p

    var p = arguments[0];
    if(typeof(arguments[0])=='string'){

        if(arguments[0]=='reload'){
            if(arguments[1]==null||arguments[1].rootDivId==null){
                alert('第二个参数内没有rootDivId属性！');
                return ;
            }

            p = $('#'+arguments[1].rootDivId).data('myP');

            if(p){
                var p2 = arguments[1];
                $.extend(p,p2);
            }else{
                alert('图标未初始化！');
                return ;
            }
        }

    }else if(typeof(arguments[0])=='object'){
        $('#'+arguments[0].rootDivId).data('myP',p);
    }
    console.log(p);
    //计算出echart要用的对象p

    setTimeout(function(){

        var echartRoot = echarts.init(document.getElementById(p.rootDivId));

        $.ajax({
            url: p.ajaxUrl,
            dataType:'json',
            type:'post',
            async:false,
            success:function(myData){

                //为下面的option内的legend的data算值
                var legendData = [];
                $.each(p.config,function(i,n){
                    legendData.push(p.config[i][1]);
                });
                //为下面的option内的legend的data算值


                //*************定义该bar图表要用的横坐标值
                var xDate = []; //xDate存储横坐标的数组值
                $.each(myData,function(i,n){
                    xDate.push(myData[i][p.xValName]);
                });
                //*************定义该bar图表要用的横坐标值



                //*************定义该bar图表要用的series值

                var series = []; //series为setOption方法中series属性要给的值

                $.each(p.config,function(ii,nn){

                    if( myData[0][p.config[ii][0]]||myData[0][p.config[ii][0]]==0 ){ //检查config数组中存的元素的index0子元素是否是myData[0](myData数组的第一个元素)的一个属性
                        //config[ii]就是一个字符串，如(pm25)
                        var data = []; //定义一个临时数组data

                        $.each(myData,function(i,n){
                            data.push( myData[i][p.config[ii][0]] );
                        });

                        var ser={}; //定义series数组当前元素为一个对象，存在临时变量ser中
                        ser.name = p.config[ii][1];
                        ser.data = data;
                        if(p.config[ii][2]=='R'){
                            ser.yAxisIndex = 1; //****************************设置yAxisIndex极为重要，不然显示不出双y轴
                        }

                        ser.type = 'bar';

                        series.push(ser); //把临时变量ser放入数组series中
                    }
                });

                //*************定义该bar图表要用的series值

                var option ={
                    baseOption: {
                        legend:{
                            data: legendData,
                            right:'2%',
                            top: '17%',
                            height:'100%',
                            orient:'vertical'
                        },
                        grid:{
                            left:'10%',
                            right:'15%',
                            width:'66%'
                        },
                        xAxis:{
                            data:xDate,
                            axisLabel:{
                                formatter:function(value,index){
                                    if(value.length>2){

                                        var arr = value.split('');
                                        var newArr=[];

                                        $.each(arr,function(i,n){
                                            newArr.push(n);
                                            if((i+1)%2==0){
                                                newArr.push('\n');
                                            }
                                        });


                                        return newArr.join('');
                                    }
                                    return value;
                                }
                            }
                        },
                        yAxis: [
                            {
                                name: p.yLAxisName
                            },
                            {
                                name: p.yRAxisName
                            }
                        ],
                        itemStyle:{
                            normal:{
                                barBorderRadius:[6,6,0,0],
                                borderWidth:1,
                                borderColor:'black'
                            }
                        },
                        series: series
                    },
                    media:[
                        {
                            query:{
                                minWidth:0
                            },
                            option:{
                                legend:{
                                    left:'0%',
                                    bottom:'0%'
                                },
                                grid:{
                                    left:'20%',
                                    bottom:'50%',
                                    top:'10%',
                                    width:'60%',
                                    height:240
                                }
                            }
                        },
                        {
                            query:{
                                minWidth:480
                            },
                            option:{
                                legend:{
                                    right:'0%',
                                    top: '17%'
                                },
                                grid:{
                                    left:'12%',
                                    bottom:'20%',
                                    width:'50%'
                                }
                            }
                        },
                        {
                            query:{
                                minWidth:768
                            },
                            option:{
                                grid:{
                                    width:'60%'
                                }
                            }
                        }
                    ]
                };

                echartRoot.resize();
                setTimeout(function(){
                    echartRoot.setOption(option);
                },30);

                $(window).resize(function(){
                    echartRoot.resize();
                });

            }
        });
    },200);

}
//双y轴条形图函数
