insert into authors (firstname, lastname, birthday) values ('Author1', 'Author1', '31.07.1965');
insert into authors (firstname, lastname, birthday) values ('Author2', 'Author2', '05.01.1932');

insert into genres (codegenre, genre) values ('ХЛ', 'Детектив');
insert into genres (codegenre, genre) values ('БП', 'Роман');

insert into books (author_id, genre_id, bookname) values (1, 1, 'Book1');
insert into books (author_id, genre_id, bookname) values (2, 2, 'Book2');

insert into comments (message, book_id) values ('Comments1', 1);
insert into comments (message, book_id) values ('Comments2', 2);
