package ru.otus.spring.domain;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Setter
@Getter
@AllArgsConstructor
public class Book {

    private final long id;
    private final Author author;
    private final Genre genre;
    private final String bookName;

}
