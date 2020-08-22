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
@Table(name = "AUTHORS")
@Accessors(chain = true)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @NonNull private long id;

    @Column(name = "FIRSTNAME")
    @NonNull private String firstName;

    @Column(name = "LASTNAME")
    @NonNull private String lastName;

    @Column(name = "BIRTHDAY")
    private String birthday;
}
