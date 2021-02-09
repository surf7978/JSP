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
	function formSubmit(str) {
		frm.tNumber.value = str;
		frm.submit();
	}
</script>
<body>
	<div class="card-body p-0">
		<div align="center">
			<h1>내폰 사기</h1>
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
									onclick="formSubmit('${vo.tNumber }')">
									<li class="w3-purple w3-xlarge w3-padding-32">${vo.tImage }</li>
									<li class="w3-padding-16">${vo.tTitle }</li>
									<li class="w3-padding-16">${vo.pName }</li>
									<li class="w3-padding-16">${vo.pVolume }${vo.pColor }</li>
									<li class="w3-padding-16">${vo.tPrice }</li>
									<li class="w3-padding-16">${vo.boardView }</li>
									<c:if test="${vo.tradeProcess eq 'NotComplete' }">
										<li style="text-align: center; color: red;">${vo.tradeProcess }</li>
									</c:if>
									<c:if test="${vo.tradeProcess eq 'Complete' }">
										<li style="text-align: center; color: green;">${vo.tradeProcess }</li>
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