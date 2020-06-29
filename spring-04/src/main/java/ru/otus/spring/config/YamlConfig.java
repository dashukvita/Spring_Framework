package ru.otus.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ru.otus.spring.service.*;

import java.util.Locale;
import java.util.Scanner;

@Configuration
public class YamlConfig {

    @Value("${questions.file.name}")
    private String fileName;

    @Value("${application.language}")
    private Locale language;

    @Bean
    public MessageService messageServiceImpl(MessageSource messageSource,
                                             ReadWriteService readWriteService) {
        return new MessageServiceImpl(language, messageSource, readWriteService);
    }

    @Bean
    public ReadWriteService readWriteServiceImpl() {
        return new ReadWriteServiceImpl(new Scanner(System.in), System.out);
    }

    @Bean
    public QuestionService questionServiceImpl() {
        QuestionService questionServiceImpl = new QuestionServiceImpl();
        Resource resource = new ClassPathResource(fileName.replace(".", "_" + language + "."));

        questionServiceImpl.init(resource);
        return questionServiceImpl;
    }
}
