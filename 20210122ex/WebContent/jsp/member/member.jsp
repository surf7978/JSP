<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function Passcheck() {
		var form = document.frm;
		var pw = form.pw.value;
		var pwc = form.pwc.value;

		if (pw == pwc) {
			form.submit();
		} else {
			alert("패스워드가 일치하지 않습니다.!!!");
			form.pw.value = null;
			form.pwc.value = null;
			form.pw.focus();
		}
	}
</script>
</head>
<body>
<jsp:include page="../common/menu.jsp" />
	<div align="center">
		<div>
			<h1>회 원 가 입</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="../../memberResult" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="100">이 름</th>
							<td width="300"><input type="text" id="name" name="name"
								size="20" style="width:300px; border:0;" value="Hong Gil Dong"></td>
						</tr>
						<tr>
							<th width="100">아 이 디</th>
							<td width="300"><input type="text" id="id" name="id"
								size="20" style="width:300px; border:0;" value="hong"></td>
						</tr>
						<tr>
							<th width="100">PW</th>
							<td width="300"><input type="password" id="pw" name="pw"
								size="20" style="width:300px; border:0;" value="1234"></td>
						</tr>
						<tr>
							<th width="100">PW확인</th>
							<td width="300"><input type="password" id="pwc" name="pwc"
								size="20" style="width:300px; border:0;" value="1234"></td>
						</tr>
						<tr>
							<th width="100">취 미</th>
							<td width="300"><input type="checkbox" id="hobbys"
								name="hobbys" size="20" value="등산">등산 <input
								type="checkbox" id="hobbys" name="hobbys" size="20" value="낚시">낚시
								<input type="checkbox" id="hobbys" name="hobbys" size="20"
								value="바둑">바둑 <input type="checkbox" id="hobbys"
								name="hobbys" size="20" value="스포츠">스포츠 <input
								type="checkbox" id="hobbys" name="hobbys" size="20" value="없음" checked>없음</td>
						</tr>
						<tr>
							<th width="100">성 별</th>
							<td width="300"><input type="radio" id="gender"
								name="gender" size="20" value="남" checked>남<input type="radio"
								id="gender" name="gender" size="20" value="여">여</td>
						</tr>
						<tr>
							<th width="100">전화번호</th>
							<td width="300"><input type="text" id="tel" name="tel"
								size="20" style="width:300px; border:0;" value="010-1111-2222"></td>
						</tr>
					</table>
				</div>
				<button type="button" onclick="Passcheck()">회원가입</button>
				<button type="reset">취소하기</button>
				<br />
			</form>
		</div>
		<br />
		<div>
			<a href="../../index.jsp">홈가기</a>
		</div>
	</div>
</body>
</html>

