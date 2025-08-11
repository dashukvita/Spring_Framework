package ru.otus.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.otus.spring.entity.User;

import java.util.ArrayList;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class GameControllerImpl implements GameController {
    private final QuestionService questionService;
    private final MessageService messageService;

    @Override
    public void startTest() {
        String correctAnswer = "";
        String userAnswer = "";

        User user = new User();
        user.setFirstName(messageService.userFirstName());
        user.setLastName(messageService.userLastName());

        for (Map.Entry<String, ArrayList<String>> entry : questionService.getQuestions().entrySet()) {
            messageService.getQuestion(entry.getKey());
            ArrayList<String> answers = entry.getValue();
            for (int i = 0; i < answers.size(); i++) {
                if(i < answers.size()-1){
                    messageService.getQuestion(answers.get(i));
                } else {
                    correctAnswer = answers.get(i);
                }
            }
            userAnswer = messageService.getAnswer();

            if (correctAnswer.equalsIgnoreCase(userAnswer)) {
                messageService.correctAnswer();
                user.setScore(user.getScore() + 1);
            } else {
                messageService.incorrectAnswer(correctAnswer);
            }
        }

        messageService.testResult(user);
    }
}
