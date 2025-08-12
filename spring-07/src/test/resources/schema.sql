drop table if exists comments;
drop table if exists books;
drop table if exists authors;
drop table if exists genres;

create table authors
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(20) NOT NULL,
    lastname VARCHAR(20) NOT NULL,
    birthday VARCHAR(20) NOT NULL
);

create table genres
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    codegenre VARCHAR(2) NOT NULL,
    genre VARCHAR(200) NOT NULL
);

create table books
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    genre_id BIGINT,
    author_id BIGINT,
    bookname VARCHAR(200) NOT NULL,
    FOREIGN KEY (genre_id) REFERENCES genres(id) ON DELETE CASCADE,
    FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE
);

create table comments
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    message VARCHAR(255) NOT NULL,
    book_id BIGINT,
    FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE
);