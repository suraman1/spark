CREATE DATABASE spark;

USE spark;

CREATE TABLE users (
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
    password varchar(100) NOT NULL,
    created_at TIMESTAMP
);