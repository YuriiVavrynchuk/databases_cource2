DROP DATABASE IF EXISTS books_db;
CREATE DATABASE IF NOT EXISTS books_db;
USE books_db;

DROP TABLE IF EXISTS book_table;
CREATE TABLE book_table (
	id INT AUTO_INCREMENT PRIMARY KEY,
    book_email VARCHAR(20) NOT NULL,
    topic VARCHAR(20) NOT NULL,
    title VARCHAR(45) NOT NULL,
    author VARCHAR(45) NOT NULL,
    UDK VARCHAR(45) NOT NULL,
    rate INT NOT NULL
);

DROP TABLE IF EXISTS user_table;
CREATE TABLE user_table (
	id INT AUTO_INCREMENT PRIMARY KEY,
	login VARCHAR(20),
    password_id INT,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(45) NOT NULL,
    middle_name VARCHAR(45) NOT NULL,
    birthday VARCHAR(45) NOT NULL,
    birth_place VARCHAR(45) NOT NULL,
    living_place VARCHAR(45) NOT NULL,
    notes VARCHAR(45) NOT NULL,
    rate int NOT NULL
);

DROP TABLE IF EXISTS password_table;
CREATE TABLE password_table (
	id INT AUTO_INCREMENT PRIMARY KEY,
	user_password VARCHAR(20)
);

DROP TABLE IF EXISTS catalog_table;
CREATE TABLE catalog_table (
	topic VARCHAR(20) PRIMARY KEY
);

DROP TABLE IF EXISTS reference_table;
CREATE TABLE reference_table (
	book_email VARCHAR(20) PRIMARY KEY
);

DROP TABLE IF EXISTS book_user_table;
CREATE TABLE book_user_table (
	id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    user_id INT NOT NULL
);