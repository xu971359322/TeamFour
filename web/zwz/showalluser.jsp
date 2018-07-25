<%--
  Created by IntelliJ IDEA.
  User: ZWZ
  Date: 2018/7/13
  Time: 9:30
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

</head>

<h4>    客户信息管理 </h4>
<body class="pos-r">
<div style="margin-left:200px;">

    <div class="page-container">

        <div class="cl pd-5 bg-1 bk-gray mt-20">


            <span class="r">共有数据：<strong>${count }</strong> 条</span>
        </div>



        <div class="mt-20">
            <table class="table table-border table-bordered table-bg table-hover table-sort">
                <thead>
                <tr class="text-c">
                    <th width="40"><input name="" type="checkbox" value=""></th>
                    <th width="40">序号</th>
                    <th width="60">客户编号</th>
                    <th width="200">名称</th>
                    <th >地区</th>
                    <th width="100">客户经理</th>
                    <th width="100">客户等级</th>
                    <th width="100">操作</th>
                </tr>
                </thead>


                <tbody>

                <c:forEach items="${list }" var="z" varStatus="i" >
                    <tr class="text-c va-m">
                        <td><input name="w" type="checkbox" value="${z.id }"></td>
                        <td>${i.count }</td>
                        <td>WJVOPwfvo${i.count}</td>
                        <td>${z.NAME}</td>

                        <td><span class="price">${z.place }</span>  </td>
                        <td><span class="price">${z.uname }</span> </td>

                        <td class="td-status">
                            <c:if test="${z.lv==1}">
                                战略伙伴
                            </c:if>
                            <c:if test="${z.lv==2}">
                                合作伙伴
                            </c:if>
                            <c:if test="${z.lv==3}">
                                大客户
                            </c:if>
                            <c:if test="${z.lv==4}">
                                重点开发客户
                            </c:if>
                            <c:if test="${z.lv==5}">
                                普通客户
                            </c:if>

                        </td>
                        <td class="td-manage">


                            <a style="text-decoration:none" class="ml-5" onClick="product_edit('${pageContext.request.contextPath }/zwz/userredact.jsp','${z.id}')"   title="编辑">
                                <i class="Hui-iconfont">&#xe6df;</i></a>

                            <a style="text-decoration:none" class="ml-5" onClick="product_del('${z.id}')"  title="删除">
                                <i class="Hui-iconfont">&#xe6e2;</i></a></td>
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
            {"orderable":false,"aTargets":[0,7]}// 制定列不参与排序
        ]
    });






    /*人员-删除*/
    function product_del(id){
     var z=confirm('确定删除吗？');
     if(z){
         $.ajax({
         type: 'POST',
         url:'${pageContext.request.contextPath }/z/zwz_deleuser?id='+id,
         dataType: 'json'

         });
         setTimeout(function(){
             self.location='${pageContext.request.contextPath }/zwz/showalluser.jsp';
         },300);
     }



    }


    /*人员-编辑*/
    function product_edit(url,id){
        $.ajax({
            type: 'POST',
            url:'${pageContext.request.contextPath }/z/zwz_userredact?id='+id,
            dataType: 'json'

        });
        setTimeout(function(){
           self.location='${pageContext.request.contextPath }/zwz/userredact.jsp';
        },300);


    }




</script>
</body>
</html>