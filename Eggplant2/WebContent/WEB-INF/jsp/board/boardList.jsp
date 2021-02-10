<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../main/main.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
setInterval(function(){
	  $(".blinkEle").toggle();
	}, 250);
</script>
<body>
	<div class="card-body p-0">
		<div align="center">
			<h1>판매글 조회</h1>
			<div>
				<c:choose>
					<c:when test="${empty list1 }">
						<ul class="w3-ul w3-border w3-center w3-hover-shadow">
							<li class="w3-padding-16">등록된 글이 없습니다.</li>
						</ul>
					</c:when>
					<c:when test="${not empty list1 }">
						<c:forEach items="${list1 }" var="vo">
							<div class="w3-third w3-margin-bottom" style="width: 500px">
								<ul class="w3-ul w3-border w3-center w3-hover-shadow"
									onclick="location.href='boardView.do?boardDate=${vo.boardDate }'">
									<li class="w3-purple w3-xlarge w3-padding-32"><img src="image/${vo.productImage }"></li>
									<li class="w3-padding-16">${vo.boardTitle }</li>
									<li class="w3-padding-16">${vo.category1 } > ${vo.category2 } > ${vo.productName }</li>
									<li class="w3-padding-16">용량: ${vo.productVolume } GB / 
															  색상: ${vo.productColor }</li>
									<li class="w3-padding-16">가격: ${vo.price }</li>
									<li class="w3-padding-16">조회수: ${vo.boardView }</li>
									<c:if test="${vo.tradeProcess eq 'NotComplete' }">
										<li style="text-align: center; color: red; padding:16px;" id="blinkEle">
										${vo.tradeProcess }</li>
									</c:if>
									<c:if test="${vo.tradeProcess eq 'Complete' }">
										<li style="text-align: center; color: red; padding:16px;" id="blinkEle">
										${vo.tradeProcess }</li>
									</c:if>
								</ul>
							</div>
						</c:forEach>
					</c:when>
				</c:choose>
				<br />
			</div>
		</div>
	</div>
</body>
</html>