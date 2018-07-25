<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2018/7/25
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="main">
    <h1 style="font-size:25px;">公司每年的季度销量</h1>
    <div id="divShow" style="width:1300px;height:700px;position:absolute;top:130px;"></div>
</div>
<script src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/login/js/echarts.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        var chart = echarts.init($("#divShow")[0]);
        var app = {};

        var posList = [
            'left', 'right', 'top', 'bottom',
            'inside',
            'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
            'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
        ];

        app.configParameters = {
            rotate: {
                min: -90,
                max: 90
            },
            align: {
                options: {
                    left: 'left',
                    center: 'center',
                    right: 'right'
                }
            },
            verticalAlign: {
                options: {
                    top: 'top',
                    middle: 'middle',
                    bottom: 'bottom'
                }
            },
            position: {
                options: echarts.util.reduce(posList, function (map, pos) {
                    map[pos] = pos;
                    return map;
                }, {})
            },
            distance: {
                min: 0,
                max: 100
            }
        };

        app.config = {
            rotate: 90,
            align: 'left',
            verticalAlign: 'middle',
            position: 'insideBottom',
            distance: 15,
            onChange: function () {
                var labelOption = {
                    normal: {
                        rotate: app.config.rotate,
                        align: app.config.align,
                        verticalAlign: app.config.verticalAlign,
                        position: app.config.position,
                        distance: app.config.distance
                    }
                };
                chart.setOption({
                    series: [{
                        label: labelOption
                    }, {
                        label: labelOption
                    }, {
                        label: labelOption
                    }, {
                        label: labelOption
                    }]
                });
            }
        };


        var labelOption = {
            normal: {
                show: true,
                position: app.config.position,
                distance: app.config.distance,
                align: app.config.align,
                verticalAlign: app.config.verticalAlign,
                rotate: app.config.rotate,
                formatter: '{c}  {name|{a}}',
                fontSize: 16,
                rich: {
                    name: {
                        textBorderColor: '#fff'
                    }
                }
            }
        };

        var option = {
            color: ['#003366', '#006699', '#4cabce', '#e5323e'],
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            legend: {
                data: ['一季度', '二季度', '三季度', '四季度']
            },
            toolbox: {
                show: true,
                orient: 'vertical',
                left: 'right',
                top: 'center',
                feature: {
                    mark: {show: true},
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            calculable: true,
            xAxis: [
                {
                    type: 'category',
                    axisTick: {show: false},
                    data: []
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],series:[]
        };

        chart.setOption(option);


        /********************************用ajax动态加载数据****************************************************/
        //利用ajax请求，得到json
        $.ajax({
            url:"${pageContext.request.contextPath}/p/ping_showQuarter",
            type:"post",
            dataType:"json",
            success:function(data){
                //设置组件的属性
                chart.setOption({
                    xAxis:[
                        {
                            data:data.yearInfo
                        }
                    ],series: [
                        {
                            name: '一季度',
                            type: 'bar',
                            barGap: 0,
                            label: labelOption,
                            data:data.count1
                        },
                        {
                            name: '二季度',
                            type: 'bar',
                            label: labelOption,
                            data:data.count2
                        },
                        {
                            name: '三季度',
                            type: 'bar',
                            label: labelOption,
                            data:data.count3
                        },
                        {
                            name: '四季度',
                            type: 'bar',
                            label: labelOption,
                            data:data.count4
                        }
                    ]
                });
            }
        });
    })
</script>
</body>
</html>
