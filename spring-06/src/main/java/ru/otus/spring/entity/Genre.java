package ru.otus.spring.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
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

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    List<Book> books;

}
