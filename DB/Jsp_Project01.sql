CREATE TABLE TEST_MEMBER(
    MID NVARCHAR2(10),
    MPW NVARCHAR2(10),
    MNAME NVARCHAR2(10),
    MBIRTH DATE
);

SELECT * FROM TEST_MEMBER;
SELECT * FROM TEST_MEMBER WHERE MID = 'lsw4656' and MPW = '1111'; 

-- 회원정보 조회
SELECT * FROM TEST_MEMBER WHERE MID = 'lsw4656';

-- DELETE
DELETE FROM TEST_MEMBER WHERE MID = 'lsw4656';

commit;


/*** MEMBERBOARD ***/

/* 회원정보테이블 */
CREATE TABLE MEMBERS(
    MID NVARCHAR2(20),
    MPW NVARCHAR2(20),
    MNAME NVARCHAR2(5),
    MBIRTH DATE,
    MADDR NVARCHAR2(100),
    MEMAIL NVARCHAR2(50),
    MSTATE NCHAR(1)
);

-- PK
ALTER TABLE MEMBERS
ADD CONSTRAINT PK_MID PRIMARY KEY(MID);

SELECT * FROM MEMBERS;

/* 게시글 정보 테이블 */
CREATE TABLE BOARDS(
    BNO NUMBER,                         -- 글 번호(PK)
    BTITLE NVARCHAR2(50) NOT NULL,      -- 글 제목
    BWRITER NVARCHAR2(20),              -- 글 작성자(회원아이디 FK)
    BCONTENT NVARCHAR2(2000),           -- 글 내용
    BDATE DATE,                         -- 글 작성일 (SYSDATE)
    BHITS NUMBER,                       -- 글 조회수(초기값 0)
    BFILENAME NVARCHAR2(200),           -- 파일명
    BSTATE NCHAR(1)                     -- 글 상태 ('1': 삭제처리, '0': 정상)
);

ALTER TABLE BOARDS
ADD CONSTRAINT PK_BNO PRIMARY KEY(BNO);

ALTER TABLE BOARDS
ADD CONSTRAINT FK_BWRITER FOREIGN KEY(BWRITER) REFERENCES MEMBERS(MID);

INSERT INTO BOARDS(BNO, BTITLE, BWRITER, BCONTENT, BDATE, BHITS, BFILENAME, BSTATE)
VALUES(1, '테스트글제목', 'test01', '테스트 글내용', SYSDATE, 0, '', '0');

INSERT INTO BOARDS(BNO, BTITLE, BWRITER, BCONTENT, BDATE, BHITS, BFILENAME, BSTATE)
VALUES(2, '테스트글제목2', 'test02', '테스트 글내용2', SYSDATE, 10, '', '0');

commit;

SELECT * FROM BOARDS;