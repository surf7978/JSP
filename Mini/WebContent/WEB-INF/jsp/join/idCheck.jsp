<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/Mini/css/css.css" type="text/css">
<meta charset="UTF-8">
<title>중복 체크</title>
<script type="text/javascript">
function formClose(){
	if(${check }) {
		opener.document.frm.memberId.value = null;
		opener.document.frm.memberId.focus();
		
	}
	else {
		
		opener.document.frm.memberPassword.focus();
	}
	window.close();
}

</script>

</head>
<body>

<div align="center">

<h3>${msg }</h3>
<button type="button" onclick="formClose()">확인</button>

</div>
</body>
</html>