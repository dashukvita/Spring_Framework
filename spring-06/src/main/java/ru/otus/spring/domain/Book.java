package ru.otus.spring.domain;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedEntityGraph(name = "author-entity-graph",
        attributeNodes = {@NamedAttributeNode("author")}
)
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Column(name = "bookname", nullable = false, unique = true)
    private String bookName;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

}
