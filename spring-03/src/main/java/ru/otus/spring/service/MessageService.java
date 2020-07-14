package ru.otus.spring.service;

import ru.otus.spring.domain.User;

public interface MessageService {

    String userFirstName();

    String userLastName();

    String getQuestion(String question);

    String getAnswer();

    void correctAnswer();

    void incorrectAnswer(String correctAnswer);

    void testResult(User user);

}
