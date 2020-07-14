package ru.otus.spring.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
@DisplayName("Класс GameControllerImp")
public class GameControllerImplTest {

    @Autowired
    private GameControllerImpl gameController;
    @MockBean
    private QuestionService questionService;
    @MockBean
    private MessageService messageService;

    @DisplayName("имитация теста выполнена корректно")
    @Test
    void startTest() {
        String firstName = "firstName";
        String lastName = "lastName";
        List<Question> questions = new ArrayList<>();
        String question = "Вопрос";
        String answer = "Ответ";

        questions.add(new Question(question, answer));

        when(messageService.userFirstName()).thenReturn(firstName);
        when(messageService.userLastName()).thenReturn(lastName);
        when(messageService.getQuestion(question)).thenReturn(answer);

        for (Map.Entry<String, ArrayList<String>> entry : questionService.getQuestions().entrySet()) {
            when(entry.getValue().get(0)).thenReturn(question);
            verify(messageService).getQuestion(question);
            verify(messageService).correctAnswer();
            verify(messageService).incorrectAnswer("неверный ответ");
        }

        gameController.startTest();

        verify(messageService).userFirstName();
        verify(messageService).userLastName();
        verify(messageService).testResult(any(User.class));
    }

}
