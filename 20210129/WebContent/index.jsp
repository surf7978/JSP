<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 

  CREATE TABLE "MICOL"."REPLY" 
   (	"BID" NUMBER NOT NULL ENABLE, 
	"RNUM" NUMBER NOT NULL ENABLE, 
	"SUBJECT" VARCHAR2(500 BYTE) NOT NULL ENABLE, 
	"RDATE" DATE DEFAULT sysdate NOT NULL ENABLE, 
	 CONSTRAINT "REPLY_FK1" FOREIGN KEY ("BID")
	  REFERENCES "MICOL"."BOARD" ("BID") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

insert into reply values(1, 1, '댓글');
insert into reply values(1, 2, '댓글2');
insert into reply values(1, 3, '댓글3');

select a.bid, b.subject from board a, reply b where a.bid=b.bid;

select * from reply where bid=1;

commit;

댓글 테이블 기본 셋팅

 -->
<body>
<jsp:forward page="main.do" />
</body>
</html>