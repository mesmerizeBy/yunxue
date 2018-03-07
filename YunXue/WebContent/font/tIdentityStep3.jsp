<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
<link type="text/css"  href="css/tIdentity.css" rel="stylesheet"/>
<link type="text/css"  href="css/header-bottom.css" rel="stylesheet"/>
<script type="text/javascript" src="js/tIdentity3.js"></script>
<script type="text/javascript" src="js/jquery v3.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tIdentityStep3</title>
</head>
<body>
<jsp:include page="nav.jsp" flush="true"/>

<form action="Tidentity3.do" method="post">
<div style="width:1200px;height:auto;margin:0 auto;" id="step3">
  <div class="step">
    <img src="IMG/tIdentity/step3.png" width="1200" height="110" />
  </div>
  
  <p style="font-size:30px;margin-bottom: 20px;">设置上课信息</p>
  <div class="info">
     <div class="key">
       <span style="color:red;">*</span>教授阶段：
     </div>
     <div class="value">
       <input style="margin-left:10px;" type="checkbox" name="stage" value="小学"/>&nbsp;&nbsp;小学
       <input style="margin-left:10px;" type="checkbox" name="stage" value="初中"/>&nbsp;&nbsp;初中
       <input style="margin-left:10px;" type="checkbox" name="stage" value="高中"/>&nbsp;&nbsp;高中
     </div>
  </div>
  <div class="info" style="height:100px;">
     <div class="key">
       <span style="color:red;">*</span>教授科目：
     </div>
     <div class="value">
      <input style="margin-left:10px;" type="checkbox" name="subject" value="语文"/>&nbsp;&nbsp;语文
      <input style="margin-left:10px;" type="checkbox" name="subject" value="数学"/>&nbsp;&nbsp;数学
      <input style="margin-left:10px;" type="checkbox" name="subject" value="英语"/>&nbsp;&nbsp;英语
      <input style="margin-left:10px;" type="checkbox" name="subject" value="奥数"/>&nbsp;&nbsp;奥数
      <input style="margin-left:10px;" type="checkbox" name="subject" value="新概念英语一册"/>&nbsp;&nbsp;新概念英语一册
      <input style="margin-left:10px;" type="checkbox" name="subject" value="新概念英语二册"/>&nbsp;&nbsp;新概念英语二册&nbsp;&nbsp;
      <input style="margin-left:10px;" type="checkbox" name="subject" value="物理"/>&nbsp;&nbsp;物理
      <input style="margin-left:10px;" type="checkbox" name="subject" value="化学"/>&nbsp;&nbsp;化学
      <input style="margin-left:10px;" type="checkbox" name="subject" value="生物"/>&nbsp;&nbsp;生物
      <input style="margin-left:10px;" type="checkbox" name="subject" value="政治"/>&nbsp;&nbsp;政治
      <input style="margin-left:10px;" type="checkbox" name="subject" value="地理"/>&nbsp;&nbsp;地理
      <input style="margin-left:10px;" type="checkbox" name="subject" value="历史"/>&nbsp;&nbsp;历史
     </div>
  </div>
  <div class="info" style="height:400px;">
    <div class="key">
       <span style="color:red;">*</span>上课时间：
    </div>
    <table>
      <tr>
        <td></td><td>星期一</td><td>星期二</td><td>星期三</td>
        <td>星期四</td><td>星期五</td><td>星期六</td><td>星期天</td>
      </tr>
      <tr>
        <td style="width:100px;">8:00-10:00</td>
        <c:forEach items="${classno}" begin="0" end="30" step="5" var="i">
          <td><span class="checkpic">
          <input class="time" type="checkbox" name="time" value="${i.planClassNo}">
          <input type="hidden" value="${i.planClassState}">
          </span></td>     
        </c:forEach>
      </tr>
      <tr>
        <td style="width:100px;">10:10-12:10</td>
        <c:forEach items="${classno}" begin="1" end="31" step="5" var="i">
          <td><span class="checkpic">
          <input class="time" type="checkbox" name="time" value="${i.planClassNo}">
          <input type="hidden" value="${i.planClassState}">
          </span></td> 
        </c:forEach>
      </tr>
      <tr>
        <td style="width:100px;">14:00-16:00</td>
        <c:forEach items="${classno}" begin="2" end="32" step="5" var="i">
          <td><span class="checkpic">
          <input  class="time" type="checkbox" name="time" value="${i.planClassNo}">
          <input type="hidden" value="${i.planClassState}">
          </span></td> 
        </c:forEach>
      </tr>
      <tr>
        <td style="width:100px;">16:10-18:10</td>
        <c:forEach items="${classno}" begin="3" end="33" step="5" var="i">
          <td><span class="checkpic">
          <input  class="time" type="checkbox" name="time" value="${i.planClassNo}">
          <input type="hidden" value="${i.planClassState}">
          </span></td>    
        </c:forEach>
      </tr>
      <tr>
        <td style="width:100px;">19:00-21:00</td>
        <c:forEach items="${classno}" begin="4" end="34" step="5" var="i">
          <td><span class="checkpic">
          <input  class="time" type="checkbox" name="time" value="${i.planClassNo}">
          <input type="hidden" value="${i.planClassState}">
          </span></td> 
        </c:forEach>
      </tr>
    </table>
  </div>
  <div class="info" style="margin-bottom:100px;">
     <input type="submit"  class="nextstep" value="完成设置"/>
  </div> 
</div>
</form>

<jsp:include page="bottom.jsp" flush="true"/>
</body>
</html>