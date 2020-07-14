drop table if exists book;
drop table if exists author;
drop table if exists genre;

create table author
(
    author_id BIGINT PRIMARY KEY NOT NULL,
    firstName CHARACTER VARYING(20) NOT NULL,
    lastName CHARACTER VARYING(20) NOT NULL,
    birthday CHARACTER VARYING(20) NOT NULL
);


create table genre
(
    genre_id BIGINT PRIMARY KEY NOT NULL,
    codeGenre CHARACTER VARYING(2) NOT NULL,
    genre CHARACTER VARYING(200) NOT NULL
);

create table book
(
    id BIGINT PRIMARY KEY NOT NULL,
    author_id BIGINT,
    genre_id BIGINT,
    bookName CHARACTER VARYING(200) NOT NULL,
    CONSTRAINT genre_id_fk
        FOREIGN KEY (genre_id)
            REFERENCES genre (genre_id),
    CONSTRAINT author_id_fk
        FOREIGN KEY (author_id)
            REFERENCES author (author_id)
);
