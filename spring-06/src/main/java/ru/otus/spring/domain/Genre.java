package ru.otus.spring.domain;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genre")
public class Genre {

    @Id
    private long id;

    @Column(name = "codegenre", nullable = false, unique = true)
    private String codeGenre;

    @Column(name = "genre", nullable = false, unique = true)
    private String genre;
}
