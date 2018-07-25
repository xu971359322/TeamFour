<%--
  Created by IntelliJ IDEA.
  User: ZWZ
  Date: 2018/7/24
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/zwz/zwzcss/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/zwz/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/zwz/zwzcss/bootstrap.js"></script>

</head>
<body>

<h4>客户流失管理 > 确认流失</h4>
<form action="${pageContext.request.contextPath }/z/zwz_addmeasure" method="post">
    <table class="table table-striped" align="center">
        <tbody>

        <tr   style="background: #F9F9F9" >

            <td align="right" colspan="4" >
                <%--location.href--%>
                <input type="button" onclick="alert('详情联系：QQ:2991722289\n手机：17683766823\n邮箱:2991722289@qq.com')" value="帮助">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="button" onclick="window.parent.location.reload();parent.layer.close(parent.layer.getFrameIndex(window.name));"  value="返回">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      <button  onclick=" return confirm('确定保存吗？')" type="submit">保存</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </td>

        </tr>
        <c:forEach items="${inquirer}" var="z" >
        <tr  style="background: #F9F9F9" >
            <td align="center">编号</td>
            <td>
                ${z.id}
            </td>
            <td align="center">客户</td>
            <td>
                ${z.name}

            </td>
        </tr>

        <tr  style="background: #F9F9F9" >
            <td align="center">客户经理</td>
            <td>
                ${z.uname}
            </td>
            <td align="center">上次下单时间</td>
            <td>
                ${z.time}

            </td>
        </tr>
        </c:forEach>

        <c:forEach items="${measure}" var="i">

            <tr  style="background: #F9F9F9" >
                <td align="center">暂缓措施</td>
                <td>
                        ${i.content}
                </td>

            </tr>

        </c:forEach>

        <tr  style="background: #F9F9F9" >
            <td align="center">追加暂缓措施</td>
            <td>
                <textarea name="name"   cols="40"   rows="4"   style="OVERFLOW:   hidden"></textarea>

            </td>

        </tr>

        </tbody>
    </table>
</form>
</body>
</html>
