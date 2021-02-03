<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
function idCheck(str) {

	if (str != "") {

		var url = "idCheck.do?memberId=" + str;

		window.open(url, "아이디 체크", "width=400,height=300");
	}

	else {
		alert('아이디를 입력해주세요.');

	}
}


function checkForm(){
	var form = document.frm;
	var name = form.memberName;
	var id = form.memberId;
	var pw = form.memberPassword;
	var pck = form.pck;
	var tel = form.memberTel;
	var adr = form.memberAddress;

	if (name.value !="" && id.value !="" && pw.value !="" && pck.value !="" && tel.value !="" && adr.value !="" ) {
		
		if (pw.value == pck.value){
		
			form.submit();}
		else {
			alert("비밀번호가 같지 않습니다.")
			form.memberPassword.value = "";
			form.pck.value= "";
			form.memberPassword.focus();
		}

	} else {
		alert("빈 칸을 채워주세요.")
		
		if (name.value == "") {
			name.focus();
		} else if (id.value == "") {
			id.focus();
		}else if (pw.value == "") {
			pw.focus();
		}else if (pck.value == "") {
			pck.focus();
		}else if (tel.value == "") {
			tel.focus();
		}else if (adr.value == "") {
			adr.focus();
		}
	}
	
}

</script>

<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width:2000px;margin-top:296px;">
<div align="center">
<h1 style="font-weight: bolder;font-size: 50; padding: 20px;">회원가입</h1>
</div>
<form id="frm" name="frm" action="memberJoin.do" method="post">
<div align="center">
<table style=>
<tr>
<th>이름</th><td><input type="text" id="memberName" name="memberName"></td>
</tr>
<tr>
<th>아이디</th><td><input type="text" id="memberId" name="memberId"></td><td><button type="button" onclick="idCheck(memberId.value)">중복체크</button></td>
</tr>
<tr>
<th>패스워드</th><td style="margin-right: 50px;"><input type="password" id="memberPassword" name="memberPassword"></td>
</tr>
<tr>
<th>패스워드확인</th><td><input type="password" id="pck" name="pck"></td>
</tr>
<tr>
<th>전화번호</th><td><input type="text" id="memberTel" name="memberTel"></td>
</tr>
<tr>
<th>주소</th><td><input type="text" id="memberAddress" name="memberAddress"></td>
</tr>

</table>
<br>
<button type="button" onclick="checkForm()">가입</button>
</div>
			</form>
</div>
</body>
</html>