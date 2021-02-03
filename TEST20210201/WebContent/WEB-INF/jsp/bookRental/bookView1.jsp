<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../main/menu.jsp" />
<style>
	th, td{
		padding: 10px;
		text-align: center;
	}
	th{
		background-color:beige;
	}
</style>

<script type="text/javascript">
	function canNotRental(){
		alert("남은 재고가 없어서 대여할 수 없습니다.");
	}
	
	function likeClick(){
		if(lIt.value == 0){
			var YnN = confirm("좋아요?")
			if(YnN){
				lIt.value = parseInt(lIt.value)+1;
				hItB.type = "hidden";
				lItB.value = "좋아요 취소";
				location.href="updateLike.do?like="+lIt.value+"&bCode="+bCode.value;
			}
		}else{
			var YnN = confirm("취소?")
			if(YnN){
				lIt.value = parseInt(lIt.value)-1;
				hItB.type = "button";
				lItB.value = "좋아요";
				location.href="updateLike.do?like=-1&bCode="+bCode.value;
			}
		}
	}
	
	function hateClick(){
		if(hIt.value == 0){
			var YnN = confirm("싫어요?")
			if(YnN){
				hIt.value = parseInt(hIt.value)+1;
				lItB.type = "hidden";
				hItB.value = "싫어요 취소";
				location.href="updateHate.do?hate="+hIt.value+"&bCode="+bCode.value;
			}
		}else{
			var YnN = confirm("취소?")
			if(YnN){
				hIt.value = parseInt(hIt.value)-1;
				lItB.type = "button";
				hItB.value = "싫어요";
				location.href="updateHate.do?hate=-1&bCode="+bCode.value;
			}
		}
	}
</script>

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">
	<div align="center">
		<h1>도서정보 상세보기</h1>
		<form id="frm" name="frm" onsubmit="return bCountCheck()" action="" method="post">
		<table border="1">
			<tr>
				<th>도서코드</th>
				<td><input type="text" id="bCode" name="bCode" value="${vo.bookCode }" style="border:0; text-align:center;" readonly></td>
			</tr>
			<tr>
				<th>도서명</th>
				<td>${vo.bookName}</td>
			</tr>
			<tr>
				<th>총 수량</th>
				<td>${vo.quantity }권</td>
			</tr>
			<tr>
				<th>재고수량</th>
				<td>${vo.bCount }권</td>
			</tr>
		</table>
		<br />
		<div>
			<button type="button" onclick="location.href='bookRentalListUSER.do'">목록가기</button>
			&nbsp;&nbsp;
			<c:if test="${vo.bCount ne '0' }">
				<button type="button" onclick="location.href='rentalBook.do?bookCode2=${vo.bookCode }&memberId2=${memberId }'">도서대여</button>
			</c:if>
			<c:if test="${vo.bCount eq '0' }">
				<button type="button" onclick="canNotRental()" style="background-color:red; color:yellow;">대여불가</button>
			</c:if>
		</div>
		<br />
		<c:if test="${memberId ne 'admin' }">
		<div>
			<input type="button" id="lItB" name="lItB" onclick="likeClick()" style="background-color:blue; color:white" value="좋아요">
			&nbsp;&nbsp;
			<input type="button" id="hItB" name="hItB" onclick="hateClick()" style="background-color:red; color:white" value="싫어요">
		</div>
		<div>
			<input type="hidden" id="lIt" name="lIt" value=0 readonly>
			&nbsp;&nbsp;
			<input type="hidden" id="hIt" name="hIt" value=0 readonly>
		</div>
		</c:if>
		</form>
	</div>




</div>
</body>
</html>