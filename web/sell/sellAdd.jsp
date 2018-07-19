
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>客户销售管理</title>
    <meta charset="utf-8">
    <script type="text/javascript" src="${pageContext.request.contextPath }/sell/js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(function(){
            $('tr:even').css("background","#6ecadc");
        });
    </script>
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
        tr{
            height: 30px;
        }
        .name{
            text-align: center;
        }
        td{
            text-indent: 20px;
        }
        #cc{
            width: 90%;
            height: 90%;
            position: absolute;
            top: 20px;
            left: 20px;
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
                    <div id="cc">
                        <h3 class="panel-title">销售机会管理>>>>新建</h3>
                        <div style="height: 20px"></div>
                        <form action="sell_add" method="post" id="myform">
                            <table style="width: 80%">
                                <tr>
                                    <td class="name">客户名称</td>
                                    <td>
                                        <input name="cl.companyname" type="text" size="30">
                                    </td>

                                    <td class="name">机会来源</td>
                                    <td>
                                        <input name="cl.cfrom" type="text" size="30">
                                    </td>
                                </tr>
                                <tr>
                                    <td class="name">概要</td>
                                    <td colspan="3">
                                        <input name="cl.cdescribe" type="text" size="50">
                                    </td>
                                </tr>

                                <tr>
                                    <td class="name">成功几率</td>
                                    <td colspan="3">
                                        <input name="cl.cfrom" type="text" size="30">
                                    </td>
                                </tr>

                                <tr>
                                    <td class="name">联系人</td>
                                    <td>
                                        <input name="cl.cname" type="text" size="30">
                                    </td>
                                    <td class="name">联系人电话</td>
                                    <td>
                                        <input name="cl.ctel" type="text" size="30">
                                    </td>
                                </tr>
                                <tr>
                                    <td class="name"rowspan="3">机会描述</td>
                                    <td rowspan="4" colspan="3">
                                        <textarea rows="6" cols="50" name="cl.chance"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td>创建人</td>
                                    <td><input type="text" name="user" value="${user.username}"></td>

                                    <td>创建时间</td>
                                    <TD><input type="datetime-local"/></TD>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
            <!-- END BASIC TABLE -->
        </div>

    </div>
</div>
</body>
</html>
