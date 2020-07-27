drop table if exists book;
drop table if exists author;
drop table if exists genre;

create table author
(
    id bigserial not null,
    firstName character varying(20) not null,
    lastName character varying(20) not null,
    birthday character varying(20) not null,
    primary key (id)
);

create table genre
(
    id bigserial not null,
    codeGenre character varying(2) not null,
    genre character varying(200) not null,
    primary key (id)
);

create table book
(
    id bigserial not null,
    genre_id bigint references genre(id) on delete cascade,
    author_id bigint references author(id) on delete cascade,
    bookName character varying(200) not null,
    primary key (id)
);
