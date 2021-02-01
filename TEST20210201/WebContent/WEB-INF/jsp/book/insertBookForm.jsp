<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../main/menu.jsp" />

<script>
	function emptyCheck(){
		if(frm.bCode.value == ""){
			alert("도서코드를 입력하세요.");
			frm.bCode.focus();
			return false;
		}else if(frm.bName.value == ""){
			alert("도서명을 입력하세요.");
			frm.bName.focus();
			return false;
		}
		return true;
	}
</script>

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">

<div align="center">
		<div>
			<h1>도서 등록</h1>
		</div>
		<form id="frm" name="frm" onsubmit="return emptyCheck()" action="insertBook.do" method="post">
		<div>
			<table border="1">
				<tr>
					<th>도서코드</th>
					<td><input type="text" id="bCode" name="bCode"></td>
				</tr>
				<tr>
					<th>도서명</th>
					<td><input type="text" id="bName" name="bName"></td>
				</tr>
				<!-- 
				<tr>
					<th>기본수량</th>
					<td><input type="text" id="qnT" name="qnT"></td>
				</tr>
				<tr>
					<th>현재수량</th>
					<td><input type="text" id="bCt" name="bCt"></td>
				</tr>
				 -->
			</table>
		</div><br />
		<div>
			<button type="submit">저장</button>
			&nbsp;&nbsp;
			<button type="reset">취소</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='bookList.do'">뒤로가기</button>
		</div>
		</form>
	</div>

</div>
</body>
</html>