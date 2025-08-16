INSERT INTO authors (firstname, lastname, birthday) VALUES ('Joanne', 'Rowling', '1965-07-31');
INSERT INTO authors (firstname, lastname, birthday) VALUES ('Umberto', 'Eco', '1932-01-05');
INSERT INTO authors (firstname, lastname, birthday) VALUES ('Gabriel', 'Marquez', '1927-03-06');
INSERT INTO authors (firstname, lastname, birthday) VALUES ('Nassim', 'Taleb', '1960-09-11');
INSERT INTO authors (firstname, lastname, birthday) VALUES ('Andrzej', 'Sapkowski', '1948-06-21');
INSERT INTO authors (firstname, lastname, birthday) VALUES ('Koushun', 'Takami', '1969-01-10');
INSERT INTO authors (firstname, lastname, birthday) VALUES ('Honoré', 'Balzac', '1799-05-20');
INSERT INTO authors (firstname, lastname, birthday) VALUES ('Benjamin', 'Graham', '1894-05-08');
INSERT INTO authors (firstname, lastname, birthday) VALUES ('Kurt', 'Aust', '1955-12-06');

INSERT INTO genres (codegenre, genre) VALUES ('CL', 'Detective');
INSERT INTO genres (codegenre, genre) VALUES ('CL', 'Novel');
INSERT INTO genres (codegenre, genre) VALUES ('CL', 'Science Fiction');
INSERT INTO genres (codegenre, genre) VALUES ('BP', 'Economics');
INSERT INTO genres (codegenre, genre) VALUES ('BP', 'Financial Management');

INSERT INTO books (author_id, genre_id, bookname) VALUES (4, 4, 'The Black Swan: The Impact of the Highly Improbable');
INSERT INTO books (author_id, genre_id, bookname) VALUES (4, 4, 'Skin in the Game: Hidden Asymmetries in Daily Life');
INSERT INTO books (author_id, genre_id, bookname) VALUES (8, 5, 'The Intelligent Investor: The Definitive Book on Value Investing');
INSERT INTO books (author_id, genre_id, bookname) VALUES (3, 2, 'Love in the Time of Cholera');
INSERT INTO books (author_id, genre_id, bookname) VALUES (5, 3, 'The Witcher');
INSERT INTO books (author_id, genre_id, bookname) VALUES (6, 3, 'Battle Royale');
INSERT INTO books (author_id, genre_id, bookname) VALUES (7, 2, 'The Wild Skin');
INSERT INTO books (author_id, genre_id, bookname) VALUES (9, 1, 'Judgment Day');
INSERT INTO books (author_id, genre_id, bookname) VALUES (1, 3, 'Harry Potter');

INSERT INTO comments (message, book_id) VALUES ('Good book', 6);
INSERT INTO comments (message, book_id) VALUES ('Overall, I liked the book', 6);
INSERT INTO comments (message, book_id) VALUES ('I did not like the book', 8);