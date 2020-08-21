package ru.otus.spring.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    @NonNull private long id;

    @Column(name = "message")
    @NonNull private String message;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @NonNull Book book;
}
