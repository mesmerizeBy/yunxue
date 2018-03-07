<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>"/>
<meta charset="utf-8">
<title>teacher_message</title>
<link type="text/css" rel="stylesheet" href="css/teacher_message.css">
<link type="text/css" rel="stylesheet" href="css/header-bottom.css">
<script src="js/jquery v3.2.1.min.js"></script>
<script src="js/teacher_message.js"></script>
</head>

<body >

<jsp:include page="nav.jsp" flush="true"/>

<div class="wrap">
<div class="container">
    <div class="nav-line"><a href="font/index.jsp">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;<a href="font/teacher_query.jsp">家教列表页</a>&nbsp;&nbsp;>&nbsp;&nbsp;
    ${teacherMes.tName}老师</div>
	<div class="teacher-message-box">
		<div class="message-box-top">
			<div class="teacher-point">
				<div class="teacher-image">
        	    	<img src="${teacherMes.tPicture}" width="100" height="100">
        	    	<div class="mask">
    			        <img src="IMG/person_center/mask-3.png" width="100" height="100">
    		        </div>
        	    </div>
        	    <div class="teacher-name-info">
        	    	<p class="a">${teacherMes.tName}</p>
        	    	<ul class="clear">
        	    		<li>年龄：<span>${teacherMes.tAge}</span></li>
        	    		<li>性别：<span>${teacherMes.tSex}</span></li>
        	    		<li class="a">专业：<span>${teacherMes.tMajor}</span></li>
        	    	</ul>
       	            
        	        <p class="b">学校：<span>${teacherMes.tSchool}</span></p>
        	    </div>
        	    <div style="clear:both"></div>
        	    <div class="teacher-certify">
        	        <dl class="clear">
        	        	<dt><img src="IMG/teacherMessage/Heart.png" height="35px">满意度：<p>${teacherMes.teacherSatisfaction}</p></dt>
        	        	<dd><img src="IMG/teacherMessage/cap.png" height="35px">学历认证：<p>完成</p></dd>
        	        </dl>
				</div>
			</div>
        	<div class="teacher-profile">
				  <h3>家教自述</h3>
				  <p>
				  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${teacherMes.tDescription}
				  </p>
			</div>
		</div>
		<div class="message-box-bottom">
		    <div class="class-style">
        	    <h3>授课风格：</h3>
        	    <ul class="clear">${teacherMes.teacherStyle}</ul>
        	</div>
        	<div class="teacher-expe-box">
		        <p>家教经历</p>
		        <ul class="clear">
		        	<li>
		        		<dl class="clear">
		        		    <dt><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${teacherMes.tExperience}</p></dt>
		        		</dl>
					</li>
		        </ul>
	        </div>
		</div>
    </div>
    <div class="teacher-message-right">
		<div class="class-code">
			<img src="IMG/teacherMessage/timg.jpg" height="150px" style="vertical-align:-220px;">
		</div>
        <div class="class-tab">
            <h3>教师课时安排</h3>
            <div class="class-img">
            	<dl>
            		<dd><img src="IMG/teacherMessage/ban.png" height="20px" alt="不可预约"/></dd>
            		<dt>不可预约</dt>
            	</dl>
            	<dl>
            		<dd><img src="IMG/teacherMessage/can.png" height="20px"/></dd>
            		<dt>可预约</dt>
            	</dl>
            	<dl>
            		<dd><img src="IMG/teacherMessage/he.png" height="20px"/></dd>
            		<dt>已被预约</dt>
            	</dl>
            </div>
            <div class="tab-box">
        	<table>
				<thead>
					<th></th><th>周一</th><th>周二</th><th>周三</th><th>周四</th><th>周五</th><th>周六</th><th>周日</th>
				</thead>
      	        <tbody>
       	        <tr>
       	        	<td style="font-size:12px">8：00-10：00</td><td><img src="IMG/teacherMessage/he.png"/></td><td></td><td></td><td></td><td></td><td></td><td></td>
       	        </tr>
       	        <tr>
       	        	<td style="font-size:12px">10：10-12：10</td><td><img src="IMG/teacherMessage/can.png" /></td><td></td><td></td><td></td><td></td><td></td><td></td>
       	        </tr>
       	        <tr>
       	        	<td style="font-size:12px">14：00-16：00</td><td><img src="IMG/teacherMessage/ban.png"/></td><td></td><td></td><td></td><td></td><td></td><td></td>
       	        </tr>
       	        <tr>
       	        	<td style="font-size:12px">16：10-18：10</td><td><img src="IMG/teacherMessage/he.png"/></td><td></td><td></td><td></td><td></td><td></td><td></td>
       	        </tr>
       	        <tr>
       	        	<td style="font-size:12px">19：00-21：00</td><td><img src="IMG/teacherMessage/can.png" /></td><td></td><td></td><td></td><td></td><td></td><td></td>
       	        </tr>
       	        </tbody>
        	</table>
        	</div>
        </div>
    </div>
