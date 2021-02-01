<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<jsp:include page="../main/menu.jsp" />
<style>
	th, td{
		padding: 10px;
		text-align: center;
	}
</style>

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">
	<div align="center">
		<h1>회원정보 상세보기</h1>
		<table border="1">
			<tr>
				<th>권한</th>
				<td>${vo.memberAuth }</td>
			</tr>
			<tr>
				<th>회원아이디</th>
				<td>${vo.memberId }</td>
			</tr>
			<tr>
				<th>회원패스워드</th>
				<td>${vo.memberPassword }</td>
			</tr>
			<tr>
				<th>회원명</th>
				<td>${vo.memberName }</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${vo.memberTel }</td>
			</tr>
			<tr>
				<th>회원주소</th>
				<td>${vo.memberAddress }</td>
			</tr>
		</table>
		<br />
		<div>
			<button type="button" onclick="location.href='memberList.do'">목록가기</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='updateMemberForm.do?memberId1=${vo.memberId }'">정보수정</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='deleteMember.do?memberId=${vo.memberId }'">회원탈퇴</button>
		</div>
	</div>




</div>
</body>
</html>