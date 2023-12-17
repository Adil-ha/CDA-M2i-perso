-- Création de la base de données si elle n'existe pas
CREATE DATABASE IF NOT EXISTS webstore;

-- Utilisation de la base de données webstore
USE webstore;

-- Création de la table "user"
CREATE TABLE IF NOT EXISTS user (
                                    user_id INT AUTO_INCREMENT PRIMARY KEY,
                                    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(50) NOT NULL,
    connectionNumber INT(4) NOT NULL DEFAULT 0
    );

-- Insertion de cinq utilisateurs fictifs
INSERT INTO user (username, email, password) VALUES
                                                 ('NeoMatrix', 'neo@email.com', 'motdepasse1'),
                                                 ('StarshipPilot', 'pilot@email.com', 'motdepasse2'),
                                                 ('BladeRunner2049', 'blade_runner@email.com', 'motdepasse3'),
                                                 ('XenoExplorer', 'xeno@email.com', 'motdepasse4'),
                                                 ('TimeTraveler42', 'time_traveler@email.com', 'motdepasse5');