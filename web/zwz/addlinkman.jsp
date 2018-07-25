<%--
  Created by IntelliJ IDEA.
  User: ZWZ
  Date: 2018/7/20
  Time: 15:58
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

<h4>客户信息管理 > 客户信息 > 联系人 > 新建联系人</h4>
<form action="${pageContext.request.contextPath }/z/zwz_addlinkmanww" method="post">
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
                <td align="center">姓名</td>
                <td>
                    <input type="hidden" name="id">
                    <input   type="text" name="name">
                    &nbsp;
                    <a style="color: red">*</a>
                </td>

                <td align="center">性别</td>

                <td>
                    <select name="sex">
                         <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </td>

            </tr>

            <tr  style="background: #F9F9F9" >
                <td align="center">职位</td>
                <td>

                    <input type="text"   name="post">
                    &nbsp;
                    <a style="color: red">*</a>
                </td>

                <td align="center">办公电话</td>

                <td>
                    <input type="text"  name="tel">
                    &nbsp;
                    <a style="color: red">*</a>
                </td>

            </tr>
            <tr  style="background: #F9F9F9" >
                <td align="center">手机</td>
                <td>

                    <input type="text"  name="phone">
                </td>

                <td align="center">备注</td>

                <td>
                    <input type="text"   name="ramark">
                </td>

            </tr>




        </tbody>
    </table>
</form>
</body>
</html>
