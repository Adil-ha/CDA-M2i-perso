CREATE DATABASE college;

USE college;

CREATE TABLE T_student (
 id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
 last_name VARCHAR(200) NOT NULL,
 first_name VARCHAR(200) NOT NULL,
 number_class INT NOT NULL,
 date_diplome DATE NOT NULL
);

DROP TABLE student;