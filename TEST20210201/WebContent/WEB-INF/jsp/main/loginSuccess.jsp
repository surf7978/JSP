<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style>
	h3{
		color:white;
	}
</style>
<jsp:include page="menu.jsp" />

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">

	<div align="center">
		<h3>로그인 성공</h3>
		<h3>${vo.memberName }님은 ${vo.memberAuth } 권한을 갖습니다.</h3>
		<button type="button" onclick="location.href='main.do?memberId=${vo.memberId }'">홈으로</button>
	</div>
	
</div>
</body>
</html>