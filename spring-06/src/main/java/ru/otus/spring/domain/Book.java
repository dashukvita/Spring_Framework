package ru.otus.spring.domain;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    private long id;

    private Author author;
    private Genre genre;

    @Column(name = "bookname", nullable = false, unique = true)
    private String bookName;

}
