package ru.otus.spring.mongock.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;

@ChangeLog(order = "001")
public class DatabaseChangelog {

    @ChangeSet(order = "000", id= "dropDb", runAlways = true, author = "")
    public void dropDb(final MongoDatabase mongoDatabase) {
        mongoDatabase.drop();
    }
}
