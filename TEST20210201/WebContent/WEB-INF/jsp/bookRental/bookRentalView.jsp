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
		<h1>대여중인 도서정보 상세보기</h1>
		<table border="1">
			<tr>
				<th>대여일자</th>
				<td><input style="border:0; text-align:center;" id="rDate" name="rDate" value="${vo.rentalDate }" readonly></td>
			</tr>
			<tr>
				<th>도서코드</th>
				<td><input style="border:0; text-align:center;" id="bCode" name="bCode" value="${vo.bookCode }" readonly></td>
			</tr>
			<tr>
				<th>회원아이디</th>
				<td><input style="border:0; text-align:center;" id="mId" name="mId" value="${vo.memberId}" readonly></td>
			</tr>
		</table>
		<br />
		<div>
			<button type="button" onclick="location.href='bookRentalList.do'">목록가기</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='returnbook.do?rentalDate3=${vo.rentalDate }&memberId3=${memberId }&bookCode3=${vo.bookCode }'">반납하기</button>
		</div><br/>
	</div>



</div>
</body>
</html>