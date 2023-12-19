CREATE DATABASE BANK;

USE BANK;

CREATE TABLE T_CLIENT (
    client_id INT AUTO_INCREMENT PRIMARY KEY,
    last_name VARCHAR(255),
    first_name VARCHAR(255),
    phone_number VARCHAR(20)
);

CREATE TABLE T_BANK_ACCOUNT (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    balance DECIMAL(10, 2) DEFAULT 0,
    client_id INT,
    FOREIGN KEY (client_id) REFERENCES T_CLIENT(client_id)
);

CREATE TABLE T_TRANSACTION (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    transaction_type VARCHAR(10), -- 'deposit' or 'withdrawal'
    amount DECIMAL(10, 2),
    account_id INT,
    FOREIGN KEY (account_id) REFERENCES T_BANK_ACCOUNT(account_id)
);
