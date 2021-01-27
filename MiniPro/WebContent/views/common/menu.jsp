<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- 이거(=스위치 case문) 추가해줘야됨 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#topMenu {
	height: 30px;
	width: 850px;
}

#topMenu ul li {
	list-style: none;
	color: white;
	background-color: #2d2d2d;
	float: left;
	line-height: 30px;
	vertical-align: middle;
	text-align: center;
}

#topMenu .menuLink {
	text-decoration: none;
	color: white;
	display: block;
	width: 150px;
	font-size: 12px;
	font-weight: bold;
	font-family: "Trebuchet MS";
}

#topMenu .menuLink:hover {
	color: red;
	background-color: #4d4d4d;
}
</style>
</head>
<body>
	<div align="center">
		<nav id="topMenu">
			<ul>
				<li><a class="menuLink" href="main.do">Home</a></li>
				<li>|</li>
				<c:if test="${mid eq null }"> <!-- prefix="c"%>의 c임(=스위치 case문) -->
					<!-- 여기서 mid는 Session의 mid속성 값임 -->
					<!-- ne=not equal, eq=equal null값이면 저거만 보여줌 -->
					<li><a class="menuLink" href="loginForm.do">로그인</a></li>
					<li>|</li>
					<li><a class="menuLink" href="memberJoinForm.do">회원가입</a></li>
				</c:if>
				<c:if test="${mid ne null }">
					<li><a class="menuLink" href="logout.do">로그아웃</a></li>
				</c:if>
				<li>|</li>
				<li><a class="menuLink" href="#">자유게시판</a></li>
				<li>|</li>
				<li><a class="menuLink" href="#">공지사항</a></li>
			</ul>
		</nav>
	</div>
</body>
</html>