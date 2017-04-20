-- This script rollouts a new database and user for the app

CREATE DATABASE spring;

USE spring;

CREATE TABLE persons (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(32),
    firstname VARCHAR(32)
);

CREATE USER 'app'@'localhost' IDENTIFIED BY 'app';

GRANT ALL PRIVILEGES ON spring.* TO 'app'@'localhost';
