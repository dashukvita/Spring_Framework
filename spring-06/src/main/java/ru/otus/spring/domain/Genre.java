package ru.otus.spring.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "codegenre", nullable = false, unique = true)
    private String codeGenre;

    @Column(name = "genre", nullable = false, unique = true)
    private String genreName;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    List<Book> books;

}
