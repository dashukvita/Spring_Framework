package ru.otus.spring.entity;

import lombok.*;

@Getter
@RequiredArgsConstructor
public class Question {

    private final String question;
    private final String answer;
}
