insert into authors (id, firstName, lastName, birthday) values (1, 'Джоан', 'Роулинг', '31.07.1965');
insert into authors (id, firstName, lastName, birthday) values (2, 'Умберто', 'Эко', '05.01.1932');
insert into authors (id, firstName, lastName, birthday) values (3, 'Габриэль','Маркес', '06.03.1927');
insert into authors (id, firstName, lastName, birthday) values (4, 'Нассим','Талеб', '11.09.1960');
insert into authors (id, firstName, lastName, birthday) values (5, 'Анджей','Сапковский', '21.06.1948');
insert into authors (id, firstName, lastName, birthday) values (6, 'Косюн','Таками', '10.01.1969');
insert into authors (id, firstName, lastName, birthday) values (7, 'Оноре','Бальзак', '20.05.1799');
insert into authors (id, firstName, lastName, birthday) values (8, 'Бэнджамин','Грэм', '08.05.1894');
insert into authors (id, firstName, lastName, birthday) values (9, 'Курт','Ауст', '06.12.1955');

insert into genres (id, codeGenre, genre) values (1, 'ХЛ', 'Детектив');
insert into genres (id, codeGenre, genre) values (2, 'ХЛ', 'Роман');
insert into genres (id, codeGenre, genre) values (3, 'ХЛ', 'Фантастика');
insert into genres (id, codeGenre, genre) values (4, 'БП', 'Экономика');
insert into genres (id, codeGenre, genre) values (5, 'БП', 'Управление финансами');

insert into books (id, author_id, genre_id, bookName) values (1, 4, 4, 'Черный лебедь. Под знаком непредсказуемости');
insert into books (id, author_id, genre_id, bookName) values (2, 4, 4, 'Рискуя собственной шкурой. Скрытая асимметрия повседневной жизни');
insert into books (id, author_id, genre_id, bookName) values (3, 8, 5, 'Разумный инвестор. Полное руководство по стоимостному инвестированию');
insert into books (id, author_id, genre_id, bookName) values (4, 3, 2, 'Любовь во время чумы');
insert into books (id, author_id, genre_id, bookName) values (5, 5, 3, 'Ведьмак');
insert into books (id, author_id, genre_id, bookName) values (6, 6, 3, 'Королевская битва');
insert into books (id, author_id, genre_id, bookName) values (7, 7, 2, 'Шагреневая кожа');
insert into books (id, author_id, genre_id, bookName) values (8, 9, 1, 'Судный день');
insert into books (id, author_id, genre_id, bookName) values (9, 1, 3, 'Гарри Поттер');
