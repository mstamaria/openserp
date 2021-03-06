CREATE TABLE CTX_STUDENT (
    RECID  INTEGER NOT NULL AUTO_INCREMENT,
	VERSION  INTEGER DEFAULT 0,
    STUDENT_ID VARCHAR(20) NOT NULL,
    LAST_NAME VARCHAR(50) NOT NULL,
    MIDDLE_NAME VARCHAR(50),
    FIRST_NAME VARCHAR(50) NOT NULL,
    NAME_SUFFIX VARCHAR(35) NOT NULL,
    BDATE DATE,
    ADDRESS1 VARCHAR(50), 
    ADDRESS2 VARCHAR(50), 
    ADDRESS3 VARCHAR(50),
    CONTACT_NO VARCHAR(20),
    PRIMARY KEY (RECID));
    
    
ALTER TABLE CTX_STUDENT ADD CONSTRAINT UK_STUD_ID UNIQUE (STUDENT_ID);

CREATE INDEX IDX_STUD_NAMES ON CTX_STUDENT(LAST_NAME, FIRST_NAME);
