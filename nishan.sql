CREATE TABLE tbl_user_role(
    user_role_id INTEGER,
    username VARCHAR2(50) NOT NULL,
    user_role VARCHAR2(50) DEFAULT 'ROLE_ADMIN' NOT NULL,
    CONSTRAINT pk_user_role_id PRIMARY KEY(user_role_id)
);    

DESC TBL_USER_ROLE;

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


SELECT USERNAME, PASSWORDS, ENABLED FROM TBL_ADMIN WHERE USERNAME='admin';

SELECT USERNAME, USER_ROLE FROM TBL_USER_ROLE WHERE USERNAME='admin';

UPDATE TBL_USER_ROLE SET USER_ROLE='ROLE_USER' WHERE USERNAME='admin';
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
--User table

--------------------33333333333333333333333333333333333333333333333333
CREATE TABLE TBL_USER(
    user_id NUMBER,
    full_name VARCHAR2(255) NOT NULL,
    email VARCHAR2(255) UNIQUE,
    contact VARCHAR2(255) NOT NULL,
    address VARCHAR2(255),
    username VARCHAR2(255) UNIQUE NOT NULL,
    user_password VARCHAR2(255) NOT NULL, 
    created_at DATE DEFAULT SYSDATE NOT NULL,
    enabled CHAR(1) DEFAULT 1 NOT NULL,
    CONSTRAINT pk_user_id PRIMARY KEY(user_id)
);

ALTER TABLE TBL_USER ADD USER_TYPE VARCHAR2(10);
ALTER TABLE TBL_USER RENAME COLUMN USER_PASSWORD TO PASSWORD;
ALTER TABLE TBL_USER MODIFY FULL_NAME VARCHAR2(255) NULL;
ALTER TABLE TBL_USER MODIFY USER_TYPE VARCHAR2(10) NOT NULL;
DESC TBL_USER;


CREATE SEQUENCE sq_user_id START WITH 1;

CREATE OR REPLACE TRIGGER tr_user_id
BEFORE INSERT ON TBL_USER
FOR EACH ROW
BEGIN 
    SELECT sq_user_id.NEXTVAL
    INTO :NEW.user_id
    FROM DUAL;
END;


--444444444444444444444444444444444444444444444444444444444444444444444444444444444
CREATE TABLE TBL_SHIPPING_ADDRESS(
    shipping_address_id NUMBER,
    address VARCHAR2(255) NOT NULL,
    CONSTRAINT pk_shipping_address_id PRIMARY KEY(shipping_address_id)
);

CREATE SEQUENCE sq_shipping_address_id START WITH 1;

CREATE OR REPLACE TRIGGER tr_shipping_address_id
BEFORE INSERT ON TBL_SHIPPING_ADDRESS
FOR EACH ROW
BEGIN 
    SELECT sq_shipping_address_id.NEXTVAL
    INTO :NEW.shipping_address_id
    FROM DUAL;
END;


--5555555555555555555555555555555555555555555555555555555555555555555555555555555
CREATE TABLE TBL_CATEGORY(
    category_id NUMBER,
    category_name VARCHAR2(255) NOT NULL,
    details VARCHAR2(500),
    CONSTRAINT pk_category_id PRIMARY KEY(category_id)
);

CREATE SEQUENCE sq_category_id START WITH 1;

CREATE OR REPLACE TRIGGER tr_category_id
BEFORE INSERT ON TBL_CATEGORY
FOR EACH ROW
BEGIN 
    SELECT sq_category_id.NEXTVAL
    INTO :NEW.category_id
    FROM DUAL;
END;


--66666666666666666666666666666666666666666666666666666666666666666666666666
CREATE TABLE TBL_PASHMINA(
    pashmina_id NUMBER,
    pashmina_name VARCHAR2(255),
    price FLOAT NOT NULL,
    added_at DATE DEFAULT SYSDATE NOT NULL,
    enabled CHAR(1) DEFAULT 1 NOT NULL,
    category_id NUMBER,
    CONSTRAINT pk_pashmina_id PRIMARY KEY(pashmina_id),
    CONSTRAINT fk_category_id FOREIGN KEY(pashmina_id) REFERENCES TBL_CATEGORY(category_id)
);

CREATE SEQUENCE sq_pashmina_id START WITH 1;

CREATE OR REPLACE TRIGGER tr_pashmina_id
BEFORE INSERT ON TBL_PASHMINA
FOR EACH ROW
BEGIN 
    SELECT sq_pashmina_id.NEXTVAL
    INTO :NEW.pashmina_id
    FROM DUAL;
END;



