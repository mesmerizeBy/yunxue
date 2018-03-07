// JavaScript Document
$(function(){
	var str = $(".class-style ul").text();
	var result = str.split(",");
	$(".class-style ul").empty();
    for(var i=0;i<result.length;i++){
        $(".class-style ul").append("<li>" + result[i] + "</li>");
	}
	
	
})