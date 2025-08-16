package ru.otus.spring.repositories.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import ru.otus.spring.entities.Author;
import ru.otus.spring.repositories.AuthorRepository;

@ChangeLog(order = "001")
public class InitMongoDBDataChangelog {

    @ChangeSet(order = "000", id = "dropDB", author = "stvort", runAlways = true)
    public void dropDB(MongoDatabase database){
        database.drop();
    }

    @ChangeSet(order = "002", id= "initAuthors", author = "admin", runAlways = true)
    public void initAuthors(final AuthorRepository authorsRepository) {
        authorsRepository.save(Author.builder()
                .name("Author1")
                .surname("Author1")
                .birthday("1965-07-31")
                .build());
        authorsRepository.save(Author.builder()
                .name("Author2")
                .surname("Author2")
                .birthday("1932-01-05")
                .build());
    }
}