--777777777777777777777777777777777777777777777777777777777777777777777777777777777
CREATE TABLE TBL_DESCRIPTION(
    description_id NUMBER,
    pashmina_description VARCHAR2(999) NOT NULL,
    pashmina_id NUMBER,
    CONSTRAINT pk_description_id PRIMARY KEY(description_id),
    CONSTRAINT fk_pashmina_id FOREIGN KEY(pashmina_id) REFERENCES TBL_PASHMINA(pashmina_id)
);

CREATE SEQUENCE sq_description_id START WITH 1;

CREATE OR REPLACE TRIGGER tr_description_id
BEFORE INSERT ON TBL_DESCRIPTION
FOR EACH ROW
BEGIN 
    SELECT sq_description_id.NEXTVAL
    INTO :NEW.description_id
    FROM DUAL;
END;


--88888888888888888888888888888888888888888888888888888888888888888888888888888888888
CREATE TABLE TBL_ORDER(
    order_id NUMBER,
    user_id NUMBER,
    pashmina_id NUMBER,
    order_date DATE DEFAULT SYSDATE NOT NULL,
    sold_out_status CHAR(1) DEFAULT 0 NOT NULL,
    shipped_date DATE,
    quantity NUMBER NOT NULL,
    shipping_address_id NUMBER,
    CONSTRAINT pk_order_id PRIMARY KEY(order_id),
    CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES TBL_USER(user_id),
    CONSTRAINT fk_order_pashmina_id FOREIGN KEY(pashmina_id) REFERENCES TBL_PASHMINA(pashmina_id),
    CONSTRAINT fk_shipping_address_id FOREIGN KEY(shipping_address_id) REFERENCES TBL_SHIPPING_ADDRESS(shipping_address_id)
);

CREATE SEQUENCE sq_order_id START WITH 1;


CREATE OR REPLACE TRIGGER tr_order_id
BEFORE INSERT ON TBL_ORDER
FOR EACH ROW
BEGIN 
    SELECT sq_order_id.NEXTVAL
    INTO :NEW.order_id
    FROM DUAL;
END;

--99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999
CREATE TABLE TBL_PASHMINA_COLOUR(
    colour_id NUMBER,
    color VARCHAR2(20),
    pashmina_id NUMBER,
    CONSTRAINT pk_colour_id PRIMARY KEY(colour_id),
    CONSTRAINT fk_colour_pashmina_id FOREIGN KEY(pashmina_id) REFERENCES TBL_PASHMINA(pashmina_id)
);

CREATE SEQUENCE sq_colour_id START WITH 1;


CREATE OR REPLACE TRIGGER tr_colour_id
BEFORE INSERT ON TBL_PASHMINA_COLOUR
FOR EACH ROW
BEGIN 
    SELECT sq_colour_id.NEXTVAL
    INTO :NEW.colour_id
    FROM DUAL;
END;

--------------------------------------------------------------------------------------------------------------------------------
--TBL_ADMIN.username%TYPE

CREATE OR REPLACE TRIGGER tr_admin_user_role
AFTER INSERT ON tbl_admin
FOR EACH ROW
BEGIN
    INSERT INTO tbl_user_role(username, user_role) VALUES(:NEW.username, 'ROLE_ADMIN');
END;
DROP TRIGGER tr_admin_user_role;
-------------------------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER tr_user_user_role
AFTER INSERT ON TBL_USER
FOR EACH ROW
BEGIN
    IF :NEW.USER_TYPE = 'admin' THEN
        INSERT INTO tbl_user_role(username, user_role) VALUES(:NEW.username, 'ROLE_ADMIN');    
    ELSE 
        INSERT INTO tbl_user_role(username, user_role) VALUES(:NEW.username, 'ROLE_USER');
    END IF;
END;
-------------------------------------------------------------------------------------------------

INSERT INTO tbl_admin(username, passwords) VALUES('nisha', 'nisha');
select * from tbl_user;

INSERT INTO tbl_user(full_name, email, contact, address, username, user_password, user_type) 
VALUES('Admin', 'admin@gmail.com', '+977-9861211775', 'Hokse', 'admin', 'admin', 'admin');

INSERT INTO tbl_user(full_name, email, contact, address, username, user_password, user_type) 
VALUES('Nishan Dhungana', 'nishandhungana41@gmail.com', '+977-9861211775', 'Hokse', 'nishandhungana41', 'nishan', 'user');

select * from tbl_user_role;
DELETE FROM TBL_USER_ROLE;
select * from TBL_USER;
DELETE FROM TBL_USER;
SELECT USERNAME, PASSWORD, ENABLED FROM TBL_USER WHERE USERNAME='admin';
SELECT USERNAME, USER_ROLE FROM TBL_USER_ROLE WHERE USERNAME='admin';

