</div>

<div style="clear:both"></div>
<div class="help">
 <div class="help2">
  <div class="logo2">
   <a href="index.html"><img src="IMG/index/logo1.png" width="180" height="65" /></a>
  </div>
  <i class="spacer"></i>
  <div class="f1 f">
   <p class="f2 ff"><strong>帮助中心</strong></p>
   <dd class="f0 f3"><a href="#">学生帮助</a></dd>
   <dd class="f0 f3"><a href="#">家教入驻</a></dd>
   <dd class="f0 f3"><a href="#">注册登录</a></dd>
   <dd class="f0 f3"><a href="#">平台保障</a></dd>
   <dd class="f0 f3"><a href="#">网站地图</a></dd>
   <dd class="f0 f3"><a href="#">网站条款</a></dd>
   <dd class="f0 f3"><a href="#">友情链接</a></dd>
  </div>
  <i class="spacer"></i>
  <div class="f1" style="width:100px">
   <p class="f2" style="width:80px;"><strong>服务支持</strong></p>
   <dd class="f3"><a href="#">支付方式</a></dd>
   <dd class="f3"><a href="#">意见反馈</a></dd>
  </div>
  <i class="spacer"></i>
  <div class="f1 f">
   <p class="f2 ff"><strong>关于云学</strong></p>
   <dd class="f0 f3"><a href="#">网站简介</a></dd>
   <dd class="f0 f3"><a href="#">新闻报道</a></dd>
   <dd class="f0 f3"><a href="#">加入我们</a></dd>
   <dd class="f0 f3"><a href="#">活动公告</a></dd>
   <dd class="f0 f3"><a href="#">联系我们</a></dd>
   <dd class="f0 f3"><a href="#">行业大会</a></dd>
  </div>
  <i class="spacer"></i>
  <div class="f1" style="width:100px">
   <p class="f2" style="width:80px"><strong>关注我们</strong></p>
   <dd class="f3"><a href="#">官网微信</a></dd>
   <dd class="f3"><a href="#">新浪微博</a></dd>
  </div>
 </div>
</div>

<div class="bottom0">
 <div class="bottom">
  <div class="copyright">
   办学许可证：111010873931661&nbsp;&nbsp;&nbsp;&nbsp;
   电信与信息服务业务经营许可证：京ICP证150105号&nbsp;&nbsp;&nbsp;&nbsp;
   京ICP备14035240号-2 &nbsp;&nbsp;&nbsp;&nbsp;   京公网安备11010802016334号
   <br/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;江西师范大学瑶湖校区&nbsp;&nbsp;&nbsp;&nbsp;2015级软件技术一班&nbsp;&nbsp;&nbsp;&nbsp;云学网开发小组
  </div>
  <div class="copyr">
   <img src="IMG/index/pit.png" width="132" height="48" />
  </div>
 </div>
</div>

</body>
</html>