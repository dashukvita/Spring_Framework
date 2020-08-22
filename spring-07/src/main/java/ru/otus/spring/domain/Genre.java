package ru.otus.spring.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GENRES")
@Accessors(chain = true)
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @NonNull private long id;

    @Column(name = "CODE", unique = true)
    @NonNull private String code;

    @Column(name = "TITLE", unique = true)
    @NonNull private String title;
}