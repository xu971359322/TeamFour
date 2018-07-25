<%--
  Created by IntelliJ IDEA.
  User: ZWZ
  Date: 2018/7/23
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/zwz/js/zw/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/zwz/js/zw/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/zwz/js/zw/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/zwz/js/zw/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/zwz/js/zw/static/h-ui.admin/css/style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath }/zwz/js/zw/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <%-------------------------------------------------------------------------------------------------------------------------------%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/zwz/zwzcss/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/zwz/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/zwz/zwzcss/bootstrap.js"></script>
</head>

<h4>客户流失管理</h4>

<table class="table table-striped" align="center">
    <tbody>


    <tr   style="background: #F9F9F9"    >
        <td align="center" >
            <%--location.href--%>
            <input type="button" style="height: 30px;width: 50px" onclick="alert('详情联系：QQ:2991722289\n手机：17683766823\n邮箱:2991722289@qq.com')" value="帮助">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </td>

    </tr>

    </tbody>


</table>

<body class="pos-r">
<div style="margin-left:200px;">

    <div class="page-container">

        <div class="cl pd-5 bg-1 bk-gray mt-20">


            <span class="r">共有数据：<strong>${list1count }</strong> 条</span>
        </div>

        <div class="mt-20">
            <table class="table table-border table-bordered table-bg table-hover table-sort">
                <thead>
                <tr class="text-c">
                    <th width="40"><input name="" type="checkbox" value=""></th>
                    <th width="100">编号</th>
                    <th width="60">客户</th>
                    <th width="60">客户经理</th>
                    <th>上次下单时间</th>
                    <th width="100">确认流失时间</th>
                    <th width="70">状态</th>
                    <th width="70">操作</th>
                </tr>
                </thead>


                <tbody>

                <c:forEach items="${list1}" var="z" varStatus="i" >
                    <tr class="text-c va-m">
                        <td><input name="w" type="checkbox" value="${z.cid }"></td>
                        <td>${i.count }</td>
                        <td>${z.name}</td>
                        <td>${z.uname}</td>

                        <td>
                         ${z.time }
                        </td>
                        <td>

                        </td>
                        <td>

                                暂缓流失
                        </td>


                        <td class="td-manage">


                            <a style="text-decoration:none" class="ml-5" onClick="product_edit('${z.id}')"   title="暂缓措施">
                                <i class="Hui-iconfont">&#xe6df;</i></a>

                                <a style="text-decoration:none" class="ml-5" onClick="product_del('${z.id}')"   title="确定流失">
                                <i class="Hui-iconfont">&#xe6e2;</i></a>
                        </td>

                    </tr>

                </c:forEach>



                </tbody>
            </table>
        </div>
    </div>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/lib/jquery/1.9.1/jquery.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/lib/showall.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">


    var setting = {
        view: {
            dblClickExpand: false,
            showLine: false,
            selectedMulti: false
        },
        data: {
            simpleData: {
                enable:true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        },
        callback: {
            beforeClick: function(treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj("tree");
                if (treeNode.isParent) {
                    zTree.expandNode(treeNode);
                    return false;
                } else {
                    //demoIframe.attr("src",treeNode.file + ".html");
                    return true;
                }
            }
        }
    };




    $(document).ready(function(){
        var t = $("#treeDemo");
        t = $.fn.zTree.init(t, setting, zNodes);
        //demoIframe = $("#testIframe");
        //demoIframe.on("load", loadReady);
        var zTree = $.fn.zTree.getZTreeObj("tree");
        //zTree.selectNode(zTree.getNodeByParam("id",'11'));
    });

    $('.table-sort').dataTable({
        "aaSorting": [[ 1, "desc" ]],//默认第几个排序
        "bStateSave": true,//状态保存
        "aoColumnDefs": [
            {"orderable":false,"aTargets":[0,5]}// 制定列不参与排序
        ]
    });




    /*联系人-删除*/
    function product_del(id){
        var z=confirm('确定流失吗？');
        if(z){
            $.ajax({
                type: 'POST',
                url:'${pageContext.request.contextPath }/z/zwz_updatemeasure?id='+id,
                dataType: 'json'

            });
            setTimeout(function(){
                self.location='${pageContext.request.contextPath }/zwz/showdrain.jsp';
            },150);
        }



    }




    /*客户流失管理-添加流失措施*/
    function product_edit(id){
        $.ajax({
            type: 'POST',
            url:'${pageContext.request.contextPath }/z/zwz_selectmeasure?id='+id,
            dataType: 'json'

        });
        setTimeout(function(){
            self.location='${pageContext.request.contextPath }/zwz/showmeasure.jsp';
        },150);


    }




</script>
</body>
</html>
