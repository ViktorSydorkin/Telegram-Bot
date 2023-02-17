package com.example.englishstudybot.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Phrase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phrase_id")
    private long id;
    @Column(name = "phrase")
    private String phrase;
    @ManyToOne
    @JoinColumn(name="preposition_fk_id")
    @Fetch(value = FetchMode.SELECT)
    @Lazy(value = false)
    private Preposition preposition;
}
