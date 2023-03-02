package com.example.englishstudybot.entity;

import javax.persistence.*;

import lombok.*;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return wordId == word.wordId && Objects.equals(englishWord, word.englishWord) && Objects.equals(ukrainianWord, word.ukrainianWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordId, englishWord, ukrainianWord);
    }
}
