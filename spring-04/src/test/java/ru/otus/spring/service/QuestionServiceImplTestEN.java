package ru.otus.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DisplayName("Класс QuestionServiceImpl вопросы на английском")
public class QuestionServiceImplTestEN {

    private QuestionService questionService;

    @BeforeEach
    void setup(){
        questionService = new QuestionServiceImpl();
        Resource resource = new ClassPathResource("questions_en.CSV");
        questionService.init(resource);
    }

    @DisplayName("содержит пять вопросов")
    @Test
    void hasFiveQuestions() {
        Map<String, ArrayList<String>> questions = questionService.getQuestions();
        assertThat(questions).hasSize(5);
    }

    @DisplayName("все ответы корректные")
    @Test
    void hasRightQuestions() {
        ArrayList<String> answers = new ArrayList<>();
        List<String> rightAnswer = Arrays.asList("1","3","2","3","1");

        for (Map.Entry<String, ArrayList<String>> entry : questionService.getQuestions().entrySet()) {
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
        List<String> rightAnswer = Arrays.asList("3","2","3","1","3");

        for (Map.Entry<String, ArrayList<String>> entry : questionService.getQuestions().entrySet()) {
            answers.add(entry.getValue().get(4));
        }

        for (int i = 0; i < rightAnswer.size(); i++) {
            assertFalse(rightAnswer.get(i).equals(answers.get(i)));
        }
    }
}
