package ru.otus.spring.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Класс StudentTest")
public class StudentTest {

    @DisplayName("корректно создается конструктором")
    @Test
    void getRightStudent(){
        Student student = new Student("Ivan", "Ivanov", 0);

        assertAll("student",
                () ->  assertEquals("Ivan", student.getFirstName()),
                () ->  assertEquals("Ivanov", student.getLastName()),
                () ->  assertEquals(0, student.getTestResult())
        );
    }
}
