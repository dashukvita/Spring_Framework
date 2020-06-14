package ru.otus.spring.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс QuestionServiceImpl")
public class QuestionServiceImplTest {
    ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("/spring-context.xml");
    QuestionsServiceImpl questionsService = context.getBean(QuestionsServiceImpl.class);

    @DisplayName("содержит пять вопросов")
    @Test
    void hasFiveQuestions() {
        Map<String, ArrayList<String>> questions = questionsService.getQuestions();
        assertThat(questions).hasSize(5);
    }

    @DisplayName("все ответы корректные")
    @Test
    void hasRightQuestions() {
        ArrayList<String> answers = new ArrayList<>();
        List<String> rightAnswer = Arrays.asList("3","3","2","1");

        for (Map.Entry<String, ArrayList<String>> entry : questionsService.getQuestions().entrySet()) {
            answers.add(entry.getValue().get(4));
        }

        for (int i = 0; i < rightAnswer.size(); i++) {
            assertTrue(rightAnswer.get(i).equals(answers.get(i)));
        }
    }

    @DisplayName("все ответы ошибочные")
    @Test
    void hasWrongQuestions() {
        ArrayList<String> answers = new ArrayList<>();
        List<String> rightAnswer = Arrays.asList("1","2","3","3");

        for (Map.Entry<String, ArrayList<String>> entry : questionsService.getQuestions().entrySet()) {
            answers.add(entry.getValue().get(4));
        }

        for (int i = 0; i < rightAnswer.size(); i++) {
            assertFalse(rightAnswer.get(i).equals(answers.get(i)));
        }
    }
}
