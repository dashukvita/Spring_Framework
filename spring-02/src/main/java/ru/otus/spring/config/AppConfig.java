package ru.otus.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ru.otus.spring.service.*;

import java.util.Locale;
import java.util.Scanner;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public MessageService messageServiceImpl(@Value("${language}") Locale language, MessageSource messageSource,
                                             ReadWriteService readWriteService) {
        return new MessageServiceImpl(language, messageSource, readWriteService);
    }

    @Bean
    public ReadWriteService readWriteServiceImpl() {
        return new ReadWriteServiceImpl(new Scanner(System.in), System.out);
    }

    @Bean
    public QuestionService questionServiceImpl(@Value("${language}") String language,
                                               @Value("${questions.file.name}") String fileName) {
        QuestionService questionServiceImpl = new QuestionServiceImpl();
        Resource resource = new ClassPathResource(fileName.replace(".", "_" + language + "."));

        questionServiceImpl.init(resource);
        return questionServiceImpl;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
}
