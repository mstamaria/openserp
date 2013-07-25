CREATE TABLE CTX_USER_ROLE(
	RECID  INTEGER NOT NULL AUTO_INCREMENT,
	VERSION  INTEGER DEFAULT 0 NOT NULL,
    USERNAME VARCHAR(50) NOT NULL,
    ROLE VARCHAR(50) NOT NULL,
    PRIMARY KEY (RECID));
    
ALTER TABLE CTX_USER_ROLE ADD CONSTRAINT UK_USERNAME_ROLE UNIQUE  (USERNAME, ROLE);
ALTER TABLE CTX_USER_ROLE ADD CONSTRAINT FK_USERNAME FOREIGN KEY (USERNAME) REFERENCES CTX_USER(USERNAME);

