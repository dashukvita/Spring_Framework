package ru.otus.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class Genre {

    private final long id;
    private final String codeGenre;
    private final String genre;
}
