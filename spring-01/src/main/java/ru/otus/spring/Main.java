package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.service.GameService;
import ru.otus.spring.service.GameServiceImpl;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");

        GameService service = context.getBean(GameServiceImpl.class);
        service.startGame();
    }
}
