package ru.otus.spring.domain;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Accessors(chain = true)
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @NonNull private long id;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "GENRE_ID")
    @NonNull private Genre genre;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "AUTHOR_ID")
    @NonNull private Author author;

    @Column(name = "TITLE")
    @NonNull private String title;
}
