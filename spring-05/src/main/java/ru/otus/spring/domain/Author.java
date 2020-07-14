package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Author {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final String birthday;
}
