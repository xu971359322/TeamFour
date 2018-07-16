<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/16
  Time: 8:25
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
</head>
<body>
    <table class="table table-striped" align="center">
        <tbody>
        <s:iterator value="datail">
            <tr>
                <td align="center">编号</td>
                <td>${scid}</td>
                <td align="center">服务类型</td>
                <td>${sdname}</td>
            </tr>
            <tr >
                <td align="center">概要</td>
                <td colspan="3">${scdescribe}</td>
            </tr>
            <tr>
                <td align="center">客户</td>
                <td>${companyname}</td>
                <td align="center">状态</td>
                <td>已分配</td>
            </tr>
            <tr >
                <td align="center">服务请求</td>
                <td colspan="3">${sd_request}</td>
            </tr>
            <tr>
                <td align="center">创建人</td>
                <td>${uname}</td>
                <td align="center">创建时间</td>
                <td>${TIME}</td>
            </tr>
            <tr style="height: 40px">
                <td ></td>
            </tr>
            <tr>
                <td align="center">分配给</td>
                <td>${gname}</td>
                <td align="center">分配时间</td>
                <td>${givetime}</td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</body>
</html>
