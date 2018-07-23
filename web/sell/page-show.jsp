
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>客户销售管理</title>
    <meta charset="utf-8">
    <script type="text/javascript" src="${pageContext.request.contextPath }/sell/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/sell/js/script2.js"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/vendor/linearicons/style.css">
    <link rel="stylesheet" href="assets/vendor/chartist/css/chartist-custom.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="assets/css/demo.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
    <style type="text/css">
        table,tr,td,th{
            text-align: center;
        }
        .sell-div{
            height: 30px;
            width: 85px;
            background-color: #00aa00;
            color: white;
            text-align: center;
            border: 1px chartreuse solid;
            font-size: 17px;
            border-radius: 20px;
            float: left;
            margin-right: 20px;
            padding-bottom: 10px;
         }
       .sell-div a{
            text-decoration:none;
        }
        table{
            font-size: 25px;
        }
</style>
</head>
<body>
<!-- MAIN CONTENT -->
<div class="main-content" style="width: 100%">
    <div class="container-fluid" style="width: 100%">
        <div class="col-md-6" style="width: 100%">
        <!-- BASIC TABLE -->
        <div class="panel" style="width: 99%">
            <div class="panel-heading">
                <h3 class="panel-title">客户开发计划</h3>
            </div>
            <div class="panel-body" style="width: 100%;font-size: 25px">
                <center>
                            客户名称:<input name="companyname" type="text" value="${companyname}">&nbsp;&nbsp;&nbsp;
                            概要：<input type="text" name="cdescribe" value="${cdescribe}">&nbsp;&nbsp;&nbsp;
                            联系人:<input type="text" name="cname" value="${cname}">&nbsp;&nbsp;&nbsp;
                </center>
                <table class="table">
                    <thead>
                    <tr>
                        <th>编号1</th>
                        <th>客户名称</th>
                        <th>概要</th>
                        <th>联系人</th>
                        <th>联系电话</th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody name="tbodyc">
                        <c:forEach items="${sessionScope.sellList}" var="li" varStatus="k">
                            <tr>

                                <td>${k.index+1+ (sessionScope.sellIndex-1)*sessionScope.sellSize}</td>
                                <td>${li.companyname}</td>
                                <td>${li.cdescribe}</td>
                                <td>${li.cname}</td>
                                <td>${li.ctel}</td>
                                <td><fmt:formatDate
                                        type="date"
                                        value="${li.ctime}"
                                        dateStyle="default"
                                /></td>
                                <td>
                                    <c:if test="${li.cstatus!=0}">
                                         <a href="sell_page?cid=${li.cid}">编辑销售计划 </a>
                                    </c:if>
                                    <c:if test="${li.cstatus==0}">
                                        该客户未指派 无法制定计划
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    <tr>
                        <td></td>
                        <td colspan="4" align="center">
                            <c:if test="${sessionScope.sellIndex != 1}">
                                <a href="sell_change?index=1&p=2"><div class="sell-div">首页</div></a>
                                <a href="sell_change?index=${sessionScope.sellIndex-1}&p=2"><div class="sell-div">上一页</div></a>
                            </c:if>
                            <c:if test="${sessionScope.sellIndex == 1 }">
                                <a  onclick="alert('已经是第一页了')"><div class="sell-div">首页</div></a>
                                <a  onclick="alert('已经是第一页了')"><div class="sell-div">上一页</div></a>
                            </c:if>
                            <a href="#"><div class="sell-div"></div></a>
                            <a href="#"><div class="sell-div"></div></a>
                            <a href="#"><div class="sell-div"></div></a>

                        </td>
                        <td align="center">
                            <c:if test="${sessionScope.sellIndex == sessionScope.sellcount}">
                            <a  onclick="alert('已经是最后一页了')"><div class="sell-div">下一页</div></a>
                            <a  onclick="alert('已经是最后页了')"><div class="sell-div">尾页</div></a>
                        </c:if>
                            <c:if test="${sessionScope.sellIndex != sessionScope.sellcount}">
                                <a href="sell_change?index=${sessionScope.sellIndex+1}&p=2"><div class="sell-div">下一页</div></a>
                                <a href="sell_change?index=${sessionScope.sellcount}&p=2"><div class="sell-div">尾页</div></a>
                            </c:if>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- END BASIC TABLE -->
    </div>

    </div>
</div>
</body>
</html>
