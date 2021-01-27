<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//부모창으로 돌려주는 기능 만들기
	function formClose(){
		if(${check }) {
			//opener = 부모창
			window.opener.document.getElementById("mPassword").focus();
		}else {
			window.opener.document.getElementById("mId").value = null;
			window.opener.document.getElementById("mId").focus();
		}
		window.close();
	}
</script>
</head>
<body>
<div align="center">
	<h1>${msg }</h1>
	<button type="button" onclick="formClose()">확인</button>
</div>
</body>
</html>