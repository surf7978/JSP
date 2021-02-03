<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width: 2000px; margin-top: 296px;">

<div align="center">
	<div><h1>도서 등록</h1></div>
	<form id="frm" name="frm" action="insertexec.do" method="post">
		<table border="1" class="table">
			<tr >
				<th width="150">도서명</th>
				<th width="150">기본 수량</th>
				<th width="150">현재 수량</th>
			</tr>

			<tr>
				<td width="150"><input type="text" id="bookname" name="bookname"></td>
				<td width="150"><input type="number" id="quantity" name="quantity" min="1" max="5" >
				<td width="150"><input type="number" id="bcount" name="bcount" min="1" max="5" >
			</tr>	
			

		</table><br/>
		<div>
			<button type="submit" >도서 등록</button>&nbsp;&nbsp;
			<input type="reset" id="cancle" name="cancle" value="취소">&nbsp;&nbsp;
			<button type="button" onclick="location.href='listadmin.do'" >목록으로 돌아가기</button>
		</div>
	</form>	

</div>
</div>

