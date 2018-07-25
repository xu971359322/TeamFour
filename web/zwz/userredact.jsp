<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/16
  Time: 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/zwz/zwzcss/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/zwz/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/zwz/zwzcss/bootstrap.js"></script>


</head>
<body >

<h4>客户信息管理 > 客户信息</h4>
<form action="${pageContext.request.contextPath }/z/zwz_updateuser" method="post">
    <table class="table table-striped" align="center">
        <tbody>
        <c:forEach items="${user}" var="z">
            <tr   style="background: #F9F9F9"    >
                <td align="right" colspan="4" >
                    <%--location.href--%>
                    <input type="button" onclick="alert('详情联系：QQ:2991722289\n手机：17683766823\n邮箱:2991722289@qq.com')" value="帮助">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      <input type="button" onclick="window.location.href='${pageContext.request.contextPath }/z/zwz_showcontacts'" value="联系人">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="button" onclick="window.location.href='${pageContext.request.contextPath }/z/zwz_showchat'" value="交往记录">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="button"  onclick="window.location.href='${pageContext.request.contextPath }/z/zwz_showorders'" value="历史订单">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="button" onclick="window.parent.location.reload();parent.layer.close(parent.layer.getFrameIndex(window.name));"  value="返回">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <button  onclick=" return confirm('确定保存吗？')" type="submit">保存</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>

            </tr>

            <tr  style="background: #F9F9F9" >
                <td align="center">编号</td>
                <td>
                    ${z.id}
                </td>
                <td align="center">名称</td>
                <td>
                <input type="text" value="${z.NAME}" name="name">
                    &nbsp;
                    <a style="color: red">*</a>
                </td>
            </tr>



            <tr style="background: #F9F9F9">
                <td align="center">地区</td>
                <td>

                    <select name="place" >
                        <option value="-1">请选择地区</option>
                        <c:forEach items="${dz}" var="w">

                            <option value="${w}"
                                    <c:if test="${w==z.place}">
                                      selected
                                    </c:if>>${w}
                            </option>

                        </c:forEach>
                    </select>

                    &nbsp;
                    <a style="color: red">*</a>

                </td>
                <td align="center">客户经理</td>
                <td>
                     <select name="manager" >
                    <option value="-1">--请选择--</option>

                    <c:forEach items="${managerr}" var="zw">

                        <option value="${zw.manager}"
                                <c:if test="${zw.manager==z.uname}">
                                    selected
                                </c:if>>${zw.manager}
                        </option>

                    </c:forEach>

                </select>


                    &nbsp;
                    <a style="color: red">*</a>

                </td>
            </tr>

            <tr style="background: #F9F9F9">
                <td align="center">客户等级</td>
                <td>

                    <select name="lv" >
                        <option value="-1">--请选择--</option>

                        <c:forEach items="${dj}" var="x" varStatus="i">

                            <option value="${i.count}"
                                    <c:if test="${i.count==z.lv}">
                                        selected
                                    </c:if>>${x}
                            </option>

                        </c:forEach>

                    </select>
                    &nbsp;
                    <a style="color: red">*</a>

                </td>

            </tr>


            <tr style="background: #F9F9F9">
                <td align="center">客户满意度</td>
                <td>
                    <select name="satisfaction" >
                        <option value="-1">--请选择--</option>

                        <c:forEach items="${xx}" var="x" varStatus="i">

                            <option value="${i.count}"
                                    <c:if test="${i.count==z.satisfaction}">
                                        selected
                                    </c:if>>${x}
                            </option>

                        </c:forEach>

                    </select>
                    &nbsp;
                    <a style="color: red">*</a>

                </td>
                <td align="center">客户信用度</td>
                <td>
                    <select name="credit" >
                    <option value="-1">--请选择--</option>

                    <c:forEach items="${xx}" var="x" varStatus="i">

                    <option value="${i.count}"
                            <c:if test="${i.count==z.credit}">
                                selected
                            </c:if>>${x}
                    </option>

                    </c:forEach>
                    &nbsp;
                    <a style="color: red">*</a>

                </td>
            </tr>


            <tr style="height: 40px; background: #FFFFFF">
            <td ></td>
            </tr>

            <tr style="background: #F9F9F9">
                <td align="center">地址</td>
                <td>
                    <input type="text" value="${z.placeDetail}" name="placeDetail">
                    &nbsp;
                    <a style="color: red">*</a>

                </td>
                <td align="center">邮政编码</td>
                <td>
                    <input type="text" value="${z.email}" name="email">
                    &nbsp;
                    <a style="color: red">*</a>
                </td>
            </tr>

            <tr style="background: #F9F9F9">
                <td align="center">电话</td>
                <td>
                    <input type="text" value="${z.companytel}" name="companytel">
                    &nbsp;
                    <a style="color: red">*</a>

                </td>

                <td align="center">传真</td>
                <td>
                    <input type="text" value="${z.fax}" name="fax">
                    &nbsp;
                    <a style="color: red">*</a>
                </td>
            </tr>

            <tr style="background: #F9F9F9">
                <td align="center">网址</td>
                <td>
                    <input type="text" value="${z.url}" name="url">
                    &nbsp;
                    <a style="color: red">*</a>
                </td>

            </tr>
            <tr style="height: 40px; background: #FFFFFF">
                <td ></td>
            </tr>

            <tr style="background: #F9F9F9">
                <td align="center">营业执照注册号
                </td>
                <td>
                    <input type="text" value="${z.busineslicense}" name="busineslicense">
                </td>

                <td align="center">法人</td>
                <td>
                    <input type="text" value="${z.legalperson}" name="legalperson">
                    &nbsp;
                    <a style="color: red">*</a>
                </td>
            </tr>

            <tr style="background: #F9F9F9">
                <td align="center">注册资金（万元）</td>
                <td>
                    <input type="text" value="${z.loginprice}" name="loginprice">
                </td>

                <td align="center">年营业额</td>
                <td>
                    <input type="text" value="${z.yearprice}" name="yearprice">
                </td>
            </tr>

            <tr style="background: #F9F9F9">
                <td align="center">开户银行</td>
                <td>
                    <input type="text" value="${z.openback}" name="openback">
                    &nbsp;
                    <a style="color: red">*</a>
                </td>

                <td align="center">银行帐号</td>
                <td>
                    <input type="text" value="${z.backNo}" name="backNo">
                    &nbsp;
                    <a style="color: red">*</a>
                </td>
            </tr>

            <tr style="background: #F9F9F9">
                <td align="center">地税登记号</td>
                <td>
                    <input type="text" value="${z.governmentNo}" name="governmentNo">
                </td>

                <td align="center">国税登记号</td>
                <td>
                    <input type="text" value="${z.countryNo}" name="countryNo">
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</form>

</body>
</html>
