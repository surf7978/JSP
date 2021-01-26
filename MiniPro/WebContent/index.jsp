<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MiniPro</title>
</head>
<!-- 
DB에서 기본셋팅하고 작업하기 micol계정하나 만들어서 시작

create table board(
 bid number primary key,
 bname varchar2(20) not null,
 btitle varchar2(100)not null,
 bcontent varchar2(4000) not null,
 bdate date default sysdate,
 bhit number default 0,
 bgroup number,
 bstep number,
 bindent number);
commit;
 
--시퀀스 생성해서 보드넘버 넣기
create SEQUENCE bidseq;
commit;

insert into board(bid, bname, btitle, bcontent)
values(bidseq.nextval, '홍길동', '비가온다', '비오는 화요일이다. 자바 수업 중');
select * from board;
commit;

create table member(
 mid varchar2(20) primary key,
 mname varchar2(20) not null,
 mpassword varchar2(20) not null,
 mauth varchar2(10) default 'USER');
commit;

insert into member values('admin', '관리자', 1234,'ADMIN');
insert into member(mid, mname, mpassword) values('hong', '홍길동', 1234);
select * from member;
commit;
 -->
<body>
<jsp:forward page="main.do" /> <!-- 이제 모든 명령 .do로 하면 web에서 FrontController로 보냄 -->
</body>
</html>