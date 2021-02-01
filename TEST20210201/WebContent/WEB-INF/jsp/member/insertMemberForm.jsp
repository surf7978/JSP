<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../main/menu.jsp" />

<script>
	function emptyCheck(){
		if(frm.mId.value == ""){
			alert("회원아이디를 입력하세요.");
			frm.mId.focus();
			return false;
		}else if(frm.mPassword.value == ""){
			alert("회원패스워드을 입력하세요.");
			frm.mPassword.focus();
			return false;
		}else if(frm.mPasswordCheck.value == ""){
			alert("패스워드확인을 입력하세요.");
			frm.mPasswordCheck.focus();
			return false;
		}else if(frm.mName.value == ""){
			alert("회원명을 입력하세요.");
			frm.mName.focus();
			return false;
		}else if(frm.mTel.value == ""){
			alert("전화번호를 입력하세요.");
			frm.mTel.focus();
			return false;
		}else if(frm.mPasswordCheck.value != frm.mPassword.value){
			alert("패스워드가 맞지 않습니다.");
			frm.mPasswordCheck.value = null;
			frm.mPasswordCheck.focus();
			return false;
		}
		return true;
	}
</script>

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">

<div align="center">
		<div>
			<h1>회원 가입</h1>
		</div>
		<form id="frm" name="frm" onsubmit="return emptyCheck()" action="insertMember.do" method="post">
		<div>
			<table border="1">
				<tr>
					<th>회원아이디</th>
					<td><input type="text" id="mId" name="mId"></td>
				</tr>
				<tr>
					<th>회원패스워드</th>
					<td><input type="password" id="mPassword" name="mPassword"></td>
				</tr>
				<tr>
					<th>패스워드확인</th>
					<td><input type="password" id="mPasswordCheck" name="mPasswordCheck"></td>
				</tr>
				<tr>
					<th>회원명</th>
					<td><input type="text" id="mName" name="mName"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" id="mTel" name="mTel"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type="text" id="mAddress" name="mAddress"></td>
				</tr>
			</table>
		</div><br />
		<div>
			<button type="submit">저장</button>
			&nbsp;&nbsp;
			<button type="reset">취소</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='memberList.do'">뒤로가기</button>
		</div>
		</form>
	</div>

</div>
</body>
</html>