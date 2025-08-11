package ru.otus.spring.service;
import ru.otus.spring.entity.Student;

import java.util.ArrayList;
import java.util.Map;

public class GameServiceImpl implements GameService {

    private final QuestionsServiceImpl questionsService;
    private final ReadWriteServiceImpl readWriteService;

    static final String WELCOME_MESSAGE = "Тест на знание Java.";
    static final String INPUT_NAME = "Введите ваше имя:";
    static final String INPUT_SURNAME = "Введите вашу фамилию:";
    static final String RESULT_MESSAGE = "%s %s, ваш результат: %d из 5.";

    public GameServiceImpl(QuestionsServiceImpl questionsService, ReadWriteServiceImpl readWriteService) {
        this.questionsService = questionsService;
        this.readWriteService = readWriteService;
    }

    @Override
    public void startGame(){
        Student student = new Student();
        readWriteService.write(WELCOME_MESSAGE);

        readWriteService.write(INPUT_NAME);
        student.setFirstName(readWriteService.read());

        readWriteService.write(INPUT_SURNAME);
        student.setLastName(readWriteService.read());

        beginGame(student);
        readWriteService.writeResult(RESULT_MESSAGE, student.getFirstName(), student.getLastName(), student.getTestResult());
    }

    private void beginGame(Student student){
        for (Map.Entry<String, ArrayList<String>> entry : questionsService.getQuestions().entrySet()) {
            readWriteService.write(entry.getKey());
            ArrayList<String> answers = entry.getValue();
            int i = 0;
            while (i < answers.size()-1){
                readWriteService.write(answers.get(i));
                i++;
            }

            if(readWriteService.read().equals(answers.get(i))){
                student.setTestResult(student.getTestResult() + 1);
            }
        }
    }

}
