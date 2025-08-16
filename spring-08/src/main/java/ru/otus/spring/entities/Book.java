package ru.otus.spring.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String bookName;

    private String genreId;

    private String authorId;
}
