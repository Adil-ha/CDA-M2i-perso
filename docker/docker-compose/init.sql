
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

INSERT INTO users (nom, prenom, email) VALUES
    ('Doe', 'John', 'john.doe@example.com'),
    ('Smith', 'Alice', 'alice.smith@example.com'),
    ('Johnson', 'Bob', 'bob.johnson@example.com');


SELECT * FROM users;
