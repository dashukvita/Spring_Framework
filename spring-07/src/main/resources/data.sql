insert into AUTHORS ( FIRSTNAME, LASTNAME, BIRTHDAY) values ('Джоан', 'Роулинг', '31.07.1965');
insert into AUTHORS ( FIRSTNAME, LASTNAME, BIRTHDAY) values ('Умберто', 'Эко', '05.01.1932');
insert into AUTHORS ( FIRSTNAME, LASTNAME, BIRTHDAY) values ('Габриэль','Маркес', '06.03.1927');
insert into AUTHORS ( FIRSTNAME, LASTNAME, BIRTHDAY) values ('Нассим','Талеб', '11.09.1960');
insert into AUTHORS ( FIRSTNAME, LASTNAME, BIRTHDAY) values ('Анджей','Сапковский', '21.06.1948');
insert into AUTHORS ( FIRSTNAME, LASTNAME, BIRTHDAY) values ('Косюн','Таками', '10.01.1969');
insert into AUTHORS ( FIRSTNAME, LASTNAME, BIRTHDAY) values ('Оноре','Бальзак', '20.05.1799');
insert into AUTHORS ( FIRSTNAME, LASTNAME, BIRTHDAY) values ('Бэнджамин','Грэм', '08.05.1894');
insert into AUTHORS ( FIRSTNAME, LASTNAME, BIRTHDAY) values ('Курт','Ауст', '06.12.1955');

insert into GENRES ( CODE, TITLE) values ('ХЛ', 'Детектив');
insert into GENRES ( CODE, TITLE) values ('ХЛ', 'Роман');
insert into GENRES ( CODE, TITLE) values ('ХЛ', 'Фантастика');
insert into GENRES ( CODE, TITLE) values ('БП', 'Экономика');
insert into GENRES ( CODE, TITLE) values ('БП', 'Управление финансами');

insert into BOOKS ( AUTHOR_ID, GENRE_ID, TITLE) values (4, 4, 'Черный лебедь. Под знаком непредсказуемости');
insert into BOOKS ( AUTHOR_ID, GENRE_ID, TITLE) values (4, 4, 'Рискуя собственной шкурой. Скрытая асимметрия повседневной жизни');
insert into BOOKS ( AUTHOR_ID, GENRE_ID, TITLE) values (8, 5, 'Разумный инвестор. Полное руководство по стоимостному инвестированию');
insert into BOOKS ( AUTHOR_ID, GENRE_ID, TITLE) values (3, 2, 'Любовь во время чумы');
insert into BOOKS ( AUTHOR_ID, GENRE_ID, TITLE) values (5, 3, 'Ведьмак');
insert into BOOKS ( AUTHOR_ID, GENRE_ID, TITLE) values (6, 3, 'Королевская битва');
insert into BOOKS ( AUTHOR_ID, GENRE_ID, TITLE) values (7, 2, 'Шагреневая кожа');
insert into BOOKS ( AUTHOR_ID, GENRE_ID, TITLE) values (9, 1, 'Судный день');
insert into BOOKS ( AUTHOR_ID, GENRE_ID, TITLE) values (1, 3, 'Гарри Поттер');

insert into COMMENTS ( MESSAGE, BOOK_ID) values ('Хорошая книга', 6);
insert into COMMENTS ( MESSAGE, BOOK_ID) values ('Книга в целом понравилась', 6);
insert into COMMENTS ( MESSAGE, BOOK_ID) values ('Книга не понравилась', 8);
