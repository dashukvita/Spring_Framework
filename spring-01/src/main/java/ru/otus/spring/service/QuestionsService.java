package ru.otus.spring.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public interface QuestionsService {
    Map<String, ArrayList<String>> getQuestions() throws IOException;
}
