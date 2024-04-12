CREATE DATABASE IF NOT EXISTS tp_vendredi_swing;
USE tp_vendredi_swing;
CREATE TABLE employee (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(100) NOT NULL,
                          gender ENUM('MALE', 'FEMALE') NOT NULL,
                          age INT NOT NULL,
                          bloodGroup ENUM('A','B','AB','O') NOT NULL,
                          phoneNumber VARCHAR(20) NOT NULL,
                          qualification ENUM('DOCT', 'DESS', 'MAST', 'LICE', 'BTS', 'DEUG', 'DUT', 'BAC') NOT NULL,
                          startDate DATE NOT NULL,
                          address VARCHAR(255),
                          photoUrl VARCHAR(255)
);


