$(function () {
    /**
     * 加载
     */
    $("[name=uname]").keyup(function (){
    })


    var chart = echarts.init($("#div1")[0]);

    //2、设置图表的属性
    var option={

        //标题
        title:{
            text:"各电脑品牌销售数据汇总",
            //x:"center",  //对齐方式
            subtext:"统计人:张三丰"//子标题

        },
        //鼠标悬停在当前柱状时的提示信息（默认显示：品牌名称，销售数据）
        tooltip:{
            trigger: 'item',//设置鼠标悬 停时显示的内容{a}为xAxis中name的名称,{b}为,series中data值,{c}为series部份data的值
            formatter: "{a} <br/>{b} : {c}万元"
        },
        //下载或切换视图
        toolbox: {
            show : true,
            feature : {
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        //每一个颜色对应的名称
        legend: {
            data:["销售数据"]//颜色标题,需要与series的name一致，才可以显示
        },
        //x坐标
        xAxis:{
            data:["联想","IBM","华硕","戴尔","小米","APPLE"]
        },
        //y坐标
        yAxis:{},
        //指定要显示的数据
        series:{
            name:"销售数据",//图表的名称
            type:"bar",//图表的类型 //bar,pie,line
            data:[231,451,239,421,355,109]//图表要显示的数据
        }
    }
    //给渲染的组件，设置图表属性
    chart.setOption(option);
})