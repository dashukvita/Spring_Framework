insert into authors ( firstName, lastName, birthday) values ('Author1', 'Author1', '31.07.1965');
insert into authors ( firstName, lastName, birthday) values ('Author2', 'Author2', '05.01.1932');

insert into genres ( codeGenre, genre) values ('ХЛ', 'Детектив');
insert into genres ( codeGenre, genre) values ('БП', 'Роман');

insert into books ( author_id, genre_id, bookName) values (1, 1, 'Book1');
insert into books ( author_id, genre_id, bookName) values (2, 2, 'Book2');