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
    <script src="js/giveService.js"></script>
</head>
<body onload="load(${status})">
<s:debug/>
    <h2>客户服务管理>>>>服务分配</h2>

    <form action="xu/serv_sel.action" method="post">
        <table class="table table-striped" align="center">
            <tbody >
                <tr>
                    <td>客户</td>
                    <td>
                        <input type="text">
                    </td>
                    <td>概要</td>
                    <td>
                        <input type="text">
                    </td>
                    <td>服务类型</td>
                    <td>
                        <select name="status">
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
                        <input type="date" name="">-
                        <input type="date" name="">

                    </td>
                    <td>状态</td>
                    <td>
                        <select name="scstatus" readonly="true">
                            <option value="-1">全部</option>
                            <option value="1">新创建</option>
                            <option value="2">已分配</option>
                            <option value="3">已处理</option>
                            <option value="3">归档</option>
                        </select>
                    </td>
                </tr>
            </tbody>
        </table>

        <button class="btn btn-primary" type="submit">查询</button>
        <button class="btn btn-primary">帮助</button>
    </form>

    <table class="table table-striped" align="center">
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
            <div id="mydiv">
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
                        </td>
                    </tr>
                </s:iterator>

            </div>
        </tbody>
    </table>

<input type="hidden" id="myDate">
<script language="JavaScript">
    var now = new Date();
    myDate.value=now.getFullYear() + "-"+ (now.getMonth()+1)+"-"+now.getDate()+" "+now.getHours()+":"+now.getMinutes()+":"+now.getSeconds();

</script>
</body>
</html>
