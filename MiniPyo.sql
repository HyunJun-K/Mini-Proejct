--------------------------------------------------------
--  파일이 생성됨 - 일요일-8월-02-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence DEPARTMENTS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."DEPARTMENTS_SEQ"  MINVALUE 1 MAXVALUE 9990 INCREMENT BY 10 START WITH 280 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence EMPLOYEES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."EMPLOYEES_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 207 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence LOCATIONS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."LOCATIONS_SEQ"  MINVALUE 1 MAXVALUE 9900 INCREMENT BY 100 START WITH 3300 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table GAMEUSER
--------------------------------------------------------

  CREATE TABLE "HR"."GAMEUSER" 
   (	"ID" VARCHAR2(20 BYTE), 
	"PW" VARCHAR2(20 BYTE), 
	"NAME" VARCHAR2(20 BYTE), 
	"BIRTH" VARCHAR2(20 BYTE), 
	"EMAIL" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table GAMEROOM
--------------------------------------------------------

  CREATE TABLE "HR"."GAMEROOM" 
   (	"NO" NUMBER(*,0), 
	"USER1" VARCHAR2(20 BYTE), 
	"USER2" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table LOBBY
--------------------------------------------------------

  CREATE TABLE "HR"."LOBBY" 
   (	"ID" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USERRANK
--------------------------------------------------------

  CREATE TABLE "HR"."USERRANK" 
   (	"RANK" NUMBER(*,0), 
	"ID" VARCHAR2(20 BYTE), 
	"SCORE" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for View EMP_DETAILS_VIEW
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "HR"."EMP_DETAILS_VIEW" ("EMPLOYEE_ID", "JOB_ID", "MANAGER_ID", "DEPARTMENT_ID", "LOCATION_ID", "COUNTRY_ID", "FIRST_NAME", "LAST_NAME", "SALARY", "COMMISSION_PCT", "DEPARTMENT_NAME", "JOB_TITLE", "CITY", "STATE_PROVINCE", "COUNTRY_NAME", "REGION_NAME") AS 
  SELECT
  e.employee_id,
  e.job_id,
  e.manager_id,
  e.department_id,
  d.location_id,
  l.country_id,
  e.first_name,
  e.last_name,
  e.salary,
  e.commission_pct,
  d.department_name,
  j.job_title,
  l.city,
  l.state_province,
  c.country_name,
  r.region_name
FROM
  employees e,
  departments d,
  jobs j,
  locations l,
  countries c,
  regions r
WHERE e.department_id = d.department_id
  AND d.location_id = l.location_id
  AND l.country_id = c.country_id
  AND c.region_id = r.region_id
  AND j.job_id = e.job_id
WITH READ ONLY
;
REM INSERTING into HR.GAMEUSER
SET DEFINE OFF;
Insert into HR.GAMEUSER (ID,PW,NAME,BIRTH,EMAIL) values ('rladudwo','rladudwo1!','김영재','1990년12월11일','abc@abc.com');
Insert into HR.GAMEUSER (ID,PW,NAME,BIRTH,EMAIL) values ('zzang9','!@#Aa842612','박성언','1990년5월12일','asd@asd.com');
Insert into HR.GAMEUSER (ID,PW,NAME,BIRTH,EMAIL) values ('abc11','rladudwo1!','김군','1990년2월28일','abc@def.com');
Insert into HR.GAMEUSER (ID,PW,NAME,BIRTH,EMAIL) values ('qweqweqwewqe','qwer154112!','미미미미','1920년4월6일','gg@gg.com');
Insert into HR.GAMEUSER (ID,PW,NAME,BIRTH,EMAIL) values ('wonbin','rladudwo1!','원빈','1990년2월25일','abc1@abc.com');
Insert into HR.GAMEUSER (ID,PW,NAME,BIRTH,EMAIL) values ('qwer15411','qwer154112!','현준','2014년2월7일','gg@gmail.com');
Insert into HR.GAMEUSER (ID,PW,NAME,BIRTH,EMAIL) values ('chckchck','qwer154112!','현준','2017년2월25일','guswms@ggg.com');
Insert into HR.GAMEUSER (ID,PW,NAME,BIRTH,EMAIL) values ('dasfdsfasd','qwer154112!','혀누','2020년1월1일','gaga@gamo.com');
Insert into HR.GAMEUSER (ID,PW,NAME,BIRTH,EMAIL) values ('1210yeasol','aaa000***','김예솔','1992년12월10일','1210yeasol@naver.com');
Insert into HR.GAMEUSER (ID,PW,NAME,BIRTH,EMAIL) values ('abc123','rladudwo1!','김재','1990년12월11일','123123@co.kr');
Insert into HR.GAMEUSER (ID,PW,NAME,BIRTH,EMAIL) values ('eqweqweq','qwer154112!','현준','0년0월0일','eqweqw@gamfad.com');
Insert into HR.GAMEUSER (ID,PW,NAME,BIRTH,EMAIL) values ('star97','qwer154112!','현준','1997년5월26일','guswns9865@naver.com');
Insert into HR.GAMEUSER (ID,PW,NAME,BIRTH,EMAIL) values ('qwer154112','qwer154112!','원빈','2020년1월1일','gagag@gamilo.com');
Insert into HR.GAMEUSER (ID,PW,NAME,BIRTH,EMAIL) values ('user2','qwer154112!','현준짱','1969년3월2일','guswns@gmail.com');
Insert into HR.GAMEUSER (ID,PW,NAME,BIRTH,EMAIL) values ('user1','0000','어두민','1921년5월4일','admin@admin.com');
Insert into HR.GAMEUSER (ID,PW,NAME,BIRTH,EMAIL) values ('aslkdjahds','dud305612!','김영재','1920년2월30일','sakdda@com.com');
Insert into HR.GAMEUSER (ID,PW,NAME,BIRTH,EMAIL) values ('admin','0000','어드민','1990년5월12일','admin@admin.com');
REM INSERTING into HR.GAMEROOM
SET DEFINE OFF;
Insert into HR.GAMEROOM (NO,USER1,USER2) values (0,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (1,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (2,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (3,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (4,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (5,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (6,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (7,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (8,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (9,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (10,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (11,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (12,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (13,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (14,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (15,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (16,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (17,null,null);
Insert into HR.GAMEROOM (NO,USER1,USER2) values (18,null,null);
REM INSERTING into HR.LOBBY
SET DEFINE OFF;
REM INSERTING into HR.USERRANK
SET DEFINE OFF;
Insert into HR.USERRANK (RANK,ID,SCORE) values (5,'zzang9',1010);
Insert into HR.USERRANK (RANK,ID,SCORE) values (9,'abc11',null);
Insert into HR.USERRANK (RANK,ID,SCORE) values (9,'qweqweqwewqe',null);
Insert into HR.USERRANK (RANK,ID,SCORE) values (9,'aslkdjahds',null);
Insert into HR.USERRANK (RANK,ID,SCORE) values (6,'wonbin',910);
Insert into HR.USERRANK (RANK,ID,SCORE) values (9,'qwer15411',null);
Insert into HR.USERRANK (RANK,ID,SCORE) values (9,'chckchck',null);
Insert into HR.USERRANK (RANK,ID,SCORE) values (9,'dasfdsfasd',null);
Insert into HR.USERRANK (RANK,ID,SCORE) values (1,'1210yeasol',2130);
Insert into HR.USERRANK (RANK,ID,SCORE) values (8,'abc123',50);
Insert into HR.USERRANK (RANK,ID,SCORE) values (9,'eqweqweq',null);
Insert into HR.USERRANK (RANK,ID,SCORE) values (2,'star97',1850);
Insert into HR.USERRANK (RANK,ID,SCORE) values (9,'abc12',null);
Insert into HR.USERRANK (RANK,ID,SCORE) values (7,'rladudwo',500);
Insert into HR.USERRANK (RANK,ID,SCORE) values (4,'user2',1360);
Insert into HR.USERRANK (RANK,ID,SCORE) values (3,'admin',1740);
Insert into HR.USERRANK (RANK,ID,SCORE) values (9,'user1',null);
Insert into HR.USERRANK (RANK,ID,SCORE) values (9,'qwer154112',null);
--------------------------------------------------------
--  DDL for Procedure ADD_JOB_HISTORY
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "HR"."ADD_JOB_HISTORY" 
  (  p_emp_id          job_history.employee_id%type
   , p_start_date      job_history.start_date%type
   , p_end_date        job_history.end_date%type
   , p_job_id          job_history.job_id%type
   , p_department_id   job_history.department_id%type
   )
IS
BEGIN
  INSERT INTO job_history (employee_id, start_date, end_date,
                           job_id, department_id)
    VALUES(p_emp_id, p_start_date, p_end_date, p_job_id, p_department_id);
END add_job_history;

/
--------------------------------------------------------
--  DDL for Procedure SECURE_DML
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "HR"."SECURE_DML" 
IS
BEGIN
  IF TO_CHAR (SYSDATE, 'HH24:MI') NOT BETWEEN '08:00' AND '18:00'
        OR TO_CHAR (SYSDATE, 'DY') IN ('SAT', 'SUN') THEN
	RAISE_APPLICATION_ERROR (-20205,
		'You may only make changes during normal office hours');
  END IF;
END secure_dml;

/
