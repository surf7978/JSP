<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../main/menu.jsp" />
<style>
	th, td{
		padding: 10px;
		text-align: center;
	}
	input{
		border:0;
		text-align: center;
		background-color: gold;
	}
</style>

<script>
	function emptyCheck(){
		if(mPassword.value == ""){
			alert("비밀번호를 입력하세요.");
			mPassword.focus();
			return false;
		}else if(mName.value == ""){
			alert("이름을 입력하세요.");
			mName.focus();
			return false;
		}else if(mTel.value == ""){
			alert("전화번호을 입력하세요.");
			mTel.focus();
			return false;
		}else{
			mId.submit();
			mPassword.submit();
			mName.submit();
			return true;
		}
	}
	
	function deleteConfirm(){
		var YnN = confirm("정말 탈퇴할까요?")
		if(YnN){
			location.href="deleteMember.do?memberId="+${vo.memberId }; 
		}
	}
</script>

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">

	<div align="center">
		<h1>회원정보 변경</h1>
		<form id="frm" name="frm" onsubmit="return emptyCheck()" action="updateMember.do" method="post">
		<table border="1">
			<tr>
				<th>권한</th>
				<td><input value="${vo.memberAuth }" style="background-color:white;" readonly></td>
			</tr>
			<tr>
				<th>회원아이디</th>
				<td><input  id="mId" name="mId" value="${vo.memberId }" style="background-color:white;" readonly></td>
			</tr>
			<tr>
				<th>회원패스워드</th>
				<td><input type="text" id="mPassword" name="mPassword" value="${vo.memberPassword }"></td>
			</tr>
			<tr>
				<th>회원명</th>
				<td><input type="text" id="mName" name="mName" value="${vo.memberName }"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" id="mTel" name="mTel" value="${vo.memberTel }"></td>
			</tr>
			<tr>
				<th>회원주소</th>
				<td><input type="text" id="mAddress" name="mAddress" value="${vo.memberAddress }"></td>
			</tr>
		</table>
		<br />
		<div>
			<button type="button" onclick="location.href='memberList.do'">목록가기</button>
			&nbsp;&nbsp;
			<button type="submit">변경</button>
		</div>
		</form>
	</div>



</div>
</body>
</html>