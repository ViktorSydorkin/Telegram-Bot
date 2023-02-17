package com.example.englishstudybot.entity;

import javax.persistence.*;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_id")
    private long wordId;
    @Column(name = "word_english")
    private String englishWord;
    @Column(name = "word_ukrainian")
    private String ukrainianWord;

}
