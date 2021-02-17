<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
<style>
.center {
  text-align: center;
}

.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  margin: 0 4px;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>
</head>
<jsp:include page="../common/menu.jsp" />
<script type="text/javascript">
	function cursorDo(){
		location.href="cursor.do?salary="+salary.value+"&employeeId="+employeeId.value;
	}
	
	function goPage(page){
		location.href="${pageContext.request.contextPath}/paging.do?pageNo="+page;
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
<div align="center"><button onclick="location.href='paging.do?pageNo=1'">paging.do실행</button></div>




<br/>
<div align="center"><p>employeeId / firstName / lastName / salary / email / hireDate </p></div>
<c:forEach var="vo" items="${list }">
	<div align="center"><p>${vo.employeeId } / ${vo.firstName } / ${vo.lastName } / ${vo.salary } / ${vo.email } / ${vo.hireDate }</p></div>
</c:forEach>

<jsp:include page="../common/paging.jsp" />

</body>
</html>