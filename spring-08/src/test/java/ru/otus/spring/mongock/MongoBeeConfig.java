package ru.otus.spring.mongock;

import com.github.mongobee.Mongobee;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import ru.otus.spring.mongock.changelog.DatabaseChangelog;

@Configuration
public class MongoBeeConfig {
    @Autowired
    private MongoClient mongo;

    @Bean
    public Mongobee mongobee(Environment environment) {
        Mongobee runner = new Mongobee((MongoClientURI) mongo);
        runner.setDbName("company");
        runner.setChangeLogsScanPackage(DatabaseChangelog.class.getPackage().getName());
        runner.setSpringEnvironment(environment);
        return runner;
    }
}
