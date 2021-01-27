<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
<script type="text/javascript">
	function formCheck(){
		//내가 한 것
		if(frm.mId.value == ""){
			alert("아이디는 반드시 입력해야 합니다.");
			frm.mId.focus();
			return false;
		}else if(frm.mPassword.value == ""){
			alert("패스워드는 반드시 입력해야 합니다.");
			frm.mPassword.focus();
			return false;
		}else if(frm.mPassword1.value == ""){
			alert("패스워드는 반드시 입력해야 합니다.");
			frm.mPassword1.focus();
			return false;
		}else if(frm.mPassword.value != frm.mPassword1.value){
			alert("패스워드가 일치하지 않습니다.");
			frm.mPassword.value = null;
			frm.mPassword1.value = null;
			frm.mPassword.focus();
			return false;
		}else if(frm.mName.value == ""){
			alert("이름은 반드시 입력해야 합니다.");
			frm.mName.focus();
			return false;
		}
		
		//교수님이 하신 것
//		if(frm.mId.value == ""){
//			alert("아이디는 반드시 입력해야 합니다.");
//			frm.mId.focus();
//			return false;
//		} //HTML에 required="required" 속성 넣어도 반드시 쓰게 할 수 있음

//		if(frm.mPassword.value == ""){
//			alert("패스워드는 반드시 입력해야 합니다.");
//			frm.mPassword.focus();
//			return false;
//		}else if(frm.mPassword.value != frm.mPassword1.value){
//			alert("패스워드가 일치하지 않습니다.");
//			frm.mPassword.value = null;
//			frm.mPassword1.value = null;
//			frm.mPassword.focus();
//			return false;
//		}
		
//		if(frm.mName.value == ""){
//			alert("이름은 반드시 입력해야 합니다.");
//			frm.mName.focus();
//			return false;
//		}
		return true;
	}
	
	
	function idCheck(str){
		if(str == ""){
			alert("체크할 아이디를 입력하세요.");
			frm.mId.focus();
		}else{
			var url = "idCheck.do?mid="+str;
			window.open(url, "아이디 중복체크", "width=700, height=150, top=100, left=100");
		}
	}
</script>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<div>
			<h1>회 원 가 입</h1>
		</div>
		<div>
			<form id="frm" name="frm" onsubmit="return formCheck()" action="memberJoin.do" method="post">
			<!-- onsubmit="return formCheck()" 리턴으로 안 적어주면 false값 못 받아와서 action="memberJoin.do" 진행됨 -->
				<div>
					<table border="1">
						<tr>
							<th width="100">아 이 디</th>
							<td width="150">
								<input type="text" id="mId" name="mId"size="30" required="required">
								<!-- required="required" = 반드시 써야하게 할 때 JS말고 HTML로도 할 수 있음 -->
								<button type="button" onclick="idCheck(mId.value)">중복체크</button>
							</td>
						</tr>
						<tr>
							<th width="100">패스워드</th>
							<td width="170"><input type="password" id="mPassword" name="mPassword" size="41"></td>
						</tr>
						<tr>
							<th width="100">패스워드확인</th>
							<td width="170"><input type="password" id="mPassword1" name="mPassword1" size="41"></td>
						</tr>
						<tr>
							<th width="100">이 름</th>
							<td width="170"><input type="text" id="mName" name="mName" size="41"></td>
						</tr>
					</table>
				</div><br /> 
				<div>
					<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>