<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
<c:if test="${logout ne null}">
alert("로그아웃 하셨습니다.");
</c:if>

<c:if test="${MemberVo.memberAuth ne null}">
window.onload =function(){
let rollingData = [];

<c:forEach var="vo" items="${MainList }">

	rollingData.push("${vo.bookName}");

</c:forEach>


let timer = 2000;

let first = document.getElementById('first');
let second = document.getElementById('second');
let third = document.getElementById('third');
let move = 2;
let dataCnt = 1;
let listCnt = 1;


first.children[0].innerHTML = rollingData[0];

setInterval(() => {
if(move == 2){
first.classList.remove('card_sliding');
first.classList.add('card_sliding_after');

second.classList.remove('card_sliding_after');
second.classList.add('card_sliding');

third.classList.remove('card_sliding_after');
third.classList.remove('card_sliding');

move = 0;
} else if (move == 1){
first.classList.remove('card_sliding_after');
first.classList.add('card_sliding');

second.classList.remove('card_sliding_after');
second.classList.remove('card_sliding');

third.classList.remove('card_sliding');
third.classList.add('card_sliding_after');

move = 2
} else if (move == 0) {
first.classList.remove('card_sliding_after');
first.classList.remove('card_sliding');

second.classList.remove('card_sliding');
second.classList.add('card_sliding_after');

third.classList.remove('card_sliding_after');
third.classList.add('card_sliding');

move = 1;
}

if(dataCnt < (rollingData.length - 1)) {
document.getElementById('rolling_box').children[listCnt].children[0].innerHTML = rollingData[dataCnt];
dataCnt++;
} else if(dataCnt == rollingData.length - 1) {
document.getElementById('rolling_box').children[listCnt].children[0].innerHTML = rollingData[dataCnt];
dataCnt = 0;
}

if(listCnt < 2) {
listCnt++;
} else if (listCnt == 2) {
listCnt = 0;
}

}, timer);
}
</c:if>
</script>

<jsp:include page="menu.jsp" />

<div class="w3-content" style="max-width: 2000px; margin-top: 296px; height: 500px;">
	<c:if test="${Ljoin eq 'fail' }">
		<script>
			alert("로그인 실패하셨습니다");
		</script>
	</c:if>

	<c:if test="${MemberVo.memberAuth eq null}">
		<jsp:include page="login.jsp" />
	</c:if>

	<c:if test="${MemberVo.memberAuth ne null}">
		<div class="row">
			<div class="leftcolumn">
				<div class="card">
					<h2>신착자료</h2>
					<h5></h5>
					<div class="fakeimg">
						<div class="rolling_box" style=" cursor: pointer;" onclick="location.href='viewbk.do'">
							<ul id="rolling_box">
								<li class="card_sliding" id="first"><p></p></li>
								<li class="" id="second"><p></p></li>
								<li class="" id="third"><p></p></li>
							</ul>
						</div>
					</div>
					<p>책을 읽읍시다...</p>
					<p>책은 마음의 양식...</p>
				</div>

			</div>
			<div class="rightcolumn">
				<div class="card">
					<c:if test="${MemberVo.memberAuth eq 'admin' }">
						<h2>관리자</h2>
					</c:if>
					<c:if test="${MemberVo.memberAuth eq 'user' }">
						<h2>회원</h2>
					</c:if>

					<div class="fakeimg" style="height: 100px;">
						<p>ID : ${MemberVo.memberId }
						<p>
					</div>
					<p>${MemberVo.memberName }님환영합니다.</p>
				</div>

				<div class="card">
					<h3>공지사항</h3>
					<p>세미나 참가자 모집중</p>
				</div>
			</div>
		</div>
	</c:if>

</div>
</body>

</html>