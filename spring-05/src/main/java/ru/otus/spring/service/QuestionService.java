package ru.otus.spring.service;

import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public interface QuestionService {

    void init(Resource resource, Locale language);

    Map<String, ArrayList<String>> getQuestions();
}
