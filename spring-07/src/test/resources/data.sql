insert into AUTHORS ( FIRSTNAME, LASTNAME, BIRTHDAY) values ('Author1', 'Author1', '31.07.1965');
insert into AUTHORS ( FIRSTNAME, LASTNAME, BIRTHDAY) values ('Author2', 'Author2', '05.01.1932');

insert into GENRES ( CODE, TITLE) values ('ХЛ', 'Детектив');
insert into GENRES ( CODE, TITLE) values ('ХЛ', 'Роман');

insert into BOOKS ( AUTHOR_ID, GENRE_ID, TITLE) values (1, 1, 'Book1');
insert into BOOKS ( AUTHOR_ID, GENRE_ID, TITLE) values (2, 2, 'Book2');

insert into COMMENTS ( MESSAGE, BOOK_ID) values ('Comments1', 1);
insert into COMMENTS ( MESSAGE, BOOK_ID) values ('Comments2', 2);
