package ru.otus.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
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

    @ManyToOne (cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    Book book;

}
