<%--
  Created by IntelliJ IDEA.
  User: ZWZ
  Date: 2018/7/22
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/zwz/js/zw/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/zwz/js/zw/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/zwz/js/zw/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/zwz/js/zw/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/zwz/js/zw/static/h-ui.admin/css/style.css" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/zwz/zwzcss/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/zwz/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/zwz/zwzcss/bootstrap.js"></script>


</head>
<body  class="pos-r">

<h4>客户信息管理 > 客户信息 > 历史订单 > 订单明细 </h4>
<form action="${pageContext.request.contextPath }/z/zwz_updateuser" method="post">
    <table class="table table-striped" align="center">
        <tbody>
        <c:forEach items="${detaillist}" var="z">
            <tr   style="background: #F9F9F9"    >
                <td align="right" colspan="4" >
                        <%--location.href--%>
                    <input type="button" style="height: 30px;width: 50px" onclick="alert('详情联系：QQ:2991722289\n手机：17683766823\n邮箱:2991722289@qq.com')" value="帮助">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="button"  style="height: 30px;width: 50px" onclick="window.parent.location.reload();parent.layer.close(parent.layer.getFrameIndex(window.name));"  value="返回">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>

            </tr>

            <tr  style="background: #F9F9F9" >
                <td align="center">编号</td>
                <td>
                        ${z.id}
                </td>
                <td align="center">日期</td>
                <td>
                     ${z.time}

                </td>
            </tr>


            <tr  style="background: #F9F9F9" >
                <td align="center">送货地址</td>
                <td>
                        ${z.opath}
                </td>
                <td align="center">总金额（元）</td>
                <td>
                 ${addresscount}
                </td>
            </tr>


            <tr  style="background: #F9F9F9" >
                <td align="center">状态</td>
                <td>
                    <c:if test="${z.ostutas==1 }">
                    已回款
                </c:if>
                    <c:if test="${z.ostutas==0 }">
                        未回款
                    </c:if>
                </td>

            </tr>

        </c:forEach>

        </tbody>
    </table>

</form>

<div style="margin-left:200px;">

    <div class="page-container">

        <div class="cl pd-5 bg-1 bk-gray mt-20">


            <span class="r">共有数据：<strong>${addresslistsize }</strong> 条</span>
        </div>



        <div class="mt-20">
            <table class="table table-border table-bordered table-bg table-hover table-sort">
                <thead>
                <tr class="text-c">
                    <th width="40"><input name="" type="checkbox" value=""></th>
                    <th width="40">序号</th>
                    <th width="60">商品</th>
                    <th width="200">数量</th>
                    <th >单位</th>
                    <th width="100">单价（元）</th>
                    <th width="100">金额（元）</th>
                </tr>
                </thead>


                <tbody>

                <c:forEach items="${addresslist }" var="z" varStatus="i" >
                    <tr class="text-c va-m">
                        <td><input name="w" type="checkbox" value="${z.id }"></td>
                        <td>${i.count }</td>
                        <td>${z.name}-${z.gtype}</td>
                        <td>${z.ocount}</td>

                        <td><span class="price">台</span>  </td>
                        <td><span class="price">${z.gprice }</span> </td>

                        <td class="td-status">
                           ${z.price}
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
            {"orderable":false,"aTargets":[0,6]}// 制定列不参与排序
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
