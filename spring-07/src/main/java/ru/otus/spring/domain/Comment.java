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
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    @NonNull private long id;

    @Column(name = "MESSAGE")
    @NonNull private String message;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    @NonNull Book book;
}
