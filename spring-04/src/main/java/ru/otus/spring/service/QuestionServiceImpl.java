package ru.otus.spring.service;

import lombok.Getter;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class QuestionServiceImpl implements QuestionService {

    @Getter
    private Map<String, ArrayList<String>> questions;

    public void init(Resource resource) {
        try {
            questions = getQuestions(resource);
        } catch (IOException e) {
            String error = "Произошла ошибка чтения ресурса с вопросами, -> " + e.getMessage();
            throw new IllegalArgumentException(error);
        }
    }

    private Map<String, ArrayList<String>> getQuestions(Resource resource) throws IOException {
        Map<String, ArrayList<String>> questions = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));) {
            while (reader.ready()) {
                String[] line = reader.readLine().split(";");
                ArrayList<String> answerOptions = new ArrayList<>();
                answerOptions.add(line[1]);
                answerOptions.add(line[2]);
                answerOptions.add(line[3]);
                answerOptions.add(line[4]);
                answerOptions.add(line[5]);
                questions.put(line[0], answerOptions);
            }
        }

        return questions;
    }
}
