package ru.otus.spring.domain;

import lombok.*;

@Getter
@RequiredArgsConstructor
public class Question {

    private final String question;
    private final String answer;
}
