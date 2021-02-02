<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:forward page="loginForm.do" />
<div align="center">
	<h1>로딩 중</h1>
</div>

<!-- 
create table book99(BookCode varchar2(4) not null primary key,
BookName varchar2(100) not null , Quantity number default 5 not null , bCount number default 5 not null);

insert into book99(bookcode, bookname) values('1111','1번책');
insert into book99(bookcode, bookname) values('222','2번책');
insert into book99(bookcode, bookname) values('33','3번책');

create table member99(MemberId varchar2(10) not null primary key,
MemberName varchar2(20) not null , MemberPassword varchar2(20) not null
,MemberTel varchar2(20) not null, MemberAddress varchar2(100), MemberAuth varchar2(10) default 'USER' );

insert into member99(MemberId, MemberName, MemberPassword, MemberTel, MemberAddress, MemberAuth) 
values('admin','관리자', 'admin', '010-1111-2222', '대구시', 'ADMIN');
insert into member99(MemberId, MemberName, MemberPassword, MemberTel, MemberAddress) 
values('park','박', '1234', '010-1234-5678', '서울시');

create table bookrental99(RentalDate varchar2(20) default to_char(sysdate,'yyyy/mm/dd hh24:mi:ss') not null,
BookCode varchar2(4) not null , MemberId varchar2(10) not null
,ReturnDate varchar2(20));

drop table book99;
drop table member99;
drop table bookrental99;

commit;
 -->
</body>
</html>