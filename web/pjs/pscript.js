$(function () {
    var chart = echarts.init($("#div2")[0],'dark');
    var option={
        title:{
            text:"客户流失分析",
            subtext:"统计人：CRM",
            x:"center"
        },
        //每一个颜色对应的说明信息
        legend: {
            orient: 'vertical',//内容纵向排列
            left: 'left',//左对齐
            data: []//名称，一维数组
        },
        //鼠标悬停时的提示信息
        tooltip:{
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c}位({d}%)"
        },
        //下载，切换
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {
                    show: true,
                    type: ['pie', 'funnel']
                },
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        series:{
            name:"客户状态",//名称
            type:"pie",//类型
            radius:"60%",//圆的半径
            //roseType: 'angle',//显示为南丁格尔样式
            data:[],//数据，需要二维数组
            itemStyle: {
                normal: {
                    shadowBlur: 200,
                    shadowColor: 'rgba(0, 0, 0, 0.9)',
                }
            },
            label: {
                show: true
            },// 高亮样式。
            emphasis: {
                itemStyle: {
                    // 高亮时点的颜色。
                    color: 'orange'
                }
            }
        }
    }

    chart.setOption(option);
    /********************************用ajax动态加载数据****************************************************/
    //利用ajax请求，得到json
    $.ajax({
        url:"${pageContext.request.contextPath}/p/ping_showTypeEChartLS",
        type:"post",
        dataType:"json",
        success:function(data){
            //设置组件的属性
            chart.setOption({
                legend: {
                    orient: 'vertical',//内容纵向排列
                    left: 'left',//左对齐
                    data: data.titles//名称，一维数组
                },
                series:{
                    name:"客户状态",//名称
                    type:"pie",//类型
                    radius:"60%",//圆的半径
                    center: ['50%', '60%'],
                    //roseType: 'angle',//显示为南丁格尔样式
                    data: data.list2,//数据，需要二维数组
                    itemStyle: {
                        normal: {
                            shadowBlur: 200,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            });
        }
    });
})