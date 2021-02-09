<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!doctype html>
<html lang="en" class="no-js">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" href="startbootstrap-sb-admin-2-gh-pages/css/reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="startbootstrap-sb-admin-2-gh-pages/css/menu_style.css"> <!-- Resource style -->
	<script src="startbootstrap-sb-admin-2-gh-pages/js/modernizr.js"></script> <!-- Modernizr -->
  	
	<title>Mega Dropdown | CodyHouse</title>
</head>
<body>
	<header>
		<div class="cd-dropdown-wrapper">
			<a class="cd-dropdown-trigger" href="#0">목록</a>
			<nav class="cd-dropdown">
				<h2>Title</h2>
				<a href="#0" class="cd-close">Close</a>
				<ul class="cd-dropdown-content">
					
					<li class="cd-divider">분류</li>
					<li class="has-children">
						<a href="#">의류</a>

						<ul class="cd-secondary-dropdown is-hidden">
							<li class="go-back"><a href="#0">Menu</a></li>
							<li class="see-all"><a href="searchCategory1.do?searchCategory1=의류">All 의류</a></li>
							<li class="has-children">
								<a href="#">상의</a>

								<ul class="is-hidden">
									<li class="go-back"><a href="#0">의류</a></li>
									<li class="see-all"><a href="searchCategory2.do?searchCategory2=상의">All 상의</a></li>
									
									<li><a href="#">패딩</a></li>
									<li><a href="#">T셔츠</a></li>
								</ul>
							</li>

							<li class="has-children">
								<a href="#">하의</a>

								<ul class="is-hidden">
									<li class="go-back"><a href="#0">의류</a></li>
									<li class="see-all"><a href="searchCategory2.do?searchCategory2=하의">ALL 하의</a></li>
									<li><a href="#0">바지</a></li>
									<li><a href="#0">치마</a></li>
								</ul>
							</li>

							<li class="has-children">
								<a href="#">신발</a>

								<ul class="is-hidden">
									<li class="go-back"><a href="#0">의류</a></li>
									<li class="see-all"><a href="searchCategory2.do?searchCategory2=신발">All 신발</a></li>
									<li><a href="#">운동화</a></li>
									<li><a href="#">구두</a></li>
								</ul>
							</li>

							<li class="has-children">
								<a href="#">모자</a>

								<ul class="is-hidden">
									<li class="go-back"><a href="#0">의류</a></li>
									<li class="see-all"><a href="searchCategory2.do?searchCategory2=모자">All 모자</a></li>
									<li><a href="#">캡</a></li>
									<li><a href="#">비니</a></li>
								</ul>
							</li>
						</ul> <!-- .cd-secondary-dropdown -->
					</li> <!-- .has-children -->
					
					<li class="has-children">
						<a href="#">전자기기</a>

						<ul class="cd-secondary-dropdown is-hidden">
							<li class="go-back"><a href="#0">Menu</a></li>
							<li class="see-all"><a href="searchCategory1.do?searchCategory1=전자기기">All 전자기기</a></li>
							<li class="has-children">
								<a href="#">스마트폰</a>

								<ul class="is-hidden">
									<li class="go-back"><a href="#0">전자기기</a></li>
									<li class="see-all"><a href="searchCategory2.do?searchCategory2=스마트폰">All 스마트폰</a></li>
									
									<li><a href="#">갤럭시</a></li>
									<li><a href="#">아이폰</a></li>
								</ul>
							</li>

							<li class="has-children">
								<a href="#">컴퓨터</a>

								<ul class="is-hidden">
									<li class="go-back"><a href="#0">전자기기</a></li>
									<li class="see-all"><a href="searchCategory2.do?searchCategory2=컴퓨터">ALL 컴퓨터</a></li>
									<li><a href="#">삼성</a></li>
									<li><a href="#">LG</a></li>
								</ul>
							</li>

							<li class="has-children">
								<a href="#">주변기기</a>

								<ul class="is-hidden">
									<li class="go-back"><a href="#0">전자기기</a></li>
									<li class="see-all"><a href="searchCategory2.do?searchCategory2=주변기기">All 주변기기</a></li>
									<li><a href="#">키보드</a></li>
									<li><a href="#">마우스</a></li>
								</ul>
							</li>

						</ul> <!-- .cd-secondary-dropdown -->
					</li> <!-- .has-children -->



				</ul> <!-- .cd-dropdown-content -->
			</nav> <!-- .cd-dropdown -->
		</div> <!-- .cd-dropdown-wrapper -->
	</header>

<!-- Bootstrap core JavaScript-->
	<script src="startbootstrap-sb-admin-2-gh-pages/vendor/jquery/jquery.min.js"></script>
	<script src="startbootstrap-sb-admin-2-gh-pages/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="startbootstrap-sb-admin-2-gh-pages/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="startbootstrap-sb-admin-2-gh-pages/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="startbootstrap-sb-admin-2-gh-pages/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="startbootstrap-sb-admin-2-gh-pages/js/demo/chart-area-demo.js"></script>
	<script src="startbootstrap-sb-admin-2-gh-pages/js/demo/chart-pie-demo.js"></script>
	
		
<script src="startbootstrap-sb-admin-2-gh-pages/js/jquery-2.1.1.js"></script>
<script src="startbootstrap-sb-admin-2-gh-pages/js/jquery.menu-aim.js"></script> <!-- menu aim -->
<script src="startbootstrap-sb-admin-2-gh-pages/js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>