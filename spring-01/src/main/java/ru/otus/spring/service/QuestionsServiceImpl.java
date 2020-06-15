package ru.otus.spring.service;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QuestionsServiceImpl implements QuestionsService{

    private final Map<String, ArrayList<String>> questions;

    public QuestionsServiceImpl(Resource resource) throws IOException {
        questions = putQuestions(resource);
    }

    private Map<String, ArrayList<String>> putQuestions(Resource resource) throws IOException{
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

    @Override
    public Map<String, ArrayList<String>> getQuestions() {
        return questions;
    }
}
