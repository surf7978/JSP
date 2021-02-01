<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	tr:hover{
		background-color: yellow;
	}
	td:hover{
		background-color: gold;
	}
	td{
		padding:10px;
	}
</style>

<jsp:include page="menu.jsp" />

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">

	<div align="center">
	<div><h1>로 그 인</h1></div>
		<div>
			<form id="frm" name="frm" action="login.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="100">아 이 디</th>
							<td width="150"><input type="text" id="mId" name="mId" size="30" value="admin"></td>
						</tr>
						<tr>
							<th width="100">패스워드</th>
							<td width="150"><input type="password" id="mPassword" name="mPassword" size="30" value="admin"></td>
						</tr>
					</table>
				</div><br />
				<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소">
			</form>
		</div>
	</div>
	
</div>
</body>
</html>