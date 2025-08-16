package ru.otus.spring.repositories;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;

@DataMongoTest
@EnableConfigurationProperties
//@ComponentScan({"ru.otus.example.mongodbdemo.config", "ru.otus.example.mongodbdemo.repositories"})
@ComponentScan({"ru.otus.example.mongodbdemo.repositories"})
//@Import(RawResultPrinterImpl.class)
public abstract class AbstractRepositoryTest {
}
