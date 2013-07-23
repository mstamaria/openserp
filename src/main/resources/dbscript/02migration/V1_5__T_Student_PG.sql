CREATE TABLE CTX_STUDENT_PG (
    ID  INTEGER NOT NULL AUTO_INCREMENT,
	VERSION  INTEGER DEFAULT 0,
    LAST_NAME VARCHAR(50) NOT NULL,
    MIDDLE_NAME VARCHAR(50),
    FIRST_NAME VARCHAR(50) NOT NULL,
    NAME_SUFFIX VARCHAR(35) NOT NULL,
    BDATE DATE,
    ADDRESS1 VARCHAR(50), 
    ADDRESS2 VARCHAR(50), 
    ADDRESS3 VARCHAR(50),
    CONTACT_NO VARCHAR(20),
    PRIMARY KEY (ID));
    
    
CREATE TABLE CTX_STUD_PG_LNK (
    ID  INTEGER NOT NULL AUTO_INCREMENT,
    VERSION  INTEGER DEFAULT 0,
    STUDENT_ID INTEGER NOT NULL,
    PG_ID INTEGER NOT NULL,
    PRIMARY KEY (ID)
);

ALTER TABLE CTX_STUD_PG_LNK ADD CONSTRAINT UK_STUD_PG_ID UNIQUE (STUDENT_ID, PG_ID);
ALTER TABLE CTX_STUD_PG_LNK ADD CONSTRAINT FK_STUD_ID FOREIGN KEY (STUDENT_ID) REFERENCES CTX_STUDENT(ID);
ALTER TABLE CTX_STUD_PG_LNK ADD CONSTRAINT FK_PG_ID FOREIGN KEY (PG_ID) REFERENCES CTX_STUDENT_PG(ID);

CREATE INDEX IDX_STUD_PG_NAMES ON CTX_STUDENT_PG(LAST_NAME, FIRST_NAME);
