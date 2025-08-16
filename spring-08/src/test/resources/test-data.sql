INSERT INTO authors (firstname, lastname, birthday) VALUES ('Author1', 'Author1', '1965-07-31');
INSERT INTO authors (firstname, lastname, birthday) VALUES ('Author2', 'Author2', '1932-01-05');

INSERT INTO genres (codegenre, genre) VALUES ('CL', 'Detective');
INSERT INTO genres (codegenre, genre) VALUES ('BP', 'Novel');

INSERT INTO books (author_id, genre_id, bookname) VALUES (1, 1, 'Book1');
INSERT INTO books (author_id, genre_id, bookname) VALUES (2, 2, 'Book2');

INSERT INTO comments (message, book_id) VALUES ('Comment1', 1);
INSERT INTO comments (message, book_id) VALUES ('Comment2', 2);
