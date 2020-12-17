
CREATE TABLE member(
       mem_num NUMBER(10) not null,
       email VARCHAR2(50) unique not null,
       auth NUMBER(1) default 2 not null,
      CONSTRAINT mem_pk PRIMARY KEY(mem_num)
);

CREATE TABLE member_detail(
       mem_num NUMBER(10) not null,
       mem_image BLOB,
       mem_imagename varchar2(100),
       nickname VARCHAR2(30) not null,
       password VARCHAR2(60) not null,
       birth DATE not null,
       phone VARCHAR2(20) not null,
       mem_regdate DATE default SYSDATE not null,
       mem_modifydate DATE ,
       purchase_date DATE,
       expire_date Date,
       prefer number(2),
      CONSTRAINT mem_detail_pk PRIMARY KEY(mem_num)
);

CREATE TABLE musical(
    mus_num NUMBER(10) not null,
    mus_name VARCHAR2(100) not null,
    gen_num NUMBER(10) not null,
    mus_age NUMBER(2) not null,
    mus_actor VARCHAR2(100) not null,
    mus_time NUMBER(3) not null,
    mus_video VARCHAR2(1500) not null,
    mus_rate NUMBER(10) default 0 not null,
    mus_post BLOB not null,
    mus_postname VARCHAR2(200) not null,
    mus_summary VARCHAR2(1500) not null,
    mus_detail CLOB not null,
    mus_regdate DATE not null,
    mus_hit NUMBER(10) default 0,
     CONSTRAINT musical_pk PRIMARY KEY(mus_num)
);


CREATE TABLE genre(
 gen_num NUMBER(2) not null,
 gen_name VARCHAR2(50)  not null,
CONSTRAINT genre_pk  PRIMARY KEY (gen_num)
);


CREATE TABLE pick(
 pick_num NUMBER(10) not null,
 mem_num NUMBER(10)  not null,	
 mus_num NUMBER(10) not null,
CONSTRAINT pick_pk  PRIMARY KEY (pick_num)
);

CREATE TABLE reviews(
 rev_num NUMBER(10) not null,
 mem_num NUMBER(10)   not null,
 mus_num NUMBER(20) not null,
 rev_rate NUMBER(10,1) not null,
 review varchar2(300) not null,
 rev_regdate date not null,
 hide_rev VARCHAR2(100),
CONSTRAINT reviews_pk PRIMARY KEY (rev_num)
);


CREATE TABLE notice(
	no_num NUMBER(10) not null,
	mem_num NUMBER(10)not null,
	no_title VARCHAR2(300)  not null,
	no_content clob,
	no_regdate DATE  not null,
	no_hit NUMBER(10) default 0 not null ,
	noticedate date not null ,
CONSTRAINT notice_pk PRIMARY KEY (no_num)
);



--ALTER TABLE member 
--ADD CONSTRAINTS email
--FOREIGN KEY(email)
--REFERENCES member_detail(email);

ALTER TABLE member
ADD CONSTRAINTS mem_num 
FOREIGN KEY(mem_num)
REFERENCES member_detail(mem_num);

ALTER TABLE musical
ADD CONSTRAINTS gen_num
FOREIGN KEY(gen_num)
REFERENCES genre(gen_num)
ON DELETE CASCADE;

ALTER TABLE prefer
ADD CONSTRAINTS mem_num2
FOREIGN KEY(mem_num)
REFERENCES  member(mem_num)
ON DELETE CASCADE;

ALTER TABLE pick
ADD CONSTRAINTS mem_num3
FOREIGN KEY(mem_num)
REFERENCES  member(mem_num)
ON DELETE CASCADE;

ALTER TABLE pick
ADD CONSTRAINTS mus_num
FOREIGN KEY(mus_num)
REFERENCES  musical(mus_num)
ON DELETE CASCADE;

ALTER TABLE reviews
ADD CONSTRAINTS mem_num4
FOREIGN KEY(mem_num)
REFERENCES  member(mem_num)
ON DELETE CASCADE;

ALTER TABLE reviews
ADD CONSTRAINTS mus_num2
FOREIGN KEY(mus_num)
REFERENCES  musical(mus_num)
 ON DELETE CASCADE;

ALTER TABLE notice
ADD CONSTRAINTS mem_num6
FOREIGN KEY(mem_num)
REFERENCES  member(mem_num)
ON DELETE CASCADE;




CREATE SEQUENCE mem_num
INCREMENT BY 1
START WITH  10000;

CREATE SEQUENCE mus_seq
INCREMENT BY 1
START WITH  100;


CREATE SEQUENCE pick_num
INCREMENT BY 1
START WITH 30000;

CREATE SEQUENCE rev_num
INCREMENT BY 1
START WITH  40000;

CREATE SEQUENCE admin_seq
INCREMENT BY 1
START WITH  100;

CREATE SEQUENCE no_seq
INCREMENT BY 1
START WITH 70000;

INSERT INTO genre (gen_num,gen_name) VALUES(0,'분류없음');
INSERT INTO genre (gen_num,gen_name) VALUES(1,'라이선스');
INSERT INTO genre (gen_num,gen_name) VALUES(2,'오리지널');
INSERT INTO genre (gen_num,gen_name) VALUES(3,'창작');
INSERT INTO genre (gen_num,gen_name) VALUES(4,'어린이/가족');
INSERT INTO genre (gen_num,gen_name) VALUES(5,'퍼포먼스');

