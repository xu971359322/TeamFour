
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>客户销售管理</title>
    <meta charset="utf-8">
    <script type="text/javascript" src="${pageContext.request.contextPath }/sell/js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(function(){
            $('tr:even').css("background","#6ecadc");
            change();
            sum();
        });
        function change(){
            var d = new Date();

            var year = d.getFullYear();
            var mon = d.getMonth()+1;
            var day = d.getDate();
            var ho = d.getHours();
            var mm = d.getMinutes();
            var ss = d.getSeconds();

            if(ss<='9'){
                ss = "0"+ss;
            }
            if(mm<='9'){
                mm="0"+mm;
            }
            if(ho<='9'){
                ho = "0"+ho;
            }

            var str = year+"-"+mon+"-"+day+" "+ho+":"+mm+":"+ss;

            $('#date').val(str);

            setTimeout("change()",1000);
        }


        function sum(){
            $("#myform").submit(function () {
                var companyname = $('#companyname').val();
                var cdescribe = $('#cdescribe').val();
                var cfrom = $('#cfrom').val();
                var chance = $('#chance').val();

                if(companyname==""){
                    $('#companyname').focus();
                    return false;
                }
                if(cdescribe==""){
                    $('#cdescribe').focus();
                    return false;
                }
                if(cfrom==""){
                    $('#cfrom').focus();
                    return false;
                }
                if(chance==""){
                    $('#chance').focus();
                    return false;
                }
                return true;

            });
        }

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
            height: 45px;
        }
        .name{
            text-align: center;
        }
        td{
            text-indent: 20px;
        }
        table{
            background-color: #c7ddef;
            font-size: 25px;
            width: 100%;
        }
        input{
            height: 30px;
        }
        .sell-div{
            height: 30px;
            width: 80px;
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
        #cc{
            position: absolute;
            right: 30px;
            height: 90px;
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
                        <h3 class="panel-title">销售机会管理>>>>编辑</h3>
                        <form action="${pagecontext.request.getcontextpath}/sell_zp" method="post" id="myform">

                            <center>
                                <table>

                                    <tr>
                                        <td class="name">客户名称</td>
                                        <td>
                                            <span>${sessionScope.clienUser.companyname}</span>
                                        </td>

                                        <td class="name">机会来源</td>
                                        <td>
                                            <span>${sessionScope.clienUser.cfrom}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="name">概要</td>
                                        <td>
                                            <span>${sessionScope.clienUser.cdescribe}</span>
                                        </td>
                                        <td class="name">成功几率(%)</td>
                                        <td colspan="2">
                                            <span>${sessionScope.clienUser.success}</span>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="name">联系人</td>
                                        <td>
                                            <span>${sessionScope.clienUser.cname}</span>
                                        </td>
                                        <td class="name">联系人电话</td>
                                        <td>
                                            <span>${sessionScope.clienUser.ctel}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="name">机会描述</td>
                                        <td colspan="3">
                                            <span>${sessionScope.clienUser.chance}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="name">创建人</td>
                                        <td><span>${username}</span></td>
                                        <td class="name">创建时间</td>
                                        <TD><span>
                                            <fmt:formatDate
                                                    type="date"
                                                    value="${sessionScope.clienUser.ctime}"
                                                    dateStyle="default"
                                            />
                                        </span></TD>
                                    </tr>
                                    <tr style="background-color: white"></tr>
                                    <tr>
                                        <td class="name">指派给</td>
                                        <td>
                                            <select name="zp" style="width: 200px;">&nbsp;&nbsp;<span style="color: red;">*</span>
                                                <option value="0">请选择...</option>
                                                <c:forEach items="${sessionScope.userList}" var="cc">
                                                    <c:if test="${sessionScope.sellUser.uid==cc.uid}">
                                                        <option  value="${cc.uid}" selected="selected">${cc.uname}</option>
                                                    </c:if>
                                                    <c:if test="${sessionScope.sellUser.uid!=cc.uid}">
                                                        <option  value="${cc.uid}">${cc.uname}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        <td class="name">指派时间</td>
                                        <TD><input name="ctime" id="date"/>&nbsp;&nbsp;<span style="color: red;">*</span></TD>
                                        </td>
                                    </tr>
                                </table>
                            </center>
                            <div id="cc">
                                <a href="${pagecontext.request.getcontextpath}/sell_show"><div class="sell-div">返回</div></a>
                                <div class="sell-div"><input type="submit" value="提交" style="background-color: transparent;border: 0px transparent solid; color: white;text-align: center;font-size: 17px"/></div>
                            </div>
                        </form>

                </div>
            </div>
            <!-- END BASIC TABLE -->
        </div>
    </div>
</div>
</body>
</html>