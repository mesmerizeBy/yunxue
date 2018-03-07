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
<link type="text/css"  href="css/teacher_query.css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery v3.2.1.min.js"></script>
<script type="text/javascript" src="js/teacher-query.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>teacher_query</title>
<script type="text/javascript">
$(document).ready(function(){
 $(".nav1 ul li").removeClass("cur").eq(2).addClass("cur");
 $(".page a").each(function(){
	 if($(this).html()==${pagebean.currentPage}){
		 $(this).addClass("first");
	 }
 });
 
});
</script>
</head>
<body>
<jsp:include page="nav.jsp" flush="true"/>

<div class="container">
	<div class="query_img">
	    <a href="#" target="_blank"><img src="IMG/query/thumb.jpg"/></a>
    </div>
    <!--主要内容 -->
    <div class="search-title clearboth">
		<div class="crumbs-nav-item leve1">
			<div class="menu-drop">
				<a class="big" href="/">首页</a>
			</div>
			<i class="crumbs-arrow">&gt;</i>
	    </div>
		<div class="crumbs-nav-item leve1">
			<div class="menu-drop">
				<a href="font/teachernamequery.do">老师列表页</a>
			</div>
				<i class="crumbs-arrow">&gt;</i>
		</div>
   </div>
	<div class="lesson-select clearboth">
			          
			<!-- 阶段 -->
		<div class="lesson-select-left">
			<span class="lesson-select-title">课程阶段：</span>
		</div>					
		<div class="lesson-select-right">
			<span>
				<a href="#" class="active">全部</a>
			</span>
		    <span>
	            <a href="#" class="">高考</a>
	        </span>
			<span>
                <a href="#" class="">高中</a>
	        </span>
		    <span>
	            <a href="#" class="">中考</a>
	        </span>
			<span>
	            <a href="#" class="">初中</a>
	        </span>
			<span>
	            <a href="#" class="">小学</a>
	        </span>
		</div>
								<!-- 年级 --> 					
		<div class="lesson-select-cut-line"></div>
			<div class="lesson-select-left">
				<span class="lesson-select-title">适合年级：</span>
			</div>
			<div class="lesson-select-right">
	            <span>
					<a href="#" class="active">全部</a>
				</span>
				<span>
					<a href="#" class="">高考</a>
				</span>
			</div>
		<div class="lesson-select-cut-line"></div>
								<!-- 科目 -->
		<div class="lesson-select-left">
			<span class="lesson-select-title">适合科目：</span>
		</div>
		<div class="lesson-select-right">
	          <span>
				<a href="#" class="active">全部</a>
			  </span>
			  <span><a href="#" class="">语文</a></span>
			  <span><a href="#" class="">数学</a></span>
			  <span><a href="#" class="">英语</a></span>
		      <span><a href="#" class="">物理</a></span>
			  <span><a href="#" class="">化学</a></span>
			  <span><a href="#" class="">生物</a></span>
			  <span><a href="#" class="">历史</a></span>
			  <span><a href="#" class="">地理</a></span>
			  <span><a href="#" class="">政治</a></span>
		</div>
		<div class="lesson-select-cut-line"></div>
				 	
				<!-- 性别 -->
							
	    <div class="lesson-select-left">
			<span class="lesson-select-title">性别：</span>
		</div>    
		<div class="lesson-select-right">
	        <span><a href="#" class="active">全部</a></span>
			<span><a href="#" class="">男</a></span>
			<span><a href="#" class="">女</a></span>
		</div>
		<div class="lesson-select-cut-line"></div>
 </div>
    <div class="course-list clearboth">
	    <div class="course-list-left clearboth">
	    	<!-- 选课方案 -->
	        <div class="lesson-list-title clearboth">
	    		<a class="current" href="#">智能排序</a>
	    			
	    		<a class="" href="#">人气 </a>
	    			
	    		<a class="" href="#">评价数 </a>
	    		
	    		<a class="" href="#">价格 </a>
	    		<pseudo:after></pseudo:after>
	    	</div>
	    	
            <!--教师详细内容-->
  <c:forEach items="${pagebean.pageList}" var="teacherInfo">
	<a target="_blank" href="TeaMessage.do?teacherNo=${teacherInfo.teacherNo}">
	 <div class="lesson-box clearboth">
	 	 <div class="lesson-box-left">
	 	     <div class="lesson-box-img"> 
	 	        <img width="80px" height="80px" src="${teacherInfo.tPicture}" style="display: inline;">
 		            <div class="lesson-box-img-mask">
 		               <img class="mask1" width="80px" height="80px" src="IMG/query/mask-1.png">
 		               <img class="mask3" width="80px" height="80px" src="IMG/query/mask-3.png">
 		            </div>		
 		     </div>
 		     <p>${teacherInfo.tName}</p>
         </div>	 							
	 	 <div class="lesson-box-center">
		    <ul class="renzheng clearboth">
		      <li class="realname">身份认证</li>
		      <li class="certification">学历认证</li>  			
		    </ul>
            <div class="clear"></div>
		    <div class="lesson-box-information">
		      <p>
		        <span style="color: rgb(153, 153, 153);">性别：</span>${teacherInfo.tSex}&nbsp;&nbsp;&nbsp;&nbsp;				
		      </p>
		      <p>
		        <span style="color: rgb(153, 153, 153);">学校：</span>${teacherInfo.tSchool}
		      </p>
		      <p> 
		        <span style="color: rgb(153, 153, 153);">学历：</span>${teacherInfo.tEducation}&nbsp;&nbsp;&nbsp;&nbsp;				
		      </p>
		      <p>
		        <span style="color: rgb(153, 153, 153);">满意度：</span>${teacherInfo.teacherSatisfaction}
		      </p>
		      <p>
		        <span style="color: rgb(153, 153, 153);">所教阶段：</span>${teacherInfo.teacherStage}
		      </p>
		      <p style="width:400px;height:30px;">
		        <span style="color: rgb(153, 153, 153);">所教科目：</span>${teacherInfo.teacherClasses} 
		      </p>
		    </div> 
	 	 </div>	 							
	 	 <div class="lesson-box-right">
		    <div class="course-list-btn">立即预约</div>
	 	 </div>
	 </div>
	</a> 
  </c:forEach>   	 							    											
  <div class="clear"></div>
   <c:if test="${pagebean.pageCount!=1}">
	<div class="page clearboth">
		<span class="first">当前页数：[${pagebean.currentPage}/${pagebean.pageCount}] </span>
        <c:if test="${pagebean.firstPage==true}">
        </c:if>
        <c:if test="${pagebean.firstPage==false}">
           <a href="font/teachernamequery.do?curPage=1&search1=${name}" class="first">首页 </a>
           <a href="font/teachernamequery.do?curPage=${pagebean.previousPageCount}&search1=${name}">上一页 </a>
        </c:if>
          <c:forEach begin="${pagebean.start}" end="${pagebean.end}" step="1" var="i">
            <a href="font/teachernamequery.do?curPage=${i}&search1=${name}">${i}</a>
          </c:forEach>             	
        <c:if test="${pagebean.lastPage==true}">
        </c:if>
        <c:if test="${pagebean.lastPage==false}">
           <a href="font/teachernamequery.do?curPage=${pagebean.nextPageCount}&search1=${name}">下一页 </a>
           <a href="font/teachernamequery.do?curPage=${pagebean.pageCount}&search1=${name}">尾页 </a>
        </c:if>	
    </div>
    </c:if>  
   </div>    
		
			
        <!--特色教师栏-->
		<div class="course-list-right">
          
			<div class="recommended-teacher">				
			    <h4 class="title2">特色老师</h4>
		        <ul class="teacher_list_style1">
		          <c:forEach items="${teacherlist2}" var="teacherInfo2">
	     	        <li class="">
	                    <a href="#">
	            	        <img src="${teacherInfo2.tPicture}">
			 				    <p class="title"><span>${teacherInfo2.tName}</span></p>
		                        <p class="description">
		                        <span>学校：</span>${teacherInfo2.tSchool}<br>                    
		                        <span>所教科目：</span>${teacherInfo2.teacherClasses}
		                        </p>
					            <div class="clear"></div>                      
	                    </a>
	                </li>
	               </c:forEach>
	               <p class="teacher-style-title">		</p> 
			    </ul>
			</div>
		 </div> 
	    </div>
	</div>
<jsp:include page="bottom.jsp" flush="true"/>

</body>
</html>