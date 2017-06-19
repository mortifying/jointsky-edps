//线图函数
function echart2yLine(p){

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

                    if( myData[0][p.config[ii][0]] ){ //检查config数组中存的元素的index0子元素是否是myData[0](myData数组的第一个元素)的一个属性
                        //config[ii]就是一个字符串，如(pm25)
                        var data = []; //定义一个临时数组data

                        $.each(myData,function(i,n){
                            //alert( myData[i][p.config[ii][0]] );
                            if( myData[i][p.config[ii][0]] ){
                                data.push( myData[i][p.config[ii][0]] );
                            }else{
                                alert('缺少数据！');
                            }
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
                    legend:{
                        data: legendData,
                        right:'2%',
                        top: '10%',
                        orient:'vertical'
                    },
                    grid:{
                        left:'10%',
                        right:'15%',
                        width:'70%'
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
                };

                echartRoot.setOption(option);

                $(window).resize(function(){
                    echartRoot.resize();
                });

            }
        });
    },0);

}
//线图函数
