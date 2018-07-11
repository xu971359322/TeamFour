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
<div style="display:none"><p>jQuery是现在最流行的JavaScript工具库。</p><p>据统计，目前全世界57.3%的网站使用它。也就是说，10个网站里面，有6个使用jQuery。如果只考察使用工具库的网站，这个比例就会上升到惊人的91.7%。</p><p>虽然jQuery如此受欢迎，但是它臃肿的<a href="http://mathiasbynens.be/demo/jquery-size" target="_blank" data-mce-href="http://mathiasbynens.be/demo/jquery-size">体积</a>也让人头痛不已。jQuery 2.0的原始大小为235KB，优化后为81KB；如果是支持IE6、7、8的jQuery 1.8.3，原始大小为261KB，优化后为91KB。</p><p>这样的体积，即使是宽带环境，完全加载也需要1秒或更长，更不要说移动设备了。这意味着，如果你使用了jQuery，用户至少延迟1秒，才能看到网 页效果。考虑到本质上，jQuery只是一个操作DOM的工具，我们不仅要问：如果只是为了几个网页特效，是否有必要动用这么大的库？</p></div><form id="msform">
	<!-- progressbar -->
	<ul id="progressbar">
		<li class="active">Account Setup</li>
		<li>Social Profiles</li>
		<li>Personal Details</li>
	</ul>
	<!-- fieldsets -->
	<fieldset>
		<h2 class="fs-title">Create your account</h2>
		<h3 class="fs-subtitle">This is step 1</h3>
		<input type="text" name="email" placeholder="Email" />
		<input type="password" name="pass" placeholder="Password" />
		<input type="password" name="cpass" placeholder="Confirm Password" />
		<input type="button" name="next" class="next action-button" value="Next" />
	</fieldset>
	<fieldset>
		<h2 class="fs-title">Social Profiles</h2>
		<h3 class="fs-subtitle">Your presence on the social network</h3>
		<input type="text" name="twitter" placeholder="Twitter" />
		<input type="text" name="facebook" placeholder="Facebook" />
		<input type="text" name="gplus" placeholder="Google Plus" />
		<input type="button" name="previous" class="previous action-button" value="Previous" />
		<input type="button" name="next" class="next action-button" value="Next" />
	</fieldset>
	<fieldset>
		<h2 class="fs-title">Personal Details</h2>
		<h3 class="fs-subtitle">We will never sell it</h3>
		<input type="text" name="fname" placeholder="First Name" />
		<input type="text" name="lname" placeholder="Last Name" />
		<input type="text" name="phone" placeholder="Phone" />
		<textarea name="address" placeholder="Address"></textarea>
		<input type="button" name="previous" class="previous action-button" value="Previous" />
		<input type="submit" name="submit" class="submit action-button" value="Submit" />
	</fieldset>
</form>
<script src="login/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="login/js/jquery.easing.min.js" type="text/javascript"></script>
<script src="login/js/jQuery.time.js" type="text/javascript"></script>
<br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br>
www
</body>
</html>