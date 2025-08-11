package ru.otus.spring.entity;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class Book {

    private final long id;
    private final Author author;
    private final Genre genre;
    private final String bookName;

}
