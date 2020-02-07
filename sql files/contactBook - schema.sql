CREATE DATABASE application;

use application
GO

CREATE TABLE credentials (
    id bigint NOT NULL IDENTITY(1,1) PRIMARY KEY,
    email varchar(255),
    username varchar(255),
    password varchar(255)
);
GO 

CREATE TABLE person (
    id bigint NOT NULL IDENTITY(1,1) PRIMARY KEY,
    email varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    category varchar(255),
    phone_number varchar(255),
    birth_dat varchar(255)
);
GO