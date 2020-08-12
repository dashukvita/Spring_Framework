package ru.otus.spring.domain;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Column(name = "bookname", nullable = false, unique = true)
    private String bookName;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Comment> comments = new ArrayList<>();
}
