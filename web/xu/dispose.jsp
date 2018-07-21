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
    <script src="js/dispose.js"></script>
</head>
<body>
<s:iterator value="datail">
<h1>查看服务详情</h1>
<form action="${pageContext.request.contextPath}/xu/serv_addDeal.action" method="post">
    <table class="table table-striped" align="center">
        <tbody>
            <tr>
                <td align="center">编号</td>
                <td>
                     ${scid}<input type="hidden" name="dis.scId" value="${scid}">
                </td>
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
                <s:if test="status==2 or status==3">
                    <td>已分配</td>
                </s:if>
                <s:elseif test="status==4">
                    <td>已处理</td>
                </s:elseif>
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
                <td>${gettime}</td>
            </tr>
            <tr style="height: 40px">
                <td ></td>
            </tr>
            <s:if test="status==2">
            <tr>
                <td align="center">服务处理</td>
                <td colspan="3">
                    <textarea cols="30" rows="5" name="dis.diContent"></textarea>
                </td>
            </tr>
            <tr>
                <td align="center">处理人</td>
                <td >
                    <input type="text" name="uname" value="${user.uname}">
                </td>
                <td align="center">处理时间</td>
                <td>
                    <input type="text" name="dis.diTime" id="myDate">
                </td>
            </tr>
        </s:if>
            <s:else>
                <tr>
                    <td align="center">服务处理</td>
                    <td colspan="3">${di_content}</td>
                </tr>
                <tr>
                    <td align="center">处理人</td>
                    <td >${dealname}</td>
                    <td align="center">处理时间</td>
                    <td>${di_time}</td>
                </tr>
            </s:else>
        <tr style="height: 40px">
            <td colspan="4"></td>
        </tr>
        <s:if test="status==3">
            <tr>
                <td align="center">处理结果</td>
                <td>
                    <input type="text" name="dis.diResult">
                </td>
                <td align="center">满意度</td>
                <td>
                    <select name="dis.faction">
                        <option value="-1">请选择满意度</option>
                        <option value="1">★</option>
                        <option value="2">★★</option>
                        <option value="3">★★★</option>
                        <option value="4">★★★★</option>
                        <option value="5">★★★★★</option>
                    </select>
                </td>

            </tr>
        </s:if>
        <s:if test="status==4">
            <tr>
                <td align="center">处理结果</td>
                <td>${di_result} </td>
                <td align="center">满意度</td>
                <td>
                    <c:forEach begin="1" end="${faction}">
                        ★
                    </c:forEach>
                </td>
            </tr>
        </s:if>
        </tbody>
    </table>
    <input type="hidden" name="status" value="${status}">
    <input type="hidden" name="dis.diId" value="${di_id}">
    <s:if test="status!=4">
        <button class="btn btn-primary" type="submit">提交</button>
        <button class="btn btn-primary">帮助</button>
    </s:if>
    </s:iterator>
</form>
    <script language="JavaScript">
        var now = new Date();
        myDate.value=now.getFullYear() + "-"+ (now.getMonth()+1)+"-"+now.getDate()+" "+now.getHours()+":"+now.getMinutes()+":"+now.getSeconds();

    </script>
</body>
</html>
