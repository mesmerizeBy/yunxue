<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link href="css/student_login.css" rel="stylesheet" type="text/css">
<link href="css/_footer.css" rel="stylesheet" type="text/css">
<script src="js/jquery v3.2.1.min.js"></script>

<style type="text/css">
	.main{
		background-color:beige;
	}
</style>
</head>

<body class="main">
<c:if test="${not empty acount}">
<script>
	$(function(){
		$("span.word1").eq(0).remove();
		$("span.word1").eq(0).css({"color":"red"}).fadeIn("slow"); 
	})
</script>
</c:if>

<c:choose>
<c:when test="${loginmes == 'lost2'}">
<script>
    $(function(){
    	alert("账号不存在");
    })
</script>
</c:when>
<c:when test="${loginmes == 'lost1'}">
<script>
    $(function(){
    	alert("密码错误");
    })
</script>
</c:when>
</c:choose>
    <header>
    	<img src="IMG/index/logo1.png" height="70">
   	    <span class="word1">欢迎登录</span>
   	    <span class="word1" style="display:none">注册成功，请登录</span>
   	    <h3>有了云学网，学习就是爽</h3>
    </header>
    <main>
    	<div class="tab">
    		<div class="tab_0"><img src="IMG/index/logo1.png" height="60"></div>
    		<form action="Login.do" method="post" >
    		    <div class="tab_1">
    		        <img src="IMG/login/account_login.png">
    		        <input id="mobile" class="login_tab" type="text" name="uesrPhone" placeholder="请输入您的手机号" value="${phone}">
    		        
    		    </div>
    		    <div class="tab_1">
    		        <img src="IMG/login/password_login.png">
    		        <input id="pass" class="login_tab" type="password" name="passWord" placeholder="请输入您的密码">
    		    </div>
    		    <input type="submit" value="登录" id="login_submit_button">
    		</form>
    		<div class="tab_2">
    			<a href="#" class="login_tab_0">忘记密码</a>
    			新用户,
    		    <a href="font/user_register.jsp">去注册</a>
    		</div>
    	</div>
    </main>
    <div class="footer">
    	<div class="footer-box1">
    		<a href="#" target="_blank">关于云学网</a>
    		<a href="#" target="_blank">联系我们</a>
    		<a href="#" target="_blank">加入我们</a>
    		<a href="#" target="_blank">网站条款</a>
    		<a href="#" target="_blank">帮助我们</a>
    		<a href="#" target="_blank">服务支持</a>
    		<a href="#" target="_blank">官方微信</a>
    	</div>
    	<div class="footer-box2">
    		<p>高新技术企业证书：GR201611005838 办学许可证：111010873931661 电信与信息服务业务经营许可证：京公网安备11010802016334号 yxw.com</p>
    	</div>
    	<div class="footer-box3">
    	    <img src="IMG/register/link1.jpg" height="33">
    	    <img src="IMG/register/aqyz.png" height="33">
    	    <img src="IMG/register/link2.jpg" height="33">
		</div>
    </div>
</body>
</html>