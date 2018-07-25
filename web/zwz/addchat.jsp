<%--
  Created by IntelliJ IDEA.
  User: ZWZ
  Date: 2018/7/21
  Time: 15:59
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

<h4>客户信息管理 > 客户信息 > 交往记录 > 新建交往记录</h4>
<form action="${pageContext.request.contextPath }/z/zwz_addchat" method="post">
    <table class="table table-striped" align="center">
        <tbody>

        <tr   style="background: #F9F9F9"    >
            <td align="right" colspan="4" >
                <%--location.href--%>
                <input type="button" onclick="alert('详情联系：QQ:2991722289\n手机：17683766823\n邮箱:2991722289@qq.com')" value="帮助">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="button" onclick="window.parent.location.reload();parent.layer.close(parent.layer.getFrameIndex(window.name));"  value="返回">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button  onclick=" return confirm('确定保存吗？')" type="submit">保存</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </td>

        </tr>


        <tr  style="background: #F9F9F9" >
            <td align="center">时间</td>
            <td>
                <input type="date" name="time">
                &nbsp;
                <a style="color: red">*</a>
            </td>

            <td align="center">地点</td>

            <td>
                <input type="text"   name="path">
                &nbsp;
                <a style="color: red">*</a>
            </td>

        </tr>

        <tr  style="background: #F9F9F9" >
            <td align="center">概要</td>
            <td>

                <input type="text"   name="describe">
                &nbsp;
                <a style="color: red">*</a>
            </td>

            <td align="center">备注</td>

            <td>
                <input type="text"  name="camark">
            </td>

        </tr>
        <tr  style="background: #F9F9F9" >
            <td align="center">详细信息</td>
            <td>

                <textarea name="detail"   cols="40"   rows="4"   style="OVERFLOW:   hidden"></textarea>
            </td>




        </tr>




        </tbody>
    </table>
</form>
</body>
</html>
