package ru.otus.spring.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Document(collection = "comments")
public class Comment {
    @Id
    private String id;
    private String message;
    private String bookId;
}
