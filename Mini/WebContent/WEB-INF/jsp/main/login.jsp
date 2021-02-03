<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
function checkForm(){
	var form = document.frm;
	var memberId = form.memberId.value;
	var memberPassword = form.memberPassword.value;


	if (memberId != "" && memberPassword != "") {

			form.submit();

	} else {
		alert("빈 칸을 채워주세요.")
		if (memberId == "") {
			form.memberId.focus();
		} else if (memberPassword == "") {
			form.memberPassword.focus();
		}
	}
	
}

</script>

		<div align="center" style="padding: 10px;">
		<div>
			<h1 style="font-weight: bolder;font-size: 50; padding: 20px;">로그인</h1></div>
			<form id="frm" name="frm" action="login.do" method="post">
				<div>
					<table style="padding: 30px;">
						<tr >
							<td class="login">아 이 디</td>
							<td class="login"><input type="text" id="memberId" name="memberId"  class="login" size="20"></td>
						</tr>
						<tr>
							<td class="login">패스워드</td>
							<td class="login"><input type="password" id="memberPassword"  class="login" name="memberPassword" size="20"></td>
						</tr>
					</table>
				</div>
				<button type="button" onclick=checkForm()>로그인</button>
				<button type="button" onclick="location.href = 'memberJoinForm.do'">회원가입</button>
			</form>
		</div>