<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
</head>
<jsp:include page="../common/menu.jsp" />
<script type="text/javascript">
	function cursorDo(){
		location.href="cursor.do?salary="+salary.value+"&employeeId="+employeeId.value;
	}
</script>

<body>
<div align="center">
	<h1>여기는 처음으로 접속했을때 보여 주는 페이지 입니다.</h1>
</div>
<div align="center">
	변경할 employeId 입력 :
	<input type="text" id="employeeId" value="101" style="text-align:center; width:60px;">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</div>
<div align="center">
	변경할 Salary 입력 : 
	<input type="text" id="salary" value="17000" style="text-align:center; width:60px;">
	<button onclick="cursorDo()">cursor.do실행</button>
</div>
<br/>
<div align="center">${vo }</div>
</body>
</html>
