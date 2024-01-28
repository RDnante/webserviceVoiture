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
    mots_de_passe VARCHAR(50),
    role varchar(50) not null
);

create table employer (
    id serial primary key,
    firstname varchar(100),
    lastname varchar(100),
    email varchar(150),
    password varchar,
    role varchar
);

CREATE TABLE marque(
    id_marque SERIAL PRIMARY KEY,
    libelle VARCHAR(100) 
);

CREATE TABLE categorie(
    id_categorie SERIAL PRIMARY KEY,
    libelle VARCHAR(100)
);

CREATE TABLE energie(
    id_energie SERIAL PRIMARY KEY,
    libelle VARCHAR(20)
);

CREATE TABLE boite_vitesse(
    id_boite_vitesse SERIAL PRIMARY KEY,
    libelle VARCHAR(3)
);


CREATE TABLE voiture(
    id_voiture SERIAL PRIMARY KEY,
    modele VARCHAR(100),
    id_marque INT REFERENCES marque(id_marque),
    id_categorie INT REFERENCES categorie(id_categorie),
    moteur VARCHAR(200),
    id_energie INT REFERENCES energie(id_energie),
    id_boite_vitesse INT REFERENCES boite_vitesse(id_boite_vitesse),
    puissance INT,
    consommation DECIMAL(3,1),
    description TEXT,
    numero_matricule VARCHAR(50)
);

CREATE TABLE status(
    id_status SERIAL PRIMARY KEY,
    libelle VARCHAR(30)
);

CREATE TABLE annonce(
    id_annonce SERIAL PRIMARY KEY,
    date_annonce DATE,
    id_utilisateur INT REFERENCES utilisateur(id_utilisateur),
    id_voiture INT REFERENCES  voiture(id_voiture),
    prix DECIMAL(20,2),
    id_status INT REFERENCES status(id_status)
);

CREATE TABLE photos_annonce(
    id_photo_annonce,
    id_annonce INT REFERENCES annonce(id_annonce),
    photo TEXT
);
