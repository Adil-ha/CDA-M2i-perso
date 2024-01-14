CREATE DATABASE EXAMEN;
USE EXAMEN;

CREATE TABLE examen (
   idExamen INT,
   nom VARCHAR(50),
   dateExamen DATE,
   PRIMARY KEY(idExamen)
);

CREATE TABLE etablissement (
   code INT,
   nom VARCHAR(50),
   adresse VARCHAR(50),
   ville VARCHAR(50),
   PRIMARY KEY(code)
);

CREATE TABLE eleve (
   idEleve INT,
   nom VARCHAR(50),
   code INT NOT NULL,
   PRIMARY KEY(idEleve),
   FOREIGN KEY(code) REFERENCES etablissement(code)
);

CREATE TABLE epreuve (
   idepreuve INT,
   coefficient DECIMAL(15,2),
   PRIMARY KEY(idepreuve)
);

CREATE TABLE enseignant (
   matricule INT,
   nom VARCHAR(50),
   telephone VARCHAR(50),
   adresse VARCHAR(50),
   ville VARCHAR(50),
   code INT NOT NULL,
   PRIMARY KEY(matricule),
   FOREIGN KEY(code) REFERENCES etablissement(code)
);

CREATE TABLE passer (
   idExamen INT,
   idEleve INT,
   PRIMARY KEY(idExamen, idEleve),
   FOREIGN KEY(idExamen) REFERENCES examen(idExamen),
   FOREIGN KEY(idEleve) REFERENCES eleve(idEleve)
);

CREATE TABLE comprend (
   idExamen INT,
   idepreuve INT,
   PRIMARY KEY(idExamen, idepreuve),
   FOREIGN KEY(idExamen) REFERENCES examen(idExamen),
   FOREIGN KEY(idepreuve) REFERENCES epreuve(idepreuve)
);

CREATE TABLE redige (
   idepreuve INT,
   matricule INT,
   PRIMARY KEY(idepreuve, matricule),
   FOREIGN KEY(idepreuve) REFERENCES epreuve(idepreuve),
   FOREIGN KEY(matricule) REFERENCES enseignant(matricule)
);

-- Insérer des données dans la table examen
INSERT INTO examen (idExamen, nom, dateExamen) VALUES
(1, 'Baccalauréat', '2023-06-15'),
(2, 'Diplôme National', '2023-07-20');

-- Insérer des données dans la table etablissement
INSERT INTO etablissement (code, nom, adresse, ville) VALUES
(1, 'Lycée A', '123 Rue de l\'Ecole', 'Paris'),
(2, 'Lycée B', '456 Avenue du Savoir', 'Lyon');

-- Insérer des données dans la table eleve
INSERT INTO eleve (idEleve, nom, code) VALUES
(1, 'Jean Dupont', 1),
(2, 'Marie Martin', 2);

-- Insérer des données dans la table epreuve
INSERT INTO epreuve (idepreuve, coefficient) VALUES
(1, 2.5),
(2, 3.0);

-- Insérer des données dans la table enseignant
INSERT INTO enseignant (matricule, nom, telephone, adresse, ville, code) VALUES
(101, 'Professeur Smith', '123-456-7890', '789 Rue des Profs', 'Paris', 1),
(102, 'Professeur Johnson', '987-654-3210', '654 Avenue du Savoir', 'Lyon', 2);

-- Insérer des données dans la table passer
INSERT INTO passer (idExamen, idEleve) VALUES
(1, 1),
(2, 2);

-- Insérer des données dans la table comprend
INSERT INTO comprend (idExamen, idepreuve, note) VALUES
(1, 1, 18),
(2, 2, 16);

-- Insérer des données dans la table redige
INSERT INTO redige (idepreuve, matricule) VALUES
(1, 101),
(2, 102);
