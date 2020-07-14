package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedEntityGraph(name = "book-entity-graph",
        attributeNodes = {@NamedAttributeNode("book")}
)
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "message", nullable = false)
    private String message;

    @ManyToOne(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

}
