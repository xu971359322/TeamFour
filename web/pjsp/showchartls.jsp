<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
    <title>Notifications</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/linearicons/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/toastr/toastr.min.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/demo.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath}/assets/img/favicon.png">
</head>

<body>
<!-- WRAPPER -->
<div id="wrapper">
    <!-- NAVBAR -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="brand">
            <a href="index.html"><img src="${pageContext.request.contextPath}/assets/img/logo-dark.png" alt="Klorofil Logo" class="img-responsive logo"></a>
        </div>
        <div class="container-fluid">
            <div class="navbar-btn">
                <button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
            </div>
            <form class="navbar-form navbar-left">
                <div class="input-group">
                    <input type="text" value="" class="form-control" placeholder="Search dashboard...">
                    <span class="input-group-btn"><button type="button" class="btn btn-primary">Go</button></span>
                </div>
            </form>
            <div class="navbar-btn navbar-btn-right">
                <a class="btn btn-success update-pro" href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
            </div>
            <div id="navbar-menu">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
                            <i class="lnr lnr-alarm"></i>
                            <span class="badge bg-danger">5</span>
                        </a>
                        <ul class="dropdown-menu notifications">
                            <li><a href="#" class="notification-item"><span class="dot bg-warning"></span>System space is almost full</a></li>
                            <li><a href="#" class="notification-item"><span class="dot bg-danger"></span>You have 9 unfinished tasks</a></li>
                            <li><a href="#" class="notification-item"><span class="dot bg-success"></span>Monthly report is available</a></li>
                            <li><a href="#" class="notification-item"><span class="dot bg-warning"></span>Weekly meeting in 1 hour</a></li>
                            <li><a href="#" class="notification-item"><span class="dot bg-success"></span>Your request has been approved</a></li>
                            <li><a href="#" class="more">See all notifications</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="lnr lnr-question-circle"></i> <span>Help</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Basic Use</a></li>
                            <li><a href="#">Working With Data</a></li>
                            <li><a href="#">Security</a></li>
                            <li><a href="#">Troubleshooting</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="${pageContext.request.contextPath}/assets/img/user.png" class="img-circle" alt="Avatar"> <span>Samuel</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><i class="lnr lnr-user"></i> <span>My Profile</span></a></li>
                            <li><a href="#"><i class="lnr lnr-envelope"></i> <span>Message</span></a></li>
                            <li><a href="#"><i class="lnr lnr-cog"></i> <span>Settings</span></a></li>
                            <li><a href="#"><i class="lnr lnr-exit"></i> <span>Logout</span></a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- END NAVBAR -->

    <!-- LEFT SIDEBAR -->
    <div id="sidebar-nav" class="sidebar">
        <div class="sidebar-scroll">
            <nav>
                <ul class="nav">
                    <li><a href="main.jsp" class=""><i class="lnr lnr-chart-bars" ></i> <span>营销管理</span></a></li>
                    <li><a href="management.jsp" class=""><i  class="lnr lnr-file-empty"></i> <span>客户管理</span></a></li>
                    <li><a href="service.html" class=""><i class="lnr lnr-cog"></i> <span>服务管理</span></a></li>
                    <li>
                        <a href="#subPages" data-toggle="collapse" class="collapsed"><i class="lnr lnr-code"></i> <span>统计报表</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subPages" class="collapse ">
                            <ul class="nav">
                                <li><a href="${pageContext.request.contextPath}/p/ping_showChartGX" class="">客户贡献分析</a></li>
                                <li><a href="${pageContext.request.contextPath}/p/ping_showChartFX" class="">客户构成分析</a></li>
                                <li><a href="${pageContext.request.contextPath}/p/ping_showChartFW" class="">客户服务分析</a></li>
                                <li><a href="${pageContext.request.contextPath}/p/ping_showChartLS" class="">客户流失分析</a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="admin.jsp" class=""><i class="lnr lnr-alarm"></i> <span>基础数据</span></a></li>
                </ul>
            </nav>
        </div>
    </div>





    <div class="main">
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">Tables</h3>
                <div class="row">
                    <div class="col-md-6" style="width:1500px;">
                        <!-- TABLE STRIPED -->
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title">客户流失分析</h3><br/>
                                <%--bootstrap表单在一行显示--%>
                                <form  action="${pageContext.request.contextPath}/p/ping_searchLS" method="post" class="form-inline" role="form">
                                    <div class="form-group">
                                        <label class="form-label">客户名称</label>
                                        <input type="text" name="companyname" value="${sessionScope.clientName}" class="form-control"  placeholder="客户名称">
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label">客户经理</label>
                                        <input type="text" name="uname" value="${sessionScope.manger}" class="form-control"  placeholder="客户经理">
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <input type="submit" class="btn btn-info" value="查询">
                                        </div>
                                    </div>

                                </form>
                            </div>
                            <div class="panel-body">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>年份</th>
                                        <th>客户</th>
                                        <th>客户经理</th>
                                        <th>流失原因</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <s:iterator value="#request.list" var="k" status="st" >
                                        <tr>
                                            <td><s:property value="#k.lc_id"/></td>
                                            <td><s:property value="#k.year"/></td>
                                            <td><s:property value="#k.companyname"/></td>
                                            <td><s:property value="#k.uname"/></td>
                                            <td><s:property value="#k.lc_content"/></td>
                                        </tr>
                                    </s:iterator>
                                    <tr>
                                        <td colspan="6" align="center">
                                            <c:if test="${pageNo==1}">
                                                <button class="btn btn-success" disabled="disabled">首页</button>&nbsp;
                                                <button class="btn btn-success" disabled="disabled">上一页</button>&nbsp;
                                            </c:if>
                                            <c:if test="${pageNo!=1}">
                                                <a href="${pageContext.request.contextPath}/p/ping_changePage?pageNo=1" class="btn btn-success">首页&nbsp;</a>
                                                <a href="${pageContext.request.contextPath}/p/ping_changePage?pageNo=${pageNo-1}" class="btn btn-success">上一页&nbsp;</a>
                                            </c:if>
                                            <c:if test="${pageNo==maxPage||count==0}">
                                                <button class="btn btn-success" disabled="disabled">下一页</button>&nbsp;
                                                <button class="btn btn-success" disabled="disabled">尾页</button>&nbsp;
                                            </c:if>
                                            <c:if test="${pageNo!=maxPage&&count!=0}">
                                                <a href="${pageContext.request.contextPath}/p/ping_changePage?pageNo=${pageNo+1}" class="btn btn-success">下一页&nbsp;</a>
                                                <a href="${pageContext.request.contextPath}/p/ping_changePage?pageNo=${maxPage}" class="btn btn-success">尾页&nbsp;</a>
                                            </c:if>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- END TABLE STRIPED -->

                        <div id="div2" style="width:600px;height:400px"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="clearfix"></div>
    <footer>
        <div class="container-fluid">
            <p class="copyright">Copyright &copy; 2017.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
        </div>
    </footer>
</div>

<!-- END WRAPPER -->
<!-- Javascript -->
<script src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/toastr/toastr.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/scripts/klorofil-common.js"></script>
<script src="${pageContext.request.contextPath}/login/js/echarts.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/pjs/pscript.js" type="text/javascript"></script>
</body>

</html>