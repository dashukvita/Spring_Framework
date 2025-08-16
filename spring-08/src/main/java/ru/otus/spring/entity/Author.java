package ru.otus.spring.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Document(collection = "authors")
public class Author {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String birthday;
}
