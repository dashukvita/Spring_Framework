package ru.otus.spring.entity;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class Author {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final String birthday;

}
