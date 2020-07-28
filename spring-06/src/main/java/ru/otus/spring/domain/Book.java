package ru.otus.spring.domain;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Column(name = "bookname", nullable = false, unique = true)
    private String bookName;

}
