insert into authors (id, firstName, lastName, birthday) values (1, 'Author1', 'Author1', '31.07.1965');
insert into authors (id, firstName, lastName, birthday) values (2, 'Author2', 'Author2', '05.01.1932');

insert into genres (id, codeGenre, genre) values (1, 'ХЛ', 'Детектив');
insert into genres (id, codeGenre, genre) values (2, 'БП', 'Роман');

insert into books (id, author_id, genre_id, bookName) values (1, 1, 1, 'Book1');
insert into books (id, author_id, genre_id, bookName) values (2, 2, 2, 'Book2');