insert into authors ( firstname, lastname, birthday) values ('Джоан', 'Роулинг', '31.07.1965');
insert into authors ( firstname, lastname, birthday) values ('Умберто', 'Эко', '05.01.1932');
insert into authors ( firstname, lastname, birthday) values ('Габриэль','Маркес', '06.03.1927');
insert into authors ( firstname, lastname, birthday) values ('Нассим','Талеб', '11.09.1960');
insert into authors ( firstname, lastname, birthday) values ('Анджей','Сапковский', '21.06.1948');
insert into authors ( firstname, lastname, birthday) values ('Косюн','Таками', '10.01.1969');
insert into authors ( firstname, lastname, birthday) values ('Оноре','Бальзак', '20.05.1799');
insert into authors ( firstname, lastname, birthday) values ('Бэнджамин','Грэм', '08.05.1894');
insert into authors ( firstname, lastname, birthday) values ('Курт','Ауст', '06.12.1955');

insert into genres ( codegenre, genre) values ('ХЛ', 'Детектив');
insert into genres ( codegenre, genre) values ('ХЛ', 'Роман');
insert into genres ( codegenre, genre) values ('ХЛ', 'Фантастика');
insert into genres ( codegenre, genre) values ('БП', 'Экономика');
insert into genres ( codegenre, genre) values ('БП', 'Управление финансами');

insert into books ( author_id, genre_id, bookname) values (4, 4, 'Черный лебедь. Под знаком непредсказуемости');
insert into books ( author_id, genre_id, bookname) values (4, 4, 'Рискуя собственной шкурой. Скрытая асимметрия повседневной жизни');
insert into books ( author_id, genre_id, bookname) values (8, 5, 'Разумный инвестор. Полное руководство по стоимостному инвестированию');
insert into books ( author_id, genre_id, bookname) values (3, 2, 'Любовь во время чумы');
insert into books ( author_id, genre_id, bookname) values (5, 3, 'Ведьмак');
insert into books ( author_id, genre_id, bookname) values (6, 3, 'Королевская битва');
insert into books ( author_id, genre_id, bookname) values (7, 2, 'Шагреневая кожа');
insert into books ( author_id, genre_id, bookname) values (9, 1, 'Судный день');
insert into books ( author_id, genre_id, bookname) values (1, 3, 'Гарри Поттер');

insert into comments ( message, book_id) values ('Хорошая книга', 6);
insert into comments ( message, book_id) values ('Книга в целом понравилась', 6);
insert into comments ( message, book_id) values ('Книга не понравилась', 8);
