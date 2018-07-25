<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="main">
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">Tables</h3>
                <div class="row">
                    <div class="col-md-6" style="width:1500px;">
                        <!-- TABLE STRIPED -->
                        <div class="panel">
                            <div class="panel-heading">
                                &nbsp;&nbsp; <a href="${pageContext.request.contextPath}/pjsp/main.jsp"style="font-size: 20px;float:right;" >&nbsp;&nbsp;返回首页&nbsp;&nbsp;</a>
                                &nbsp;&nbsp; <a href="${pageContext.request.contextPath}/p/ping_showExcel" style="font-size: 20px;float:right;" >&nbsp;&nbsp;下载Excel&nbsp;&nbsp;</a>
                                &nbsp;&nbsp;  <a id="alertShow111" style="float: right;font-size: 20px;cursor: pointer;">图表数据</a>&nbsp;&nbsp;
                                <h3 class="panel-title">客户贡献分析</h3><br>
                                <form action="${pageContext.request.contextPath}/p/ping_search" method="post" class="form-inline" role="form" >
                                    <div class="form-group">
                                        <label class="form-label">客户名称 </label>
                                        <input type="search" name="searchName" value="${requestScope.searchName}" class="form-control"  placeholder="客户名称">
                                    </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <div class="form-group">
                                        <label class="form-label">年份 </label>
                                        <select name="yearName" class="form-control">
                                                <option value="-1" >全部</option>
                                                   <c:forEach items="${sessionScope.year}" var="y">
                                                        <option value="${y.year}" <c:if test="${y.year==requestScope.yearSelect}">selected</c:if> >${y.year}年</option>
                                                   </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <input type="submit" class="btn btn-info" value="查询">
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                            <thead>
                                            <tr>
                                                <th>编号</th>
                                                <th>客户名称</th>
                                                <th>订单金额（元）</th>
                                                <th>回款状态</th>
                                                <th>年份</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <s:iterator value="%{#session.list}" var="k" status="st" >
                                                <s:if test="#k.sum!=0">
                                                <tr>
                                                    <td>${st.count}</td>
                                                    <td><s:property value="#k.companyname"/></td>
                                                    <td><s:property value="#k.sum"/><strong>.</strong>00(元)</td>
                                                    <s:if test="#k.result=='未回款'">
                                                        <td style="color: red"><s:property value="#k.result"/></td>
                                                    </s:if>
                                                    <s:if test="#k.result=='已回款'">
                                                        <td style="color: green"><s:property value="#k.result"/></td>
                                                    </s:if>
                                                    <td><s:property value="#k.year"/></td>
                                                </tr>
                                                </s:if>
                                            </s:iterator>
                                            </tbody>
                                        </table>
                                    </div>
                            </div>
                        </div>
                        <div id="div111" style="width:700px;height:500px;background-color:whitesmoke;display:none;position: absolute;top:150px;left: 350px;z-index:9"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<script src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/toastr/toastr.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/scripts/klorofil-common.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/dataTables/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/dataTables/dataTables.bootstrap.js"></script>
<script type="text/javascript">
    function showell(){
        window.location.href="chart.jsp";
    }

    $(document).ready(function (){
        $('#dataTables-example').DataTable({
            language: {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "lengthMenu": [10,20,30,50,100],
            "autoWidth":true
        });
    });
</script>
<script src="${pageContext.request.contextPath}/login/js/echarts.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/pjs/pscript_gx.js"></script>
</body>
</html>
