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
    libelle VARCHAR(100)
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
    id_utilisateur INT REFERENCES employer(id),
    id_voiture INT REFERENCES  voiture(id_voiture),
    prix DECIMAL(20,2),
    id_status INT REFERENCES status(id_status)
);

CREATE TABLE photos_annonce(
    id_photo_annonce SERIAL PRIMARY KEY ,
    id_annonce INT REFERENCES annonce(id_annonce),
    photo TEXT
);


-- 28-01-24
create table annonce_favoris (
    id_annonce_favoris serial primary key,
    id_employer int references employer(id),
    id_annonce int references annonce(id_annonce),
    date date default current_date
);

insert into boite_vitesse values (default,'a');

insert into energie values (default,'automatique');

insert into categorie values (default,'cat');

insert into voiture values (default,'unique',2,1,'moteur',1,1,200,3,'description','123434');

insert into status values (0,'attente');
insert into status values (5,'valider');
insert into status values (10,'vendu');

insert into annonce values (default,default,1,1,30000,0);


