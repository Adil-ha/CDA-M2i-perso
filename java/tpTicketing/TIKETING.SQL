CREATE DATABASE TIKETING;

USE TIKETING;

CREATE TABLE T_PLACE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    capacity INT
);

CREATE TABLE T_EVENT (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    date DATE,
    time TIME,
    place_id INT,
    price DECIMAL(10, 2),
    tickets_sold INT,
    FOREIGN KEY (place_id) REFERENCES T_PLACE(id)
);

CREATE TABLE T_CLIENT (
    id INT AUTO_INCREMENT PRIMARY KEY,
    last_name VARCHAR(255),
    first_name VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE T_TICKET (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    event_id INT,
    FOREIGN KEY (client_id) REFERENCES T_CLIENT(id),
    FOREIGN KEY (event_id) REFERENCES T_EVENT(id)
);
