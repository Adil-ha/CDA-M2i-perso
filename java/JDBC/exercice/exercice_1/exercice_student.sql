CREATE DATABASE college;

USE college;

CREATE TABLE T_student (
 id INT AUTO_INCREMENT PRIMARY KEY,
 last_name VARCHAR(200),
 first_name VARCHAR(200),
 number_class INT,
 date_diplome DATE
);

DROP TABLE student;