<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	table{
		background-color: white;
	}
	h1{
		color:white;
	}
	button:hover{
		background-color: gray;
	}
	body {
		font-family: "Lato", sans-serif;
		background-image: url("/20210129/img/1.jpg");
	}
	.mySlides {display: none}
</style>
<body>

<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card">
    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <c:if test="${memberId eq null }">
    	<a href="loginForm.do" class="w3-bar-item w3-button w3-padding-large">로그인</a>
    	<a href="insertMemberForm.do" class="w3-bar-item w3-button w3-padding-large">회원가입</a>
    </c:if>
    <c:if test="${memberId ne null }">
    	<a href="logout.do" class="w3-bar-item w3-button w3-padding-large">로그아웃</a>
    	<a href="main.do" class="w3-bar-item w3-button w3-padding-large">홈</a>
    	<c:if test="${memberAuth eq 'USER' }">
    		<a href="bookRentalListUSER.do" class="w3-bar-item w3-button w3-padding-large w3-hide-small">도서 대여관리</a>
    	</c:if>
    	<c:if test="${memberAuth eq 'ADMIN' }">
    		<a href="bookRentalList.do" class="w3-bar-item w3-button w3-padding-large w3-hide-small">도서 대여관리</a>
    		<a href="bookList.do" class="w3-bar-item w3-button w3-padding-large w3-hide-small">도서 관리</a>
    		<a href="memberList.do" class="w3-bar-item w3-button w3-padding-large w3-hide-small">멤버 관리</a>
    	</c:if>
    	<a href="javascript:void(0)" class="w3-padding-large w3-hover-red w3-hide-small w3-right"><i class="fa fa-search"></i></a>
    </c:if>
  </div>
</div>

<!-- Navbar on small screens (remove the onclick attribute if you want the navbar to always show on top of the content when clicking on the links) -->
<div id="navDemo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top" style="margin-top:46px">
  <c:if test="${memberId ne null }">
  	<c:if test="${memberAuth eq 'USER' }">
  		<a href="bookRentalListUSER.do" class="w3-bar-item w3-button w3-padding-large" onclick="myFunction()">도서 대여관리</a>
  	</c:if>
  	<c:if test="${memberAuth eq 'ADMIN' }">
  		<a href="bookRentalList.do" class="w3-bar-item w3-button w3-padding-large" onclick="myFunction()">도서 대여관리</a>
  		<a href="bookList.do" class="w3-bar-item w3-button w3-padding-large" onclick="myFunction()">도서 관리</a>
  		<a href="memberList.do" class="w3-bar-item w3-button w3-padding-large" onclick="myFunction()">맴버 관리</a>
  	</c:if>
  </c:if>
</div>

<script>
// Used to toggle the menu on small screens when clicking on the menu button
function myFunction() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}
</script>