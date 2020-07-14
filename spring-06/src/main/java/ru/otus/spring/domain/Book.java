package ru.otus.spring.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;


@Data
@Entity
@NamedEntityGraph(name = "author-genre-graph",
        attributeNodes = {@NamedAttributeNode("genre"),
                @NamedAttributeNode("author")}
)
@Accessors(chain = true)
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "bookname", nullable = false, unique = true)
    private String bookName;
}
