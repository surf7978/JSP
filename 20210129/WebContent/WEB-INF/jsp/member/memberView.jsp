<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<jsp:include page="../main/menu.jsp" />
<style>
	th, td{
		padding: 10px;
		text-align: center;
	}
</style>

<script type="text/javascript">
	function deleteConfirm(){
		var YnN = confirm("정말 탈퇴할까요?")
		if(YnN){
			location.href="deleteMember.do?mId="+${vo.mId }; 
		}
	}
</script>
<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">
	<div align="center">
		<h1>회원정보 상세보기</h1>
		<table border="1">
			<tr>
				<th>권한</th>
				<td>${vo.mAuth }</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${vo.mId }</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>${vo.mPassword }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${vo.mName }</td>
			</tr>
		</table>
		<br />
		<div>
			<button type="button" onclick="location.href='memberList.do'">목록가기</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='updateMemberForm.do?mId1=${vo.mId }'">정보수정</button>
			&nbsp;&nbsp;
			<button type="button" onclick="deleteConfirm()">회원탈퇴</button>
		</div>
	</div>




</div>
</body>
</html>