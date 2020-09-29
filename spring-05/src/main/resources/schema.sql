drop table if exists books;
drop table if exists authors;
drop table if exists genres;

create table authors
 (
     id serial not null,
     firstName character varying(20) not null,
     lastName character varying(20) not null,
     birthday character varying(20) not null,
     primary key (id)
 );

create table genres
 (
     id serial not null,
     codeGenre character varying(2) not null,
     genre character varying(200) not null,
     primary key (id)
 );

create table books
 (
     id serial not null,
     genre_id bigint references genres(id) on delete cascade,
     author_id bigint references authors(id) on delete cascade,
     bookName character varying(200) not null,
     primary key (id)
 );