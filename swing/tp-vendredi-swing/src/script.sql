CREATE DATABASE IF NOT EXISTS tp_vendredi_swing;
USE tp_vendredi_swing;
CREATE TABLE employee (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(100) NOT NULL,
                          gender ENUM('MALE', 'FEMALE', 'OTHER') NOT NULL,
                          age INT NOT NULL,
                          bloodGroup VARCHAR(10) NOT NULL,
                          phoneNumber VARCHAR(20) NOT NULL,
                          qualification VARCHAR(100),
                          startDate DATE NOT NULL,
                          address VARCHAR(255),
                          photoUrl VARCHAR(255)
);


