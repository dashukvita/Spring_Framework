package ru.otus.spring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Класс UserTest")
public class UserTest {

    @DisplayName("корректно создается конструктором")
    @Test
    void getRightStudent(){
        User user = new User("Ivan", "Ivanov", 5);

        assertAll("student",
                () ->  assertEquals("Ivan", user.getFirstName()),
                () ->  assertEquals("Ivanov", user.getLastName()),
                () ->  assertEquals(5, user.getScore())
        );
    }
}
