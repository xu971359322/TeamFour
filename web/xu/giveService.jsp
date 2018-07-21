<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/14
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/xu/js/jquery-1.8.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/xu/js/giveService.js"></script>

    <script src="${pageContext.request.contextPath }/xu/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath }/xu/assets/js/dataTables/dataTables.bootstrap.js"></script>


</head>
<body onload="load(${status})">
<s:debug/>
    <h2>客户服务管理>>>>服务分配</h2>

    <form action="${pageContext.request.contextPath }/xu/serv_sel.action" method="post">
        <table class="table table-striped" align="center" >
            <tbody >
                <tr>
                    <td>客户</td>
                    <td>
                        <select name="ss.cid">
                            <option value="-1">请选择客户</option>
                            <c:forEach items="${sessionScope.clients}" var="cl">
                                <option value="${cl.cid}">${cl.companyname}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>概要</td>
                    <td>
                        <input type="text" name="ss.content">
                    </td>
                    <td>服务类型</td>
                    <td>
                        <select name="ss.sdId">
                            <option value="-1">全部</option>
                            <s:iterator value="servedetail">
                                <option value="${sd_id}">${sd_name}</option>
                            </s:iterator>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>创建日期</td>
                    <td colspan="3">
                        <input type="date" name="ss.beginTime">-
                        <input type="date" name="ss.endTime">

                    </td>
                    <td>状态</td>
                    <td>
                        <select id="status" disabled>
                            <option value="-1">全部</option>
                            <option value="1">新创建</option>
                            <option value="2">已分配</option>
                            <option value="3">已处理</option>
                            <option value="4">已归档</option>
                        </select>
                    </td>
                </tr>
            </tbody>
        </table>
        <input type="hidden" value="${status}" name="ss.scstatus" >
        <button class="btn btn-primary" type="submit">查询</button>
        <button class="btn btn-primary">帮助</button>
    </form>

    <%--<div id="mydiv"></div>--%>
<div class="panel panel-default">
    <div class="panel-heading">
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-striped" align="center" id="dataTables-example">
                    <thead align="center">
                        <tr align="center">
                            <th>编号</th>
                            <th>客户</th>
                            <th>概要</th>
                            <th>服务类型</th>
                            <th>创建人</th>
                            <th>创建日期</th>
                            <s:if test="status==1">
                                <th>分配</th>
                            </s:if>

                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                            <s:iterator value="newService">
                                <tr align="center" >
                                    <td>${scid}</td>
                                    <td>${companyname}</td>
                                    <td>${scdescribe}</td>
                                    <td>${sdname}</td>
                                    <td>${uname}</td>
                                    <td>${time}</td>
                                    <s:if test="status==1">
                                        <td>
                                            <select name="uid">
                                                <option value="-1">请选择</option>
                                                <s:iterator value="users">
                                                    <option value="${uid}">${uname}</option>
                                                </s:iterator>
                                            </select>
                                            <button>
                                                <span class="give">分配</span>
                                            </button>
                                            <input type="hidden" value="${scid}">
                                        </td>
                                    </s:if>
                                    <td>
                                        <s:if test="status==1">
                                            <button class="btn btn-danger">删除</button>
                                        </s:if>
                                        <s:elseif test="status==2">
                                            <button class="btn btn-warning" >
                                               <a href="${pageContext.request.contextPath}/xu/serv_deal.action?scId=${scid}">处理</a>
                                            </button>
                                        </s:elseif>
                                        <s:elseif test="status==3">
                                            <button class="btn btn-info" >
                                                <a href="${pageContext.request.contextPath}/xu/serv_over.action?scId=${scid}">处理</a>
                                            </button>
                                        </s:elseif>
                                        <s:elseif test="status==4">
                                            <button class="btn btn-group">
                                                <a href="${pageContext.request.contextPath}/xu/serv_lastDetail.action?scId=${scid}">查看</a>
                                            </button>
                                        </s:elseif>
                                    </td>
                                </tr>
                            </s:iterator>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<input type="hidden" id="myDate">
<script language="JavaScript">
    var now = new Date();
    myDate.value=now.getFullYear() + "-"+ (now.getMonth()+1)+"-"+now.getDate()+" "+now.getHours()+":"+now.getMinutes()+":"+now.getSeconds();
    $(document).ready(function () {

        $('#dataTables-example').dataTable({
            language: {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "lengthMenu": [5,10,20,50,100],
            "autoWidth":true

        });




    });
</script>
</body>
</html>
