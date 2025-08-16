package ru.otus.spring.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Document(collection = "genres")
public class Genre {

    @Id
    private String id;
    private String codeGenre;
    private String genreName;
}
