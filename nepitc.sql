CREATE TABLE tbl_admin(
    admin_id INTEGER,
    username VARCHAR2(50) NOT NULL UNIQUE,
    password VARCHAR2(50) NOT NULL,
    CONSTRAINT pk_admin_id PRIMARY KEY(admin_id)
);

DESC TBL_ADMIN;

ALTER TABLE tbl_admin RENAME COLUMN active TO enabled;
ALTER TABLE tbl_admin MODIFY enabled CHAR(1) DEFAULT 1;

ALTER TABLE tbl_admin ADD active NUMBER(1) DEFAULT 1 NOT NULL;
ALTER TABLE tbl_admin ADD created_at DATE DEFAULT SYSDATE NOT NULL;

CREATE SEQUENCE sq_admin_id START WITH 1;

CREATE OR REPLACE TRIGGER tr_admin
BEFORE INSERT ON tbl_admin
FOR EACH ROW
BEGIN
    SELECT sq_admin_id.NEXTVAL
    INTO :NEW.admin_id 
    FROM dual;
END;

INSERT INTO TBL_ADMIN(username, password) VALUES ('admin', 'admin');

SELECT * FROM TBL_ADMIN;

ALTER TABLE TBL_ADMIN ADD email VARCHAR2(100) UNIQUE;

SELECT USERNAME, PASSWORD FROM TBL_ADMIN WHERE USERNAME='admin' AND PASSWORD='admin';
    
    
CREATE TABLE tbl_user_role(
    user_role_id INTEGER,
    username VARCHAR2(50) NOT NULL,
    user_role VARCHAR2(50) DEFAULT 'ROLE_ADMIN' NOT NULL,
    CONSTRAINT pk_user_role_id PRIMARY KEY(user_role_id)
);    

DESC TBL_USER_ROLE;

ALTER TABLE tbl_user_role ADD CONSTRAINT fk_username FOREIGN KEY(username) REFERENCES tbl_admin(username);

DESC tbl_user_role;

CREATE SEQUENCE sq_user_role_id START WITH 1;

CREATE OR REPLACE TRIGGER tr_user_role
BEFORE INSERT ON tbl_user_role
FOR EACH ROW
BEGIN
    SELECT sq_user_role_id.NEXTVAL
    INTO :NEW.user_role_id
    FROM dual;
END;

INSERT INTO tbl_user_role(username) VALUES('admin');
INSERT INTO tbl_user_role(username) VALUES('nishan');
INSERT INTO tbl_user_role(username) VALUES('nishan11');

SELECT * FROM tbl_user_role;


SELECT * FROM TBL_ADMIN T, TBL_USER_ROLE U
WHERE T.USERNAME = U.USERNAME;
--
--CREATE OR REPLACE TRIGGER tr_insert_email 
--AFTER INSERT ON tbl_admin
--FOR EACH ROW
--BEGIN
--    INSERT INTO tbl_user_role VALUES(NULL, '', NULL);
--END;







