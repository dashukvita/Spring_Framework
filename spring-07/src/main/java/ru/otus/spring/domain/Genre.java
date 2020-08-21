package ru.otus.spring.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genres")
@Accessors(chain = true)
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NonNull private long id;

    @Column(name = "codegenre", unique = true)
    @NonNull private String codeGenre;

    @Column(name = "genre", unique = true)
    @NonNull private String genreName;

    @OneToMany(mappedBy = "genre", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Book> books;

}