<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>

	<c:if test="${lo ne null}">
	alert("${msg}");
	location.href = "main.do";
	</c:if>

	<c:if test="${lo eq null}">

	</c:if>

	function Search() {

		let search = document.getElementById("search").value;
		if(search != ""){
		let book = document.getElementsByClassName("bname");
		let find=[];
		for(i=0; i<book.length;i++){
			if(book[i].innerText.indexOf(search)>=0){
				find.push(book[i].parentNode);
				book[i].parentNode.style.backgroundColor ="gray";							
			}else{book[i].parentNode.style.backgroundColor ="transparent";}
		}

		if (find.length == []){
			alert("존재하지 않는 책입니다.");
			}
		else {find[0].scrollIntoView(false);}
		}
		else {
			alert("검색할 도서를 입력해주세요.");
			document.getElementById("search").focus();
		}


	}
</script>


<jsp:include page="../main/menu.jsp" />


<div class="w3-content" style="max-width: 2000px; margin-top: 296px;">
	<div align="center">
		<input type="text" class="search" id="search" name="search">&nbsp;
		<button onclick="Search()">도서명 검색</button>
	</div>

	<br>

	<div align="center">
		<table class=tableTarget style="">
			<tr>

				<th>도서코드</th>
				<th>도서명</th>
				<th>기본수량</th>
				<th>현재수량</th>
				<c:if test="${MemberVo.memberAuth eq 'user'}">
					<th>대출</th>
				</c:if>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr class="row">


					<td>${vo.bookCode}</td>
					<td id=${vo.bookName } class="bname">&nbsp;${vo.bookName}</td>
					<td>${vo.quantity}</td>
					<td>${vo.bCount}</td>
					<c:if test="${MemberVo.memberAuth eq 'user'}">
						<td><form class=${vo.bookCode } name="${vo.bookCode }"
								action="rental.do" method="post">
								<input type="hidden" name="bCount" value="${vo.bCount}">
								<input type="hidden" name="bookCode" value="${vo.bookCode}">
								<button type="button" onclick="rental(${vo.bookCode})">대출</button>
							</form></td>
					</c:if>

				</tr>
			</c:forEach>
		</table>
	</div>

</div>
</body>
<script>
function rental(fname){

	let frm = document.querySelector("[name='"+fname+"']");
if(frm.bCount.value ==0){
	alert("현재 수량이 0입니다.");
}
else{
	frm.submit();
}
	
}

</script>
</html>