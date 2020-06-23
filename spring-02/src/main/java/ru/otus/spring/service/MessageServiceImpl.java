package ru.otus.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.User;


import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final Locale locale;
    private final MessageSource messageSource;
    private final ReadWriteService readWriteService;

    @Override
    public String userFirstName() {
        String messageWelcome = messageSource.getMessage("message.welcome", null, locale);
        readWriteService.write(messageWelcome);
        return readWriteService.read();
    }

    @Override
    public String userLastName() {
        String messageName = messageSource.getMessage("message.name", null, locale);
        readWriteService.write(messageName);
        return readWriteService.read();
    }

    @Override
    public void correctAnswer() {
        String correctAnswer = messageSource.getMessage("message.answer.correct", null, locale);
        readWriteService.write(correctAnswer);
    }

    @Override
    public void incorrectAnswer(String correctAnswer) {
        String incorrectAnswer = messageSource.getMessage("message.answer.incorrect",
                new String[]{correctAnswer},
                locale);
        readWriteService.write(incorrectAnswer);
    }

    @Override
    public void testResult(User user) {
        String result = messageSource.getMessage("message.result",
                new String[]{user.getFirstName(), user.getLastName(), String.valueOf(user.getScore())},
                locale);
        readWriteService.write(result);
    }

    @Override
    public String getAnswer() {
        return readWriteService.read();
    }

    @Override
    public String getQuestion(String question) {
        return readWriteService.write(question);
    }
}