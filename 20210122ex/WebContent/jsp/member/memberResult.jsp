<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../common/menu.jsp" />
<div align="center">
	<h1>${msg }</h1> <br />
	입력한 이름 : ${param.name } <br />
	입력한 아이디 : ${param.id } <br />
	입력한 패스워드 : ${param.pw } <br />
	입력한 패스워드체크 : ${param.pwc } <br />
	입력한 취미 : ${paramValues.hobbys[0] } ${paramValues.hobbys[1] } ${paramValues.hobbys[2] } ${paramValues.hobbys[3] } ${paramValues.hobbys[4] }<br />
	입력한 성별 : ${param.gender } <br />
	입력한 전화번호 : ${param.tel } <br />
</div>
</body>
</html>