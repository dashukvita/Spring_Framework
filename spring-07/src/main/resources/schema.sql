drop table if exists COMMENTS;
drop table if exists BOOKS;
drop table if exists AUTHORS;
drop table if exists GENRES;

create table AUTHORS
(
    ID          bigserial  not null,
    FIRSTNAME   character varying(20) not null,
    LASTNAME    character varying(20) not null,
    BIRTHDAY    character varying(20) not null,
    primary key (ID)
);

create table GENRES
(
    ID          bigserial not null,
    CODE        character varying(2) not null,
    TITLE       character varying(200) not null,
    primary key (ID)
);


create table BOOKS
(
    ID          bigserial not null,
    TITLE       character varying(200) not null,
    GENRE_ID    bigint references GENRES(ID) on delete cascade,
    AUTHOR_ID   bigint references AUTHORS(ID) on delete cascade,
    primary key (ID)
);

create table COMMENTS
(
    ID          bigserial not null,
    MESSAGE     character varying(255) not null,
    BOOK_ID     bigint references BOOKS(ID) on delete cascade,
    primary key (ID)
);


