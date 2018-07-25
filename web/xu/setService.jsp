<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/12
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建服务</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/xu/js/jquery-1.8.3.min.js"></script>
    <script src="js/setService.js"></script>
</head>
<body style="height: 500px;">
<s:debug/>
    <h2>客户服务管理>>>>创建管理</h2>
    <!-- CONDENSED TABLE -->

    <form action="${pageContext.request.contextPath}/xu/serv_add.action" method="post" id="frm">
        <table class="table table-striped" align="center">
            <tbody >
                <tr >
                    <td align="center">编号</td>
                    <td>
                        <input type="text" name="sc.scId" value="${maxId+1}" readonly>
                    </td>
                    <td align="center">服务类型</td>
                    <td>
                        <select name="sc.sdId" id="sdid">
                            <option value="-1">请选择</option>
                            <s:iterator value="servedetail">
                                <option value="${sd_id}">${sd_name}</option>
                            </s:iterator>
                        </select>
                        <span name="typespan"><img src="js/img/err.png"></span>
                    </td>
                </tr>
                <tr>
                    <td align="center">概要</td>
                    <td colspan="2">
                        <input type="text" name="sc.scDescribe" size="55" id="describe">
                        <span name="describespan"><img src="js/img/err.png"></span>
                    </td>

                </tr>
                <tr>
                    <td align="center">客户</td>
                    <td>
                        <select name="sc.cid" id="cid">
                            <option value="-1">请选择客户</option>
                            <s:iterator value="client">
                                <option value="${cid}">${companyname}</option>
                            </s:iterator>
                        </select>
                        <span name="clentspan"><img src="js/img/err.png"></span>
                    </td>
                    <td align="center">状态</td>
                    <td><span>新创建</span></td>
                </tr>
                <tr>
                    <td align="center"> 服务请求</td>
                    <td colspan="2">
                        <textarea name="sc.sdRequest" id="" cols="50" rows="7" id="request" ></textarea>
                        <span name="requestspan"><img src="js/img/err.png"></span>
                    </td>
                </tr>
                <tr>
                    <td align="center">创建人</td>
                    <td><input type="text" name="uname" value="${sessionScope.user.uname}" disabled></td>
                    <td align="center">创建时间</td>
                    <td><input type="text" value="" name="sc.scSettime" id="myDate" readonly></td>
                </tr>
            </tbody>
        </table>
        <button class="btn btn-primary" type="submit">提交</button>
        <button class="btn btn-primary">帮助</button>
    </form>
<script language="JavaScript">
    var now = new Date();
    myDate.value=now.getFullYear() + "-"+ (now.getMonth()+1)+"-"+now.getDate()+" "+now.getHours()+":"+now.getMinutes()+":"+now.getSeconds();
</script>
</body>
</html>
