CREATE DATABASE bookstore;

USE bookstore;

CREATE TABLE users(
                    user_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                    user_name VARCHAR(255) NOT NULL UNIQUE,
                    user_email VARCHAR(255) NOT NULL UNIQUE,
                    user_password VARCHAR(255),
);

CREATE TABLE authors(
                    author_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                    author_name VARCHAR(255) NOT NULL UNIQUE,
                    author_email VARCHAR(255) NOT NULL UNIQUE,
);

CREATE TABLE books(
                    book_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                    book_name VARCHAR(255) NOT NULL UNIQUE,
                    book_author VARCHAR(255) NOT NULL UNIQUE,
                    ADD FOREIGN KEY (book_author) REFERENCES authors(author_id)
);