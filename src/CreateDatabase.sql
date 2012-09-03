CREATE DATABASE IF NOT EXISTS DUTY_ROSTER;
USE DUTY_ROSTER;

CREATE TABLE IF NOT EXISTS MEMBER (
	ID INT,
	NAME VARCHAR(255),
	ADDRESS VARCHAR(255),
	PHONE_NUMBER VARCHAR(20),
	PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS DUTY (
	ID INT,
	NAME VARCHAR(255),
	DESCRIPTION VARCHAR(1024),
	PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS ALLOCATION (
	MEMBER_ID INT,
	DUTY_ID INT,
	ALLOCATION_START_DATETIME DATETIME,
	ALLOCATION_END_DATETIME DATETIME,
	FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER (ID),
	FOREIGN KEY (DUTY_ID) REFERENCES DUTY (ID)
);
INSERT INTO member (id,name,address,phone_number) values (1,'derp','123 privett drive', '0412345678');
INSERT INTO member (id,name,address,phone_number) values (2,'derpette','125 privett drive', '0412345679');
INSERT INTO member (id,name,address,phone_number) values (3,'derpington','127 privett drive', '0412345677');
INSERT INTO member (id,name,address,phone_number) values (4,'derpthemost','129 privett drive', '0412345676');
