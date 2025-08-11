package ru.otus.spring.entity;

import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "codegenre", nullable = false, unique = true)
    private String codeGenre;

    @Column(name = "genre", nullable = false, unique = true)
    private String genreName;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Book> books;

}
