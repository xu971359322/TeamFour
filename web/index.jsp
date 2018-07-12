<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/11
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<title>jQuery/CSS3分步骤注册表单切换动画在线演示</title>
	<link rel="stylesheet" media="screen" href="login/css/css.css" />
</head>
<form id="msform" action="login_login" method="post">
	<!-- progressbar -->
	<ul id="progressbar">
		<li class="active">发现</li>
		<li>坚持</li>
		<li>成功</li>
	</ul>
	<!-- fieldsets -->
	<fieldset>
		<h2 class="fs-title">客户关系管理系统</h2>
		<h3 class="fs-subtitle">This is step 1</h3>
		<input type="text" name="u.username" placeholder="请输入用户名" />
		<input type="password" name="u.pwd" placeholder="请输入密码" />
		<input type="password" name="cpass" placeholder="再次输入密码" />
		<input type="submit" class="next action-button" value="登录"/>
		<input type="button" name="next" class="next action-button" value="退出" />
	</fieldset>
	<%--<fieldset>--%>
		<%--<h2 class="fs-title">Social Profiles</h2>--%>
		<%--<h3 class="fs-subtitle">Your presence on the social network</h3>--%>
		<%--<input type="text" name="twitter" placeholder="Twitter" />--%>
		<%--<input type="text" name="facebook" placeholder="Facebook" />--%>
		<%--<input type="text" name="gplus" placeholder="Google Plus" />--%>
		<%--<input type="button" name="previous" class="previous action-button" value="Previous" />--%>
		<%--<input type="button" name="next" class="next action-button" value="Next" />--%>
	<%--</fieldset>--%>
	<%--<fieldset>--%>
		<%--<h2 class="fs-title">Personal Details</h2>--%>
		<%--<h3 class="fs-subtitle">We will never sell it</h3>--%>
		<%--<input type="text" name="fname" placeholder="First Name" />--%>
		<%--<input type="text" name="lname" placeholder="Last Name" />--%>
		<%--<input type="text" name="phone" placeholder="Phone" />--%>
		<%--<textarea name="address" placeholder="Address"></textarea>--%>
		<%--<input type="button" name="previous" class="previous action-button" value="Previous" />--%>
		<%--<input type="submit" name="submit" class="submit action-button" value="Submit" />--%>
	<%--</fieldset>--%>
</form>
<script src="login/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="login/js/jquery.easing.min.js" type="text/javascript"></script>
<script src="login/js/jQuery.time.js" type="text/javascript"></script>
<br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>