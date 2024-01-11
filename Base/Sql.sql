CREATE DATABASE ventevoiture;
\c ventevoiture

CREATE TABLE admin(
    id_admin SERIAL PRIMARY KEY,
    nom VARCHAR(100),
    mots_de_passe VARCHAR(50)
);

CREATE TABLE utilisateur(
    id_utilisateur SERIAL PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    date_de_naissance DATE,
    email VARCHAR(100),
    numero VARCHAR(50),
    mots_de_passe VARCHAR(50)
);

CREATE TABLE marque(
    id_marque SERIAL PRIMARY KEY,
    libelle VARCHAR(100) 
);

CREATE TABLE categorie(
    id_categorie SERIAL PRIMARY KEY,
    libelle VARCHAR(100)
);

CREATE TABLE voiture(
    id_voiture SERIAL PRIMARY KEY,
    id_marque INT REFERENCES marque(id_marque),
    id_categorie INT REFERENCES categorie(id_categorie),
    nom VARCHAR(100),
    numero_matricule VARCHAR(50),
    prix DECIMAL 
);
